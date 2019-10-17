package com.imooc.shenzhouyh.web.server;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.imooc.shenzhouyh.web.serverlet.TestServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import java.util.concurrent.*;

/**
 * @author: yinhao
 * @email:286817442@qq.com
 * @date:2019/10/17
 * @time:10:59
 * @desciption
 */
public class TomcatServer {
	private Tomcat tomcat;
	private String[] args;

	/**
	 * 构造方法
	 *
	 * @param args
	 */
	public TomcatServer(String[] args) {
		this.args = args;
	}

	public void startServer() throws LifecycleException {
		tomcat = new Tomcat();
		tomcat.setPort(6699);
		tomcat.start();
		//实例化context容器
		Context context = new StandardContext();
		context.setPath("");
		//设置默认的生命周期
		context.addLifecycleListener(new Tomcat.FixContextListener());
		TestServlet testServlet = new TestServlet();
		//tomcat容器添加servlet，并且设置为异步调用
		Tomcat.addServlet(context, "testServlet", testServlet).setAsyncSupported(true);
		//配置访问路径
		context.addServletMappingDecoded("/test.json", "testServlet");
		//获取host容器，并将context容器添加进去
		tomcat.getHost().addChild(context);
		/*
		  使用线程池实例化线程,同时设置线程名称且为守护线程
		 */
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("tomcat_await_thread")
				.setDaemon(false).build();
		ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
		//执行线程
		singleThreadPool.execute(() -> TomcatServer.this.tomcat.getServer().await());
	}
}

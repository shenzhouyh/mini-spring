package com.imooc.shenzhouyh.starter;

import com.imooc.shenzhouyh.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

/**
 * @author: yinhao
 * @email:286817442@qq.com
 * @date:2019/10/14
 * @time:11:34
 * @desciption
 */
public class MiniApplication {

  public static void run(Class<?> cls, String[] args) {
    System.out.println("hello miniSpring");
	  System.out.println("test");
	  //实例化tomcat容器
	  TomcatServer tomcatServer = new TomcatServer(args);
	  try {
		  tomcatServer.startServer();
	  } catch (LifecycleException e) {
		  e.printStackTrace();
	  }
  }
}

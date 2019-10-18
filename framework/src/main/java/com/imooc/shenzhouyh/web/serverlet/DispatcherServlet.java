package com.imooc.shenzhouyh.web.serverlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: yinhao
 * @email:286817442@qq.com
 * @date:2019/10/17
 * @time:11:50
 * @desciption
 */
public class DispatcherServlet implements Servlet {
	@Override public void init(ServletConfig config) throws ServletException {

	}

	@Override public ServletConfig getServletConfig() {
		return null;
	}

	@Override public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().print("test");
	}

	@Override public String getServletInfo() {
		return null;
	}

	@Override public void destroy() {

	}
}

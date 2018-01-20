package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 实际开发也是这样
 * 专门写一个初始化的servlet用于启动时初始化数据
 * @author Administrator
 *
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//tomcat启动时会优先创建context
		//然后在创建Servlet
		ServletContext context=
				getServletContext();
		//声明变量，流量默认为0
		context.setAttribute("count", 0);
		
	}

}

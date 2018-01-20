package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HiServlet extends HttpServlet {
    
	//创建默认构造器观察下什么时候调用
	public HiServlet() {
		System.out.println("实例化Servlet");
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("初始化HiServlet");
	}


	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		System.out.println("调用servlet处理请求");
	}


	@Override
	public void destroy() {
		super.destroy();
		System.out.println("销毁HiServlet");
	}

}

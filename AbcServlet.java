package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbcServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		
		//通过不同方法获取访问路径的不同部位
		//针对访问路径的获取java有一套方法
		
		//getContextPath得到项目名称
		System.out.println(
				req.getContextPath());
		//getServletPath得到访问路径(网名)
		System.out.println(
				req.getServletPath());
		//URI即是绝对路径
		System.out.println(
				req.getRequestURI());
		//URL即是完整路径
		System.out.println(
				req.getRequestURL());
		//若是没有向浏览器写响应信息
		//会自动发送响应信息
		//只是响应信息为空，就是一个空白网页
		//浏览器会看到一片空白，并不会报错
		
	}

}

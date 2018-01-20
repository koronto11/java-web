package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindDeptServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		//父类获取context的方法
		//Tomcat启动时就创建context，并且会调用它的方法
		//来加载web.xml中的参数，context是全局的，任何
		//servlet都可以使用
		ServletContext context=
				getServletContext();
		String size=
				context.getInitParameter("size");
		System.out.println(size);
		System.out.println("分页查询部门数据");
		
		//统计流量
		Integer count=(Integer) context.getAttribute("count");
		context.setAttribute("count", ++count);
		System.out.println(count);
	}

	
}

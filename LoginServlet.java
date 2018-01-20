package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		//config是数据的载体，解析配置文件后将数据
		//放到config里
		String maxOnline=
				config.getInitParameter("maxOnline");
		System.out.println(maxOnline);
	}

	@Override
	protected void service(
			HttpServletRequest arg0, 
			HttpServletResponse arg1) 
					throws ServletException, IOException {
		//父类提供的方法getServletConfig()
		//就可以得到那个config
		//此config就是init方法传入的config
		//是同一个对象
		ServletConfig cfg=getServletConfig();
		String maxOnline=
				cfg.getInitParameter("maxOnline");
		System.out.println(maxOnline);
		System.out.println("readly login...");
	}

}

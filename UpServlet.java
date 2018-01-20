package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//模拟Servlet的线程安全问题
//在延迟8秒内信息输入重叠，这就是servlet线程安全问题
public class UpServlet extends HttpServlet {
    
    double salary=2000.0;//声明成员变量
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
	//部分加sync锁
	synchronized (this) {
	salary+=100.0;
	try {
		//模拟网络延迟
		//执行的数据先进入延迟才输出
		Thread.sleep(8000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	res.setContentType("text/html,charset=utf-8");
	PrintWriter out=res.getWriter();
	out.println(salary);
	out.close();
	}
 }

}

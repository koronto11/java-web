 package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {
    //开发者只需要操作request和response即可
	//以服务器角度来开发，入口为service()函数
	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
			throws ServletException, IOException {
		//1.使用request获取请求数据
		//1)请求行
		System.out.println("请求方式:"+req.getMethod());
		System.out.println("访问路径:"+req.getServletPath());
		System.out.println("协议类型:"+req.getProtocol());
		//2)消息头
		//消息头内容为键值对，是一些若干个描述实体内容的数据
		//Enumeration是老版本的迭代器，其作用与用法和Iterator迭代器一致
		//req的getHeaderNames获得所有消息头键值对的Key值
		//然后迭代Key后根据每个Key再取对应的value
		//这样就可以遍历所有消息头数据
		Enumeration<String> e=req.getHeaderNames();
		//迭代器模式都是配合while
		//hasMoreElements()判断有无元素，直至返回false为止，遍历所有元素
		while(e.hasMoreElements()){
			//每次循环nextElement()返回一个key
			String key=e.nextElement();
			//req的getHeader(key)，根据带入key返回对应value
			String value=req.getHeader(key);
			System.out.println(key+":"+value);
		}
		//3)实体内容
		
		//2.使用response发送响应数据
		//1)状态行
		
		//2)消息头
		
		//3)实体内容
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		Date date=new Date();
		SimpleDateFormat sdf=
				new SimpleDateFormat("HH:mm:ss");
		String now=sdf.format(date);
		out.println("<P>"+now+"</p>");
		out.close();
	}
     
	


}

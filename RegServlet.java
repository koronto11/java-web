package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
		    throws ServletException, IOException {
		//在接收参数之前指定字符编码，这样接收到的参数就可以按照指定的字符编码接收
		req.setCharacterEncoding("utf-8");
		//处理请求的一般步骤
		//1.接收参数
		String user=req.getParameter("userName");
	    String pwd=req.getParameter("pwd");
	    String sex=req.getParameter("sex");
	    String[] interests=
	    		req.getParameterValues("interest");
	    
	    //1.处理请求乱码(反向编码的方式)
	    //将接收到的中文字符按照ISO8859-1还原为byte，然后再将byte按照utf-8解码为字符串
	    //这样就回到了最初始的状态
	    //不过这种反向编码的方式较麻烦
	    //当数据量大时这种方法较为占用资源，要一个一个数据的转，通常不用
	    /*
	    byte[] bs=user.getBytes("ISO8859-1");
	    user=new String(bs,"utf-8");
	    */
	    
	    
	    //2.处理业务
	    //按照正常的工作业务要求，应该把用户的注册信息存入数据库表里
	    //本案例重点在于传参数
	    System.out.println(user);
	    System.out.println(pwd);
	    System.out.println(sex);
	    //一般一定要加判断来遍历避免空指针异常
	    //一般在业务中NullPointerException属于重大bug
	    if(interests!=null){
	    	for(String i:interests){
	    		System.out.println(i);
	    	}
	    }
	    
	    //3.发送响应
	    
	    //需要设置响应的类型ContentType
	    //res.setCharacterEncoding("utf-8");
	    //声明编码方式,若是声明了charset=utf-8"，那么这句话可以省略
	    res.setContentType("text/html;charset=utf-8");//声明相应数据类型和按照什么方式解码
	    PrintWriter out=res.getWriter();
	    out.println("<p>注册成功</p>");
	    out.close();
	    
	}

}

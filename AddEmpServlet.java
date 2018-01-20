package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		//针对浏览器的请求乱码问题
		//值适用form的method属性为post的类型
		req.setCharacterEncoding("utf-8");
		
		//接收数据
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		String salary=req.getParameter("salary");
		
		//处理业务
		//包装成Emp实例再保存到Dao中
		Emp e=new Emp();
		e.setEname(ename);
		e.setJob(job);
		if(salary!=null && !salary.equals("")){
		    e.setSal(new Double(salary));
		}
		//实例化Dao
		EmpDao dao=new EmpDaoImpl();
		dao.save(e);
		
		//输出响应
		/*
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.println("<p>保存成功</p>");
		out.close();
		*/
		//重定向到查询页面
		//一种特殊的响应过程
		//sendRedirect方法就是重定向
		//目标为/EmpManager/findEmp
		//当前为/EmpManager/addEmp
		//重定向到某一页面的访问路径
		//也可以理解为自动回到查询页面
		res.sendRedirect("findEmp");
	}

}

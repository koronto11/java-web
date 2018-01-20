package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import dao.EmpDaoImpl;
import entity.Emp;

/**
 * 开发规范
 * 实际开发用*.后缀的方式
 * 通常后缀代表模块，类，便于管理
 * 查询员工的路径是/findEmp.do
 * 增加员工的路径是/addEmp.do
 * @author Administrator
 * 
 * 一个servlet同时处理多个请求
 *
 */
public class MainServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		String p=req.getServletPath();
		if(p.equals("/findEmp.do")){
			findEmp(req,res);
		}else if(p.equals("/addEmp.do")){
			addEmp(req,res);
		}else{
			//报错
			try {
				throw new RuntimeException("error");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	protected void findEmp(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		//查询方法
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findall();
		res.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.println("<a href='add_emp.html'>增加</a>");
		out.println("<table border='1' cellspacing='0' width='40%'>");
		out.println("  <tr>");
		out.println("    <td>编号</td>");
		out.println("    <td>姓名</td>");
		out.println("    <td>职位</td>");
		out.println("    <td>月薪</td>");
		out.println("  </tr>");
		if(list!=null){
			for(Emp e:list){
				out.println("  <tr>");
				out.println("    <td>"+e.getEmpno()+"</td>");
				out.println("    <td>"+e.getEname()+"</td>");
				out.println("    <td>"+e.getJob()+"</td>");
				out.println("    <td>"+e.getSal()+"</td>");
				out.println("  </tr>");
			}
		}
		out.println("</table>");
		out.close();
	}
	
	protected void addEmp(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		//增加方法
		req.setCharacterEncoding("utf-8");
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		String salary=req.getParameter("salary");
		Emp e=new Emp();
		e.setEname(ename);
		e.setJob(job);
		if(salary!=null && !salary.equals("")){
		    e.setSal(new Double(salary));
		}
		//实例化Dao
		EmpDao dao=new EmpDaoImpl();
		dao.save(e);
		res.sendRedirect("findEmp.do");
	}
	

}

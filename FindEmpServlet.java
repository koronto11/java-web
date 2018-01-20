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
 * 这个Servlet用于将数据(员工信息)拼接成一个表
 * 然后传给浏览器
 * 满足javaBean规范
 * 有包，有默认构造器，有serializable接口，有get/set方法
 * 因为FindEmpServlet继承了HttpServlet
 * 其父类HttpServlet实现了serializable接口
 * 那么其子类同样也继承了接口
 * 所有FindEmpServlet也算javaBean
 * @author Administrator
 *
 */
public class FindEmpServlet extends HttpServlet {

	@Override
	protected void service(
			HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		//1.接收参数
		//这里不需要接收数据
		//只是将数据库数据处理完毕后响应给浏览器
		
		//2.处理业务(查询)
		//以父类接收接口
		EmpDao dao = new EmpDaoImpl();
		List<Emp> list = dao.findall();
		
		
		//3.响应输出(表格)
		res.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		//这个增加的超链接是连接到一个静态网页
		//静态网页的访问路径直接在项目之下
		//当前是查询页面的路径：       /EmpManager/FindEmpServlet
		//连接到的目标静态网页的路径/EmpManager/add_emp.html
		//查询页面和目标静态网的路径关系为平级(相对路径)
		out.println("<a href='add_emp.html'>增加</a>");
		out.println("<table border='1' cellspacing='0' width='40%'>");
		out.println("  <tr>");
		out.println("    <td>编号</td>");
		out.println("    <td>姓名</td>");
		out.println("    <td>职位</td>");
		out.println("    <td>月薪</td>");
		out.println("  </tr>");
		//遍历集合数据
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
				
	}

}

package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import DAO.TaiKhoanDao;
import Model.TaiKhoan;

/**
 * Servlet implementation class TaiKhoanServelet
 */
@WebServlet(urlPatterns = "/TaiKhoanServlet")
public class TaiKhoanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaiKhoanServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// khi form đăng nhập ấn nút submit thì nó sẽ truyền về servlet này
		try {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			TaiKhoanDao acc = new TaiKhoanDao();
			TaiKhoan a = acc.checklogin(user, pass);
			if(a==null) {
//				response.sendRedirect("error.jsp");
				String jspPath = "/login.jsp";
				RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				rs.forward(request,response);
			}else {
//				response.sendRedirect("access.jsp");
				String jspPath = "/access.jsp";
				RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				rs.forward(request,response);
			}
		} catch(Exception e) {
			
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

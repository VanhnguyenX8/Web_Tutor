package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.HocSinhDAO;


/**
 * Servlet implementation class HocSinhServlet
 */
@WebServlet(urlPatterns = {"/ThemThongTinHS"})
public class HocSinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HocSinhServlet() {
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
		System.out.println("vao day chua");
		String ten_hoc_sinh = request.getParameter("name");
		String nam_sinh = request.getParameter("ngaySinh");
		
		String sdt = request.getParameter("phone");
		String email = request.getParameter("email");
		String gioi_tinh = request.getParameter("gender");
		String dia_chi = request.getParameter("address");
		String so_tai_khoan = request.getParameter("bankAccount");
		System.out.println("name" + ten_hoc_sinh);
		System.out.println("nam_sinh" + nam_sinh);
		System.out.println("sdt" + sdt);
		System.out.println("email" + email);
		System.out.println("gioi tinh" + gioi_tinh);
		System.out.println("dia chi" + dia_chi);
		System.out.println("so tai klhoan" + so_tai_khoan);
	
		// TODO Auto-generated method stub
		try {
			

			HocSinhDAO hs = new HocSinhDAO();
			hs.ThemThongTinHS(ten_hoc_sinh, nam_sinh, sdt, email, gioi_tinh, dia_chi, so_tai_khoan);
//			response.sendRedirect("login.jsp");

		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
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

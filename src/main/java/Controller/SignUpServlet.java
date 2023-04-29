package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SignUpDao;
import Model.TaiKhoan;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			String repass = request.getParameter("renamepass");
			 if(!pass.equals(repass)) {
				 response.sendRedirect("login.jsp");
			 }else {
				 SignUpDao sign = new SignUpDao();
				 TaiKhoan a = sign.checkAccount(user);
				 if(a != null) {
					 response.sendRedirect("login.jsp");
				 } else {
					 sign.NewAccount(user, pass);
					 response.sendRedirect("access.jsp");
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

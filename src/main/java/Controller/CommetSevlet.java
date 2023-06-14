package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CommentChiTietSP;

/**
 * Servlet implementation class CommetSevlet
 */
@WebServlet("/CommetSevlet")
public class CommetSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommetSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String usercmt = request.getParameter("comment");
		System.out.println("usercmt" + usercmt);
		HttpSession session = request.getSession();
		String idlophoc = (String) session.getAttribute("idLopHoc");
		try {
			CommentChiTietSP cmt = new CommentChiTietSP();
			

			cmt.ThemCMT(idlophoc, usercmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("profileLH?id=" + idlophoc);
	
	}
	}



package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import DAO.UserDAO;
import DAO.UserHSDAO;

@WebServlet (urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Kiểm tra xem người dùng đã đăng nhập hay chưa
	    HttpSession session = request.getSession();
	    Model.TaiKhoan account = (Model.TaiKhoan) session.getAttribute("acc");
	    boolean isLoggedIn = (account != null);

	    // Kiểm tra yêu cầu đăng xuất
	    String logoutParam = request.getParameter("logout");
	    boolean isLogoutRequested = (logoutParam != null && logoutParam.equals("true"));

	    // Xử lý dữ liệu và hiển thị trang chủ
	    if (isLoggedIn && !isLogoutRequested) {
	        // Người dùng đã đăng nhập, hiển thị trang chủ với thông tin người dùng
	        String username = account.getUsername();
	        UserDAO usergs = new UserDAO();
	        UserHSDAO userhs = new UserHSDAO();
	        String Name = null;
	        String email = null;
	        String position = account.getPosition(); // Lấy vai trò của người dùng

	        if (position.equals("giasu")) {
	            // Xử lý thông tin gia sư
	            try {
	                Name = usergs.getNameFromDatabase(username);
	                email = usergs.getEmailFromDatabase(username);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } else if (position.equals("hocsinh")) {
	            // Xử lý thông tin học sinh
	        	try {
	                Name = userhs.getNameFromDatabase(username);
	                email = userhs.getEmailFromDatabase(username);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        request.setAttribute("Name", Name);
	        request.setAttribute("email", email);
	        // Các thuộc tính khác nếu cần thiết

	        String jspPath = "/trangchu.jsp";
	        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
	        rs.forward(request, response);
	    } else {
	        // Người dùng chưa đăng nhập hoặc yêu cầu đăng xuất, xóa thông tin đăng nhập khỏi session
	        session.removeAttribute("acc");

	        // Chuyển hướng về trang chủ không đăng nhập
	        String jspPath = "/Home.jsp";
	        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
	        rs.forward(request, response);
	    }
	}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doGet(req, resp);
    }
}


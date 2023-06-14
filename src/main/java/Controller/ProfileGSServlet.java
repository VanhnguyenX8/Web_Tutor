package Controller;

import DAO.UserDAO;
import Model.UserGS;
import Model.UserHS;
import Model.LopHoc;
import Service.GiaSuService;
import Service.HocSinhService;
//import Service.LopHocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/profileGS")
public class ProfileGSServlet extends HttpServlet {
    GiaSuService giaSuService = new GiaSuService();
    HocSinhService hocSinhService = new HocSinhService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession session = req.getSession();
    	Model.TaiKhoan account = (Model.TaiKhoan) session.getAttribute("acc");
    	boolean isLoggedIn = (account != null);
    	
    	// Kiểm tra yêu cầu đăng xuất
	    String logoutParam = req.getParameter("logout");
	    boolean isLogoutRequested = (logoutParam != null && logoutParam.equals("true"));

    	// Xử lý dữ liệu và hiển thị trang thông tin
    	if (isLoggedIn && !isLogoutRequested) {
    	    String username = account.getUsername(); // Lấy username của người dùng
    	    session.setAttribute("username", username);
    	    String position = account.getRole(); // Lấy vai trò của người dùng
    	    session.setAttribute("position", position);
    	    if (position.equals("giasu")) {
    	    	UserGS giaSu = giaSuService.getGiaSuByUsername(username);
        	    if (giaSu != null && giaSu.getUsername() != null) {
        	        req.setAttribute("giaSu", giaSu);
        	        RequestDispatcher dispatcher = req.getRequestDispatcher("/profileGiaSu.jsp");
        	        dispatcher.forward(req, resp);
        	    }
    	    }else if(position.equals("hocsinh")) {
    	    	UserHS hocSinh = hocSinhService.getHocSinhByUsername(username);
    	    	if(hocSinh != null && hocSinh.getUsername() != null) {
    	    		req.setAttribute("hocSinh", hocSinh);
    	    		RequestDispatcher dispatcher = req.getRequestDispatcher("/profileGiaSu.jsp");
        	        dispatcher.forward(req, resp);
    	    	}
    	    }
    	    
    	}

    }
}
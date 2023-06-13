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
import java.util.ArrayList;
import java.util.List;
import DAO.UserDAO;
import DAO.UserHSDAO;
import Service.GiaSuService;
import Service.LopHocService;
import Model.LopHoc;
//import Service.LopHocService;
import Model.UserGS;

@WebServlet (urlPatterns = {"/Home"})
public class HomeServlet extends HttpServlet {
	GiaSuService giaSuService = new GiaSuService();
    LopHocService lopHocService = new LopHocService();
//    LopHocService lopHocService = new LopHocService();
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
	        String position = account.getRole(); // Lấy vai trò của người dùng

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
	        List<LopHoc> list3lv3 = new ArrayList<>();
	        List<LopHoc> list4lv3 = new ArrayList<>();
	        List<LopHoc> lopHoclv3 = lopHocService.getLopHocByKhoi(3, false);
	        if (lopHoclv3 != null) {
	        	for (int i = 0; i < lopHoclv3.size(); i++) {
		            if (i < 3) {
		                list3lv3.add(lopHoclv3.get(i));
		            } else if (i < 7) {
		                list4lv3.add(lopHoclv3.get(i));
		            }
		        }
	        }
	        

	        List<LopHoc> list3lv2 = new ArrayList<>();
	        List<LopHoc> list4lv2 = new ArrayList<>();
	        List<LopHoc> lopHoclv2 = lopHocService.getLopHocByKhoi(2, false);
	        if (lopHoclv2 != null) {
	        	for (int i = 0; i < lopHoclv2.size(); i++) {
		            if (i < 3) {
		                list3lv2.add(lopHoclv2.get(i));
		            } else if (i < 7)
		                list4lv2.add(lopHoclv2.get(i));
		        }
	        }
	        

	        List<LopHoc> list3lv1 = new ArrayList<>();
	        List<LopHoc> list4lv1 = new ArrayList<>();
	        List<LopHoc> lopHoclv1 = lopHocService.getLopHocByKhoi(1, false);
	        if (lopHoclv1 != null) {
	        	for (int i = 0; i < lopHoclv1.size(); i++) {
		            if (i < 3) {
		                list3lv1.add(lopHoclv1.get(i));
		            } else if (i < 7)
		                list4lv1.add(lopHoclv1.get(i));
		        }
	        }
	        
	        request.setAttribute("list3lv3", list3lv3);
	        request.setAttribute("list4lv3", list4lv3);
	        request.setAttribute("list3lv2", list3lv2);
	        request.setAttribute("list4lv2", list4lv2);
	        request.setAttribute("list3lv1", list3lv1);
	        request.setAttribute("list4lv1", list4lv1);
	        request.setAttribute("Name", Name);
	        request.setAttribute("email", email);
	        request.setAttribute("position", position);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/trangchu.jsp");
	        dispatcher.forward(request, response);
	        
	    } else {
	        // Người dùng chưa đăng nhập hoặc yêu cầu đăng xuất, xóa thông tin đăng nhập khỏi session
	        session.removeAttribute("acc");

	        // Chuyển hướng về trang chủ không đăng nhập
	        List<LopHoc> list3lv3 = new ArrayList<>();
	        List<LopHoc> list4lv3 = new ArrayList<>();
	        List<LopHoc> lopHoclv3 = lopHocService.getLopHocByKhoi(3, false);
	        if (lopHoclv3 != null) {
	        	for (int i = 0; i < lopHoclv3.size(); i++) {
		            if (i < 3) {
		                list3lv3.add(lopHoclv3.get(i));
		            } else if (i < 7) {
		                list4lv3.add(lopHoclv3.get(i));
		            }
		        }
	        }
	        

	        List<LopHoc> list3lv2 = new ArrayList<>();
	        List<LopHoc> list4lv2 = new ArrayList<>();
	        List<LopHoc> lopHoclv2 = lopHocService.getLopHocByKhoi(2, false);
	        if (lopHoclv2 != null) {
	        	for (int i = 0; i < lopHoclv2.size(); i++) {
		            if (i < 3) {
		                list3lv2.add(lopHoclv2.get(i));
		            } else if (i < 7)
		                list4lv2.add(lopHoclv2.get(i));
		        }
	        }
	        

	        List<LopHoc> list3lv1 = new ArrayList<>();
	        List<LopHoc> list4lv1 = new ArrayList<>();
	        List<LopHoc> lopHoclv1 = lopHocService.getLopHocByKhoi(1, false);
	        if (lopHoclv1 != null) {
	        	for (int i = 0; i < lopHoclv1.size(); i++) {
		            if (i < 3) {
		                list3lv1.add(lopHoclv1.get(i));
		            } else if (i < 7)
		                list4lv1.add(lopHoclv1.get(i));
		        }
	        }
	        
	        request.setAttribute("list3lv3", list3lv3);
	        request.setAttribute("list4lv3", list4lv3);
	        request.setAttribute("list3lv2", list3lv2);
	        request.setAttribute("list4lv2", list4lv2);
	        request.setAttribute("list3lv1", list3lv1);
	        request.setAttribute("list4lv1", list4lv1);
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

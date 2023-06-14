package Controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDao;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet(urlPatterns = {"/ChangePassword"})
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ChangePass.jsp");
	    dispatcher.forward(request, response);
		
	}
	private boolean validateInputs(HttpServletRequest request, String oldpass, String newpass, String repass) {
        boolean isValid = true;

        if (oldpass.isEmpty()) {
            request.setAttribute("oldpassError", "Tên người dùng không được bỏ trống");
            isValid = false;
        }

        if (newpass.isEmpty()) {
            request.setAttribute("newpassError", "Mật khẩu không được bỏ trống");
            isValid = false;
        }

        if (repass.isEmpty()) {
            request.setAttribute("repassError", "Vui lòng nhập lại mật khẩu");
            isValid = false;
        }
        
        if (newpass.length() < 8) {
            request.setAttribute("newpassError", "Mật khẩu phải có ít nhất 8 kí tự");
            isValid = false;
        }

        if (!Character.isUpperCase(newpass.charAt(0))) {
            request.setAttribute("newpassError", "Mật khẩu phải có một chữ hoa");
            isValid = false;
        }

        if (!newpass.matches(".*[\\W_].*")) {
            request.setAttribute("newpassError", "Mật khẩu phải chứa ít nhất một kí tự đặc biệt");
            isValid = false;
        }
        
        return isValid;
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String oldPassword = request.getParameter("oldPassword");
	        String newPassword = request.getParameter("newPassword");
	        String confirmPassword = request.getParameter("confirmPassword");
	        
	        if(!validateInputs(request, oldPassword, newPassword, confirmPassword)) {
	        	String jspPath = "/ChangePass.jsp";
		        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
		        rs.forward(request, response);
		        return;
	        	
	        }
	        // Kiểm tra mật khẩu mới và nhập lại mật khẩu mới có khớp không
	        if (!newPassword.equals(confirmPassword)) {
	            // Xử lý khi mật khẩu mới và nhập lại mật khẩu mới không khớp
	            request.setAttribute("repassError", "Mật khẩu không trùng khớp");
	            String jspPath = "/ChangePass.jsp";
		        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
		        rs.forward(request, response);
	            return;
	        }
	        
	        // Xác thực mật khẩu hiện tại 
	        TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
	        String storedPassword = null;
			try {
				storedPassword = taiKhoanDao.getPasswordFromDB(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // Kiểm tra mật khẩu hiện tại có chính xác không
	        try {
	        	byte[] encode = taiKhoanDao.getSaltFromDB(username);
				if (!storedPassword.equals(hashPassword(oldPassword, encode))) {
				    // Xử lý khi mật khẩu hiện tại không chính xác
				    request.setAttribute("oldpassError", "Mật khẩu cũ không chính xác");
				    String jspPath = "/ChangePass.jsp";
			        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
			        rs.forward(request, response);
				    return;
				}else {
					// Mật khẩu mới hợp lệ, tiến hành cập nhật vào cơ sở dữ liệu
					String changepass = hashPassword(newPassword, encode);
			        taiKhoanDao.updatePassword(username, changepass);
			        System.out.println(username + " " + changepass);
			        response.sendRedirect("Home");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
    }
    //hàm để mã háo mật khẩu
	private String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
		String hashedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt);
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			hashedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hashedPassword;
	}

}

package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import DAO.SignUpDao;
import Model.TaiKhoan;

/**
 * Servlet implementation class SignUp
 */
@WebServlet(urlPatterns = {"/SignUpServlet"})
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 // Phương thức để mã hóa mật khẩu
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

    private byte[] generateSalt() throws NoSuchAlgorithmException {
	    SecureRandom random = SecureRandom.getInstanceStrong();
	    byte[] salt = new byte[16];
	    random.nextBytes(salt);
	    return salt;
	}
    
    private boolean validateInputs(HttpServletRequest request, String username, String password, String repassword) {
        boolean isValid = true;

        if (username.isEmpty()) {
            request.setAttribute("usernameError", "Tên người dùng không được bỏ trống");
            isValid = false;
        }

        if (password.isEmpty()) {
            request.setAttribute("passwordError", "Mật khẩu không được bỏ trống");
            isValid = false;
        }

        if (repassword.isEmpty()) {
            request.setAttribute("repasswordError", "Vui lòng nhập lại mật khẩu");
            isValid = false;
        }

        if (password.length() < 8) {
            request.setAttribute("passwordError", "Mật khẩu phải có ít nhất 8 kí tự");
            isValid = false;
        }

        if (!Character.isUpperCase(password.charAt(0))) {
            request.setAttribute("passwordError", "Mật khẩu phải bắt đầu bằng chữ hoa");
            isValid = false;
        }

        if (!password.matches(".*[\\W_].*")) {
            request.setAttribute("passwordError", "Mật khẩu phải chứa ít nhất một kí tự đặc biệt");
            isValid = false;
        }


        return isValid;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		request.setCharacterEncoding("UTF-8");
		//
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repass");
		String position = request.getParameter("position");
		if (!validateInputs(request, user, pass, repass)) {
	        String jspPath = "/signup.jsp";
	        RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
	        rs.forward(request, response);
	        return;
	    }
		try {
			//tạp salt mới
			byte[] salt = generateSalt();
			//mã hóa mật khẩu
			String hashedPassword = hashPassword(pass, salt);
			
			boolean isGiasu = false;
			boolean isHocsinh = false;

			if (position != null) {
			    if (position.equals("giasu") && !position.isEmpty()) {
			        isGiasu = true;
			    } else if (position.equals("hocsinh") && !position.isEmpty()) {
			        isHocsinh = true;
			    }
			}
			String newPosition = request.getParameter("position");
			if (newPosition != null) {
			    if (newPosition.equals("giasu") && !newPosition.isEmpty()) {
			        isGiasu = true;
			        isHocsinh = false; // Bỏ chọn thẻ học sinh nếu đã được chọn trước đó
			    } else if (newPosition.equals("hocsinh") && !newPosition.isEmpty()) {
			        isHocsinh = true;
			        isGiasu = false; // Bỏ chọn thẻ gia sư nếu đã được chọn trước đó
			    }
			}
			
			if(!pass.equals(repass)) {
				String jspPath = "/signup.jsp";
				request.setAttribute("repasswordError", "Mật khẩu không trùng khớp");
				RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
				rs.forward(request,response);
			}else {
				SignUpDao sign = new SignUpDao();
				TaiKhoan a = sign.checkAccount(user);
				if(a != null) {
					//duoc sign up
					String jspPath = "/signup.jsp";
					request.setAttribute("usernameError", "Tài khoản đã tồn tại");
					RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
					rs.forward(request,response);
				} else {
					// day ve trang login
					TaiKhoan acc = new TaiKhoan(user, hashedPassword, position, salt);
					HttpSession session = request.getSession();
				    session.setAttribute("acc", acc);
					if(isGiasu) {
						String role = "giasu";
						sign.NewAccount(user, hashedPassword, role, salt);
						sign.NewInfoGS(user);
						response.sendRedirect("AddInfo");
//						String jspPath = "/login.jsp";
//						RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
//						rs.forward(request,response);
					}else if(isHocsinh) {
						String role = "hocsinh";
						sign.NewAccount(user, hashedPassword, role, salt);
						sign.NewInfoHS(user);
						response.sendRedirect("AddInfo");
//						String jspPath = "/login.jsp";
//						RequestDispatcher rs = getServletContext().getRequestDispatcher(jspPath);
//						rs.forward(request,response);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
		}
	}

}
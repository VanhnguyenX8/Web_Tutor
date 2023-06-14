package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TaiKhoanDao;
import DAO.UserDAO;
import DAO.UserHSDAO;
import Model.UserGS;
import Model.UserHS;
import Service.GiaSuService;
import Service.HocSinhService;

/**
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet(urlPatterns = {"/UpdateInfo"})
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GiaSuService giaSuService = new GiaSuService();
    HocSinhService hocSinhService = new HocSinhService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private List<String> validateInputs(String ten, String gioiTinh, Date ngaySinh, String diaChi, String soDienThoai, String email, String stk) {
        List<String> errorMessages = new ArrayList<>();

        // Kiểm tra không được bỏ trống
        if (ten.isEmpty() || gioiTinh.isEmpty() || ngaySinh == null || diaChi.isEmpty() || soDienThoai.isEmpty() || email.isEmpty() || stk.isEmpty()) {
            errorMessages.add("Vui lòng nhập đầy đủ thông tin.");
        }

        // Kiểm tra định dạng email
        if (!email.matches(".+@.+\\..+")) {
            errorMessages.add("Định dạng email không hợp lệ.");
        }

        return errorMessages;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
    	Model.TaiKhoan account = (Model.TaiKhoan) session.getAttribute("acc");
    	boolean isLoggedIn = (account != null);
    	
    	// Kiểm tra yêu cầu đăng xuất
	    String logoutParam = request.getParameter("logout");
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
        	        request.setAttribute("giaSu", giaSu);
        	        RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateInfo.jsp");
        	        dispatcher.forward(request, response);
        	    }
    	    }else if(position.equals("hocsinh")) {
    	    	UserHS hocSinh = hocSinhService.getHocSinhByUsername(username);
    	    	if(hocSinh != null && hocSinh.getUsername() != null) {
    	    		request.setAttribute("hocSinh", hocSinh);
    	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateInfo.jsp");
        	        dispatcher.forward(request, response);
    	    	}
    	    }
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
	    Model.TaiKhoan account = (Model.TaiKhoan) session.getAttribute("acc");
	    boolean isLoggedIn = (account != null);
	    if(isLoggedIn) {
	    	String ten = request.getParameter("name");
	    	String gioiTinh = request.getParameter("gender");
	    	String ngaySinhString = request.getParameter("ngaySinh");
//	    	System.out.println(ngaySinhString);
	    	String diaChi = request.getParameter("address");
	    	String soDienThoai = request.getParameter("phone");
	    	String email = request.getParameter("email");
	    	String stk = request.getParameter("bankAccount");
	    	String username = account.getUsername();//Lấy tên người dùng
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	java.util.Date ngaySinhUtil = null;
	    	try {
	    	    ngaySinhUtil = dateFormat.parse(ngaySinhString);
//	    	    System.out.println(ngaySinhUtil);
	    	} catch (ParseException e) {
	    	    e.printStackTrace();
	    	}
	    	java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinhUtil.getTime());
	    	// Lấy vai trò người dùng
	    	String position = account.getRole(); 

	    	if (position.equals("giasu")) {
	    	    // Kiểm tra thông tin đầu vào
	    		List<String> errorMessages = validateInputs(ten, gioiTinh, ngaySinhSQL, diaChi, soDienThoai, email, stk);
	    	    
	    	    if (errorMessages.isEmpty()) {
	    	        // Tạo một đối tượng GiaSu từ thông tin đã lấy
	    	    	UserDAO userDAO = new UserDAO();
	    	        UserGS userGS;
					try {
						userGS = userDAO.getByUserName(username);
						userGS.setTen_gia_su(ten);
						userGS.setGioi_tinh(gioiTinh);
			    	    userGS.setNam_sinh(ngaySinhSQL);
			    	    userGS.setDia_chi(diaChi);
			    	    userGS.setSdt(soDienThoai);
			    	    userGS.setEmail(email);
			    	    userGS.setSotaikhoan(stk);
			    	    userGS.setUsername(username);
			    	    // Lưu dữ liệu vào cơ sở dữ liệu bằng cách gọi phương thức từ DAO
			    	    giaSuService.insertGiaSu(userGS);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	        // Redirect về trang chính sau khi lưu thành công
	    	        response.sendRedirect("Home");
	    	    } else {
	    	        // Trường thông tin không hợp lệ, xử lý lỗi tại đây
	    	        request.setAttribute("ten", ten);
	    	        request.setAttribute("gioiTinh", gioiTinh);
	    	        request.setAttribute("ngaySinh", ngaySinhString);
	    	        request.setAttribute("diaChi", diaChi);
	    	        request.setAttribute("soDienThoai", soDienThoai);
	    	        request.setAttribute("email", email);
	    	        request.setAttribute("stk", stk);
	    	        request.setAttribute("username", username);
	    	        request.getRequestDispatcher("/ThemTT.jsp").forward(request, response);
	    	    }
	    	} else if (position.equals("hocsinh")) {
	    	    // Kiểm tra thông tin đầu vào
	    	    List<String> errorMessages = validateInputs(ten, gioiTinh, ngaySinhSQL, diaChi, soDienThoai, email, stk);
	    	    if (errorMessages.isEmpty()) {
	    	    	UserHSDAO userHSDAO = new UserHSDAO();
	    	    	UserHS userHS;
					try {
						userHS = userHSDAO.getByUsername(username);
						// Tạo một đối tượng HocSinh từ thông tin đã lấy
		    	        userHS.setTen_hoc_sinh(ten);
		    	        userHS.setGioi_tinh(gioiTinh);
		    	        userHS.setNam_sinh(ngaySinhSQL);
		    	        userHS.setDia_chi(diaChi);
		    	        userHS.setSdt(soDienThoai);
		    	        userHS.setEmail(email);
		    	        userHS.setSo_tai_khoan(stk);
		    	        userHS.setUsername(username);
		    	        // Lưu dữ liệu vào cơ sở dữ liệu bằng cách gọi phương thức từ DAO
		    	        hocSinhService.insertHocSinh(userHS);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	        // Redirect về trang chính sau khi lưu thành công
	    	        response.sendRedirect("Home");
	    	    } else {
	    	        // Trường thông tin không hợp lệ, xử lý lỗi tại đây
	    	        request.setAttribute("errorMessages", errorMessages);
	    	        request.setAttribute("ten", ten);
	    	        request.setAttribute("gioiTinh", gioiTinh);
	    	        request.setAttribute("ngaySinh", ngaySinhString);
	    	        request.setAttribute("diaChi", diaChi);
	    	        request.setAttribute("soDienThoai", soDienThoai);
	    	        request.setAttribute("email", email);
	    	        request.setAttribute("stk", stk);
	    	        request.setAttribute("username", username);
	    	        request.getRequestDispatcher("/ThemTT.jsp").forward(request, response);
	    	    }
	    	}

	    }
	}
}

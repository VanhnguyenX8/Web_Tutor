package Controller;

import java.io.IOException;
import java.sql.Date;
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

/**
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet(urlPatterns = {"/UpdateInfo"})
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO giaSuDAO;   
	private UserHSDAO hocSinhDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
        giaSuDAO = new UserDAO();
        hocSinhDAO = new UserHSDAO();
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateInfo.jsp");
	    dispatcher.forward(request, response);
		
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
	    	TaiKhoanDao taiKhoanDao = new TaiKhoanDao();
	    	
	    	String ten = request.getParameter("name");
        	if (ten == null) {
        	    ten = "";
        	}
	    	String gioiTinh = request.getParameter("gender");
	    	if (gioiTinh == null) {
	    		gioiTinh = "";
	    	}
	    	String ngaySinhString = request.getParameter("ngaySinh");
	    	if (ngaySinhString == null) {
	    		ngaySinhString = "";
	    	}
//	    	System.out.println(ngaySinhString);
	    	String diaChi = request.getParameter("address");
	    	if (diaChi == null) {
        	    diaChi = "";
        	}
	    	String soDienThoai = request.getParameter("phone");
	    	if (soDienThoai == null) {
        	    soDienThoai = "";
        	}
	    	String email = request.getParameter("email");
	    	if (email == null) {
        	    email = "";
        	}
	    	String stk = request.getParameter("bankAccount");
	    	if (stk == null) {
        	    stk = "";
        	}
	    	String username = account.getUsername();
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	java.util.Date ngaySinhUtil = null;
	    	try {
	    	    ngaySinhUtil = dateFormat.parse(ngaySinhString);
//	    	    System.out.println(ngaySinhUtil);
	    	} catch (ParseException e) {
	    	    e.printStackTrace();
	    	}
	    	java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinhUtil.getTime());
	    	String position = account.getRole(); 

	    	if (position.equals("giasu")) {
	    	    // Kiểm tra thông tin đầu vào
	    		List<String> errorMessages = validateInputs(ten, gioiTinh, ngaySinhSQL, diaChi, soDienThoai, email, stk);
	    	    
	    	    if (errorMessages.isEmpty()) {
	    	        // Tạo một đối tượng GiaSu từ thông tin đã lấy
	    	        UserGS userGS = new UserGS();
	    	        userGS.setTen_gia_su(ten);
	    	        userGS.setGioi_tinh(gioiTinh);
	    	        userGS.setNam_sinh(ngaySinhSQL);
	    	        userGS.setDia_chi(diaChi);
	    	        userGS.setSdt(soDienThoai);
	    	        userGS.setEmail(email);
	    	        userGS.setSotaikhoan(stk);
	    	        userGS.setUsername(username);
	    	        // Lưu dữ liệu vào cơ sở dữ liệu bằng cách gọi phương thức từ DAO
	    	        giaSuDAO.saveGiaSu(userGS);
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
	    	        // Tạo một đối tượng HocSinh từ thông tin đã lấy
	    	        UserHS userHS = new UserHS();
	    	        userHS.setTen_hoc_sinh(ten);
	    	        userHS.setGioi_tinh(gioiTinh);
	    	        userHS.setNam_sinh(ngaySinhSQL);
	    	        userHS.setDia_chi(diaChi);
	    	        userHS.setSdt(soDienThoai);
	    	        userHS.setEmail(email);
	    	        userHS.setSo_tai_khoan(stk);
	    	        userHS.setUsername(username);
	    	        // Lưu dữ liệu vào cơ sở dữ liệu bằng cách gọi phương thức từ DAO
	    	        hocSinhDAO.saveHocSinh(userHS);
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

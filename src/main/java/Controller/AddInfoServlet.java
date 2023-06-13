package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class AddInfoServlet
 */
@WebServlet(urlPatterns = "/AddInfo")
public class AddInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO giaSuDAO;   
	private UserHSDAO hocSinhDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
        giaSuDAO = new UserDAO();
        hocSinhDAO = new UserHSDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
	    	String gioiTinh = request.getParameter("gender");
	    	String ngaySinhString = request.getParameter("ngaySinh");
	    	System.out.println(ngaySinhString);
	    	String diaChi = request.getParameter("address");
	    	String soDienThoai = request.getParameter("phone");
	    	String email = request.getParameter("email");
	    	String stk = request.getParameter("bankAccount");
	    	String username = account.getUsername();
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	System.out.println(ten);
	    	java.util.Date ngaySinhUtil = null;
	    	try {
	    	    ngaySinhUtil = dateFormat.parse(ngaySinhString);
	    	    System.out.println(ngaySinhUtil);
	    	} catch (ParseException e) {
	    	    e.printStackTrace();
	    	}
	    	java.sql.Date ngaySinhSQL = new java.sql.Date(ngaySinhUtil.getTime());
	    	String position = account.getRole(); 

	    	if (position.equals("giasu")) {
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
	        } else if (position.equals("hocsinh")) {
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
		        hocSinhDAO.saveHocSinh(userHS);
	        }
	        
	        // Redirect về trang chính sau khi lưu thành công
	        response.sendRedirect("Home");
	    }
	    
	}

}

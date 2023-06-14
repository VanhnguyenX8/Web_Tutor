package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CamXucDAO;
import DAO.CommentChiTietSP;
import DAO.RatingDAO;
import Model.BinhLuan;
import Model.LopHoc;
import Model.TaiKhoan;
import Service.LopHocService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/profileLH")

public class ProfileLHServlet extends HttpServlet {
    LopHocService lopHocService = new LopHocService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	HttpSession session = req.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("acc");
        String username = tk.getUsername();
        CamXucDAO like = new CamXucDAO();
        RatingDAO rating = new RatingDAO();
        req.setAttribute("username", username);
        
        String idLH = req.getParameter("id");
        System.out.println("in ra id hop loc" +idLH );
        LopHoc lopHoc = lopHocService.getlopHocById(idLH);
        session.setAttribute("idLopHoc", idLH);
        req.setAttribute("lopHoc", lopHoc);
        try {
			boolean hasLiked = like.hasLiked(idLH, "vanhnguyenx8");
			System.out.println("bollen của người dăng nhập" + hasLiked);
			req.setAttribute("hasLiked", hasLiked);
			int tongSoLuotThich = like.getLikeCount(idLH);
			double danhgia = 0;
	 danhgia = rating.calculateAverageRating(idLH);
			System.out.println("tong danh gia" + danhgia);
			req.setAttribute("tongSoLuotThich", tongSoLuotThich);
			req.setAttribute("averageRating", danhgia);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
try {
			
			CommentChiTietSP ccmt = new CommentChiTietSP();
			List<BinhLuan> cmt = ccmt.getallcmt(idLH);
			req.setAttribute("datacmt", cmt);
		} catch (Exception e) {
			// TODO: handle exception
		}
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profileLopHoc.jsp");
        dispatcher.forward(req, resp);
    }
}

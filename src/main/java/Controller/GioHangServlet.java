package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.GioHangDAO;
import DAO.HocSinhDAO;
import Model.GioHang;
import Model.UserHS;

/**
 * Servlet implementation class GioHangServlet
 */
@WebServlet(name = "GioHangServlet", urlPatterns = {"/Pull", "/Push", "/Delete", "/Confirm"})
public class GioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/Pull")) {
			
			String username = request.getParameter("username");
			
			ArrayList<GioHang> gh = new GioHangDAO().getGioHang(username);
			
			String json = getGioHangJson(gh);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
		}
		else{
			if(path.equals("/Confirm")) {
				String username = request.getParameter("username");
				int so_du_moi = Integer.parseInt(request.getParameter("so_du_moi"));
				String bac_hoc = request.getParameter("bac_hoc");
				try {
					new GioHangDAO().confirmGioHang(username, so_du_moi, bac_hoc);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				String username = request.getParameter("username");
				String id_lop_hoc = request.getParameter("id_lop_hoc");
				if(path.equals("/Push")) {
					
					new GioHangDAO().editGioHang(username, id_lop_hoc, 0);
				}
				else if(path.equals("/Delete")) {
					
					new GioHangDAO().editGioHang(username, id_lop_hoc, 1);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String getGioHangJson(ArrayList<GioHang> gh) {
		Gson gson = new Gson();
		String ans = gson.toJson(gh);
		
		return ans;
	}
}

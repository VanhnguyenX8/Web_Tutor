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

import DAO.LopHocDKDAO;
import Model.LopHoc;

/**
 * Servlet implementation class LopHocServlet
 */
//@WebServlet("/LopHocServlet")
@WebServlet(name = "LopHocServlet", urlPatterns = {"/TieuHoc", "/THCS", "/THPT", "/All"})
public class LopHocDKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LopHocDKServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		ArrayList<LopHoc> lopHoc;
 		
		if(path.equals("/TieuHoc")) {
			lopHoc = new LopHocDKDAO().getLopHoc(0);
		}
		else if(path.equals("/THCS")) {
			lopHoc = new LopHocDKDAO().getLopHoc(1);
		}
		else if(path.equals("/THPT")){
			lopHoc = new LopHocDKDAO().getLopHoc(2);
		}
		else{
			String username = request.getParameter("username");
			lopHoc = new LopHocDKDAO().getLopHoc(username);
		}
		String json = getLopHocJson(lopHoc);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String getLopHocJson(ArrayList<LopHoc> lopHoc) {

//		System.out.println(lopHoc);
		Gson gson = new Gson();
		String ans = gson.toJson(lopHoc);
//		System.out.println(ans);
		return ans;
	}
	
}

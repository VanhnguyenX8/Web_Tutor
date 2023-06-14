package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CamXucDAO;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String idlophoc = (String) session.getAttribute("idLopHoc");
		boolean hasLiked =  (Boolean) session.getAttribute("hasLiked");
		System.out.println("lay bollen khi bam post" + hasLiked);
		try {
			CamXucDAO like = new CamXucDAO();
			System.out.println("bien like trong csdl" + hasLiked);
			  String likeParam = request.getParameter("like");
			  System.out.println("booleen like" + likeParam);
			  System.out.println("booleen hasLiked" + hasLiked);
			  System.out.println("id lop hoc" + idlophoc);
           if(likeParam != null && likeParam.equals("true")) {
        	   System.out.println("da vao ham if này");
        	   if (hasLiked) {
                   // Người dùng đã like, xóa lượt like
        		   System.out.println("da vao ham haslike");
        		   like.removeLike(idlophoc, "vanhnguyenx8");
        		   
               	
               } else {
                   // Người dùng chưa like, thêm lượt like mới
            	   like.addLike(idlophoc, "vanhnguyenx8");
               }	
           }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
			response.sendRedirect("profileLH?id=" + idlophoc);
	}

}

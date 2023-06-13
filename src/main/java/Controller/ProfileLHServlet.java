package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.LopHoc;
import Model.TaiKhoan;
import Service.LopHocService;

import java.io.IOException;

@WebServlet(urlPatterns = "/profileLH")

public class ProfileLHServlet extends HttpServlet {
    LopHocService lopHocService = new LopHocService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	HttpSession session = req.getSession();
        TaiKhoan tk = (TaiKhoan)session.getAttribute("acc");
        String username = tk.getUsername();
        req.setAttribute("username", username);
        
        String idLH = req.getParameter("id");
        LopHoc lopHoc = lopHocService.getlopHocById(idLH);
        req.setAttribute("lopHoc", lopHoc);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/profileLopHoc.jsp");
        dispatcher.forward(req, resp);
    }
}

package Controller.dashboard;

import DAO.dashboard.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/giasu")

public class DashboardTutorServlet extends HttpServlet {
    public DashboardTutorServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setCharacterEncoding("UTF-8");
    	String action = req.getParameter("actionGiaSu");
        if (action != null) {
            if (action.equals("list_giasu")) {
                DashboardTutorDAO gs = new DashboardTutorDAO();
                resp.setContentType("application/json");

                // Ghi mảng JSON vào body của response
                resp.getWriter().write(gs.getListGiaSu().toString());
            }
        } else {
            req.getRequestDispatcher("./dashboard-tutor.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        DashboardTutorDAO gs = new DashboardTutorDAO();
        // Ghi mảng JSON vào body của response
        gs.updateGiaSu(username);
        Map<String, Integer> map = new HashMap<>();
        map.put("check", 1);
        JSONObject obj = new JSONObject(map);
        resp.getWriter().write(obj.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        DashboardTutorDAO gs = new DashboardTutorDAO();
        gs.deleteGiaSu(username);
        Map<String, Integer> map = new HashMap<>();
        map.put("check", 1);
        JSONObject obj = new JSONObject(map);
        resp.getWriter().write(obj.toString());
    }
}

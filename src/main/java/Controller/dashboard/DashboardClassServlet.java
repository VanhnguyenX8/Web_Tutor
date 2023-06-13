package Controller.dashboard;

import DAO.dashboard.DashboardClassDAO;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/lophoc")

public class DashboardClassServlet extends HttpServlet {
    public DashboardClassServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setCharacterEncoding("UTF-8");
    	String action = req.getParameter("actionLopHoc");
        if(action != null){
            if(action.equals("list_lophoc")){
                DashboardClassDAO lh = new DashboardClassDAO();
                resp.setContentType("application/json");

                // Ghi mảng JSON vào body của response
                resp.getWriter().write(lh.getListLopHoc().toString());
            }
        }else {
            req.getRequestDispatcher("./dashboard-class.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            DashboardClassDAO lh = new DashboardClassDAO();
            lh.updateLopHoc(id);
            resp.setContentType("application/json");

            // Ghi mảng JSON vào body của response
            Map<String,Integer> map = new HashMap<>();
            map.put("check",1);
            JSONObject obj = new JSONObject(map);
            resp.getWriter().write(obj.toString());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            DashboardClassDAO lh = new DashboardClassDAO();
            lh.deleteLopHoc(id);
            resp.setContentType("application/json");

            // Ghi mảng JSON vào body của response
            Map<String,Integer> map = new HashMap<>();
            map.put("check",1);
            JSONObject obj = new JSONObject(map);
            resp.getWriter().write(obj.toString());
    }
}

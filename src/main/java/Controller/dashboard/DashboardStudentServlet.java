package Controller.dashboard;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import DAO.dashboard.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hocsinh")
public class DashboardStudentServlet extends HttpServlet {
    public DashboardStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("actionHocSinh");
        if (action != null) {
            if (action.equals("list_hocsinh")) {
                DashboardStudentDAO hs = new DashboardStudentDAO();
                resp.setContentType("application/json");
                // Ghi mảng JSON vào body của response
                resp.getWriter().write(hs.getListHocSinh().toString());

            }
        } else {
            req.getRequestDispatcher("./dashboard-student.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("check");
        DashboardStudentDAO hs = new DashboardStudentDAO();
        hs.deleteHocSinh(username);
        resp.setContentType("application/json");
        // Ghi mảng JSON vào body của response
        Map<String, Integer> map = new HashMap<>();
        map.put("check", 1);
        JSONObject obj = new JSONObject(map);
        resp.getWriter().write(obj.toString());
    }
}

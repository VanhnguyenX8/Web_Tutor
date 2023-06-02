package com.example.dashboardweb.controller;

import com.example.dashboardweb.DAO.HocSinhDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/hocsinh")
public class HocSinhServlet extends HttpServlet {
    public HocSinhServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("actionHocSinh");
        if (action != null) {
            if (action.equals("list_hocsinh")) {
                HocSinhDAO hs = new HocSinhDAO();
                resp.setContentType("application/json");
                // Ghi mảng JSON vào body của response
                resp.getWriter().write(hs.getListHocSinh().toString());

            }
        } else {
            req.getRequestDispatcher("./hocsinh.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("check");
        HocSinhDAO hs = new HocSinhDAO();
        hs.deleteHocSinh(username);
        resp.setContentType("application/json");
        // Ghi mảng JSON vào body của response
        Map<String, Integer> map = new HashMap<>();
        map.put("check", 1);
        JSONObject obj = new JSONObject(map);
        resp.getWriter().write(obj.toString());
    }
}

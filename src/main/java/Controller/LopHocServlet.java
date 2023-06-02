package com.example.dashboardweb.controller;

import com.example.dashboardweb.DAO.GiaSuDAO;
import com.example.dashboardweb.DAO.LopHocDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/lophoc")

public class LopHocServlet extends HttpServlet {
    public LopHocServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("actionLopHoc");
        if(action != null){
            if(action.equals("list_lophoc")){
                LopHocDAO lh = new LopHocDAO();
                resp.setContentType("application/json");

                // Ghi mảng JSON vào body của response
                resp.getWriter().write(lh.getListLopHoc().toString());
            }
        }else {
            req.getRequestDispatcher("./lophoc.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            LopHocDAO lh = new LopHocDAO();
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
            int id = Integer.parseInt(req.getParameter("id"));
            LopHocDAO lh = new LopHocDAO();
            lh.deleteLopHoc(id);
            resp.setContentType("application/json");

            // Ghi mảng JSON vào body của response
            Map<String,Integer> map = new HashMap<>();
            map.put("check",1);
            JSONObject obj = new JSONObject(map);
            resp.getWriter().write(obj.toString());
    }
}

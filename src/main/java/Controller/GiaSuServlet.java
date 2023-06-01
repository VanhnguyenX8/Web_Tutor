package com.example.dashboardweb.controller;

import com.example.dashboardweb.DAO.GiaSuDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/giasu")

public class GiaSuServlet extends HttpServlet {
    public GiaSuServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("actionGiaSu");
        if (action != null) {
            if (action.equals("list_giasu")) {
                GiaSuDAO gs = new GiaSuDAO();
                resp.setContentType("application/json");

                // Ghi mảng JSON vào body của response
                resp.getWriter().write(gs.getListGiaSu().toString());
            }


        } else {
            req.getRequestDispatcher("./giasu.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        GiaSuDAO gs = new GiaSuDAO();
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
        GiaSuDAO gs = new GiaSuDAO();
        gs.deleteGiaSu(username);
        Map<String, Integer> map = new HashMap<>();
        map.put("check", 1);
        JSONObject obj = new JSONObject(map);
        resp.getWriter().write(obj.toString());
    }
}

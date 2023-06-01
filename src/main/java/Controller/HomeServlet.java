package com.example.dashboardweb.controller;

import com.example.dashboardweb.DAO.GiaSuDAO;
import com.example.dashboardweb.DAO.HocSinhDAO;
import com.example.dashboardweb.DAO.LopHocDAO;
import com.example.dashboardweb.DAO.TaiChinhDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(urlPatterns = "/home")

public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "loinhuan":
                    try {
                        TaiChinhDAO tc = new TaiChinhDAO();
                        JSONArray obj = new JSONArray();
                        obj.put(tc.tinhLoiNhuanTheoNam());
                        response.setContentType("application/json");

                        // Ghi mảng JSON vào body của response
                        response.getWriter().write(obj.toString());
                    } catch (IOException | JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case "tyle":
                    try {
                        TaiChinhDAO tc = new TaiChinhDAO();
                        JSONObject obj = new JSONObject(tc.tinhPhanTramChiTraChoGiaSu());

                        response.setContentType("application/json");

                        // Ghi mảng JSON vào body của response
                        response.getWriter().write(obj.toString());
                    }catch (IOException | JSONException e){
                        e.printStackTrace();
                    }
                case "dangkilophoc":
                    try {
                        String startDate = request.getParameter("startDate");
                        String endDate = request.getParameter("endDate");
                        if (startDate != null && endDate != null){
                            LopHocDAO lh = new LopHocDAO();
                            JSONArray obj =  new JSONArray();
                            obj.put(lh.soLopMoTheoNgay(startDate,endDate));
                            response.setContentType("application/json");

                            // Ghi mảng JSON vào body của response
                            response.getWriter().write(obj.toString());
                        }
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    GiaSuDAO gs = new GiaSuDAO();
                    HocSinhDAO hs = new HocSinhDAO();
                    LopHocDAO lh = new LopHocDAO();
                    TaiChinhDAO tc = new TaiChinhDAO();
                    JSONObject obj = new JSONObject();
                    obj.put("soLuongGiaSu",gs.countGiaSu());
                    obj.put("soLuongHocSinh",hs.countHocSinh());
                    obj.put("soLuongLopHoc",lh.countLopHoc());
                    obj.put("tongDoanhThu",tc.getTongDoanhThu());
                    response.setContentType("application/json");

                    // Ghi mảng JSON vào body của response
                    response.getWriter().write(obj.toString());
                    break;
            }
        } else {
            request.getRequestDispatcher("./home.jsp").forward(request, response);
        }
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

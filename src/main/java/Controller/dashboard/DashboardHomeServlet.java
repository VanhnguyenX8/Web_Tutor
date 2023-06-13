package Controller.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import DAO.dashboard.DashboardClassDAO;
import DAO.dashboard.DashboardFinanceDAO;
import DAO.dashboard.DashboardStudentDAO;
import DAO.dashboard.DashboardTutorDAO;

@WebServlet(urlPatterns = "/home_dashboard")

public class DashboardHomeServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    public DashboardHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "loinhuan":
                    try {
                        DashboardFinanceDAO tc = new DashboardFinanceDAO();
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
                        DashboardFinanceDAO tc = new DashboardFinanceDAO();
                        JSONObject obj = new JSONObject(tc.tinhPhanTramChiTraChoGiaSu());

                        ((ServletResponse) response).setContentType("application/json");

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
                            DashboardClassDAO lh = new DashboardClassDAO();
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
                    DashboardTutorDAO gs = new DashboardTutorDAO();
                    DashboardStudentDAO hs = new DashboardStudentDAO();
                    DashboardClassDAO lh = new DashboardClassDAO();
                    DashboardFinanceDAO tc = new DashboardFinanceDAO();
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
            request.getRequestDispatcher("./dashboard-home.jsp").forward(request, response);
        }
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

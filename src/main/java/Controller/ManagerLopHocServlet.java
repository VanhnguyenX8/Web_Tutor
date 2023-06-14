package Controller;

import Model.TaiKhoan;
import Model.LopHoc;
import Service.GiaSuService;
import Service.LopHocService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/managerLopHoc")
public class ManagerLopHocServlet extends HttpServlet {
    LopHocService lopHocService = new LopHocService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TaiKhoan account = (TaiKhoan) session.getAttribute("acc");
        String action = req.getParameter("action");
        RequestDispatcher dispatcher = null;
        String idLH = req.getParameter("id");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                dispatcher = req.getRequestDispatcher("/lopHoc/create.jsp");
                break;
            case "edit":
                req.setAttribute("lopHoc", lopHocService.getlopHocById(idLH));
                dispatcher = req.getRequestDispatcher("/lopHoc/edit.jsp");
                break;
            case "delete":
                lopHocService.deletelopHoc(idLH);
                resp.sendRedirect("managerLopHoc");
                return;
            case "accept":
                lopHocService.acceptLopHoc(1, idLH);
                resp.sendRedirect("managerLopHoc");
                return;
            case "unAccept":
                lopHocService.acceptLopHoc(0, idLH);
                resp.sendRedirect("managerLopHoc");
                return;
            default:
                showLopHoc(req, resp, account);
                return;
        }

        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("UTF-8");
        try {
            HttpSession session = req.getSession();
            TaiKhoan account = (TaiKhoan) session.getAttribute("acc");
            String action = req.getParameter("action");
            RequestDispatcher dispatcher = null;
            if (action == null) {
                action = "";
            }
            String id = req.getParameter("id");
            Integer hour = Integer.parseInt(req.getParameter("hour"));
            int lever = Integer.parseInt(req.getParameter("lever"));
            String name = req.getParameter("name");
            String usernameHS = req.getParameter("usernameHS");
            String date = req.getParameter("date");
            String img = req.getParameter("img");
            int price = Integer.parseInt(req.getParameter("price"));
            int priceGS = Integer.parseInt(req.getParameter("priceGS"));
            String content = req.getParameter("content");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LopHoc lopHoc;
            String idLH = "";
            if (id != null) {
                idLH = id;
                lopHoc = new LopHoc(usernameHS, account.getUsername(), name, hour, dateFormat.parse(date), price,
                        priceGS, content, img);
            } else {
                lopHoc = new LopHoc(account.getUsername(), name, hour, dateFormat.parse(date), price, priceGS, content,
                        img, 0, lever);
            }

            switch (action) {
                case "create":
                    lopHocService.insertlopHoc(lopHoc);
                    break;
                case "edit":
                    lopHocService.updatelopHoc(lopHoc);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/managerLopHoc");
    }

    public void showLopHoc(HttpServletRequest req, HttpServletResponse resp, TaiKhoan account) {
        try {
            String khoi = req.getParameter("lever");
            if (khoi == null) {
                khoi = "1";
            }

            req.setAttribute("acc", account);
            if (account.getRole().equals("mod")) {
                req.setAttribute("lopHocs", lopHocService.getLopHocByLever(Integer.parseInt(khoi), true));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/lopHoc/show.jsp");
                dispatcher.forward(req, resp);
            } else {
                if ("giasu".equals(account.getRole())) {
                    req.setAttribute("lopHocs",
                            lopHocService.getLopHocByGSAndLever(account.getUsername(), Integer.parseInt(khoi)));
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/lopHoc/show.jsp");
                    dispatcher.forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
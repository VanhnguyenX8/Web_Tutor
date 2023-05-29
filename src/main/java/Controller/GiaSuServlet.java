package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Model.UserGS;

import java.io.IOException;

@WebServlet("/giasu")
public class GiaSuServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin gia sư từ cơ sở dữ liệu
        String giaSuId = request.getParameter("id");
        UserGS giaSu = giaSuDao.getGiaSuById(giaSuId); // Giả sử giaSuDao là đối tượng truy cập cơ sở dữ liệu

        // Lưu thông tin gia sư vào request để truyền cho trang cập nhật
        request.setAttribute("giaSu", giaSu);

        // Chuyển đến trang cập nhật thông tin cá nhân
        request.getRequestDispatcher("/updateProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin cập nhật từ yêu cầu
        String giaSuId = request.getParameter("id");
        String updatedName = request.getParameter("name");
        String updatedEmail = request.getParameter("email");
        // ...

        // Cập nhật thông tin gia sư trong cơ sở dữ liệu
        UserGS giaSu = UserDAO.getGiaSuByUsername();
        // viết thêm 
        giaSu.setTenGS(updatedName);
        giaSu.setEmail(updatedEmail);
        // ...

        giaSuDao.updateGiaSu(giaSu); // Giả sử giaSuDao hỗ trợ cập nhật thông tin gia sư

        // Chuyển đến trang profile để hiển thị thông tin cập nhật
        response.sendRedirect("/profile?id=" + giaSuId);
    }
}

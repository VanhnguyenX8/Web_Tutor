package Service;

import DAO.UserDAO;
import Model.UserGS;

import java.sql.SQLException;
import java.util.List;

public class GiaSuService {
    private static final String GiaSuDAO = null;
	UserDAO giaSuDAO = new UserDAO();
    public void insertGiaSu(UserGS giaSu) {
        giaSuDAO.saveGiaSu(giaSu);
		System.out.println("Thêm thành công!");
    }

    //Lấy tt GS theo username thông qua giaSuDAO
    public UserGS getGiaSuByUsername(String username) {
        try {
            UserGS GiaSu = giaSuDAO.getByUserName(username);
            if (GiaSu != null) {
                return GiaSu;
            } else {
                System.out.println("Không tìm thấy GS có Username: " + username);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn: " + e.getMessage());
        }
        return null;
    }
    
    public int countHocSinhByGiaSuUsername(String username) {
        try {
            return giaSuDAO.countHocSinhByGiaSuUsername(username);
        } catch (SQLException e) {
            return 0;
        }
    }
}
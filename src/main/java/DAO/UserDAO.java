package DAO;

import java.security.AlgorithmParametersSpi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import Model.UserGS;

public class UserDAO {
    TaiKhoanDao taikhoanDao = new TaiKhoanDao();
    MonHocDAO monHocDAO = new MonHocDAO();
    public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	public String getNameFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String Name = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT ten_gia_su FROM giasu WHERE username = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, username);
	        // Thực thi câu truy vấn
	        resultSet = statement.executeQuery();
	        // Xử lý kết quả truy vấn
	        if (resultSet.next()) {
	            Name = resultSet.getString("ten_gia_su");
	        }
	        return Name;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ và thông báo lỗi
	    }
	    return null;
	}
	//lấy email của gia sư theo username
	public String getEmailFromDatabase(String username) throws SQLException{
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    String email = null;
	    try {
	        // Chuẩn bị câu truy vấn
	        String query = "SELECT email FROM giasu WHERE username = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, username);
	        // Thực thi câu truy vấn
	        resultSet = statement.executeQuery();
	        // Xử lý kết quả truy vấn
	        if (resultSet.next()) {
	            email = resultSet.getString("email");
	        }
	        return email;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ và thông báo lỗi
	    }
	    return null;
	}
    //thêm thông tin mới sau đăng kí
    public void saveGiaSu(UserGS giaSu) {
        try {
            String sql = "update giasu "
            		+ "set ten_gia_su = ?, gioi_tinh = ?, nam_sinh = ?, sdt = ?, email = ?, dia_chi = ?,  so_tai_khoan = ? "
            		+ "where username = ?;";
            PreparedStatement statement = con.prepareStatement(sql);
            statement = con.prepareStatement(sql);
            statement.setString(1, giaSu.getTen_gia_su());
            statement.setString(2, giaSu.getGioi_tinh());
            statement.setDate(3, giaSu.getNam_sinh());
            statement.setString(4, giaSu.getSdt());
            statement.setString(5, giaSu.getEmail());
            statement.setString(6, giaSu.getDia_chi());
            statement.setString(7, giaSu.getSotaikhoan());
            statement.setString(8, giaSu.getUsername());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
  //Lấy tt GS theo username
    public UserGS getByUserName(String username) throws SQLException {
        String query = "SELECT * FROM giasu WHERE username = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	String id = resultSet.getString("id");
            String tenGS = resultSet.getString("ten_gia_su");
            Date ngaySinh = resultSet.getDate("nam_sinh");
            String sdt = resultSet.getString("sdt");
            String email = resultSet.getString("email");
            String stk = resultSet.getString("so_tai_khoan");
            String gioiTinh = resultSet.getString("gioi_tinh");
            String diaChi = resultSet.getString("dia_chi");
            int chuathanhtoan = resultSet.getInt("chua_thanh_toan");
            String img = resultSet.getString("hinh_anh");
            int sodutaikhoan = resultSet.getInt("so_du_tai_khoan");
            return new UserGS(id, tenGS, ngaySinh, sdt, email, stk, username, gioiTinh, diaChi, chuathanhtoan, img, sodutaikhoan);
        }
        return null;
    }
    public UserGS getGiaSuByUsername(String username) throws SQLException {
        String query = "SELECT * FROM giasu WHERE username = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToGiaSu(resultSet);
                }
            }
        }

        return null;
    }

    public int countHocSinhByGiaSuUsername(String giaSuUsername) throws SQLException {
        String query = "SELECT COUNT(*) FROM LopHoc lh LEFT JOIN HocSinh hs ON lh.id = hs.lop_hoc_id WHERE lh.username_gia_su = ? AND (hs.id IS NULL OR hs.id <> 0)";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, giaSuUsername);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }

        return 0;
    }

    private UserGS mapResultSetToGiaSu(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String tenGiaSu = resultSet.getString("ten_gia_su");
        Date namSinh = resultSet.getDate("nam_sinh");
        String sdt = resultSet.getString("sdt");
        String email = resultSet.getString("email");
        String soTaiKhoan = resultSet.getString("so_tai_khoan");
        String username = resultSet.getString("username");
        String gioiTinh = resultSet.getString("gioi_tinh");
        String diaChi = resultSet.getString("dia_chi");
        int chuaThanhToan = resultSet.getInt("chua_thanh_toan");
        String hinhAnh = resultSet.getString("hinh_anh");
        int soDuTaiKhoan = resultSet.getInt("so_du_tai_khoan");

        return new UserGS(id, tenGiaSu, namSinh, sdt, email, soTaiKhoan, username, gioiTinh, diaChi, chuaThanhToan, hinhAnh, soDuTaiKhoan);
    }
}
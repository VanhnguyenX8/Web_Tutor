package DAO;

import Model.UserGS;
import Model.LopHoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.sql.Statement;

public class LopHocDAO extends DBconnect {
    public DBconnect db = new DBconnect();
    Connection con = db.DBconnect();

    public void create(LopHoc lopHoc) throws SQLException {
        String query = "INSERT INTO LopHoc (username_hoc_sinh, username_gia_su, ten_lop_hoc, gio_hoc, ngay_hoc, hoc_phi, phi_gia_su, mo_ta, hinh_anh,khoi) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, lopHoc.getUsernameHocSinh());
            statement.setString(2, lopHoc.getUsernameGiaSu());
            statement.setString(3, lopHoc.getTenLopHoc());
            statement.setInt(4, lopHoc.getGioHoc());
            statement.setDate(5, new java.sql.Date(lopHoc.getNgayHoc().getTime()));
            statement.setInt(6, lopHoc.getHocPhi());
            statement.setInt(7, lopHoc.getPhiGiaSu());
            statement.setString(8, lopHoc.getMoTa());
            statement.setString(9, lopHoc.getHinhAnh());
            statement.setInt(10, lopHoc.getLever());

            statement.executeUpdate();
        }
    }

    public void update(LopHoc lopHoc) throws SQLException {
        String query = "UPDATE LopHoc SET  ten_lop_hoc = ?, gio_hoc = ?, " +
                "ngay_hoc = ?, hoc_phi = ?, phi_gia_su = ?, mo_ta = ?, hinh_anh = ?, lever = ? WHERE username_hoc_sinh = ? and username_gia_su = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, lopHoc.getTenLopHoc());
            statement.setInt(2, lopHoc.getGioHoc());
            statement.setDate(3, new java.sql.Date(lopHoc.getNgayHoc().getTime()));
            statement.setInt(4, lopHoc.getHocPhi());
            statement.setInt(5, lopHoc.getPhiGiaSu());
            statement.setString(6, lopHoc.getMoTa());
            statement.setString(7, lopHoc.getHinhAnh());
            statement.setInt(8, lopHoc.getLever());
            statement.setString(9, lopHoc.getUsernameHocSinh());
            statement.setString(10, lopHoc.getUsernameGiaSu());

            statement.executeUpdate();
        }
    }

    public void delete(int lopHocId) throws SQLException {
        String query = "DELETE FROM lophoc WHERE id = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, lopHocId);
            statement.executeUpdate();
        }
    }

    public void acceptLopHoc(int accept, String lopHocId) throws SQLException {
        String query = "UPDATE LopHoc SET  accept = ? WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, accept);
            statement.setObject(2, UUID.fromString(lopHocId));
            statement.executeUpdate();
        }
    }

    public LopHoc getById(String lopHocId) throws SQLException {
        String query = "SELECT * FROM LopHoc WHERE id = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setObject(1, UUID.fromString(lopHocId));

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToLopHoc(resultSet);
                }
            }
        }

        return null;
    }

    public List<LopHoc> getAll() throws SQLException {
        List<LopHoc> lopHocs = new ArrayList<>();

        String query = "SELECT * FROM lophoc where accept = 1";

        try (PreparedStatement statement = con.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                LopHoc lopHoc = mapResultSetToLopHoc(resultSet);
                lopHocs.add(lopHoc);
            }
        }

        return lopHocs;
    }

    public List<LopHoc> getLopHocByGS(String usernameGS) throws SQLException {
        List<LopHoc> lopHocs = new ArrayList<>();

        String query = "SELECT * FROM lophoc where username_gia_su = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, usernameGS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LopHoc lopHoc = mapResultSetToLopHoc(resultSet);
                lopHocs.add(lopHoc);
            }
        }

        return lopHocs;
    }

    public List<LopHoc> getLopHocByGSAndLever(String usernameGS, int khoi) throws SQLException {
        List<LopHoc> lopHocs = new ArrayList<>();

        int min = 0;
        int max = 0;

        if (khoi == 1) {
            min = 1;
            max = 5;
        }

        if (khoi == 2) {
            min = 6;
            max = 9;
        }

        if (khoi == 3) {
            min = 10;
            max = 12;
        }

        String query = "SELECT * FROM LopHoc where username_gia_su = ? and khoi between ? and ? ";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, usernameGS);
            statement.setInt(2, min);
            statement.setInt(3, max);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LopHoc lopHoc = mapResultSetToLopHoc(resultSet);
                lopHocs.add(lopHoc);
            }
        }
        return lopHocs;
    }

    public List<LopHoc> getLopHocByKhoi(int khoibd, int khoikt, boolean isMod) throws SQLException {
        List<LopHoc> lopHocs = new ArrayList<>();
        PreparedStatement statement;
        ResultSet resultSet;
        String query;
        if (isMod) {
            query = "SELECT * FROM LopHoc where khoi > ? and khoi < ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, khoibd);
            statement.setInt(2, khoikt);
        } else {
            query = "SELECT * FROM LopHoc where khoi = ? and accept = 1";
            statement = con.prepareStatement(query);
            statement.setInt(1, khoibd);
        }
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            LopHoc lopHoc = mapResultSetToLopHoc(resultSet);
            lopHocs.add(lopHoc);
        }

        return lopHocs;
    }

    public List<LopHoc> getLopHocByLever(int khoi, boolean isMod) throws SQLException {
        List<LopHoc> lopHocs = new ArrayList<>();
        String query;
        if (isMod) {
            query = "SELECT * FROM LopHoc where lever = ?";
        } else {
            query = "SELECT * FROM LopHoc where lever = ? and accept = 1";
        }
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, khoi);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                LopHoc lopHoc = mapResultSetToLopHoc(resultSet);
                lopHocs.add(lopHoc);
            }
        }
        return lopHocs;
    }

    public int countLopHocByGiaSuUsername(String giaSuUsername) throws SQLException {
        String query = "SELECT COUNT(*) FROM lophoc WHERE username_gia_su = ?";

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

    private LopHoc mapResultSetToLopHoc(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String usernameHocSinh = resultSet.getString("username_hoc_sinh");
        String usernameGiaSu = resultSet.getString("username_gia_su");
        String tenLopHoc = resultSet.getString("ten_lop_hoc");
        Integer gioHoc = resultSet.getInt("gio_hoc");
        Date ngayHoc = resultSet.getDate("ngay_hoc");
        int hocPhi = resultSet.getInt("hoc_phi");
        int phiGiaSu = resultSet.getInt("phi_gia_su");
        int accept = resultSet.getInt("accept");
        int khoi = resultSet.getInt("khoi");
        String moTa = resultSet.getString("mo_ta");
        String hinhAnh = resultSet.getString("hinh_anh");

        return new LopHoc(id, usernameHocSinh, usernameGiaSu, tenLopHoc, gioHoc, ngayHoc, hocPhi, phiGiaSu, moTa,
                hinhAnh, accept, khoi);
    }

}

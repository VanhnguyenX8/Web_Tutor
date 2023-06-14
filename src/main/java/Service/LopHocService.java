package Service;

import DAO.LopHocDAO;
import Model.LopHoc;

import java.sql.SQLException;
import java.util.List;

public class LopHocService {
    LopHocDAO lopHocDAO = new LopHocDAO();

    public void insertlopHoc(LopHoc lopHoc) {
        try {
            lopHocDAO.create(lopHoc);
            System.out.println("Thêm học sinh thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm học sinh: " + e.getMessage());
        }
    }

    public LopHoc getlopHocById(String idLH) {
        try {
            LopHoc lopHoc = lopHocDAO.getById(idLH);
            if (lopHoc != null) {
                return lopHoc;
            } else {
                System.out.println("Không tìm thấy học sinh có ID: " + idLH);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn học sinh: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getlopHocByUsernameGS(String usernameGS) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getLopHocByGS(usernameGS);
            if (lopHocs != null) {
                return lopHocs;
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn Lớp: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getAlllopHocs() {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getAll();
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách lớp học: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getLopHocByKhoi(int khoi, boolean isMod) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getLopHocByKhoi(khoi, isMod);
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách lớp học: " + e.getMessage());
        }
        return null;
    }

    public List<LopHoc> getLopHocByGSAndLever(String username, int khoi) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getLopHocByGSAndLever(username, khoi);
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }

    public void updatelopHoc(LopHoc lopHoc) {
        try {
            lopHocDAO.update(lopHoc);
            System.out.println("Cập nhật lớp học thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật lớp học: " + e.getMessage());
        }
    }

    public void acceptLopHoc(int accept, String lopHocId) {
        try {
            lopHocDAO.acceptLopHoc(accept, lopHocId);
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật : " + e.getMessage());
        }
    }

    public int countHocSinhInGS(String giaSuUsername) {
        try {
            return lopHocDAO.countLopHocByGiaSuUsername(giaSuUsername);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void deletelopHoc(String idLH) {
        try {
            lopHocDAO.delete(idLH);
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa Lớp học: " + e.getMessage());
        }
    }

    public List<LopHoc> getLopHocByLever(int khoi, boolean isMod) {
        try {
            List<LopHoc> lopHocs = lopHocDAO.getLopHocByLever(khoi, isMod);
            return lopHocs;
        } catch (SQLException e) {
            System.out.println("Lỗi khi truy vấn danh sách học sinh: " + e.getMessage());
        }
        return null;
    }

}

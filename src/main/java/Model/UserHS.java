package Model;

import java.sql.Date;
import java.util.UUID;

public class UserHS {
	private UUID id;
    private String ten_hoc_sinh;
    private Date nam_sinh;
    private String sdt;
    private String email;
    private String so_tai_khoan;
    private String username;
    private String gioi_tinh;
    private String dia_chi;
    private String hinh_anh;
    private int so_du_tai_khoan;

    public UserHS() {
    }

    public UserHS(UUID id, String ten_hoc_sinh, Date nam_sinh, String sdt, String email, String so_tai_khoan, String username, String gioi_tinh, String dia_chi, String hinh_anh, int so_du_tai_khoan) {
        this.id = id;
        this.ten_hoc_sinh = ten_hoc_sinh;
        this.nam_sinh = nam_sinh;
        this.sdt = sdt;
        this.email = email;
        this.so_tai_khoan = so_tai_khoan;
        this.username = username;
        this.gioi_tinh = gioi_tinh;
        this.dia_chi = dia_chi;
        this.hinh_anh = hinh_anh;
        this.so_du_tai_khoan = so_du_tai_khoan;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTen_hoc_sinh() {
		return ten_hoc_sinh;
	}

	public void setTen_hoc_sinh(String ten_hoc_sinh) {
		this.ten_hoc_sinh = ten_hoc_sinh;
	}

	public Date getNam_sinh() {
		return nam_sinh;
	}

	public void setNam_sinh(Date nam_sinh) {
		this.nam_sinh = nam_sinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSo_tai_khoan() {
		return so_tai_khoan;
	}

	public void setSo_tai_khoan(String so_tai_khoan) {
		this.so_tai_khoan = so_tai_khoan;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(String gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getHinh_anh() {
		return hinh_anh;
	}

	public void setHinh_anh(String hinh_anh) {
		this.hinh_anh = hinh_anh;
	}

	public int getSo_du_tai_khoan() {
		return so_du_tai_khoan;
	}

	public void setSo_du_tai_khoan(int so_du_tai_khoan) {
		this.so_du_tai_khoan = so_du_tai_khoan;
	}
}
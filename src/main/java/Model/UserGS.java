package Model;

import java.sql.Date;

public class UserGS {
	private String id;
    private String ten_gia_su;
    private Date nam_sinh;
    private String sdt;
    private String email;
    private String so_tai_khoan;
    private String username;
    private String gioi_tinh;
    private String dia_chi;
    private int chua_thanh_toan;
    private String hinh_anh;
    private int so_du_tai_khoan;
    public UserGS() {
    }

    public UserGS(String id, String ten_gia_su, Date nam_sinh, String sdt, String email, String sotaikhoan, String username, String gioi_tinh, String dia_chi, int chua_thanh_toan, String hinh_anh, int so_du_tai_khoan) {
        this.id = id;
        this.ten_gia_su = ten_gia_su;
        this.nam_sinh = nam_sinh;
        this.sdt = sdt;
        this.email = email;
        this.so_tai_khoan = sotaikhoan;
        this.username = username;
        this.gioi_tinh = gioi_tinh;
        this.dia_chi = dia_chi;
        this.chua_thanh_toan = chua_thanh_toan;
        this.hinh_anh = hinh_anh;
        this.so_du_tai_khoan = so_du_tai_khoan;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen_gia_su() {
		return ten_gia_su;
	}

	public void setTen_gia_su(String ten_gia_su) {
		this.ten_gia_su = ten_gia_su;
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

	public String getSotaikhoan() {
		return so_tai_khoan;
	}

	public void setSotaikhoan(String sotaikhoan) {
		this.so_tai_khoan = sotaikhoan;
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

	public int getChua_thanh_toan() {
		return chua_thanh_toan;
	}

	public void setChua_thanh_toan(int chua_thanh_toan) {
		this.chua_thanh_toan = chua_thanh_toan;
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
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LopHoc {
	private String id;
    private String usernameHocSinh;
    private String usernameGiaSu;
    private String tenLopHoc;
    private Integer gioHoc;
    private Date ngayHoc;
    private int hocPhi;
    private int khoi;
    private int accept;
    private int phiGiaSu;
    private String moTa;
    private String hinhAnh;
    //code cua Bien
    private String ngayHocString;
    private UserGS giasu;
    public LopHoc() {
    	
    }
    //
    
    public LopHoc(String id, String usernameHocSinh, String usernameGiaSu, String tenLopHoc, Integer gioHoc,
            Date ngayHoc,
            int hocPhi, int phiGiaSu, String moTa, String hinhAnh) {
        this.id = id;
        this.usernameHocSinh = usernameHocSinh;
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(String id, String usernameGiaSu, String tenLopHoc, Integer gioHoc, Date ngayHoc,
            int hocPhi, int phiGiaSu, String moTa, String hinhAnh) {
        this.id = id;
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(String usernameGiaSu, String tenLopHoc, Integer gioHoc, Date ngayHoc, int hocPhi, int khoi,
            int accept, int phiGiaSu, String moTa, String hinhAnh) {
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.khoi = khoi;
        this.accept = accept;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(String id, String usernameHocSinh, String usernameGiaSu, String tenLopHoc, Integer gioHoc,
            Date ngayHoc, int hocPhi, int phiGiaSu, String moTa, String hinhAnh, int accept, int khoi) {
        this.id = id;
        this.usernameHocSinh = usernameHocSinh;
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.khoi = khoi;
        this.accept = accept;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    public LopHoc(String usernameGiaSu, String tenLopHoc, Integer gioHoc, Date ngayHoc,
            int hocPhi, int phiGiaSu, String moTa, String hinhAnh, int accept, int khoi) {
        this.usernameGiaSu = usernameGiaSu;
        this.tenLopHoc = tenLopHoc;
        this.gioHoc = gioHoc;
        this.ngayHoc = ngayHoc;
        this.hocPhi = hocPhi;
        this.phiGiaSu = phiGiaSu;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
        this.khoi = khoi;
        this.accept = accept;
    }

    // Getter và Setter cho các trường

    public int getLever() {
        return khoi;
    }

    public void setLever(int khoi) {
        this.khoi = khoi;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsernameHocSinh() {
        return usernameHocSinh;
    }

    public void setUsernameHocSinh(String usernameHocSinh) {
        this.usernameHocSinh = usernameHocSinh;
    }

    public String getUsernameGiaSu() {
        return usernameGiaSu;
    }

    public void setUsernameGiaSu(String usernameGiaSu) {
        this.usernameGiaSu = usernameGiaSu;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public Integer getGioHoc() {
        return gioHoc;
    }

    public void setGioHoc(Integer gioHoc) {
        this.gioHoc = gioHoc;
    }

    public Date getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(Date ngayHoc) {
        this.ngayHoc = ngayHoc;
        //code cua Bien
      	this.ngayHocString = new SimpleDateFormat("dd-MM-yyyy").format(this.ngayHoc);
      	//
    }

    public int getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getPhiGiaSu() {
        return phiGiaSu;
    }

    public void setPhiGiaSu(int phiGiaSu) {
        this.phiGiaSu = phiGiaSu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    //code cua Bien
    public String getNgayHocString() {
    	return this.ngayHocString;
    }
    public void setKhoi(int k) {
    	this.khoi = k;
    }
    public int getKhoi() {
    	return this.khoi;
    }
    public UserGS getGiasu() {
		return giasu;
	}

	public void setGiasu(UserGS giasu) {
		this.giasu = giasu;
	}
    //
}

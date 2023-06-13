package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LopHoc {
	private String id;
	private String username_hoc_sinh;
	private GiaSu giasu;
	private String ten_lop_hoc;
	private int gio_hoc;
	private String ngay_hoc;
	private int hoc_phi;
	private int khoi;
	public LopHoc() {
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername_hoc_sinh() {
		return username_hoc_sinh;
	}

	public void setUsername_hoc_sinh(String username_hoc_sinh) {
		this.username_hoc_sinh = username_hoc_sinh;
	}


	public String getTen_lop_hoc() {
		return ten_lop_hoc;
	}

	public void setTen_lop_hoc(String ten_lop_hoc) {
		this.ten_lop_hoc = ten_lop_hoc;
	}

	public int getGio_hoc() {
		return gio_hoc;
	}

	public void setGio_hoc(int gio_hoc) {
		this.gio_hoc = gio_hoc;
	}

	public String getNgay_hoc() {
		return ngay_hoc;
	}

	public void setNgay_hoc(Date ngay_hoc) {
		this.ngay_hoc = new SimpleDateFormat("dd-MM-yyyy").format(ngay_hoc);
	}

	public int getHoc_phi() {
		return hoc_phi;
	}

	public void setHoc_phi(int hoc_phi) {
		this.hoc_phi = hoc_phi;
	}


	public GiaSu getGiasu() {
		return giasu;
	}

	public void setGiasu(GiaSu giasu) {
		this.giasu = giasu;
	}

	public int getKhoi() {
		return khoi;
	}

	public void setKhoi(int khoi) {
		this.khoi = khoi;
	}
	
	public String toString() {
		return this.id + "";
	}
}

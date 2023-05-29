package Model;

public class TaiKhoan {
	private String username, password, position;
	private byte[] salt;
	public TaiKhoan(String username, String password, String position, byte[] salt) {
		super();
		this.username = username;
		this.password = password;
		this.position = position;
		this.salt = salt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
}

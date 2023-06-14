package Model;

public class BinhLuan {
	private String id;
	private String idsanpham;
	private String usernamebl,chat;
	public BinhLuan(String id, String idsanpham, String usernamebl, String chat) {
		super();
		this.id = id;
		this.idsanpham = idsanpham;
		this.usernamebl = usernamebl;
		this.chat = chat;
	}
	public BinhLuan() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdsanpham() {
		return idsanpham;
	}
	public void setIdsanpham(String idsanpham) {
		this.idsanpham = idsanpham;
	}
	public String getUsernamebl() {
		return usernamebl;
	}
	public void setUsernamebl(String usernamebl) {
		this.usernamebl = usernamebl;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	
}

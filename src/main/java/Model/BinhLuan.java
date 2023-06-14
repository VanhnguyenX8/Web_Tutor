package Model;

import java.sql.Timestamp;

public class BinhLuan {
	private String id;
	private String idsanpham;
	private String usernamebl,chat;
	private Timestamp createdAt;
	private boolean canDelete;
	
	public BinhLuan(String id, String idsanpham, String usernamebl, String chat, Timestamp createdAt
			) {
		super();
		this.id = id;
		this.idsanpham = idsanpham;
		this.usernamebl = usernamebl;
		this.chat = chat;
		this.createdAt = createdAt;
	
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
	public boolean canDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
    
}

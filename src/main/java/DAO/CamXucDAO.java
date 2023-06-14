package DAO;
import java.sql.Connection;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CamXucDAO {
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	 public boolean hasLiked(String postId, String username) throws SQLException {
	        String query = "SELECT * FROM camxuc WHERE idlophoc::text = ? AND usernamebl = ?";
	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	            stmt.setString(1, postId);;
	            stmt.setString(2, username);
	            ResultSet rs = stmt.executeQuery();
	            return rs.next();
	        }
	        
	    }

	    public void addLike(String idlophoc, String username) throws SQLException {
	    	System.out.println("vao ham addlike");
	        String query = "INSERT INTO camxuc (idlophoc, usernamebl,camxuc) VALUES (?, ?,true)";
	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	        	stmt.setObject(1, UUID.fromString(idlophoc));
	            stmt.setString(2, username);
	            stmt.executeUpdate();
	        }
	        
	    }

	    public void removeLike(String postId, String username) throws SQLException {
	        String query = "DELETE FROM camxuc WHERE idlophoc::text = ? AND usernamebl = ?";
	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	        	stmt.setString(1, postId);
	            stmt.setString(2, username);
	            stmt.executeUpdate();
	        }
	    }
	    public int getLikeCount(String postId) throws SQLException {
	        String query = "SELECT COUNT(*) AS likeCount FROM camxuc WHERE idlophoc::text = ?";
	        try (PreparedStatement stmt = con.prepareStatement(query)) {
	        	stmt.setString(1, postId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return rs.getInt("likeCount");
	            }
	        }
	        return 0; // Trả về 0 nếu không có lượt thích
	    }
}

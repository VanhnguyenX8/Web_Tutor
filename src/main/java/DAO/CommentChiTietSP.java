package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Model.BinhLuan;
public class CommentChiTietSP{
	public DBconnect db = new DBconnect();
	Connection con = db.DBconnect();
	public List<BinhLuan> getallcmt(String idsanpham,String username) {
		List<BinhLuan> list = new ArrayList<>();
		String sql = "SELECT * FROM binhluan where idlophoc::text = ? ORDER BY create_at DESC";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,idsanpham);
			ResultSet rs =st.executeQuery();
			while(rs.next()) {
				String commentId = rs.getString("id");
				 String idlophoc = rs.getString("idlophoc");
	                String commentUsername = rs.getString("usernamebl");
	                String content = rs.getString("chat");
	                Timestamp create_at = rs.getTimestamp("create_at");
	                BinhLuan c = new BinhLuan(commentId, idlophoc, commentUsername, content,create_at);
	                c.setCanDelete(commentUsername.equals(username));
	                list.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	 public void deleteComment(String commentId) {
	        String sql = "DELETE FROM binhluan WHERE id::text = ?";
	        try {
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, commentId);
	            st.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	public void ThemCMT(String cid, String cmt,String username) throws ParseException {
		String query = "insert into BinhLuan(idlophoc,usernamebl,chat,create_at) values (?,?,?, CURRENT_TIMESTAMP)";
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setObject(1, UUID.fromString(cid));
			ps.setString(2, username);
			ps.setString(3, cmt);
			ps.executeUpdate();
			// k can dung result vi khi usertao tai khoan se k co du lieu tra ve
			// can dung [executeUpdate()] de update lai du lieu
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

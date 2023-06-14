package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class RatingDAO {
	 public DBconnect db = new DBconnect();
	    Connection con = db.DBconnect();
	public void Rating(String userId, String idlophoc, String rating) {
		String checkQuery = "SELECT * FROM danhgia WHERE usernamebl = ? AND idlophoc::text = ?";
	
		try {
			PreparedStatement st = con.prepareStatement(checkQuery);
			st.setString(1, userId);
			st.setString(2, idlophoc);
			ResultSet resultSet = st.executeQuery();
			
			if (resultSet.next()) {
				// Nếu đã có đánh giá từ userId cho itemId, thực hiện câu lệnh UPDATE
				String sql = "UPDATE danhgia SET rating = ? WHERE usernamebl = ? AND idlophoc::text = ?";
				PreparedStatement stUpdate = con.prepareStatement(sql);
				stUpdate.setInt(1, Integer.parseInt(rating));
				stUpdate.setString(2, userId);
				stUpdate.setString(3, idlophoc);
				stUpdate.executeUpdate();
				stUpdate.close();
			} else {
				System.out.println("da vao day insert");
				// Nếu chưa có đánh giá từ userId cho itemId, thực hiện câu lệnh INSERT
				String sql = "INSERT INTO danhgia (usernamebl, rating, idlophoc) VALUES (?, ?, ?)";
				PreparedStatement stInsert = con.prepareStatement(sql);
				stInsert.setString(1, userId);
				stInsert.setInt(2, Integer.parseInt(rating));
				stInsert.setObject(3, UUID.fromString(idlophoc));
				stInsert.executeUpdate();
				stInsert.close();
				System.out.println("thanh cong");
			}

			resultSet.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double calculateAverageRating(String idlophoc) {
		double averageRating = 0.0;
		try {
			String averageQuery = "SELECT AVG(rating) AS averageRating FROM danhgia WHERE idlophoc::text = ?";
			PreparedStatement averageStatement = con.prepareStatement(averageQuery);
			averageStatement.setString(1, idlophoc);;
			ResultSet resultSet = averageStatement.executeQuery();

			if (resultSet.next()) {
				averageRating = resultSet.getDouble("averageRating");
				System.out.println("averageRating" + averageRating);
			}

			resultSet.close();
			averageStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return averageRating;
	}

	
}

package DAO.dashboard;

import org.json.JSONArray;
import Model.LopHoc;
import org.json.JSONObject;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DashboardHomeDAO {
    DashboardConnectDB conn = new DashboardConnectDB();
    Connection con = conn.getConnect();
    public JSONObject getImageAdmin(String username) {
    	PreparedStatement pstmt = null;
    	JSONObject obj = new JSONObject();
    	String image = "";
    	String sql = "Select job_position,image,name FROM hocsinh WHERE username = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs =  pstmt.executeQuery();
            rs.next();
            image = rs.getString("image");
            String jobPosition = rs.getString("job_position");
            String name = rs.getString("name");
            obj.put("image",image);
            obj.put("job_position", jobPosition);
            obj.put("name",name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return obj;
    }
    



   
}

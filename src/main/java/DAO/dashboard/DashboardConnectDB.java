package DAO.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;

public class DashboardConnectDB {
    public Connection getConnect() {

        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://ep-damp-bush-071348.ap-southeast-1.aws.neon.tech/giasuweb","chimtrung2911","KzC8yt4pYcSW");

            return con;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}

package com.example.dashboardweb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public Connection getConnect() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/webgiasu","root","admin");

            return con;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
}

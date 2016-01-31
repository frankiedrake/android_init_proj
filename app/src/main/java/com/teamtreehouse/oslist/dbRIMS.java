package com.teamtreehouse.oslist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbRIMS {
    public static Date retrieveData() throws SQLException {
        Date currentDate = null;
        String dburl = "jdbc:sqlanywhere:uid=dvlp;pwd=dvlp;eng=devdb;database=devdb;links=tcpip(host=127.0.0.1)";

        // Connect to Sybase Database
        Connection con = DriverManager.getConnection(dburl);
        Statement statement = con.createStatement();

        // We use Sybase specific select getdate() query to return date
        ResultSet rs = statement.executeQuery("SELECT GETDATE()");


        if (rs.next()) {
            currentDate = rs.getDate(1); // get first column returned
            System.out.println("Current Date from Sybase is : " + currentDate);
        }
        rs.close();
        statement.close();
        con.close();
        return currentDate;
    }

}

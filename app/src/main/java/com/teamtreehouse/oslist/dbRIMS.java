package com.teamtreehouse.oslist;

import android.util.Log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class dbRIMS {
    public static Date retrieveData() throws SQLException {
        Date currentDate = null;
        String dburl = "jdbc:sybase:Tds:localhost:2638/rims";

        // Connect to Sybase Database
        try {
            Connection con = DriverManager.getConnection(dburl);
            try {
                Statement statement = con.createStatement();


                // We use Sybase specific select getdate() query to return date
                ResultSet rs = statement.executeQuery("SELECT GETDATE()");


                if (rs.next()) {
                    currentDate = rs.getDate(1); // get first column returned
                    //System.out.println("Current Date from Sybase is : " + currentDate);
                }
                rs.close();
                statement.close();
                con.close();
            } catch (SQLException ex) {
                Log.d("Cannot create conection", ex.toString());
            }
        } catch (SQLException ex) {
            Log.d("Caught sql exception", ex.toString());
        }
        return currentDate;
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DBoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author student
 */
public class DBHandler {
    
    String url = "jdbc:mysql://127.0.0.1:3306/fundadministrationsystem";
    String userName = "root";
    String passWord = "";
    Connection connection = null;
    PreparedStatement statement = null;
    
    

    public int setData(String query) throws SQLException{
        try{
        connection = (Connection) DriverManager.getConnection(url, userName, passWord);
        Statement stm=connection.createStatement();
        int res=stm.executeUpdate(query);
        return res;
        }
         catch (SQLException ex) {
            System.err.println("HI");
            System.out.println(ex);
            return -1;

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
    }
    }

    public  ResultSet getData(String query) throws SQLException{
        try{
        connection = (Connection) DriverManager.getConnection(url, userName, passWord);
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(query);
        return rst;
        
    }
     catch (SQLException ex) {
            System.err.println("HI");
            System.out.println(ex);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }

        }
    }
}
    
    
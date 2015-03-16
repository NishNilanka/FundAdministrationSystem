/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

//import connection.DBConnection;
import DBoperations.DBHandler;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ThemeControler {

    public static int updateTheme(int index) throws SQLException, ClassNotFoundException{
        String id="T001";
        String sql="update themes set status='"+index+"'where id='"+id+"'";
        DBHandler handler = new DBHandler();
        int res=handler.setData(sql);
        return res;
    }

    public static int searchTheme() throws SQLException, ClassNotFoundException{
        String sql="select * from themes where id='T001'";
        DBHandler handler = new DBHandler();
        ResultSet rst=handler.getData(sql);
        if(rst.next()){
            return rst.getInt(1);
        }else{
            return 0;
        }
        
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Nishan Gunawardena
 */
public class Report extends JFrame{
    
    String url = "jdbc:mysql://localhost:3306/finalfundadministrator";
    String userName = "root";
    String passWord = "";
    
    public Report(String fileName)
    {
        this(fileName,null);
    }
    public Report(String fileName, HashMap para)
    {
        super("Prison Department Employee Welfare Fund Administration System");
        try {
            
            //DBoperationWithFinal db = new DBoperationWithFinal();
            Connection con = DriverManager.getConnection(url, userName, passWord);
            JasperPrint print = JasperFillManager.fillReport(fileName, para,con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);
                    
                    
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (JRException e) {
            System.err.println(e);
        }
        setBounds(10, 10, 900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}

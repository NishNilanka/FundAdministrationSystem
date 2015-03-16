/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fundadministrationsystem;

import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Group 7
 */
public class FundAdministrationSystem {

    public static void main(String[] args) {
        try {
            try {
                UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());
            } catch (UnsupportedLookAndFeelException ex) {
                Logger.getLogger(FundAdministrationSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FundAdministrationSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login login = new Login();
        login.setVisible(true);
        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import LoanAccount.LoanAccountDetails;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nishan Gunawardena
 */
public class LoanAccount extends AbstractTableModel{
    
    private final static String[] COLLUMN_NAME = {"Loan No","Application No", "Member Name", "Amount","Duration", "Available Bal","Gurantee 1","Gurantee2"};
    private static ArrayList <LoanAccountDetails> list;
    

    public LoanAccount(ArrayList<LoanAccountDetails> loanAccount) {
       list = loanAccount;
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLLUMN_NAME.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case (0) : 
                return list.get(rowIndex).getLoanNo();
            case (1) :
                return list.get(rowIndex).getApplicationNo();
            case (2) :
                return list.get(rowIndex).getMemberName();
            case (3) :
                return list.get(rowIndex).getLoanAmount();
            case (4) :
                return list.get(rowIndex).getDuration();
            case (5) :
                return list.get(rowIndex).getBalance();
            case (6) :
                return list.get(rowIndex).getGurantee1Name();
            case (7) :
                return list.get(rowIndex).getGurantee2Name();
            default:
                return "Error";
        }
    }
    
    @Override
    public String getColumnName (int collumnindex)
    {
        return COLLUMN_NAME[collumnindex];
    }
    
}

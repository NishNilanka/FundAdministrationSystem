/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import SavingAccount.SavingsAccountDetails;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nishan Gunawardena
 */
public class SavingsAccount extends AbstractTableModel{
    
    private final static String[] COLUMN_NAME = {"Account No","Name", "Prison", "Reg. Date", "Current Balance"};
    private static ArrayList<SavingsAccountDetails> list;

     public SavingsAccount(ArrayList<SavingsAccountDetails> savingsAccount) {
        list = savingsAccount;
        
    }
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAME.length;
    }

        @Override
    public String getColumnName(int ColumnIndex)
    {
        return COLUMN_NAME[ColumnIndex];
    }
        
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case(0):
                return list.get(rowIndex).getAccountNo();
            case(1):
                return list.get(rowIndex).getName();
            case(2):
                return list.get(rowIndex).getPrison();
            case(3):
                return list.get(rowIndex).getRegDate();
            case(4):
                return list.get(rowIndex).getCurrentBalance();
            default:
                return "Error";
        }
        
    }
    
    
}

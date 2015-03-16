/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import DBoperations.DBoperations;
import SavingAccount.SavingsAccountDetails;
import Transactions.TransactionDetail;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author GWSC GINTOTA
 */
public class MonthEndAccount extends AbstractTableModel{
    private final static String[] COLUMN_NAME = {"Year","Month","Fix.Deposit","Scholorship","Reg.Fee","Loan","Death Grant","Death Grant Loan","Total","UserID"};
    private static ArrayList<TransactionDetail> list;
   
 public    MonthEndAccount(ArrayList<TransactionDetail>  MonthEndAccountList){
     list=MonthEndAccountList;
 }
     
    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
       return COLUMN_NAME.length;
    }
    
    
     public String getColumnName(int ColumnIndex)
    {
        return COLUMN_NAME[ColumnIndex];
    }
        

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case(0):
                return list.get(rowIndex).getYear();
            case(1):
                return list.get(rowIndex).getMonth();
            case(2):
                return list.get(rowIndex).getFixedDeposit();
      
            case(3):
                return list.get(rowIndex).getScholorship();
                
            case (4):
                
                return list.get(rowIndex).getRegFee();
               
            case (5):
                return list.get(rowIndex).getLoan();
            case(6):
                return list.get(rowIndex).getDeathGrant();
            case(7):
                return list.get(rowIndex).getDeathGrantLoan();
      
            case(8):
                return list.get(rowIndex).getTotal();
                
            case (9):
                
                return list.get(rowIndex).getUserID();
            default:
                return "Error";
        }
        
    }
}

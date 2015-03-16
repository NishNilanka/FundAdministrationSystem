/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import SavingAccount.TransactionDetails;
import Transactions.TransactionDetail;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nishan Gunawardena
 */
public class SavingsAccountTransaction extends AbstractTableModel {

    private final static String[] COLUMN_NAME = {"TranID", "Date", "Description", "Withdrawals", "Deposits", "Balance","Taller" };
    private static ArrayList<TransactionDetail> list;

    public SavingsAccountTransaction(ArrayList<TransactionDetail> Transactions) {
        list = Transactions;

    }

    @Override
    public String getColumnName(int ColumnIndex)
    {
        return COLUMN_NAME[ColumnIndex];
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case (0):
                return list.get(rowIndex).getTranID();
            case (1):
                return list.get(rowIndex).getYear();
            case (2):
                return list.get(rowIndex).getMonth();
            case (3):
                return list.get(rowIndex).getFixedDeposit();
            case (4):
                return list.get(rowIndex).getRegFee();
            case (5):
                return list.get(rowIndex).getScholorship();
            case (6):
                return list.get(rowIndex).getTotal();
            case (7):
                return list.get(rowIndex).getUserID();
            default:
                return "Error";
        }
    }
}

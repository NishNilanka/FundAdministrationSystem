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
 
public class svaingAccTranAutho extends AbstractTableModel {

    private final static String[] COLUMN_NAME = {"TranID", "EmpID", "Name", "FixedDeposit", "Year", "Month" };
    private static ArrayList<TransactionDetails> list;

    public svaingAccTranAutho(ArrayList<TransactionDetails> Transactions) {
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
                return list.get(rowIndex).getEmpNo();
            case (2):
                return list.get(rowIndex).getName();
            case (3):
                return list.get(rowIndex).getDeposite();
            case (4):
                return list.get(rowIndex).getYear();
            case (5):
                return list.get(rowIndex).getMonth();
            default:
                return "Error";
        }
    }
}

    


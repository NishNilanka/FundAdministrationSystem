/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Transactions.TransactionDetail;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nishan Gunawardena
 */
public class MonthEndTransactionTable extends AbstractTableModel{

    private final static String[] COLUMN_NAME = {"EmpId","Name","LedgerNo","Fix.Deposit","Scholorship","Reg.Fee","Loan","Death Grant","Death Grant Loan","Total"};
    private final ArrayList<TransactionDetail> list;
    
    public MonthEndTransactionTable(ArrayList<TransactionDetail> Transactions) {
        list = Transactions;

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
        System.out.println(list.get(rowIndex).getEmpId());
        switch (columnIndex) {
            case (0):
                return list.get(rowIndex).getEmpId();
            case (1):
                return list.get(rowIndex).getName();
            case (2):
                return list.get(rowIndex).getLedgerNo();
            case (3):
                return 465.00;
            case (4):
                return 15.00;
            case (5):
                return 0.00;
            case (6):
                return 0.00;
            case (7):
                return 20.00;
            case (8):
                return 0.00;
            case (9):
                return 500.00;
            default:
                return "Error";
        }
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import DeathGrant.DeathGrantDetails;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thilina
 */
public class DeathLoan  extends AbstractTableModel{
    
    //Load the Collumn name to the table by following code
    
    private final static String[] COLUMN_NAME = {"Death Grant Loan No", "Death Grant No", "Emp No", "Cheque No","Amount"};
    private static ArrayList<DeathGrantDetails> list;

    public DeathLoan(ArrayList<DeathGrantDetails> DeathGrantLoan) {
        list = DeathGrantLoan;
        
        //System.err.println(list);
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
    //Load the values to the table by following code

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case(0):
                return list.get(rowIndex).getLoanNo();
            case(1):
                return list.get(rowIndex).getDeathGrantNo();
            case(2):
                return list.get(rowIndex).getEmpNo();
            case(3):
                return list.get(rowIndex).getChequeNo();
             case(4):
                return list.get(rowIndex).getLoanAmount();
            default:
                return "Error";
        }
    }
    
}

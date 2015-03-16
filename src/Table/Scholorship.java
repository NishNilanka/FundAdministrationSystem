/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import Member.MemberDetails;
import ScholorshipAccount.ScholorshipDetails;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thilina
 */
public class Scholorship extends AbstractTableModel{
    
    //Load the Collumn name to the table by following code
    
    private final static String[] COLUMN_NAME = {"Scholorship No", "Last Name", "Emp NIC", "Type","Amount"};
    private static ArrayList<ScholorshipDetails> list;

    public Scholorship(ArrayList<ScholorshipDetails> Scholorship) {
        list = Scholorship;
        
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
                return list.get(rowIndex).getScholorshipNo();
            case(1):
                return (list.get(rowIndex).getLastName() + list.get(rowIndex).getFirstName());
            case(2):
                return list.get(rowIndex).getEmpNo();
            case(3):
                return list.get(rowIndex).getScholorshipType();
             case(4):
                return list.get(rowIndex).getAmount();
            default:
                return "Error";
        }
    }
    
}

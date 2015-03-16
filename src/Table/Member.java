/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Table;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Member.MemberDetails;

/**
 *
 * @author Nishan Gunawardena
 */
public class Member extends AbstractTableModel{
    
    //Load the Collumn name to the table by following code
    
    private final static String[] COLUMN_NAME = {"Emp ID","First Name", "Last Name", "Designation", "Prison"};
    private static ArrayList<MemberDetails> list;

    public Member(ArrayList<MemberDetails> member) {
        list = member;
        
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
                return list.get(rowIndex).getEmpno();
            case(1):
                return list.get(rowIndex).getFirstName();
            case(2):
                return list.get(rowIndex).getLastName();
            case(3):
                return list.get(rowIndex).getDesignation();
            case(4):
                return list.get(rowIndex).getPrison();
            default:
                return "Error";
        }
    }
    
}

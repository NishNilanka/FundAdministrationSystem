/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

import javax.swing.JOptionPane;


public class SetBirthDay {
     int year;
     boolean leapOrNot;
     int days;
     int month=1;
    boolean leapYearOrNot(int year){
         
        this. year =year;     
        
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));

        return isLeapYear;
    }
    
    
    
    
    String birthDay(String numberID){
        
    days = Integer.parseInt(numberID.substring(2,5));
    leapOrNot= leapYearOrNot(1900+ Integer.parseInt (numberID.substring(0,2)));
     if(days>500){
         days=days-500;
     }
     if(days < 500 && days > 366){
         JOptionPane.showMessageDialog(null, "Invalid ID number");
         return null;
     }
     else if(leapOrNot){
        int []daysOfMonth ={31,29,31,30,31,30,31,31,30,31,30,31};
        
        for(int i=0;i<12;i++){
            if((days - daysOfMonth[i])>0){
                days = days - daysOfMonth[i];
                month++;
            }else{
                break;
            }            
        }
        
        return new Integer(days).toString()+"-"+new Integer(month).toString()+"-"+new Integer(year).toString();
        
    }
    else{
        int []daysOfMonth ={31,28,31,30,31,30,31,31,30,31,30,31};
        
        for(int i=0;i<12;i++){
            if((days - daysOfMonth[i])>0){
                days = days - daysOfMonth[i];
                month++;
            }else{
                break;
            }            
        }
        
        return new Integer(days).toString()+"-"+new Integer(month).toString()+"-"+new Integer(year).toString();
        
        
    }
    
    }
    
    String ageSet(){
        
        String currentyDate =new java.util.Date().toString();
        String[] s = currentyDate.split(" ");
        int currentYear=new Integer(s[5]).intValue();
          return new Integer(currentYear-year).toString();
        
    }
    
    
//    public static void main(String a[]){
//        SetBirthDay sb=new SetBirthDay();
//       System.out.println( sb.birthDay("910060376v"));
//    }
    
}

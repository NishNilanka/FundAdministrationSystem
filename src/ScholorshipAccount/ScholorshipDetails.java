/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ScholorshipAccount;

import java.math.BigDecimal;

/**
 *
 * @author Thilina
 */
public class ScholorshipDetails{
    
    private int empno,age;
    private String firstName;
    private String lastName;
    private String empfirstName;
    private String emplastName;
    private String nicNo;
    private int nicType;
    private String dob;
    private String gender;
    private String school;
    private float amount;
    private String prison;
    private String ScholorshipType;
    private int scholorshipNo;
    private int OwnerID;
    private int member_transferaccountownership_OwnerID;
    
    

    
    private String accountNo;
   
 
    

    /**
     * @return the empID
     */
    

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

     public String getSchool() {
        return school;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setSchool(String school) {
        this.school = school;
    }
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
 

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
  public String getScholorshipType() {
        return ScholorshipType;
    }
    public void setScholorshipType(String ScholorshipType) {
        this.ScholorshipType = ScholorshipType;
    }
    /**
     * @return the nicNo
     */
    public String getNicNo() {
        return nicNo;
    }
    
    
     public float getAmount() {
        return amount;
    }

    
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * @param nicNo the nicNo to set
     */
    public void setNicNo(String NicNo) {
        this.nicNo = NicNo;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the address

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the regDate
     */
   
    /**
     * @return the prison
     */
    public String getPrison() {
        return prison;
    }

    /**
     * @param prison the prison to set
     */
    public void setPrison(String prison) {
        this.prison = prison;
    }

    /**
     * @return the empno
     */
    public int getEmpNo() {
        return empno;
    }

    /**
     * @param empno the empno to set
     */
    public void setEmpNo(int empno) {
        this.empno = empno;
    }

    
     
    public int getNicType() {
        return nicType;
    }

    /**
     * @param nicType the nicType to set
     */
    public void setNicType(int nicType) {
        this.nicType = nicType;
    }
    
      public int getScholorshipNo() {
        return scholorshipNo;
    }

    /**
     * @param nicType the nicType to set
     */
    public void setScholorshipNo(int scholorshipNo) {
        this.scholorshipNo = scholorshipNo;
    }

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setEmpFirstName(String empfirstname){
        this.setEmpfirstName(empfirstname); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEmpLastName(String emplastname) {
        this.setEmplastName(emplastname); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the OwnerID
     */
    public int getOwnerID() {
        return OwnerID;
    }

    /**
     * @param OwnerID the OwnerID to set
     */
    public void setOwnerID(int OwnerID) {
        this.OwnerID = OwnerID;
    }

    /**
     * @return the empfirstName
     */
    public String getEmpfirstName() {
        return empfirstName;
    }

    /**
     * @param empfirstName the empfirstName to set
     */
    public void setEmpfirstName(String empfirstName) {
        this.empfirstName = empfirstName;
    }

    /**
     * @return the emplastName
     */
    public String getEmplastName() {
        return emplastName;
    }

    /**
     * @param emplastName the emplastName to set
     */
    public void setEmplastName(String emplastName) {
        this.emplastName = emplastName;
    }

    /**
     * @return the member_transferaccountownership_OwnerID
     */
    public int getMember_transferaccountownership_OwnerID() {
        return member_transferaccountownership_OwnerID;
    }

    /**
     * @param member_transferaccountownership_OwnerID the member_transferaccountownership_OwnerID to set
     */
    public void setMember_transferaccountownership_OwnerID(int member_transferaccountownership_OwnerID) {
        this.member_transferaccountownership_OwnerID = member_transferaccountownership_OwnerID;
    }

   
    
    /**
     * @return the ownerNICType
     */
//    public int getOwnerNICType() {
//        return ownerNICType;
//    }
//
//    /**
//     * @param ownerNICType the ownerNICType to set
//     */
//    public void setOwnerNICType(int ownerNICType) {
//        this.ownerNICType = ownerNICType;
//    }
   
    
}


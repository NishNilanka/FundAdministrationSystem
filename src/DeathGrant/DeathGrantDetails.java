/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DeathGrant;

/**
 *
 * @author Thilina
 */
public class DeathGrantDetails {
    private int empno;
    private String firstName;
    private String lastName;
    private String empfirstName;
    private String emplastName;
    private String nicNo;
    private int nicType;
    private String dod;
    private String gender;
    private String relationship;
    private float amount;
    private String prison;
    private String deathCertificateNo;
    private int deathGrantNo;
    private String date;
    private String voucherno;
    private String chequeno;
    private float loanamount;
    private float monthlyPayment;
    private int loanno;
    private int transownId;
    private String accountNo;
    private int ownerId;

   
   
    

    /**
     * @return the empID
     */
    

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
     public String getEmpFirstName() {
        return empfirstName;
    }

   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getAccountNo() {
        return accountNo;
    }

   
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    /* public void setEmpFirstName(String empfirstName) {
        this.empfirstName = empfirstName;
    }*/

     public String getRelationship() {
        return relationship;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getLastName() {
        return lastName;
    }
      public String getEmpLastName() {
        return emplastName;
    }

  
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /* public void setEmpLastName(String emplastName) {
        this.emplastName = emplastName;
    }*/
    
  public String getDeathCertificateNo() {
        return deathCertificateNo;
    }
    public void setDeathCertificateNo(String deathCertificateNo) {
        this.deathCertificateNo = deathCertificateNo;
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

    
   

   
    public String getDod() {
        return dod;
    }

    
    public void setDod(String dod) {
        this.dod = dod;
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
     * @return the gender
     */
   

    /**
     * @param gender the gender to set
     */
    
    /**
     * @return the regDate
     */
   
    /**
     * @return the prison
     */
    
    /**
     * @param prison the prison to set
     */
    public void setPrison(String prison) {
        this.prison = prison;
    }
     public String getPrison() {
        return prison;
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
     public int getMemTransOwnId() {
        return transownId;
    }

    /**
     * @param empno the empno to set
     */
    public void setMemTransOwnId(int transownId) {
        this.transownId = transownId;
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
    
      public int getDeathGrantNo() {
        return deathGrantNo;
    }

    /**
     * @param nicType the nicType to set
     */
    public void setDeathGrantNo(int deathGrantNo) {
        this.deathGrantNo = deathGrantNo;
    }

    public int getLoanNo() {
        return loanno;
    }

    
    public void setLoanNo(int loanno) {
        this.loanno = loanno;
    }
    
      public float getMonthlyPayment() {
        return monthlyPayment;
    }

    
    public void setMonthlyPayment(float monthluPayment) {
        this.monthlyPayment = monthluPayment;
    }
    
      public float getLoanAmount() {
        return loanamount;
    }

    
    public void setLoanAmount(float loanamount) {
        this.loanamount = loanamount;
    }
    
     public String getChequeNo() {
        return chequeno;
    }

    
    public void setChequeNo(String chequeno) {
        this.chequeno = chequeno;
    }
      public String getVoucherNo() {
        return voucherno;
    }

    
    public void setVoucherNo(String voucherno) {
        this.voucherno = voucherno;
    }
       public String getDate() {
        return date;
    }

    
    public void setDate(String date) {
        this.date = date;
    }

 

    public void setEmpFirstName(String empfirstName) {
        this.empfirstName=empfirstName; 
    }

    public void setEmpLastName(String emplastName) {
        this.emplastName=emplastName; 
    }

    /**
     * @return the ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}

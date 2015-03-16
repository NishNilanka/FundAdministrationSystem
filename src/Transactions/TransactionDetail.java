/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transactions;

/**
 *
 * @author Nishan Gunawardena
 */
public class TransactionDetail 
{
    private int tranID;
    private int year;
    private int month;
    private float fixedDeposit;
    private float scholorship;
    private float regFee;
    private float loan;
    private float deathGrant;
    private float deathGrantLoan;
    private float total;
    
    private int empId;
    private String name;
    private String ledgerNo;
    
    private int userID;

    /**
     * @return the tranID
     */
    public int getTranID() {
        return tranID;
    }

    /**
     * @param tranID the tranID to set
     */
    public void setTranID(int tranID) {
        this.tranID = tranID;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the fixedDeposit
     */
    public float getFixedDeposit() {
        return fixedDeposit;
    }

    /**
     * @param fixedDeposit the fixedDeposit to set
     */
    public void setFixedDeposit(float fixedDeposit) {
        this.fixedDeposit = fixedDeposit;
    }

    /**
     * @return the scholorship
     */
    public float getScholorship() {
        return scholorship;
    }

    /**
     * @param scholorship the scholorship to set
     */
    public void setScholorship(float scholorship) {
        this.scholorship = scholorship;
    }

    /**
     * @return the regFee
     */
    public float getRegFee() {
        return regFee;
    }

    /**
     * @param regFee the regFee to set
     */
    public void setRegFee(float regFee) {
        this.regFee = regFee;
    }

    /**
     * @return the loan
     */
    public float getLoan() {
        return loan;
    }

    /**
     * @param loan the loan to set
     */
    public void setLoan(float loan) {
        this.loan = loan;
    }

    /**
     * @return the deathGrant
     */
    public float getDeathGrant() {
        return deathGrant;
    }

    /**
     * @param deathGrant the deathGrant to set
     */
    public void setDeathGrant(float deathGrant) {
        this.deathGrant = deathGrant;
    }

    /**
     * @return the deathGrantLoan
     */
    public float getDeathGrantLoan() {
        return deathGrantLoan;
    }

    /**
     * @param deathGrantLoan the deathGrantLoan to set
     */
    public void setDeathGrantLoan(float deathGrantLoan) {
        this.deathGrantLoan = deathGrantLoan;
    }

    /**
     * @return the empId
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ledgerNo
     */
    public String getLedgerNo() {
        return ledgerNo;
    }

    /**
     * @param ledgerNo the ledgerNo to set
     */
    public void setLedgerNo(String ledgerNo) {
        this.ledgerNo = ledgerNo;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
}

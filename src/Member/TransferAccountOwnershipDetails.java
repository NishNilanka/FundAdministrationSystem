/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Member;

/**
 *
 * @author Nishan Gunawardena
 */
public class TransferAccountOwnershipDetails {
    private int empno;
    private int ownerID;
    private String ownerName;
    private String ownerNIC;
    private String relationship;

    /**
     * @return the ownerID
     */
    public int getOwnerID() {
        return ownerID;
    }

    /**
     * @param ownerID the ownerID to set
     */
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return the ownerNIC
     */
    public String getOwnerNIC() {
        return ownerNIC;
    }

    /**
     * @param ownerNIC the ownerNIC to set
     */
    public void setOwnerNIC(String ownerNIC) {
        this.ownerNIC = ownerNIC;
    }

    /**
     * @return the relationship
     */
    public String getRelationship() {
        return relationship;
    }

    /**
     * @param relationship the relationship to set
     */
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    /**
     * @return the empno
     */
    public int getEmpno() {
        return empno;
    }

    /**
     * @param empno the empno to set
     */
    public void setEmpno(int empno) {
        this.empno = empno;
    }
}

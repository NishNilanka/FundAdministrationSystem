/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBoperations;

import DeathGrant.DeathGrantDetails;
import LoanAccount.LoanAccountDetails;
import Member.MemberDetails;
import SavingAccount.TransactionDetails;
import ScholorshipAccount.ScholorshipDetails;
import Transactions.TransactionDetail;
import fundadministrationsystem.UserDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nishan Gunawardena
 */
public class DBoperations {
    /*All the methods in this class are related with the temporaryfundadministrator DB*/
    String url = "jdbc:mysql://localhost:3306/temporaryfundadministrator";
    String userName = "root";
    String passWord = "";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet set = null;
    /* Url will contain the ip address of the server when the system will conect to the LAN */
    

   
    public boolean addMember(MemberDetails member) {
        /*This method insert values to temporaryfundadministrator DB.Insert to three tables in that DB called
	savingsaccount, transferaccountownership and member  */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            /*This query will insert data into the Savingsaccount table*/
            String queryAccount = "INSERT INTO savingsaccount VALUES (?,?)";
            statement = connection.prepareStatement(queryAccount);

            statement.setString(1, member.getAccountNo());
            statement.setBigDecimal(2, member.getCurrentBalance());
            //statement.setInt(3, 1);

            statement.executeUpdate();
            statement.close();
            //Close the above statement and keep it for future uses
            /* This query will insert data into transferaccountownership table*/
            String queryTransferAccount = "INSERT INTO transferaccountownership(OwnerID, Name, NICnO, Relationship) VALUES (?,?,?,?)";
            statement = connection.prepareStatement(queryTransferAccount, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, 0);
            statement.setString(2, member.getOwnerName());
            statement.setString(3, member.getOwnerNIC());
            statement.setString(4, member.getRelationship());


            statement.executeUpdate();
            /* generatedKeys attribute contains the generated keys while executing the above qury */
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                member.setOwnerID(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
            statement.close();
            
            
            /* This query will insert the data into newmember table */
            String queryMember = "INSERT INTO newmember (EmpNo,FirstName,SecondName,NIC,Address, Gender,RegisteredDate,Designation,Prison,PhoneNO,LedgerNo,RetirementDate,transferaccountownership_OwnerID,savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryMember);


            statement.setInt(1, 0);
            statement.setString(2, member.getFirstName());
            statement.setString(3, member.getLastName());
            statement.setString(4, member.getNicNo());
            //statement.setInt(5, member.getAge());
            statement.setString(5, member.getAddress());
            //statement.setString(7, member.getDob());
            statement.setString(6, member.getGender());
            statement.setString(7, member.getRegDate());
            statement.setString(8, member.getDesignation());
            statement.setString(9, member.getPrison());
            statement.setInt(10, member.getPhoneNo());
            statement.setString(11, member.getLedgerNo());
            statement.setString(12, member.getRetirementDate());
            statement.setInt(13, member.getOwnerID());
            statement.setString(14, member.getLedgerNo());
            

            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public boolean addUser(UserDetails user) {
        /* This method insert a new user to the temporaryfundadministrator DB. user can be an internal officer or */
        try {

            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(query);

            statement.setInt(1, 0);
            statement.setString(2, user.getNic());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getDesignation());
            statement.setString(6, user.getUserType());
            statement.setInt(7, user.getAge());
            statement.setString(8, user.getAddress());
            statement.setInt(9, user.getContactNo());
            statement.setBoolean(10, user.isMember());
            statement.setInt(11, user.getAccountNo());
            statement.setString(12, user.getUserName());
            statement.setString(13, user.getPassword());

            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.print(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }


    }

    public boolean updateMember(MemberDetails member) {
        /* This method helps to update a member. updated member will send to the temporaryfundadministrator DB
	Then it will wait for the authorization. it insert new updated data into the UpdateOwner and updatemember
	in updatemember temporaryfundadministrator DB*/
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            
            /* This query will insert new data into UpdateOwner the temporaryfundadministrator DB */
            String queryTransferAccount = "INSERT INTO UpdateOwner(OwnerID,OID, Name, NICnO, Relationship) VALUES (?,?,?,?,?)";
            statement = connection.prepareStatement(queryTransferAccount, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, 0);
            statement.setInt(2, member.getOwnerID());
            statement.setString(3, member.getOwnerName());
            statement.setString(4, member.getOwnerNIC());
            statement.setString(5, member.getRelationship());


            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                member.setOwnerID(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
            statement.close();
            
            
            /* This query will insert new data into updatemember the temporaryfundadministrator DB*/
            String queryMember = "INSERT INTO updatemember (EmpNo,FirstName,SecondName,NIC,Address, Gender,RegisteredDate,Designation,Prison,PhoneNO,LedgerNo,RetirementDate,savingsaccount_AccountNo,updateowner_OwnerID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryMember);


            statement.setInt(1, member.getEmpno());
            statement.setString(2, member.getFirstName());
            statement.setString(3, member.getLastName());
            statement.setString(4, member.getNicNo());
            //statement.setInt(5, member.getAge());
            statement.setString(5, member.getAddress());
            //statement.setString(7, member.getDob());
            statement.setString(6, member.getGender());
            statement.setString(7, member.getRegDate());
            statement.setString(8, member.getDesignation());
            statement.setString(9, member.getPrison());
            statement.setInt(10, member.getPhoneNo());
            statement.setString(11, member.getLedgerNo());
            statement.setString(12, member.getRetirementDate());
            
            statement.setString(13, member.getLedgerNo());
            statement.setInt(14, member.getOwnerID());
            

            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
        

    }

    public boolean deleteMember(MemberDetails member) {
        /* This will insert the data about the member which we wants to delete 
         * into deletemember in the temporaryfundadministrator DB */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            
            
             String queryMember = "INSERT INTO deletemember (EmpNo,FirstName,SecondName,NIC,Address, Gender,RegisteredDate,Designation,Prison,PhoneNO,LedgerNo,RetirementDate,transferaccountownership_OwnerID,savingsaccount_AccountNo,Type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryMember);


            statement.setInt(1, member.getEmpno());
            statement.setString(2, member.getFirstName());
            statement.setString(3, member.getLastName());
            statement.setString(4, member.getNicNo());
            statement.setString(5, member.getAddress());
            statement.setString(6, member.getGender());
            statement.setString(7, member.getRegDate());
            statement.setString(8, member.getDesignation());
            statement.setString(9, member.getPrison());
            statement.setInt(10, member.getPhoneNo());
            statement.setString(11, member.getLedgerNo());
            statement.setString(12, member.getRetirementDate());
            statement.setInt(13, member.getOwnerID());
            statement.setString(14, member.getLedgerNo());
            statement.setInt(15, 1);
            statement.executeUpdate();
            //statement.close();
            
            //String query = "DELETE  FROM member WHERE EmpNo='" + member.getEmpno() + "'";
            //statement = connection.prepareStatement(query);
            //statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }

    
//    public ArrayList<TransactionDetails> getTransactions(String AccountNo) {
//        
//        try {
//            ArrayList<TransactionDetails> transactionDetails = new ArrayList<TransactionDetails>();
//            connection = DriverManager.getConnection(url, userName, passWord);
//            String query = "SELECT * FROM savingsaccounttransaction Where savingsaccount_AccountNo = '" + AccountNo + "'";
//
//            statement = connection.prepareStatement(query);
//            set = statement.executeQuery();
//
//            while (set.next()) {
//                TransactionDetails transactions = new TransactionDetails();
//                transactions.setTranID(set.getInt(1));
//                transactions.setDate(set.getString(2));
//                transactions.setDesription(set.getString(3));
//                transactions.setWithdrawals(set.getFloat(4));
//                transactions.setDeposite(set.getFloat(5));
//                transactions.setBalance(set.getFloat(6));
//                transactions.setTaller(set.getString(7));
//
//                transactionDetails.add(transactions);
//
//            }
//            return transactionDetails;
//
//        } catch (Exception e) {
//            System.out.print(e);
//            return null;
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//    }
//    
    
    
//     public boolean addMonthEandAcount(TransactionDetails MonthEndAcountDetails){
//        try {
//            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
//            String query = "INSERT INTO savingsaccounttransaction VALUES(?,?,?,?,?,?,?,?)";
//           statement = connection.prepareStatement(query);
//
//            statement.setInt(1, 0);
//            statement.setString (2,MonthEndAcountDetails.getDate());
//            statement.setString(3,MonthEndAcountDetails.getDesription());
//            statement.setFloat(4,MonthEndAcountDetails.getWithdrawals());
//            statement.setFloat(5,MonthEndAcountDetails.getDeposite());
//            statement.setString(6,new Float(MonthEndAcountDetails.getBalance()).toString());
//            statement.setString(7,MonthEndAcountDetails.getSavingsaccount_AccountNo());
//            statement.setInt(8, 6);
//////            System.out.println(MonthEndAcountDetails.getDate());
//////            System.out.println(MonthEndAcountDetails.getDesription());
//////            System.out.println(MonthEndAcountDetails.getWithdrawals());
//////            System.out.println(MonthEndAcountDetails.getDeposite());
//////            System.out.println(MonthEndAcountDetails.getBalance());
//////            System.out.println(MonthEndAcountDetails.getSavingsaccount_AccountNo());
//////            
//            
//            
//            statement.executeUpdate();
//            return true;
//
//        } catch (Exception ex) {
//            System.out.print(ex);
//            return false;
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//
//
//    }

//    public ArrayList<SavingsAccountDetails> getMonthEndTransactionAccountByPrison(String prison) {
//        try {
//            ArrayList<SavingsAccountDetails> MonthEndAccountList = new ArrayList<SavingsAccountDetails>();
//            
//            connection = DriverManager.getConnection(url, userName, passWord);
//            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "'";
//            
//            statement = connection.prepareStatement(query);
//            set = statement.executeQuery();
//           
//            while (set.next()) {
//                
//                SavingsAccountDetails monthEndAccount = new SavingsAccountDetails();
//             
//                
//                monthEndAccount.setEmpNo(set.getInt(1));
//                
//                monthEndAccount.setName(set.getString(2)+" "+set.getString(3));
//                monthEndAccount.setPrison(set.getString(4));
//                monthEndAccount.setCurrentBalance(set.getFloat(5));
//                monthEndAccount.setAccountNo(set.getString(6));
//             
//                // monthEndAccount.setNewCurrentBalance(set.getFloat(5));
//                MonthEndAccountList.add(monthEndAccount);
//
//            }
//            return MonthEndAccountList;
//
//        } catch (Exception e) {
//            System.out.print(e);
//            return null;
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//    }

//    public boolean updateMonthEndAcount(SavingsAccountDetails MonthEndAcountDetails) {
//        try {
//            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
//            String q = "UPDATE savingsaccount SET CurrentBalance = '" + MonthEndAcountDetails.getCurrentBalance() + "'WHERE AccountNo = " + MonthEndAcountDetails.getAccountNo();
//            statement = (PreparedStatement) connection.prepareStatement(q);
//            statement.executeUpdate();
//            return true;
//        } catch (Exception a) {
//            System.out.print(a);
//            return false;
//        } finally {
//
//            try {
//
//                if (statement != null) {
//                    statement.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (Exception e) {
//            }
//        }
//
//
//
//
//    }
    
    public boolean addLoanAccount(LoanAccountDetails loan, MemberDetails member, MemberDetails gurantee1, MemberDetails gurantee2) {
        /* This method is used to insert a new loan. Method only insert data into the loanaccount*/
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String queryLoanAccount = "INSERT INTO loanaccount(ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, member_EmpNo, member_transferaccountownership_OwnerID, member_savingsaccount_AccountNo,Type,member_EmpNo1,member_transferaccountownership_OwnerID1,member_savingsaccount_AccountNo1,member_EmpNo2,member_transferaccountownership_OwnerID2,member_savingsaccount_AccountNo2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(queryLoanAccount);

            statement.setInt(1,loan.getLoanNo());
            statement.setDouble(2, loan.getLoanAmount());
            statement.setDouble(3, loan.getMonthlyPayment());
            statement.setFloat(4, loan.getInterest());
            statement.setInt(5,loan.getChequeNo());
            statement.setDouble(6, loan.getVoucherNo());
            statement.setString(7, loan.getDate());
            statement.setInt(8,loan.getDuration());
            statement.setInt(9, member.getEmpno());
            statement.setInt(10,member.getOwnerID());
            statement.setString(11, member.getAccountNo());
            statement.setInt(12, 1);
            
            statement.setInt(13, 5);
            statement.setInt(14, 1);
            statement.setString(15, "1");
            
            statement.setInt(16, 0);
            statement.setInt(17, 47);
            statement.setString(18, "67HS");

            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
        public boolean newScholorship(ScholorshipDetails ed) {
            /* Scholorships are given to children of members who got highest 
              marks for the Grade IV scholorships exam and Advanced 
            level Exam. Since, there are two types of scholrships. 
              The amount wll depend on the type of the scholrship. Insert new data into the 
		newscholorship in the temporaryfundadministrator DB */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO newscholorship (ScholorshipNo,FirstName,LastName,School,Gender,DOB,ScholorshipType, Amount, member_EmpNo, member_transferaccountownership_OwnerID, member_savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, 0);
            statement.setString(2, ed.getFirstName());
            statement.setString(3, ed.getLastName());
            statement.setString(4, ed.getSchool());
            statement.setString(5, ed.getGender());
            statement.setString(6, ed.getDob());
            statement.setString(7, ed.getScholorshipType());
            statement.setFloat(8, ed.getAmount());
            statement.setInt(9, ed.getEmpNo());
            statement.setInt(10, ed.getOwnerID());
            statement.setString(11, ed.getAccountNo());
            

            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
       public boolean updateScholorship(ScholorshipDetails ed) {
           /* To update a scholorship account we use this DB operation method 
            * which will directly insert the updated data into 
		updatescholorship table in the temporaryfundadministrator DB */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO updatescholorship (SNo,ScholorshipNo,FirstName,LastName,School,Gender,DOB,ScholorshipType, Amount, member_EmpNo, member_transferaccountownership_OwnerID, member_savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, 0);
            statement.setInt(2,ed.getScholorshipNo());
            statement.setString(3, ed.getFirstName());
            statement.setString(4, ed.getLastName());
            statement.setString(5, ed.getSchool());
            statement.setString(6, ed.getGender());
            statement.setString(7, ed.getDob());
            statement.setString(8, ed.getScholorshipType());
            statement.setFloat(9, ed.getAmount());
            statement.setInt(10, ed.getEmpNo());
            statement.setInt(11, ed.getOwnerID());
            statement.setString(12, ed.getAccountNo());
            

            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
     
     public boolean deleteScholorship(ScholorshipDetails ed) {
         /* Same as the update method this function helps to delete a scholorship
          * details and insert the data into deletescholorship table in the 
	temporaryfundadministrator DB */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO deletescholorship (SNo,ScholorshipNo,FirstName,LastName,School,Gender,DOB,ScholorshipType, Amount, member_EmpNo, member_transferaccountownership_OwnerID, member_savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, 0);
            statement.setInt(2,ed.getScholorshipNo());
            statement.setString(3, ed.getFirstName());
            statement.setString(4, ed.getLastName());
            statement.setString(5, ed.getSchool());
            statement.setString(6, ed.getGender());
            statement.setString(7, ed.getDob());
            statement.setString(8, ed.getScholorshipType());
            statement.setFloat(9, ed.getAmount());
            statement.setInt(10, ed.getEmpNo());
            statement.setInt(11, ed.getOwnerID());
            statement.setString(12, ed.getAccountNo());
            

            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
 public boolean newDeathGrant(DeathGrantDetails ed) {
     /* Using this method system can insert a new death grant account. 
      * New data will insert to the newdeathgrant and wait for the authorization*/
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO  newdeathgrant(DeathGrantNo, FirstName, LastName, Relationship, Gender, DOD, DeathCertificateNo, Amount, member_EmpNo, member_transferaccountownership_OwnerID, member_savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, 0);
            statement.setString(2, ed.getFirstName());
            statement.setString(3, ed.getLastName());
            statement.setString(4, ed.getRelationship());
            statement.setString(5, ed.getGender());
            statement.setString(6, ed.getDod());
            statement.setString(7, ed.getDeathCertificateNo());
            statement.setFloat(8, ed.getAmount());
            statement.setInt(9, ed.getEmpNo());
            statement.setInt(10, ed.getMemTransOwnId());
            statement.setString(11, ed.getAccountNo());
            
            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
 }
 public boolean updateDeathGrant(DeathGrantDetails deathgrant) {
     /* Same as the other update methods this methods will insert the newly 
      * updated data into the  */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO  updatedeathgrant (DNo,DeathGrantNo, FirstName, LastName, Relationship, Gender, DOD, DeathCertificateNo, Amount, member_EmpNo) VALUES (?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, 0);
            statement.setInt(2, deathgrant.getDeathGrantNo());
            statement.setString(3, deathgrant.getFirstName());
            statement.setString(4, deathgrant.getLastName());
            statement.setString(5, deathgrant.getRelationship());
            statement.setString(6, deathgrant.getGender());
            statement.setString(7, deathgrant.getDod());
            statement.setString(8, deathgrant.getDeathCertificateNo());
            statement.setFloat(9, deathgrant.getAmount());
            statement.setInt(10, deathgrant.getEmpNo());

            
            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
    }
   
 public boolean newDeathGrantLoan(DeathGrantDetails ed) {
     /* Once the member need to get a death grant loan first of all the member 
      * must get the deathgrant
	then then member can apply for a death grant loan new death grant loans 
        * are generated by thi function */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String query = "INSERT INTO  newdeathgrantloan(DeathGrantLoanNo, LoanAmount, MonthlyPayment, ChequeNo, VoucherNo, Date, deathgrant_DeathGrantNo, deathgrant_member_EmpNo, deathgrant_member_transferaccountownership_OwnerID, deathgrant_member_savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(query);


            statement.setInt(1, 0);
            statement.setFloat(2, ed.getAmount());
            statement.setFloat(3, ed.getMonthlyPayment());
            statement.setString(4, ed.getChequeNo());
            statement.setString(5, ed.getVoucherNo());
            statement.setString(6, ed.getDate());
            statement.setInt(7, ed.getDeathGrantNo());
            statement.setInt(8, ed.getEmpNo());
            statement.setInt(9, ed.getMemTransOwnId());
            statement.setString(10, ed.getAccountNo());
           

            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
 }
      

    

    public boolean deletDeathGrant(DeathGrantDetails deathgrant) {
        /*same as the other delete functions the object that need to delete is 
         * send to the deletedeathgrant table
	in the temporaryfundadministrator DB*/
          try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO  deletedeathgrant (DNo,DeathGrantNo, FirstName, LastName, Relationship, Gender, DOD, DeathCertificateNo, Amount, member_EmpNo) VALUES (?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, 0);
            statement.setInt(2, deathgrant.getDeathGrantNo());
            statement.setString(3, deathgrant.getFirstName());
            statement.setString(4, deathgrant.getLastName());
            statement.setString(5, deathgrant.getRelationship());
            statement.setString(6, deathgrant.getGender());
            statement.setString(7, deathgrant.getDod());
            statement.setString(8, deathgrant.getDeathCertificateNo());
            statement.setFloat(9, deathgrant.getAmount());
            statement.setInt(10, deathgrant.getEmpNo());
           
            
            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
        } 
    
     public boolean updateDeathLoan(DeathGrantDetails ed) {
         /* Updated death grant details will send to the updatedeathgrantloan 
          * table and wait for the authorization */
        try {
            
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            String query = "INSERT INTO  updatedeathgrantloan(DeathGrantLoanNo, LoanAmount, MonthlyPayment, ChequeNo, VoucherNo, Date, deathgrant_DeathGrantNo, deathgrant_member_EmpNo, deathgrant_member_transferaccountownership_OwnerID, deathgrant_member_savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(query);
            statement.setInt(1, 0);
            statement.setFloat(2, ed.getAmount());
            statement.setFloat(3, ed.getMonthlyPayment());
            statement.setString(4, ed.getChequeNo());
            statement.setString(5, ed.getVoucherNo());
            statement.setString(6, ed.getDate());
            statement.setInt(7, ed.getDeathGrantNo());
            statement.setInt(8, ed.getEmpNo());
            statement.setInt(9, ed.getMemTransOwnId());
            statement.setString(10, ed.getAccountNo());
           

            statement.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
      }
          public boolean deletDeathGrantLoan(DeathGrantDetails ed) {
              /* Takes a DeathGrantDetails object as the parameter and data 
               * which we need to delete from the database will send to the
		deletedeathgrantloan in temporaryfundadministrator DB */
          try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO  deletedeathgrantloan (DeleteNo,DeathGrantLoanNo, LoanAmount, MonthlyPayment, ChequeNo, VoucherNo, Date, deathgrant_DeathGrantNo, deathgrant_member_EmpNo) VALUES (?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, 0);
            statement.setInt(2, ed.getLoanNo());
            statement.setFloat(3, ed.getLoanAmount());
            statement.setFloat(4, ed.getMonthlyPayment());
            statement.setString(5, ed.getChequeNo());
            statement.setString(6, ed.getVoucherNo());
            statement.setString(7, ed.getDate());
            statement.setInt(8, ed.getDeathGrantNo());
            statement.setInt(9, ed.getEmpNo());


            statement.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
        } 
    
    public ArrayList<MemberDetails> getMemberByType(int type) {

         try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID Where member.Type = '" + type + "'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt());
                member.setAddress(set.getString(5));
                //member.setDob(set.getString(7));
                member.setGender(set.getString(6));
                member.setRegDate(set.getString(7));
                member.setDesignation(set.getString(8));
                member.setPrison(set.getString(9));
                member.setPhoneNo(set.getInt(10));
                member.setLedgerNo(set.getString(11));
                member.setRetirementDate(set.getString(12));
              
                member.setOwnerID(set.getInt(16));
                member.setOwnerName(set.getString(17));
                member.setOwnerNIC(set.getString(18));
                member.setRelationship(set.getString(19));

                memberDetailsArray.add(member);

            }
            return memberDetailsArray;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    public boolean monthEndTransactions(ArrayList<TransactionDetail> transactionDetails) {
    /* It takes a parameter as a Arraylist which has a type of TransactionDetail.
     * Parameter passes the new object which contain
	Data about the new transactions into monthendtransactions in the temporaryfundadministrator DB*/
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord); 

            String queryScholorship = "INSERT INTO  monthendtransactions (TranID,EmpID, Name, Year, Month, FixedDeposit, Scholorship, RegisterFee, Loan, DeathGrant, DeathGrantLoan,Total,userID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            for(int r = 0; r < transactionDetails.size(); r++){
            

            statement = connection.prepareStatement(queryScholorship);

            statement.setInt(1, 0);
            statement.setInt(2, transactionDetails.get(r).getEmpId());
            statement.setString(3, transactionDetails.get(r).getName());
            statement.setInt(4, transactionDetails.get(r).getYear());
            statement.setInt(5, transactionDetails.get(r).getMonth());
            statement.setFloat(6, transactionDetails.get(r).getFixedDeposit());
            statement.setFloat(7, transactionDetails.get(r).getScholorship());
            statement.setFloat(8, transactionDetails.get(r).getRegFee());
            statement.setFloat(9, transactionDetails.get(r).getLoan());
            statement.setFloat(10, transactionDetails.get(r).getDeathGrant());
            statement.setFloat(11, transactionDetails.get(r).getDeathGrantLoan());
            statement.setFloat(12, transactionDetails.get(r).getTotal());
            statement.setInt(13, transactionDetails.get(r).getUserID());

            statement.executeUpdate();
            }

            return true;

        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
 }
    
    public ArrayList<MemberDetails> getNewMember() {

        /* To authorize new members we need to load the new member details in 
         * the newmember. So we call this no parameter method and load newly added members */
         try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM newmember LEFT JOIN transferaccountownership ON newmember.transferaccountownership_OwnerID = transferaccountownership.OwnerID ";
      
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt());
                member.setAddress(set.getString(5));
                //member.setDob(set.getString(7));
                member.setGender(set.getString(6));
                member.setRegDate(set.getString(7));
                member.setDesignation(set.getString(8));
                member.setPrison(set.getString(9));
                member.setPhoneNo(set.getInt(10));
                member.setLedgerNo(set.getString(11));
                member.setRetirementDate(set.getString(12));
              
                member.setOwnerID(set.getInt(15));
                member.setOwnerName(set.getString(16));
                member.setOwnerNIC(set.getString(17));
                member.setRelationship(set.getString(18));

                memberDetailsArray.add(member);

            }
            return memberDetailsArray;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    
    public ArrayList<MemberDetails> getUpdateMember() {  
        //get update member details from temporaryfundadministrator database.
    /* Same as the above method it uses to load the newly updated member in 
     * the temporaryfundadministrator databse  */
         try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM updatemember LEFT JOIN updateowner ON updatemember.updateowner_OwnerID = updateowner.OwnerID ";
      
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt());
                member.setAddress(set.getString(5));
                //member.setDob(set.getString(7));
                member.setGender(set.getString(6));
                member.setRegDate(set.getString(7));
                member.setDesignation(set.getString(8));
                member.setPrison(set.getString(9));
                member.setPhoneNo(set.getInt(10));
                member.setLedgerNo(set.getString(11));
                member.setRetirementDate(set.getString(12));
              
                member.setOwnerID(set.getInt(15));
                member.setOwnerName(set.getString(17));
                member.setOwnerNIC(set.getString(18));
                member.setRelationship(set.getString(19));

                memberDetailsArray.add(member);

            }
            return memberDetailsArray;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    
    public ArrayList<MemberDetails> getDeleteMember() { 
        //get delete member details from temporaryfundadministrator database.
        /* no parameter getDeleteMember method will return a Arraylist which
         * contains member details type object from the deletemember table*/
         try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM deletemember LEFT JOIN transferaccountownership ON deletemember.transferaccountownership_OwnerID = transferaccountownership.OwnerID ";
      
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt());
                member.setAddress(set.getString(5));
                //member.setDob(set.getString(7));
                member.setGender(set.getString(6));
                member.setRegDate(set.getString(7));
                member.setDesignation(set.getString(8));
                member.setPrison(set.getString(9));
                member.setPhoneNo(set.getInt(10));
                member.setLedgerNo(set.getString(11));
                member.setRetirementDate(set.getString(12));
              
                member.setOwnerID(set.getInt(15));
                member.setOwnerName(set.getString(16));
                member.setOwnerNIC(set.getString(17));
                member.setRelationship(set.getString(18));

                memberDetailsArray.add(member);

            }
            return memberDetailsArray;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    public boolean deleteNewMember(MemberDetails member) {
        /* Once the Chief officer authorize a newmember from the newmember, 
         * he/she needs to delete the current data in the newmember, So the method will delete the 
	member details from the newmember table. member is identified by the 
        * employee number of the member */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "DELETE  FROM newmember WHERE EmpNo='" + member.getEmpno() + "'";
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    public boolean deleteUpMember(MemberDetails member) {
        /* same as the above method once chief officer authorize a updated 
         * member the data in the updateowner and updatemember should be deleted.
         * so using ownerID and employee no a particular member and Transfer owner 
         * will identifi */
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query1 = "DELETE  FROM updateowner WHERE OwnerID ='" + member.getOwnerID() + "'";
            statement = connection.prepareStatement(query1);
            statement.executeUpdate();
            statement.close();
            String query = "DELETE  FROM updatemember WHERE EmpNo='" + member.getEmpno() + "'";
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    public boolean deleteDeleteMember(MemberDetails member) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "DELETE  FROM deletemember WHERE EmpNo='" + member.getEmpno() + "'";
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    
    
    public ArrayList<TransactionDetails> getMonthEndTransaction() {

         try {
            ArrayList<TransactionDetails> TranArray = new ArrayList<TransactionDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            //String query = "SELECT * FROM savingsaccounttransaction LEFT JOIN savingsaccount ON savingsaccount.savingsaccount_AccountNo = savingsaccounttransaction.savingsaccount_AccountNo Where member.Type = '" + type + "'";
            //String q = "SELECT * FROM savingsaccounttransaction LEFT JOIN savingsaccount ON savingsaccounttransaction.savingsaccount_AccountNo = savingsaccount.AccountNo Where savingsaccounttransaction.Type = '" + type + "'";
            String qu = "SELECT * FROM monthendtransactions  LEFT JOIN savingsaccounttransaction ON monthendtransactions.TranID = savingsaccounttransaction.TranID ";
            statement = connection.prepareStatement(qu);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                TransactionDetails tra = new TransactionDetails();

                
                tra.setTranID(set.getInt(1));
                tra.setEmpNo(set.getInt(2));
                tra.setName(set.getString(3));
                tra.setYear(set.getInt(4));
                tra.setMonth(set.getInt(5));
                tra.setDeposite(set.getFloat(6));
                tra.setScholorship(set.getFloat(7));
                tra.setRegisterFee(set.getFloat(8));
                tra.setLoan(set.getFloat(9));
                tra.setDeathgrant(set.getFloat(10));
                tra.setDeathgrantloan(set.getFloat(11));
                tra.setTotal(set.getFloat(12));
                tra.setUser_UserNo(set.getInt(13));
                tra.setAccountNo(set.getString(20));
                            
                
                
                TranArray.add(tra);

            }
            return TranArray;
                    } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
    
    public boolean DelmonthEndTran(TransactionDetails t) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "DELETE  FROM monthendtransactions WHERE TranId='" + t.getTranID()+ "'";
            statement = connection.prepareStatement(query);
            
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
    }
        
        public ArrayList<LoanAccountDetails>getLoanByType(int type) {

         try {
            ArrayList<LoanAccountDetails> loanArray = new ArrayList<LoanAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            
            String q = "SELECT * FROM loanaccount Where loanaccount.Type = '" + type + "'";
            statement = connection.prepareStatement(q);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                LoanAccountDetails ld = new LoanAccountDetails();
                
                ld.setLoanNo(set.getInt(1));
                ld.setApplicationNo(set.getInt(2));
                ld.setLoanAmount(set.getFloat(3));
                ld.setMonthlyPayment(set.getFloat(4));
                ld.setInterest(set.getFloat(5));
                ld.setChequeNo(set.getInt(6));
                ld.setVoucherNo(set.getInt(7));
                ld.setDate(set.getString(8));
                ld.setDuration(set.getInt(9));
                ld.setBalance(set.getFloat(10));
                ld.setEmpNo1(set.getInt(11));
                ld.setOwnerId1(set.getInt(12));
                ld.setSavingAccount1(set.getString(13));
                ld.setEmpNo2(set.getInt(14));
                ld.setOwnerId2(set.getInt(15));
                ld.setSavingAccount2(set.getString(16));
                ld.setEmpNo3(set.getInt(17));
                ld.setOwnerId3(set.getInt(18));
                ld.setSavingAccount3(set.getString(19));
                
                loanArray.add(ld);
                
            }return loanArray;
         }
         
         
         catch(Exception e){
             System.out.println(e);
             return null;
         }finally{
             try{
                 if(connection!= null){
                     connection.close();
                 }if(statement!= null){
                     statement.close();
                 }
             }catch(Exception e){}
             
         } }
        
        
        
          public ArrayList<ScholorshipDetails>getscolNew() {
    
         try {
            ArrayList<ScholorshipDetails> scolArray = new ArrayList<ScholorshipDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            
            String q = "SELECT * FROM newscholorship " ;
            statement = connection.prepareStatement(q);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                ScholorshipDetails sd = new ScholorshipDetails();
                
                sd.setScholorshipNo(set.getInt(1));
                sd.setFirstName(set.getString(2));
                sd.setLastName(set.getString(3));
                sd.setSchool(set.getString(4));
                sd.setGender(set.getString(5));
                sd.setDob(set.getString(6));
                sd.setScholorshipType(set.getString(7));
                sd.setAmount(set.getFloat(8));
                sd.setEmpNo(set.getInt(9));
                sd.setOwnerID(set.getInt(10));
                sd.setAccountNo(set.getString(11));
                
                scolArray.add(sd);
                
            }return scolArray;
         }
         
         
         catch(Exception e){
             System.out.println(e);
             return null;
         }finally{
             try{
                 if(connection!= null){
                     connection.close();
                 }if(statement!= null){
                     statement.close();
                 }
             }catch(Exception e){}
             
         }} 
          
          public ArrayList<ScholorshipDetails>getscolUp() {
    
         try {
            ArrayList<ScholorshipDetails> scolArray = new ArrayList<ScholorshipDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            
            String q = "SELECT * FROM updatescholorship " ;
            statement = connection.prepareStatement(q);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                ScholorshipDetails sd = new ScholorshipDetails();
                
                sd.setScholorshipNo(set.getInt(2));
                sd.setFirstName(set.getString(3));
                sd.setLastName(set.getString(4));
                sd.setSchool(set.getString(5));
                sd.setGender(set.getString(6));
                sd.setDob(set.getString(7));
                sd.setScholorshipType(set.getString(8));
                sd.setAmount(set.getFloat(9));
                sd.setEmpNo(set.getInt(10));
                sd.setOwnerID(set.getInt(11));
                sd.setAccountNo(set.getString(12));
                
                scolArray.add(sd);
                
            }return scolArray;
         }
         
         
         catch(Exception e){
             System.out.println(e);
             return null;
         }finally{
             try{
                 if(connection!= null){
                     connection.close();
                 }if(statement!= null){
                     statement.close();
                 }
             }catch(Exception e){}
             
         }} 
          
          public ArrayList<ScholorshipDetails>getscolDe() {
    
         try {
            ArrayList<ScholorshipDetails> scolArray = new ArrayList<ScholorshipDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            
            String q = "SELECT * FROM deletescholorship " ;
            statement = connection.prepareStatement(q);
            set = statement.executeQuery();

            while (set.next()) {
                
                
                ScholorshipDetails sd = new ScholorshipDetails();
                
                sd.setScholorshipNo(set.getInt(2));
                sd.setFirstName(set.getString(3));
                sd.setLastName(set.getString(4));
                sd.setSchool(set.getString(5));
                sd.setGender(set.getString(6));
                sd.setDob(set.getString(7));
                sd.setScholorshipType(set.getString(8));
                sd.setAmount(set.getFloat(9));
                sd.setEmpNo(set.getInt(10));
                sd.setOwnerID(set.getInt(11));
                sd.setAccountNo(set.getString(12));
                
                scolArray.add(sd);
                
            }return scolArray;
         }
         
         
         catch(Exception e){
             System.out.println(e);
             return null;
         }finally{
             try{
                 if(connection!= null){
                     connection.close();
                 }if(statement!= null){
                     statement.close();
                 }
             }catch(Exception e){}
             
         }} 
          
          
          
          public boolean deleteLoan(LoanAccountDetails loan) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "DELETE  FROM loanaccount WHERE LoanNo='" + loan.getLoanNo() + "'";
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
          
         

          
          public ArrayList<DeathGrantDetails> getNewDeathGrant() {

         try {
            ArrayList<DeathGrantDetails> deathGrantDetailsArray = new ArrayList<DeathGrantDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM newdeathgrantloan LEFT JOIN newdeathgrant ON newdeathgrantloan.deathgrant_DeathGrantNo = newdeathgrant.DeathGrantNo ";
      
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                
                
               DeathGrantDetails d = new DeathGrantDetails();
               
               

                d.setLoanNo(set.getInt(1));
                d.setAmount(set.getFloat(2));
                d.setMonthlyPayment(set.getFloat(3));                 
                d.setChequeNo(set.getString(4));
                d.setVoucherNo(set.getString(5));               
                d.setDate(set.getString(6));
               // d.set
                
                d.setDeathGrantNo(set.getInt(7));
                d.setEmpNo(set.getInt(8));
                d.setOwnerId(set.getInt(9));
               // d.setAccountNo(set.getString(10)); 
                 
               // d.setDeathGrantNo(set.getInt(11));
                d.setFirstName(set.getString(12));
                d.setLastName(set.getString(13));
                d.setRelationship(set.getString(14));
                d.setGender(set.getString(15));
                d.setDod(set.getString(16));
                d.setDeathCertificateNo(set.getString(17)); 
                d.setAmount(set.getFloat(18));
                d.setEmpNo(set.getInt(19));
                d.setOwnerId(set.getInt(20));
                d.setAccountNo(set.getString(21));
                       

                deathGrantDetailsArray.add(d);

            }
            return deathGrantDetailsArray;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
          
          public ArrayList<DeathGrantDetails> getUpdateDeathGrant() {

         try {
            ArrayList<DeathGrantDetails> deathGrantDetailsArray = new ArrayList<DeathGrantDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM updatedeathgrant LEFT JOIN updatedeathgrantloan ON updatedeathgrant.DeathGrantNo = updatedeathgrantloan.deathgrant_DeathGrantNo ";
      
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                
                
               DeathGrantDetails d = new DeathGrantDetails();
               
                
                d.setDeathGrantNo(set.getInt(2));
                d.setFirstName(set.getString(3));
                d.setLastName(set.getString(4));
                d.setRelationship(set.getString(5));
                d.setGender(set.getString(6));
                d.setDod(set.getString(7));
                d.setDeathCertificateNo(set.getString(8));
                d.setAmount(set.getFloat(9));
                d.setEmpNo(set.getInt(10));
               // d.setOwnerId(set.getInt(11));
                //d.setAccountNo(set.getString(12));
                                
                d.setLoanNo(set.getInt(13));
                d.setMonthlyPayment(set.getFloat(15));
                d.setChequeNo(set.getString(16));
                d.setVoucherNo(set.getString(17));
                d.setDate(set.getString(18));
               
                

                deathGrantDetailsArray.add(d);

            }
            return deathGrantDetailsArray;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
          
          public ArrayList<DeathGrantDetails> getDelDeathGrant() {

         try {
            ArrayList<DeathGrantDetails> deathGrantDetailsArray = new ArrayList<DeathGrantDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM deletedeathgrantloan LEFT JOIN deletedeathgrant ON deletedeathgrantloan.deathgrant_DeathGrantNo = deletedeathgrant.DeathGrantNo ";
      
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                
                
               DeathGrantDetails d = new DeathGrantDetails();
               
               

                d.setLoanNo(set.getInt(2));
                d.setAmount(set.getFloat(3));
                d.setMonthlyPayment(set.getFloat(4));                 
                d.setChequeNo(set.getString(5));
                d.setVoucherNo(set.getString(6));               
                d.setDate(set.getString(7));
               // d.set
                
                d.setDeathGrantNo(set.getInt(8));
                d.setEmpNo(set.getInt(9));
                d.setOwnerId(set.getInt(10));
               // d.setAccountNo(set.getString(11)); 
                 
               // d.setDeathGrantNo(set.getInt(12));
                d.setFirstName(set.getString(13));
                d.setLastName(set.getString(14));
                d.setRelationship(set.getString(15));
                d.setGender(set.getString(16));
                d.setDod(set.getString(17));
                d.setDeathCertificateNo(set.getString(18)); 
                d.setAmount(set.getFloat(19));
                d.setEmpNo(set.getInt(20));
                d.setOwnerId(set.getInt(21));
                d.setAccountNo(set.getString(22));
                       

                deathGrantDetailsArray.add(d);

            }
            return deathGrantDetailsArray;

        } catch (Exception e) {
            System.out.print(e);
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
          }

          
           public boolean deletedeathGrant(DeathGrantDetails death) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "DELETE  FROM deletedeathgrant WHERE EmpNo='" + death.getDeathGrantNo()+ "'";
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }
          
          
           public boolean  deleteScol(ScholorshipDetails scol) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "DELETE  FROM updatescholorship";
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            return true;

        } catch (Exception ex) {
            System.out.println("ex");
            return false;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }

    }

    public boolean deleteDefaultLoanAccount(LoanAccountDetails loanAD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
               

                
       

    
}

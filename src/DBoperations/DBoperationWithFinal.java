/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DBoperations;

import DeathGrant.DeathGrantDetails;
import LoanAccount.LoanAccountDetails;
import Member.MemberDetails;
import SavingAccount.SavingsAccountDetails;
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
public class DBoperationWithFinal {

    String url = "jdbc:mysql://localhost:3306/finalfundadministrator";
    String userName = "root";
    String passWord = "";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet set = null;

    public String getUserName(String userID) {
        try {
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT FirstName, LastName FROM user WHERE UserNo = '" + userID + "'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();
            String userName1;
            if (set.next()) {
                userName1 = set.getString("FirstName") + " " + set.getString("LastName");
                return userName1;
            }

            return null;

        } catch (SQLException ex) {
            System.out.print(ex);
            return "Error";
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

    public MemberDetails getMemberByID(int empNo) {

        try {

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT EmpNo, FirstName, SecondName, NIC, Address, RegisteredDate, Designation, Prison, RetirementDate, LedgerNo FROM member Where EmpNo = '" + empNo + "'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();
            System.err.println("Hi");
            if (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                member.setAddress(set.getString(5));
                //member.setDob(set.getString(6));
                member.setRegDate(set.getString(6));
                member.setDesignation(set.getString(7));
                member.setPrison(set.getString(8));
                member.setRetirementDate(set.getString(9));
                member.setAccountNo(set.getString(10));

                return member;
            } else {
                return null;
            }

        } catch (Exception e) {

            System.out.print(e);
            //JOptionPane.showMessageDialog(this, "Member No is not valid");
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

    public ArrayList<MemberDetails> getMemberByPrison(String prisonName) {

        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID Where member.Prison = '" + prisonName + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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
    public boolean login(String username, String password) {
        try {
            connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "select * from user where UserName='" + username + "' and Password='" + password + "'";
            statement = connection.prepareStatement(sql);
            set = statement.executeQuery(sql);
            if (set.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
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

    public String getCurrentUserType(String CurrentuserName) {

        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);

            String query = "SELECT UserType FROM user WHERE UserName='" + CurrentuserName + "'";
            statement = connection.prepareStatement(query);
            //return true;

            set = statement.executeQuery();

            if (set.next()) {
                String type = set.getString(1);
                return type;
            } else {

                return null;

            }


        } catch (Exception ex) {
            System.out.println(ex);
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

    public boolean checkPassword(String password, String userID) {
        try {
            connection = DriverManager.getConnection(url, userName, passWord);
            String sql = "SELECT Password FROM user WHERE Password='" + password + "'";
            statement = connection.prepareStatement(sql);
            set = statement.executeQuery(sql);
            if (set.next()) {
                return true;
            } else {
                return false;
            }
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

    public UserDetails viewUserDetails(String userID) {
        try {
            UserDetails user = new UserDetails();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM user WHERE UserNo = '" + userID + "'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            if (set.next()) {
                user.setEmpNo(set.getInt(1));
                user.setNic(set.getString(2));
                user.setFirstName(set.getString(3));
                user.setLastName(set.getString(4));
                user.setDesignation(set.getString(5));
                user.setUserType(set.getString(6));
                user.setAge(set.getInt(7));
                user.setAddress(set.getString(8));
                user.setContactNo(set.getInt(9));
                user.setMember(set.getBoolean(10));
                user.setAccountNo(set.getInt(11));
                user.setUserName(set.getString(12));
                return user;
            } else {
                return null;
            }

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

    public boolean changePassword(String password, String userID) {
        try {

            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String q = "UPDATE user SET Password = '" + password + "'WHERE  UserNo = " + userID;
            statement = (PreparedStatement) connection.prepareStatement(q);

            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.print(e);
            return false;
        } finally {

            try {

                if (statement != null) {
                    statement.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public String getUserID(String UserName) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);

            String query = "SELECT UserNO FROM user WHERE UserName='" + UserName + "'";
            statement = connection.prepareStatement(query);
            //return true;

            set = statement.executeQuery();

            if (set.next()) {

                String userID = set.getString(1);

                return userID;
            } else {

                return null;

            }


        } catch (Exception ex) {
            System.out.println(ex);
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

    public ArrayList<MemberDetails> getMemberByName(String Name, String prison) {
        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID WHERE SecondName = '" + Name + "' AND Prison = '" + prison + "' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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

    public ArrayList<MemberDetails> getMemberByNIC(String NIC, String prison) {
        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID WHERE NIC = '" + NIC + "' AND Prison = '" + prison + "' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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

    public ArrayList<MemberDetails> getMemberByEmpNo(String EmpNO, String prison) {
        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID WHERE EmpNO = '" + EmpNO + "' AND Prison = '" + prison + "' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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

    public ArrayList<MemberDetails> getMemberByEmpNoAndName(String EmpNO, String prison, String Name) {
        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID WHERE SecondName = '" + Name + "' AND Prison = '" + prison + "' AND EmpNo = '" + EmpNO + "' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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

    public ArrayList<MemberDetails> getMemberByNICAndName(String NIC, String prison, String Name) {
        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID WHERE SecondName = '" + Name + "' AND Prison = '" + prison + "' AND NIC = '" + NIC + "' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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

    public ArrayList<MemberDetails> getMemberByEmpNoAndNIC(String EmpNO, String prison, String NIC) {
        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID WHERE EmpNO = '" + EmpNO + "' AND Prison = '" + prison + "' AND NIC = '" + NIC + "' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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

    public ArrayList<MemberDetails> getMemberByEmpNoAndNICAndName(String EmpNO, String prison, String NIC, String Name) {
        try {
            ArrayList<MemberDetails> memberDetailsArray = new ArrayList<MemberDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM member LEFT JOIN transferaccountownership ON member.transferaccountownership_OwnerID = transferaccountownership.OwnerID WHERE EmpNO = '" + EmpNO + "' AND Prison = '" + prison + "' AND NIC = '" + NIC + "' AND SecondName = '" + Name + "' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                MemberDetails member = new MemberDetails();

                member.setEmpno(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setNicNo(set.getString(4));
                //member.setAge(set.getInt(5));
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

    public ArrayList<SavingsAccountDetails> getAccountByPrison(String prison) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));
                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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

    public ArrayList<SavingsAccountDetails> getAccountByName(String Name, String prison) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND member.SecondName = '" + Name + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));

                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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

    public ArrayList<SavingsAccountDetails> getAccountByNIC(String NIC, String prison) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND member.NIC = '" + NIC + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));

                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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

    public ArrayList<SavingsAccountDetails> getAccountByAccountNo(String accountNo, String prison) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND savingsaccount.AccountNo = '" + accountNo + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));

                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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

    public ArrayList<SavingsAccountDetails> getAccountByAccountNoAndName(String accountNo, String prison, String Name) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND savingsaccount.AccountNo = '" + accountNo + "' AND member.SecondName = '" + Name + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));

                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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

    public ArrayList<SavingsAccountDetails> getAccountByNICAndName(String NIC, String prison, String Name) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND member.NIC = '" + NIC + "' AND member.SecondName = '" + Name + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));

                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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

    public ArrayList<SavingsAccountDetails> getAccountByAccountNoAndNIC(String accountNo, String prison, String NIC) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND member.NIC = '" + NIC + "' AND savingsaccount.AccountNo = '" + accountNo + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));

                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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
    

    public ArrayList<SavingsAccountDetails> getAccountByAccountNoAndNICAndName(String accountNo, String prison, String NIC, String Name) {
        try {
            ArrayList<SavingsAccountDetails> accountDetailsArray = new ArrayList<SavingsAccountDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT member.EmpNo,member.FirstName, member.SecondName, member.Prison, member.RegisteredDate, savingsaccount.CurrentBalance, savingsaccount.AccountNo FROM member LEFT JOIN savingsaccount ON member.savingsaccount_AccountNo = savingsaccount.AccountNo Where member.Prison = '" + prison + "' AND member.NIC = '" + NIC + "' AND member.SecondName = '" + Name + "' AND savingsaccount.AccountNo = '" + accountNo + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                SavingsAccountDetails account = new SavingsAccountDetails();
                account.setEmpNo(set.getInt(1));

                account.setName(set.getString(2) + " " + set.getString(3));
                account.setPrison(set.getString(4));
                account.setRegDate(set.getString(5));
                account.setCurrentBalance(set.getFloat(6));
                account.setAccountNo(set.getString(7));

                accountDetailsArray.add(account);

            }
            return accountDetailsArray;

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

    public boolean checkGurantee(int memeberNo) {
        try {

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT COUNT( LoanNo )FROM loanaccount WHERE member_EmpNo1 ='" + memeberNo + "' OR member_EmpNo2 ='" + memeberNo + "'";
            statement = connection.prepareStatement(query);

            set = statement.executeQuery();
            //System.err.println(count);
            if (set.next()) {
                int count;
                count = set.getInt(1);
                if (count < 2) {
                    System.err.println(count);
                    return true;
                } else {
                    System.out.print(count);
                    return false;
                }

            } else {
                return false;
            }


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
 public ArrayList<ScholorshipDetails> getScholorshipByPrison(String prison) {
        try {

            ArrayList<ScholorshipDetails> scholorshipDetailsArray = new ArrayList<ScholorshipDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT scholorship.ScholorshipNo, scholorship.FirstName, scholorship.LastName, scholorship.School, scholorship.Gender, scholorship.DOB, scholorship.ScholorshipType, scholorship.Amount, scholorship.member_EmpNo, member.FirstName, member.SecondName, member.NIC, member.Prison, member.transferaccountownership_OwnerID, member.savingsaccount_AccountNo FROM scholorship LEFT JOIN member ON member.EmpNo = scholorship.Member_EmpNO WHERE member.Prison = '" + prison + "' AND scholorship.Type = '0' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                ScholorshipDetails scholorship = new ScholorshipDetails();
                scholorship.setScholorshipNo(set.getInt(1));
                scholorship.setFirstName(set.getString(2));
                scholorship.setLastName(set.getString(3));
                scholorship.setSchool(set.getString(4));
                scholorship.setGender(set.getString(5));
                scholorship.setDob(set.getString(6));
                scholorship.setScholorshipType(set.getString(7));
                scholorship.setAmount(set.getFloat(8));
                scholorship.setEmpNo(set.getInt(9));


                scholorship.setEmpFirstName(set.getString(10));
                scholorship.setEmpLastName(set.getString(11));

                scholorship.setNicNo(set.getString(12));
                scholorship.setPrison(set.getString(13));
                scholorship.setOwnerID(set.getInt(14));
                scholorship.setAccountNo(set.getString(15));

                scholorshipDetailsArray.add(scholorship);

            }
            return scholorshipDetailsArray;

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

     public ArrayList<ScholorshipDetails> getScholorshipByEmpNoAndPrison(String EmpNo, String prison) {
        try {
            ArrayList<ScholorshipDetails> scholorshipDetailsArray = new ArrayList<ScholorshipDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT scholorship.ScholorshipNo, member.EmpNo, scholorship.FirstName, scholorship.LastName, member.FirstName, member.SecondName, scholorship.DOB, scholorship.School, scholorship.Gender, scholorship.ScholorshipType, scholorship.Amount,  member.Prison, member.NIC, member.transferaccountownership_OwnerID, member.savingsaccount_AccountNo FROM scholorship LEFT JOIN member ON member.EmpNo = scholorship.member_EmpNO Where member.Prison = '" + prison + "' And member.EmpNo ='" + EmpNo + "' AND scholorship.Type = '0' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                ScholorshipDetails scholorship = new ScholorshipDetails();
                scholorship.setScholorshipNo(set.getInt(1));
                scholorship.setEmpNo(set.getInt(2));
                scholorship.setFirstName(set.getString(3));
                scholorship.setLastName(set.getString(4));
                scholorship.setEmpFirstName(set.getString(5));
                scholorship.setEmpLastName(set.getString(6));
                scholorship.setDob(set.getString(7));
                scholorship.setSchool(set.getString(8));
                scholorship.setGender(set.getString(9));
                scholorship.setScholorshipType(set.getString(10));
                scholorship.setAmount(set.getFloat(11));
                scholorship.setPrison(set.getString(12));
                scholorship.setNicNo(set.getString(13));
                 scholorship.setOwnerID(set.getInt(14));
                scholorship.setAccountNo(set.getString(15));
                scholorshipDetailsArray.add(scholorship);
                
            }
            return scholorshipDetailsArray;

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

   public ArrayList<DeathGrantDetails> getDeathGrantByPrison(String prison) {
        try {
            ArrayList<DeathGrantDetails> deathgrantDetailsArray = new ArrayList<DeathGrantDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT deathgrant.DeathGrantNo,  deathgrant.FirstName, deathgrant.LastName, deathgrant.DOD, deathgrant.Relationship, deathgrant.Gender, deathgrant.DeathCertificateNo, deathgrant.Amount, deathgrant.member_EmpNo, member.FirstName, member.SecondName, member.Prison, member.NIC FROM deathgrant LEFT JOIN member ON member.EmpNo = deathgrant.member_EmpNo Where member.Prison = '" + prison + "'AND deathgrant.Type = '0' AND member.Type = '0'";
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();
            while (set.next()) {
                DeathGrantDetails deathgrant = new DeathGrantDetails();
                deathgrant.setDeathGrantNo(set.getInt(1));
                
                deathgrant.setFirstName(set.getString(2) );
                deathgrant.setLastName(set.getString(3));
                deathgrant.setDod(set.getString(4));
                deathgrant.setRelationship(set.getString(5));
                deathgrant.setGender(set.getString(6));
                deathgrant.setDeathCertificateNo(set.getString(7));
                deathgrant.setAmount(set.getFloat(8));
                deathgrant.setEmpNo(set.getInt(9));
                deathgrant.setEmpFirstName(set.getString(10) );
                deathgrant.setEmpLastName(set.getString(11));
                deathgrant.setPrison(set.getString(12));
                deathgrant.setNicNo(set.getString(13));

                deathgrantDetailsArray.add(deathgrant);
                
            } 
            return deathgrantDetailsArray;
            
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
   public ArrayList<DeathGrantDetails> getDeathGrantByEmpNoAndPrison(String EmpNo,String prison) {
        try {
            ArrayList<DeathGrantDetails> deathgrantDetailsArray = new ArrayList<DeathGrantDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT deathgrant.DeathGrantNo, deathgrant.FirstName, deathgrant.LastName, deathgrant.DOD, deathgrant.Relationship, deathgrant.Gender, deathgrant.DeathCertificateNo, deathgrant.Amount, member.EmpNo, member.FirstName, member.SecondName, member.Prison, member.NIC FROM deathgrant LEFT JOIN member ON member.EmpNo = deathgrant.member_EmpNO Where member.Prison = '" + prison + "' And member.EmpNo ='"+EmpNo+"' AND deathgrant.Type = '0' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                DeathGrantDetails deathgrant = new DeathGrantDetails();
                deathgrant.setDeathGrantNo(set.getInt(1));
                deathgrant.setFirstName(set.getString(2) );
                deathgrant.setLastName(set.getString(3));
                deathgrant.setDod(set.getString(4));
                deathgrant.setRelationship(set.getString(5));
                deathgrant.setGender(set.getString(6));
                deathgrant.setDeathCertificateNo(set.getString(7));
                deathgrant.setAmount(set.getFloat(8));
                deathgrant.setEmpNo(set.getInt(9));
                deathgrant.setEmpFirstName(set.getString(10) );
                deathgrant.setEmpLastName(set.getString(11));
                deathgrant.setPrison(set.getString(12));
                deathgrant.setNicNo(set.getString(13));
 
                deathgrantDetailsArray.add(deathgrant);

            }
            return deathgrantDetailsArray;

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
    public DeathGrantDetails getMemberByDeathGrantNo(int dgNo) {

        try {

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT DeathGrantNo, FirstName, LastName, DOD, Relationship, DeathCertificateNo, Amount, member_EmpNo FROM deathgrant Where DeathGrantNo = '" + dgNo + "' AND deathgrant.Type = '0' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            if (set.next()) {
                DeathGrantDetails member = new DeathGrantDetails();

                member.setDeathGrantNo(set.getInt(1));
                member.setFirstName(set.getString(2));
                member.setLastName(set.getString(3));
                member.setDod(set.getString(4));
                member.setRelationship(set.getString(5));
                member.setDeathCertificateNo(set.getString(6));
                member.setAmount(set.getFloat(7));
                member.setEmpNo(set.getInt(8));

                return member;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.print(e);
            //JOptionPane.showMessageDialog(this, "Member No is not valid");
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
public ArrayList<DeathGrantDetails> getDeathGrantLoanByPrison(String prison) {
        try {
            ArrayList<DeathGrantDetails> deathgrantDetailsArray = new ArrayList<DeathGrantDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT deathgrantloan.DeathGrantLoanNo, deathgrantloan.LoanAmount, deathgrantloan.MonthlyPayment, deathgrantloan.ChequeNo, deathgrantloan.VoucherNo, deathgrantloan.Date, deathgrantloan.deathgrant_DeathGrantNo, deathgrant.FirstName, deathgrant.LastName, deathgrant.DOD, deathgrant.Relationship, deathgrant.Gender, deathgrant.DeathCertificateNo, deathgrant.Amount, deathgrant.member_EmpNo, member.FirstName, member.SecondName, member.Prison, member.NIC FROM deathgrantloan LEFT JOIN  (deathgrant LEFT JOIN member  ON member.EmpNo = deathgrant.member_EmpNo) ON deathgrantloan.deathgrant_member_EmpNo= deathgrant.member_EmpNo Where member.Prison = '" + prison + "' AND deathgrant.Type = '0' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                DeathGrantDetails deathgrant = new DeathGrantDetails();
                deathgrant.setLoanNo(set.getInt(1));
                deathgrant.setLoanAmount(set.getFloat(2));
                deathgrant.setMonthlyPayment(set.getFloat(3));
                deathgrant.setChequeNo(set.getString(4));
                deathgrant.setVoucherNo(set.getString(5));
                deathgrant.setDate(set.getString(6));
                
                deathgrant.setDeathGrantNo(set.getInt(7));
                
                deathgrant.setFirstName(set.getString(8) );
                deathgrant.setLastName(set.getString(9));
                
                deathgrant.setDod(set.getString(10));
                deathgrant.setRelationship(set.getString(11));
                deathgrant.setGender(set.getString(12));
                deathgrant.setDeathCertificateNo(set.getString(13));
                deathgrant.setAmount(set.getFloat(14));
                deathgrant.setEmpNo(set.getInt(15));
                deathgrant.setEmpFirstName(set.getString(16) );
                deathgrant.setEmpLastName(set.getString(17));
                deathgrant.setPrison(set.getString(18));
                deathgrant.setNicNo(set.getString(19));

                deathgrantDetailsArray.add(deathgrant);
                
            } 
            return deathgrantDetailsArray;
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
     
       public ArrayList<DeathGrantDetails> getDeathGrantLoanEmpNoAndByPrison(String EmpNo,String prison) {
        try {
            ArrayList<DeathGrantDetails> deathgrantDetailsArray = new ArrayList<DeathGrantDetails>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT deathgrantloan.DeathGrantLoanNo, deathgrantloan.LoanAmount, deathgrantloan.MonthlyPayment, deathgrantloan.ChequeNo, deathgrantloan.VoucherNo, deathgrantloan.Date, deathgrantloan.deathgrant_DeathGrantNo, deathgrant.FirstName, deathgrant.LastName, deathgrant.DOD, deathgrant.Relationship, deathgrant.Gender, deathgrant.DeathCertificateNo, deathgrant.Amount, deathgrant.member_EmpNo, member.FirstName, member.SecondName, member.Prison, member.NIC FROM deathgrantloan LEFT JOIN  (deathgrant LEFT JOIN member  ON member.EmpNo = deathgrant.member_EmpNo) ON deathgrantloan.deathgrant_member_EmpNo= deathgrant.member_EmpNo Where member.Prison = '" + prison + "' And member.EmpNo='"+EmpNo+"' AND deathgrant.Type = '0' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                DeathGrantDetails deathgrant = new DeathGrantDetails();
                deathgrant.setLoanNo(set.getInt(1));
                deathgrant.setLoanAmount(set.getFloat(2));
                deathgrant.setMonthlyPayment(set.getFloat(3));
                deathgrant.setChequeNo(set.getString(4));
                deathgrant.setVoucherNo(set.getString(5));
                deathgrant.setDate(set.getString(6));
                
                deathgrant.setDeathGrantNo(set.getInt(7));
                
                deathgrant.setFirstName(set.getString(8) );
                deathgrant.setLastName(set.getString(9));
                
                deathgrant.setDod(set.getString(10));
                deathgrant.setRelationship(set.getString(11));
                deathgrant.setGender(set.getString(12));
                deathgrant.setDeathCertificateNo(set.getString(13));
                deathgrant.setAmount(set.getFloat(14));
                deathgrant.setEmpNo(set.getInt(15));
                deathgrant.setEmpFirstName(set.getString(16) );
                deathgrant.setEmpLastName(set.getString(17));
                deathgrant.setPrison(set.getString(18));
                deathgrant.setNicNo(set.getString(19));

                deathgrantDetailsArray.add(deathgrant);
                
            } 
            return deathgrantDetailsArray;
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
       
       public boolean addMember(MemberDetails member) {
        try {
            
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);

            String queryAccount = "INSERT INTO savingsaccount VALUES (?,?)";

            statement = connection.prepareStatement(queryAccount);

            statement.setString(1, member.getAccountNo());
            statement.setBigDecimal(2, member.getCurrentBalance());


            statement.executeUpdate();
            statement.close();

            String queryTransferAccount = "INSERT INTO transferaccountownership(OwnerID, Name, NICnO, Relationship) VALUES (?,?,?,?)";
            //String q = "UPDATE transferaccountownership SET Name = '"+member.getOwnerName()+"', NICnO = '"+member.getNicNo()+"', Relationship = '"+member.getRelationship()+"' WHERE OwnerID = "+ member.getOwnerID();
            statement = connection.prepareStatement(queryTransferAccount,Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, 0);
            statement.setString(2, member.getOwnerName());
            statement.setString(3, member.getOwnerNIC());
            statement.setString(4, member.getRelationship());

            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                member.setOwnerID(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
            statement.close();



            String queryMember = "INSERT INTO member (EmpNo,FirstName,SecondName,NIC,Address, Gender,RegisteredDate,Designation,Prison,PhoneNO,LedgerNo,RetirementDate,transferaccountownership_OwnerID,savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //String qu ="UPDATE member SET EmpNo = '"+member.getEmpno()+"', FirstName = '"+ member.getFirstName()+"', SecondName = '"+member.getLastName()+"', NIC = '"+member.getNicNo()+"', Address = '"+member.getAddress()+"', Gender = '"+member.getGender()+"', RegisteredDate= '"+member.getRegDate()+"', Designation = '"+member.getDesignation()+"', Prison = '"+member.getPrison()+"', PhoneNo = '"+member.getPhoneNo()+"', LedgerNo = '"+member.getLedgerNo()+"', RetirementDate = '"+member.getRetirementDate()+"', transferaccountownership_OwnerID = '"+member.getOwnerID()+"', savingsaccount_AccountNo = '"+member.getAccountNo()+"' WHERE EmpNo = "+member.getEmpno() ;
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
    public boolean updateMember(MemberDetails member) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);

            /*String queryAccount = "INSERT INTO savingsaccount VALUES (?,?)";

            statement = connection.prepareStatement(queryAccount);

            statement.setString(1, member.getAccountNo());
            statement.setBigDecimal(2, member.getCurrentBalance());


            statement.executeUpdate();
            statement.close();*/

//            String queryTransferAccount = "INSERT INTO transferaccountownership(OwnerID, Name, NICnO, Relationship) VALUES (?,?,?,?)";
            String q = "UPDATE transferaccountownership SET Name = '"+member.getOwnerName()+"', NICnO = '"+member.getNicNo()+"', Relationship = '"+member.getRelationship()+"' WHERE OwnerID = "+ member.getOwnerID();
            statement = connection.prepareStatement(q);

            statement.executeUpdate();
            
            statement.close();



           // String queryMember = "INSERT INTO member (EmpNo,FirstName,SecondName,NIC,Address, Gender,RegisteredDate,Designation,Prison,PhoneNO,LedgerNo,RetirementDate,transferaccountownership_OwnerID,savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            String qu ="UPDATE member SET EmpNo = '"+member.getEmpno()+"', FirstName = '"+ member.getFirstName()+"', SecondName = '"+member.getLastName()+"', NIC = '"+member.getNicNo()+"', Address = '"+member.getAddress()+"', Gender = '"+member.getGender()+"', RegisteredDate= '"+member.getRegDate()+"', Designation = '"+member.getDesignation()+"', Prison = '"+member.getPrison()+"', PhoneNo = '"+member.getPhoneNo()+"', LedgerNo = '"+member.getLedgerNo()+"', RetirementDate = '"+member.getRetirementDate()+"', transferaccountownership_OwnerID = '"+member.getOwnerID()+"', savingsaccount_AccountNo = '"+member.getAccountNo()+"' WHERE EmpNo = "+member.getEmpno() ;
            statement = connection.prepareStatement(qu);

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

     public ArrayList<LoanAccountDetails> getLoanAccountByName(String Name,String prisonName) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "'AND m.SecondName = '" + Name + "' AND l.Type = '0' AND m.Type = '0'" ;
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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
      public ArrayList<LoanAccountDetails>getLoanAccountByNIC(String NIC,String prisonName) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "'AND m.NIC = '" + NIC + "' AND l.Type = '0' AND m.Type = '0'" ;
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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
       public ArrayList<LoanAccountDetails>getLoanAccountByAccountNo(String applicationNO,String prisonName) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "'AND l.ApplicationNO='"+applicationNO+"' AND l.Type = '0' AND m.Type = '0'" ;
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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
             public ArrayList<LoanAccountDetails>getLoanAccountByApplicationNoAndName(String applicationNO,String prisonName,String Name) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "' AND l.ApplicationNO='"+applicationNO+"' And m.SecondName='"+Name+"' AND l.Type = '0' AND m.Type = '0'"; 
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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
     
       public ArrayList<LoanAccountDetails>getLoanAccountByNICAndName(String NIC,String prisonName,String Name) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "'AND m.NIC='"+NIC+"'And m.SecondName='"+Name+"' AND l.Type = '0' AND m.Type = '0'"; 
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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
      public ArrayList<LoanAccountDetails>getLoanAccountByApplicationNoAndNIC(String applicationNo,String prisonName,String NIC) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "'AND l.ApplicationNo='"+applicationNo+"'And m.NIC='"+NIC+"' AND l.Type = '0' AND m.Type = '0'"; 
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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
    public ArrayList<LoanAccountDetails>getAccountByApplicationNoAndNICAndName(String applicationNo,String prisonName,String NIC,String Name) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "'AND l.ApplicationNo='"+applicationNo+"'And m.NIC='"+NIC+"'And m.SecondName='"+Name+"' AND loanaccount.Type = '0' AND m.Type = '0'"; 
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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

    public ArrayList<LoanAccountDetails> getLoanAccountByPrison(String prisonName) {
        try {

            ArrayList<LoanAccountDetails> loanDetails = new ArrayList<LoanAccountDetails>();
            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT LoanNo, ApplicationNo, LoanAmount, MonthlyPayment, Interest, ChequeNo, VoucherNo, Date, Duration, Balance, member_EmpNo, m.LedgerNo, m.NIC, m.FirstName, m.SecondName, m.Address, m.Designation, m.RegisteredDate, m.Prison, m2.EmpNo, m2.FirstName, m2.SecondName, m2.Prison, m2.Designation, m2.RegisteredDate, m3.EmpNo, m3.FirstName, m3.SecondName, m3.Prison, m3.Designation, m3.RegisteredDate "
                    + "FROM loanaccount l "
                    + "LEFT JOIN member m ON member_EmpNo = m.EmpNo "
                    + "LEFT JOIN member m2 ON member_EmpNo1 = m2.EmpNo "
                    + "LEFT JOIN member m3 ON member_EmpNo2 = m3.EmpNo "
                    + "WHERE m.Prison = '" + prisonName + "'AND l.Type = '0' AND m.Type = '0'";
                    
            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                LoanAccountDetails loan = new LoanAccountDetails();
                
                loan.setLoanNo(set.getInt(1));
                loan.setApplicationNo(set.getInt(2));
                loan.setLoanAmount(set.getFloat(3));
                loan.setMonthlyPayment(set.getFloat(4));
                loan.setInterest(set.getFloat(5));
                loan.setChequeNo(set.getInt(6));
                loan.setVoucherNo(set.getInt(7));
                loan.setDate(set.getString(8));
                loan.setDuration(set.getInt(9));
                loan.setBalance(set.getFloat(10));
                
                loan.setMemberID(set.getInt(11));
                loan.setAccountNo(set.getString(12));
                loan.setNIC(set.getString(13));
                loan.setMemberName(set.getString(14)+ " " +set.getString(15));
                loan.setAdress(set.getString(16));
                loan.setDesignation(set.getString(17));
                loan.setRegDate(set.getString(18));
                loan.setPrison(set.getString(19));
                
                loan.setGurantee1No(set.getInt(20));
                loan.setGurantee1Name(set.getString(21) + " " +set.getString(22));
                loan.setGurantee1Prison(set.getString(23));
                loan.setGurantee1Designation(set.getString(24));
                loan.setGurantee1RetirementDate(set.getString(25));
                
                loan.setGurantee2No(set.getInt(26));
                loan.setGurantee2Name(set.getString(27) + " " +set.getString(28));
                loan.setGurantee2Prison(set.getString(29));
                loan.setGurantee2Designation(set.getString(30));
                loan.setGurantee2RetirementDate(set.getString(31));
                
                loanDetails.add(loan);
            }
            return loanDetails;

        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }finally {
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
    
    public ArrayList<TransactionDetail> getMemberByPrisonForTransactions(String prisonName) {

        try {
            ArrayList<TransactionDetail> memberDetails = new ArrayList<TransactionDetail>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT EmpNo,FirstName,SecondName,LedgerNo FROM member Where member.Prison = '" + prisonName + "' AND member.Type = '0'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                TransactionDetail member = new TransactionDetail();

                member.setEmpId(set.getInt(1));
                member.setName(set.getString(2)+" "+set.getString(3));
                member.setLedgerNo(set.getString(4));

                memberDetails.add(member);

            }
            return memberDetails;

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

    public ArrayList<TransactionDetail> getTransactions(String AccountNo) {
        try {
            ArrayList<TransactionDetail> memberDetails = new ArrayList<TransactionDetail>();

            connection = DriverManager.getConnection(url, userName, passWord);
            String query = "SELECT * FROM monthendtransactions m Where m.member_savingsaccount_AccountNo = '" + AccountNo + "'";

            statement = connection.prepareStatement(query);
            set = statement.executeQuery();

            while (set.next()) {
                TransactionDetail member = new TransactionDetail();

                member.setTranID(set.getInt(1));
                member.setYear(set.getInt(2));
                member.setMonth(set.getInt(3));
                member.setFixedDeposit(set.getFloat(4));
                member.setScholorship(set.getFloat(5));
                member.setRegFee(set.getFloat(6));
                member.setLoan(set.getFloat(7));
                member.setDeathGrant(set.getFloat(8));
                member.setDeathGrantLoan(set.getFloat(9));
                member.setTotal(set.getFloat(10));
                member.setEmpId(set.getInt(11));
                
                
                

                memberDetails.add(member);

            }
            return memberDetails;

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
    
    
     
       public boolean  deleteMemFi(MemberDetails mem) {
        try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            String query = "DELETE  FROM member ";
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

     
     
     
     
     public boolean addTran(TransactionDetails tr) {
         
        try {
           
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            
            /*String queryAccount = "INSERT INTO savingsaccounttransaction(savingsaccount_AccountNo) VALUES (?)";
           
            statement = connection.prepareStatement(queryAccount);
            
            statement.setString(1, tr.getAccountNo());            
            //statement.setFloat(2, tr.getBalance());
            
            statement.executeUpdate();
            statement.close();*/
            
            String querysavingacctran = "INSERT INTO monthendtransactions VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(querysavingacctran, Statement.RETURN_GENERATED_KEYS);
           
            statement.setInt(1, tr.getTranID());
            statement.setInt(2, tr.getYear());
            statement.setInt(3, tr.getMonth());
            statement.setFloat(4, tr.getDeposite());
            statement.setFloat(5, tr.getScholorship());
            statement.setFloat(6, tr.getRegisterFee());
            statement.setFloat(7, tr.getLoan());
            statement.setFloat(8, tr.getDeathgrant());
            statement.setFloat(9, tr.getDeathgrantloan());
            statement.setFloat(10, tr.getTotal());
            statement.setInt(11, tr.getUser_UserNo());
            statement.setInt(12, tr.getEmpNo());
            //System.out.println(tr.getAccountNo());
            statement.setString(13, tr.getAccountNo());
                   
            
            statement.executeUpdate();
            statement.close();    
            
            
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
     
      public boolean NewLoan(LoanAccountDetails ld) {
         
        try {
           
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            
            String q = "INSERT INTO loanaccount(LoanNo,ApplicationNo,LoanAmount,MonthlyPayment,Interest,ChequeNo,VoucherNo,Date,Duration,Balance,member_EmpNo,member_transferaccountownership_OwnerID,member_savingsaccount_AccountNo,member_EmpNo1,member_transferaccountownership_OwnerID1,member_savingsaccount_AccountNo1,member_EmpNo2,member_transferaccountownership_OwnerID2,member_savingsaccount_AccountNo2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, ld.getLoanNo());
            statement.setInt(2,ld.getApplicationNo());
            statement.setDouble(3, ld.getLoanAmount());
            statement.setDouble(4,ld.getMonthlyPayment());
            statement.setFloat(5,ld.getInterest());
            statement.setInt(6,ld.getChequeNo());
            statement.setInt(7,ld.getVoucherNo());
            statement.setString(8,ld.getDate());
            statement.setInt(9,ld.getDuration());
            statement.setDouble(10,ld.getBalance());
            
            statement.setInt(11,ld.getEmpNo1());
            statement.setInt(12,ld.getOwnerId1());
            statement.setString(13,ld.getSavingAccount1());
            
            statement.setInt(14,ld.getEmpNo2());
            statement.setInt(15,ld.getOwnerId2());
            statement.setString(16,ld.getSavingAccount2());
            
            statement.setInt(17,ld.getEmpNo3());
            statement.setInt(18,ld.getOwnerId3());
            statement.setString(19,ld.getSavingAccount3());
            
            
            
            statement.executeUpdate();
            statement.close();
            
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
        
        
          public boolean addScol(ScholorshipDetails sd) {
            try {
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);            
            
            String queryScholorship = "INSERT INTO Scholorship (ScholorshipNo,FirstName,LastName,School,Gender,DOB,ScholorshipType, Amount, member_EmpNo, member_transferaccountownership_OwnerID, member_savingsaccount_AccountNo) VALUES (?,?,?,?,?,?,?,?,?,?,?)";//,loanaccount_LoanNo,loanaccount_member_EmpNo,loanaccount_member_transferaccountownership_OwnerID,loanaccount_member_savingsaccount_AccountNo,loanaccount_LoanNo1,loanaccount_member_EmpNo1,loanaccount_member_transferaccountownership_OwnerID1,loanaccount_member_savingsaccount_AccountNo1)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            statement = connection.prepareStatement(queryScholorship);


            statement.setInt(1, sd.getScholorshipNo());
            statement.setString(2, sd.getFirstName());
            statement.setString(3, sd.getLastName());
            statement.setString(4, sd.getSchool());
            statement.setString(5, sd.getGender());
            statement.setString(6, sd.getDob());
            statement.setString(7, sd.getScholorshipType());
            statement.setFloat(8, sd.getAmount());
            statement.setInt(9, sd.getEmpNo());
            statement.setInt(10, sd.getMember_transferaccountownership_OwnerID());
            statement.setString(11, sd.getAccountNo());
            

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
          
           public boolean  deleteScolFi(ScholorshipDetails scol) {
            try {
                connection = (Connection) DriverManager.getConnection(url, userName, passWord);
                String query = "DELETE  FROM scholorship";
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
          
          public boolean    addDeathGrant (DeathGrantDetails death) {
         
        try {
           
            connection = (Connection) DriverManager.getConnection(url, userName, passWord);
            
            String queryAccount = "INSERT INTO deathgrantloan VALUES (?,?,?,?,?,?,?,?,?,?,?)";
           
            statement = connection.prepareStatement(queryAccount);
            
            statement.setInt(1, death.getLoanNo());            
            statement.setFloat(2, death.getAmount());
            statement.setFloat(3, death.getMonthlyPayment());
            statement.setString(4, death.getChequeNo());
            statement.setString(5, death.getVoucherNo());
            statement.setString(6, death.getDate());
            statement.setInt(7, death.getDeathGrantNo());
            statement.setInt(8, death.getEmpNo());
            statement.setInt(9, death.getOwnerId());
            statement.setString(10, death.getAccountNo());
            
            
            statement.executeUpdate();
            statement.close();
            
            String queryTransferAccount = "INSERT INTO deathgrant VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(queryTransferAccount, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, death.getLoanNo());
            statement.setString(2, death.getFirstName());
            statement.setString(3, death.getLastName());
            statement.setString(4, death.getRelationship());
            statement.setString(5, death.getGender());
            statement.setString(6, death.getDeathCertificateNo());
            statement.setFloat(7, death.getAmount());
            statement.setInt(8, death.getEmpNo());
            statement.setInt(9, death.getOwnerId());
            statement.setString(10, death.getAccountNo());


            statement.executeUpdate();
            
            statement.close();
             

           
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
        }}

          
       public boolean updateScholorship(ScholorshipDetails scholorship) {
           try {
               connection = (Connection) DriverManager.getConnection(url, userName, passWord);
               String q = "UPDATE scholorship SET ScholorshipNo = '" + scholorship.getScholorshipNo()+ "', FirstName = '" + scholorship.getFirstName()+"',LastName='"+scholorship.getLastName()+ "', School='"+scholorship.getSchool()+"',Gender = '" + scholorship.getGender()+ "', DOB = '" + scholorship.getDob() + "', ScholorshipType = '" + scholorship.getScholorshipType() + "', Amount = '" + scholorship.getAmount() + "' WHERE ScholorshipNo = " + scholorship.getScholorshipNo();
               statement = (PreparedStatement) connection.prepareStatement(q);
               statement.executeUpdate();
               return true;
               } catch (Exception e) {
                   System.out.print(e);
                   return false;
               } finally {
                    try {
                        if (statement != null) {
                            statement.close();
                        }
                        if (statement != null) {
                           statement.close();
                           }
                   
                        }catch (Exception e) {}
    }

}

    }


          

        
    
       



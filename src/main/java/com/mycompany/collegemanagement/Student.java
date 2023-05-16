/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.collegemanagement;

import static com.mycompany.collegemanagement.connection.con;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author niyati
 */

public class Student {
    private static String ID = null;
    private static String FirstName = null;
    private static String LastName = null;
    private static String MiddleName = null;
    private static String FullName = null;
    private static String Branch = null;
    private static String BranchID = null;
    private static int Semester = -1;
    private static String Email = "";
    private static String ContactNumber = null;
    private static double CPI = -1;
    private static double SPI = -1;
    private static String MentorID = null;
    private static String Mentor = null;

    public Student(){
//    	System.out.println("I am called");
    	
        //</editor-fold>
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(connection.checkconnection())
					{
						System.out.println("connected");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Start the Database Server first","Error",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
    public static String getID(){
        return ID;
    }

    /**
     * @param aID the ID to set
     */
    public static void setID(String aID) {
        ID = aID;
    }

    /**
     * @return the FirstName
     */
    public static String getFirstName() {
        return FirstName;
    }

    /**
     * @param aFirstName the FirstName to set
     */
    public static void setFirstName(String aFirstName) {
        FirstName = aFirstName;
        FullName = FirstName;
    }

    /**
     * @return the LastName
     */
    public static String getLastName() {
        return LastName;
    }

    /**
     * @param aLastName the LastName to set
     */
    public static void setLastName(String aLastName) {
        LastName = aLastName;
        
        if(FirstName !=null){
            FullName = FirstName;
        }
        if(MiddleName !=null){
            FullName += " "+ MiddleName;
        }
        FullName += " "+LastName;
    }

    /**
     * @return the MiddleName
     */
    public static String getMiddleName() {
        return MiddleName;
    }

    /**
     * @param aMiddleName the MiddleName to set
     */
    public static void setMiddleName(String aMiddleName) {
        if(FirstName !=null){
            FullName = FirstName;
        }
        MiddleName = aMiddleName;
        FullName += " "+ MiddleName;
    }

    /**
     * @return the FullName
     */
    public static String getFullName() {
        return FullName;
    }

    /**
     * @param aFullName the FullName to set
     */

    /**
     * @return the Branch
     */
    public static String getBranch() {
        return Branch;
    }

    /**
     * @param aBranch the Branch to set
     */
    

    /**
     * @return the BranchID
     */
    public static String getBranchID() {
        return BranchID;
    }

    /**
     * @param aBranchID the BranchID to set
     */
    public static void setBranchID(String aBranchID) {
        BranchID = aBranchID;
    }

    /**
     * @return the Semester
     */
    public static int getSemester() {
        return Semester;
    }

    /**
     * @param aSemester the Semester to set
     */
    public static void setSemester(int aSemester) {
        Semester = aSemester;
    }

    /**
     * @return the Email
     */
    public static String getEmail() {
        return Email;
    }

    /**
     * @param aEmail the Email to set
     */
    public static void setEmail(String aEmail) {
        Email = aEmail;
    }

    /**
     * @return the ContactNumber
     */
    public static String getContactNumber() {
        return ContactNumber;
    }

    /**
     * @param aContactNumber the ContactNumber to set
     */
    public static void setContactNumber(String aContactNumber) {
        ContactNumber = aContactNumber;
    }

    /**
     * @return the CPI
     */
    public static double getCPI() {
        return CPI;
    }

    /**
     * @param aCPI the CPI to set
     */
    public static void setCPI(double aCPI) {
        CPI = aCPI;
    }

    /**
     * @return the SPI
     */
    public static double getSPI() {
        return SPI;
    }

    /**
     * @param aSPI the SPI to set
     */
    public static void setSPI(double aSPI) {
        SPI = aSPI;
    }

    /**
     * @return the MentorID
     */
    public static String getMentorID() {
        return MentorID;
    }

    /**
     * @param aMentorID the MentorID to set
     */
    public static void setMentorID(String aMentorID) {
        MentorID = aMentorID;
    }
    
    public static String verifyMID(String mid){
        try{
            Statement s = con.createStatement();
            String q = "select mentor from mentors where mentorid = '"+mid+"'";
            ResultSet rs = s.executeQuery(q);
            if(rs.next()){
                Mentor = rs.getString(1);
                return null;
            }else{
                return "no mentor found";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static boolean verifyID(){
        try{
            Statement s = con.createStatement();
            String q = "select * from students where id = '"+ID+"'";
            if(s.execute(q)){
                return true;
            }else return false;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static String verifyBID(String bid){
        try{
            Statement s = con.createStatement();
            String q = "select BRANCH from BRANCHES where branchid = '"+bid+"'";
            ResultSet rs = s.executeQuery(q);
            if(rs.next()){
                Branch = rs.getString(1);
                return null;
            }else{
                return "no branch found";
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static String getMentor() {
        return Mentor;
    }
    
    
    public static String verify(){
        if(ID == null) return "ID cannot be empty";
        if(FirstName == null) return "FirstName cannot be empty";
        if(LastName == null) return "LastName cannot be LastName";
        if(BranchID == null) return "Branch ID cannot be empty";
        if(Semester == -1) return "Semester cannot be empty";
        if(ContactNumber == null) return "Contact Number cannot be empty";
        
        return null;
        
    }
    public static boolean insert(){
        try{
            Statement stmt = con.createStatement();
            String Query = "delete from students where id = '"+ID+"';";
            stmt.execute(Query);
            
            Query = "insert into Students(ID, FirstName, LastName, BranchID, Semester, ContactNumber) values('"+ID+"','"+FirstName+"','"+LastName+"','"+BranchID+"','"+Semester+"','"+ContactNumber+"');";
            stmt.executeUpdate(Query);
            if(MiddleName !=null){
                stmt.executeUpdate("update students set middlename = '"+MiddleName+"' where ID = '"+ID+"';");
            }
            if(Email !=null){
                stmt.executeUpdate("update students set email = '"+Email+"' where ID = '"+ID+"';");
            }
            if(CPI !=-1){
                stmt.executeUpdate("update students set cpi = '"+CPI+"' where ID = '"+ID+"';");
            }
            if(SPI !=-1){
                stmt.executeUpdate("update students set SPI = '"+SPI+"' where ID = '"+ID+"';");
            }
            if(MentorID !=null){
                stmt.executeUpdate("update students set mentorid = '"+MentorID+"' where ID = '"+ID+"';");
            }
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;    
    }
    public static boolean delete(){
        try{
            String Query = "delete from Students where id = '"+ID+"';";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(Query);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static boolean fetch(){
        try{
            String Query = "select * from Students where id = '"+ID+"';";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Query);
            if(rs.next()){
                ID = rs.getString(1);
                FirstName = rs.getString(2);
                LastName = rs.getString(4);
                BranchID = rs.getString(5);
                Semester = rs.getInt(6);
                ContactNumber = rs.getString(8);

                MiddleName = rs.getString(3);
                if(rs.wasNull()){
                	FullName = FirstName + " "+LastName;
                    MiddleName = null;
                }else {
                	FullName = FirstName + " "+MiddleName+" "+LastName;
                }
                Email = rs.getString(7);
                if(rs.wasNull()){
                    Email = null;
                }
                CPI = rs.getDouble(9);
                if(rs.wasNull()){
                    CPI = -1;
                }
                SPI = rs.getDouble(10);
                if(rs.wasNull()){
                    SPI = -1;
                }
                MentorID = rs.getString(11);
                if(rs.wasNull()){
                    MentorID = null;
                }
                verifyMID(MentorID);
                verifyBID(BranchID);
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
            public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//            	System.out.print("I am called");
            	try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(InsertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(InsertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(InsertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(InsertPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
        /* Create and display the form */
        
        /* Create and display the form */
        
    }
}

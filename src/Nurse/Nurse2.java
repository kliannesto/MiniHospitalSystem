 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nurse;

import static Login.MyConnection.getConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kli ann
 */
public class Nurse2 {
    
    private int Id;
    private String fname;
    private String lname;
    private String sex;
    private String bdate;
    private String address;
    private String phone;
    private String status;
    private String email;
    private String contract;
    private String date;
    private byte[] picture;
    
    static Connection con;
    static String url = "jdbc:mysql://localhost/Hospital";
    static String driver = "com.mysql.jdbc.Driver";
    
    public Nurse2(){
        
    }
    public Nurse2( int id,String fname,String lname, String sex, byte [] pimg, String bdate, String address, String phone,String status,
                        String email,String contract, String date) {
        this.fname = fname;
        this.lname = lname;
        this.sex = sex;
        this.picture = pimg;
        this.bdate = bdate;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.email = email;
        this.contract = contract;
        this.date = date;
        this.Id = id;
    }
    
    public int getId(){
        return Id;
    }
    public String getFname(){
        return fname;
    }
    public String getLname(){
        return lname;
    }
    public String getSex(){
        return sex;
    }
    public String getBdate(){
        return bdate;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public String getStatus(){
        return status;
    }
    public String getEmail(){
        return email;
    }
    public String getContract(){
        return contract;
    }
    public String getDate(){
        return date;
    }
    public byte[] getMyImage(){
        return picture;
    }
    
    
    
    public boolean addNew(){
        try{
            String sql = "INSERT INTO nurse (FName,LName,Sex,Bdate,Address,Phone,Status,Email,ContractNo,DEmployed)values('"+this.fname+"','"+ this.lname +"',"
                    + "'"+this.sex+"','"+this.bdate+"','"+this.address+"','"+this.phone+"','"+this.status+"','"+this.email+"','"+this.contract+"','"+date+"')";
            Class.forName(driver);
            con =  DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            return true;
        }catch(Exception e){
            System.out.println("Can not add to database...." + e);
        }
        return false;
    }
    
    public boolean updateInfo(String fname, String lname, String sex, String bdate, String address, String phone,String status,
                        String email,String contract,String date){
        try{
            String sql = "UPDATE nurse SET "
                    + "Fname='"+ fname +"',"
                    + "Lname='"+ lname +"',"
                    + "Sex='"+ sex +"',"
                    + "Bdate='"+ bdate +"',"
                    + "Address='"+ address +"', "
                    + "Phone='"+ phone +"',"
                    + "Status='"+ status +"',"
                    + "Email='"+ email + "',"
                    + "ContractNo='"+ contract + "',"
                    + "DEmployed='"+ date +"'"
                    + "WHERE Fname='"+ fname +"'";
            Class.forName(driver);
            con =  DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            return true;
        }catch(Exception e){
            System.out.println("Unable to update record...." + e);
        }
        return false;
    }
    
    public boolean deleteRecord(String id ){
        try{
            String sql = "DELETE FROM nurse WHERE NurseID='"+id +"' ";
            Class.forName(driver);
            con =  DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            return true;
        }catch(Exception e){
            System.out.println("Can not delete from database...." + e);
        }
        
        return false;
    }
    
    public ResultSet getInfo(String id) {
        Statement statement;
        try{
            String sql = "SELECT * FROM nurse WHERE NurseID='"+id+"'";
            Class.forName(driver);
           con =  DriverManager.getConnection(url, "root", "");
            statement = con.createStatement();
            ResultSet res = statement.executeQuery(sql);
            return res;
        }catch(Exception e){
            System.out.println("Customer not found...." + e);
        }
       return null;
    }
    
    //method for displaying all nurses records on jtable
        public ResultSet getAll() {
        Statement statement;
        try{
            String sql = "SELECT * FROM nurse ORDER BY NurseID ASC";
            Class.forName(driver);
           con =  DriverManager.getConnection(url, "root", "");
            statement = con.createStatement();
            ResultSet res = statement.executeQuery(sql);
            return res;
        }catch(Exception e){
            System.out.println("Receptionist not found...." + e);
        }
       return null;
    }
        
 
}

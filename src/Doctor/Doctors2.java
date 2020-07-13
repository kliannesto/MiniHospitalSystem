/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kli ann
 */
public class Doctors2 {
    
    private String fname;
    private String lname;
    private String sex;
    private String bdate;
    private String username;
    private String password;
    private String contract;
    private String status;
    private String email;
    private String phone;
    private String address;
    private byte[] picture;
    
    static Connection con;
    static String url = "jdbc:mysql://localhost/Hospital";
    static String driver = "com.mysql.jdbc.Driver";
    
    public Doctors2(){
        
    }
    public Doctors2( String fname,String lname, String sex, String bdate,String username,String password,String contract,
                        String status,String email, String phone,byte [] pimg, String address) {
        this.fname = fname;
        this.lname = lname;
        this.sex = sex;
        this.bdate = bdate;
        this.username = username;
        this.password = password;
        this.contract = contract;
        this.status = status;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.picture = pimg;
    }
        public byte[] getImage(){
        return picture;
    }
        
    public boolean addNew(){
        try{
            String sql = "INSERT INTO registration (PatientId,FullName,Gender,Age,Phone,Address,Disease,StatusOfDisease,CheckIn,RoomType,RoomNo,Building)values('"+this.fname+"','"+ this.lname +"',"
                    + "'"+this.sex+"','"+this.bdate+"','"+this.phone+"','"+this.address+"','"+this.email+"','"+this.status+"','"+this.password+"','"+this.username+"','"+this.contract+"')";
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
    
        
        public ResultSet getInfo(String id) {
        Statement statement;
        try{
            String sql = "SELECT * FROM doc_registration WHERE u_id='"+id+"'";
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
        
        //method for displaying all doctors records on jtable
        public ResultSet getAll() {
        Statement statement;
        try{
            String sql = "SELECT * FROM doc_registration ORDER BY u_id ASC";
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
        
        public boolean deleteRecord(String id ){
        try{
            String sql = "DELETE FROM doc_registration WHERE u_id='"+id +"' ";
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
        
        public boolean updateInfo(String fname,String lname, String sex, String bdate,String username,String password, String address, String phone,String status,
                        String email,String contract,String date){
        try{
            String sql = "UPDATE doc_registration SET "
                    + "u_fname='"+ fname +"',"
                    + "u_lname='"+ lname +"',"
                    + "u_sex='"+ sex +"',"
                    + "u_bdate='"+ bdate +"',"
                    + "u_username='"+ username +"',"
                    + "u_pass='"+ password +"',"
                    + "u_contract='"+ contract + "',"
                    + "u_status='"+ status +"',"
                    + "u_email='"+ email + "',"
                    + "u_phone='"+ phone +"',"
                    + "u_address='"+ address +"', "
                    + "u_dregistered='"+ date +"'"
                    + "WHERE u_fname='"+ fname +"'";
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
}

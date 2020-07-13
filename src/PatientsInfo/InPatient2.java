package PatientsInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OWNER
 */
public class InPatient2 {
    private String name;
    private String gender;
    private String age;
    private String phone;
    private String address;
    private String disease;
    private String status;
    private String checkin;
    private String roomt;
    private String roomn;
    private String building;    
    
    
    static Connection con;
    static String url = "jdbc:mysql://localhost/Hospital";
    static String driver = "com.mysql.jdbc.Driver";
    
    public InPatient2(){
        
    }
    public InPatient2( String name, String gender, String age, String phone, String address, String disease,
                        String status, String checkin, String roomt, String roomn, String building) {
        
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.disease = disease;
        this.status = status;
        this.checkin = checkin;
        this.roomn = roomt;
        this.roomt = roomn;
        this.building = building;
    }

    @Override
    public String toString() {
        return "PatientsRegistration{" + "name=" + name + ", gender=" + gender + ", age=" + age + ", phone=" + phone + 
                ", address=" + address + ", disease=" + disease + ", status=" + status + ", checkin=" + checkin + ", roomt="
                + roomt + ", roomn=" + roomn + ", building=" + building + '}';
    }
    
    public boolean addNew(){
        try{
            String sql = "INSERT INTO registration (FullName,Gender,Age,Phone,Address,Disease,StatusOfDisease,CheckIn,RoomType,RoomNo,Building)values('"+ this.name +"',"
                    + "'"+this.gender+"','"+this.age+"','"+this.phone+"','"+this.address+"','"+this.disease+"','"+this.status+"','"+this.checkin+"','"+this.roomt+"','"+this.roomn+"','"+building+"')";
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
      
    public boolean deleteRecord(String id ){
        try{
            String sql = "DELETE FROM registration WHERE PatientId='"+id +"' ";
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
 
    //----
    public boolean updateInfo(String id, String name, String gender, String age, String phone, String address, String disease, String status, String checkin, String roomt, String roomn, String building){
        try{
            String sql = "UPDATE registration SET "
                    + "PatientId='"+ id+"',"
                    + "FullName='"+ name +"',"
                    + "Gender='"+ gender+"',"
                    + "Age='"+ age+"',"
                    + "Phone='"+ phone+"',"
                    + "Address='"+ address +"', "
                    + "Disease='"+ disease +"',"
                    + "StatusOfDisease='"+ status +"',"
                    + "CheckIn='"+ checkin+"',"
                    + "RoomType='"+ roomt+"',"
                    + "RoomNo='"+ roomn+ "',"
                    + "Building='"+ building +"'"
                    + "WHERE FullName='"+ name +"'";
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
    
    
    public ResultSet getInfo(String id) {
        Statement statement;
        try{
            String sql = "SELECT * FROM registration WHERE PatientId='"+id+"'";
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
    
    //method for displaying all patients records on jtable
    public ResultSet getAll() {
        Statement statement;
        try{
            String sql = "SELECT * FROM registration ORDER BY PatientId ASC";
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
    
    //method for displaying all patients vital signs on jtable
    public ResultSet getVital() {
        Statement statement;
        try{
            String sql = "SELECT * FROM clinical ORDER BY FullName ASC";
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
    
    public ResultSet getVital2(String id) {
        Statement statement;
        try{
            String sql = "SELECT * FROM clinical WHERE PatientId='"+id+"'";
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
    
    public boolean deleteVital(String id ){
        try{
            String sql = "DELETE FROM clinical WHERE PatientId='"+id +"' ";
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientsInfo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kli ann
 */
public class Clinical2 {
    private String id;
    private String height;
    private String name;
    private String weight;
    private String bp;
    private String temperature;
    private String complaint;
    private String physician;
    private String presentillness;
    private String physical;

    
    static Connection con;
    static String url = "jdbc:mysql://localhost/Hospital";
    static String driver = "com.mysql.jdbc.Driver";
    
    public Clinical2(){
        
    }
    public Clinical2(String id,String name,String height, String weight, String bp, String temperature, String complaint,String physician, String presentillness, String physical) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.bp = bp;
        this.temperature = temperature;
        this.complaint = complaint;
        this.physician = physician;
        this.presentillness = presentillness;
        this.physical = physical;

    }
   /* @Override
    public String toString() {
        return "PatientsRegistration{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", phone=" + phone + 
                ", address=" + address + ", disease=" + disease + ", status=" + status + ", checkin=" + checkin + ", roomt="
                + roomt + ", roomn=" + roomn + ", building=" + building + '}';
    }*/
        public boolean addNew(){
        try{
            String sql = "INSERT INTO clinical(PatientId,FullName,Height,Weight,BP,Temperature,Complaint,Physician,PresentIllness,PhysicalAppearance)values('"+this.id+"','"+ this.name +"','"+ this.height +"','"+ this.weight +"','"+this.bp+"','"+this.temperature+"','"+this.complaint+"','"+ this.physician +"','"+this.presentillness+"','"+physical+"')";
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
        
 
        public boolean updateInfo(String id, String name, String height, String weight, String bp, String temperature, String complaint, String physician, String presentillness, String physical){
        try{
            String sql = "UPDATE clinical SET "
                    + "PatientId='"+ id+"',"
                    + "FullName='"+ name +"',"
                    + "Height='"+ height+"',"
                    + "Weight='"+ weight+"',"
                    + "BP='"+ bp+"',"
                    + "Temperature='"+ temperature +"', "
                    + "Complaint='"+ complaint +"',"
                    + "Physician='"+ physician +"',"
                    + "PresentIllness='"+ presentillness+"',"
                    + "PhysicalAppearance='"+ physical+"'"
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
        

        
        public boolean deleteRecord(String id ){
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
      
    public ResultSet getInfo(String id) {
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
        
        public ResultSet getAll() {
        Statement statement;
        try{
            String sql = "SELECT * FROM clinical";
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
}



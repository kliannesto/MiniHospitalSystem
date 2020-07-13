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
public class Appointments2 {
    
    private String appid;
    private String id;
    private String name;
    private String date;
    private String time;
    private String doctor;
    private String visitn;   
    static Connection con;
    static String url = "jdbc:mysql://localhost/Hospital";
    static String driver = "com.mysql.jdbc.Driver";
    
    public Appointments2(){
        
    }    
    
    public Appointments2(String appid,String id, String name, String date, String time, String doctor, String visitn) {
        this.appid = appid;
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.visitn = visitn;
    }
    
        public boolean addNew(){
        try{
            String sql = "INSERT INTO appointments (AppointmentID,PatientId,FullName,Date,Time,Doctor,VisitNature)values('"+this.appid+"','"+ this.id +"','"+ this.name +"',"
                    + "'"+this.date+"','"+this.time+"','"+this.doctor+"','"+visitn+"')";
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

        
        public ResultSet getAll() {
        Statement statement;
        try{
            String sql = "SELECT * FROM appointments ORDER BY FullName ASC";
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

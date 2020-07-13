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
public class Prescription2 {
    private String id;
    private String name;
    private String age;
    private String sex;
    private String address;
    private String illness;
    private String medicine;
    private String dosage;
    private String dailydose;
    private String dosandadmins;
    private String storage;
    private String precautions;
    private String physician;
    private String date; 
    private String time; 
    static Connection con;
    static String url = "jdbc:mysql://localhost/Hospital";
    static String driver = "com.mysql.jdbc.Driver";
    
    public Prescription2(){
        
    }
    public Prescription2(String id, String name, String age, String sex, String address, String illness, String medicine,
                        String dosage, String dailydose, String dosandadmins, String storage, String precautions,
                        String physician, String date,String time) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.illness = illness;
        this.medicine = medicine;
        this.dosage = dosage;
        this.dailydose = dailydose;
        this.dosandadmins = dosandadmins;
        this.storage = storage;
        this.precautions = precautions;
        this.physician = physician;
        this.date = date;
        this.time = time;

    }
    
    public boolean addNew(){
        try{
            String sql = "INSERT INTO prescription (PatientId,FullName,Age,Sex,Address,Illness,Medicine,Dosage,DailyDose,DoseandAdmins,Storage,Precautions,Physician,Date,Time)values('"+this.id+"','"+ this.name +"',"
                    + "'"+this.age+"','"+this.sex+"','"+this.address+"','"+this.illness+"','"+this.medicine+"','"+this.dosage+"','"+this.dailydose+"','"+this.dosandadmins+"',"
                    + "'"+this.storage+"','"+this.precautions+"','"+this.physician+"','"+this.date+"','"+time+"')";
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
    
    //method for displaying all prescriptions records on jtable
    public ResultSet getAll() {
        Statement statement;
        try{
            String sql = "SELECT * FROM prescription ORDER BY FullName ASC";
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

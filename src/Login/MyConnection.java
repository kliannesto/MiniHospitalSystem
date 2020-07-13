/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Nurse.Nurse2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kli ann
 */
public class MyConnection {
    
    public static Connection getConnection(){
        
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/Hospital", "root", "");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    
    public ArrayList<Nurse2> BindTable(){
            ArrayList<Nurse2> list = new ArrayList<Nurse2>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;
            
           try{
                st = con.createStatement();
                rs = st.executeQuery("SELECT `NurseID`, `Fname`, `Lname`, `Sex`, `image`, `Bdate`, `Address`, `Phone`, `Status`, `Email`, `ContractNo`, `DEmployed` FROM `nurse`");
                
                Nurse2 n;
                while(rs.next()){
                    n = new Nurse2(
                            rs.getInt("NurseID"),
                            rs.getString("Fname"),
                            rs.getString("Lname"),
                            rs.getString("Sex"),
                            rs.getBytes("image"),
                            rs.getString("Bdate"),
                            rs.getString("Address"),
                            rs.getString("Phone"),
                            rs.getString("Status"),
                            rs.getString("Email"),
                            rs.getString("ContractNo"),
                            rs.getString("Demployed"));
                    
                    list.add(n);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex + "Cannot retrieve data from database");
            }
           return list;
    }
        
}




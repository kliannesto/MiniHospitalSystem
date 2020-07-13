
package Cashier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Billing2{
    
    private String particulars;
    private String department;
    private String price;
    static Connection con;
    static String url = "jdbc:mysql://localhost/system";
    static String driver = "com.mysql.jdbc.Driver";

    public Billing2(String Particulars,String Department,String Price)
    {
        this.particulars = Particulars;
        this.department = Department;
        this.price = Price;
    }
    
    public String getParticulars(){
        return particulars;
    }
    public String getDepartment(){
        return department;
    }
    public String getPrice(){
        return price;
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
}


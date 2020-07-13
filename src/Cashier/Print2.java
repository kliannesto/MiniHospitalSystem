
package Cashier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author kli ann
 */
public class Print2 {
    private int billNo;
    private int id;
    private String date;
    private String roomPay;
    private String otherFees;
    private String total;
    
    static Connection con;
    static String url = "jdbc:mysql://localhost/Hospital";
    static String driver = "com.mysql.jdbc.Driver";
    
    public Print2(){
        
    }
    
    public Print2( int Id, String Date, String RoomPay, String OtherFees, String Total){
        
        this.id = Id;
        this.date = Date;
        this.roomPay = RoomPay;
        this.otherFees = OtherFees;
        this.total = Total;
    }
    
    public boolean addNew(){
        try{
            String sql = "INSERT INTO bills (BillNo, PatientId, Date, RoomPay, OtherFees, Total)values('"+ this.billNo +"',"
                    + "'"+ this.id +"','"+ this.date +"','"+ this.roomPay +"','"+ this.otherFees +"','"+total+"')";
            
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
    
}

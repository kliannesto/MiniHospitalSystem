/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Laboratory;

import java.sql.Connection;
/**
 *
 * @author kli ann
 */
public class MedicalLaboratory2 {
    
    private int no;
    private String testname;
    private String department;
    private String price;
    static Connection con;
    
    public MedicalLaboratory2(){
        
    }
    public MedicalLaboratory2( int No,String Testname,String Department,String Price) {
        this.no = No;
        this.testname = Testname;
        this.department = Department;
        this.price= Price;
    }
    
    
    public int getNo(){
        return no;
    }
    public String getTestName(){
        return testname;
    }
    public String getDepartment(){
        return department;
    }
    public String getPrice(){
        return price;
    }
    
}

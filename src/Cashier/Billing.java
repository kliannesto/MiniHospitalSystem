/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cashier;

import PatientsInfo.AdminPortal;
import PatientsInfo.InPatient2;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author kli ann
 */
public class Billing extends javax.swing.JFrame {

    double firstNum;
    double secondNum;
    double result;
    double bill;
    double bill2;
    int cash;
    String operations;
    
    public String getData[] = new String [4];
    
    public Billing() {
        
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon home = new ImageIcon(getClass().getResource("home.jpg")); 
        Image img = home.getImage().getScaledInstance(51, 57, Image.SCALE_SMOOTH);
        jLabelHome.setIcon(new ImageIcon(img) );
        
        //For Enter key event-(search bar)
        txtSearch1.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                    //jLabel.setText("Typed"+txtSearch.getText());
                    txtSearch1.getText();
                
            }
        });   
    }
    
    
    
    public Connection getConnection()
    {
        Connection con = null;
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/system","root","");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
            
    public ArrayList<Billing2> ListBillings(String ValToSearch)
    {
        
        
        ArrayList<Billing2> billingList = new ArrayList<Billing2>();
        
        Statement st;
        ResultSet rs;
        
        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `medicallab` WHERE CONCAT(`Particulars`) LIKE '%"+ValToSearch+"%'" ;
            rs = st.executeQuery(searchQuery);
            
            
            Billing2 bill;
            
            while(rs.next()){
                bill = new Billing2(
                                     rs.getString("Particulars"),
                                     rs.getString("Department"),
                                     rs.getString("Price")
                                     );
                
                billingList.add(bill);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return billingList;
    }
    
    //Method for searching items
    public void findBill()
    {
        
        ArrayList<Billing2> bills = ListBillings(txtSearch.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Particulars","Department","Price"});
        Object[] row = new Object[4];
        
        for(int i=0; i<bills.size(); i++)
        {
            row[0] = bills.get(i).getParticulars();
            row[1] = bills.get(i).getDepartment();
            row[2] = bills.get(i).getPrice();
            model.addRow(row);
        }
        tblItems.setModel(model);
    }
    
    //method for searching patients
    public void findName()
    {
        
        ArrayList<Billing2> bills = ListBillings(txtSearch1.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Particulars","Department","Price"});
        
        Object[] row = new Object[4];
        
        for(int i=0; i<bills.size(); i++)
        {
            row[0] = bills.get(i).getParticulars();
            row[1] = bills.get(i).getDepartment();
            row[2] = bills.get(i).getPrice();
            model.addRow(row);
        }
        tblItems.setModel(model);
    }
    
    public ArrayList<Billing2> Patients(String NameToSearch)
    {
        
        
        ArrayList<Billing2> nameList = new ArrayList<Billing2>();
        
        Statement st;
        ResultSet rs;
        
        try{
            Connection con = getConnection();
            st = con.createStatement();
            String searchQuery = "SELECT * FROM `info` WHERE CONCAT(`FullName`) LIKE '%"+NameToSearch+"%'" ;
            rs = st.executeQuery(searchQuery);
            
            
            Billing2 name;
            
            while(rs.next()){
                name = new Billing2(
                                     rs.getString("FullName"),
                                     rs.getString("Gender"),
                                     rs.getString("Address")
                                     );
                
                nameList.add(name);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return nameList;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItems = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelHome = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtSearch1 = new javax.swing.JTextField();
        btnSearchPatient = new javax.swing.JButton();
        lblAddress = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblRoomno = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblCheckin = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblRoomType = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblItems2 = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtRate = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtDays = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtCheckinPayment = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnRoomPayment = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        txtCash = new javax.swing.JTextField();
        jLabel_total = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jCheckBox_discount = new javax.swing.JCheckBox();
        lbl_discount = new javax.swing.JLabel();
        btn_Settle = new javax.swing.JButton();
        btn_Total = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel_netTotal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblChange = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        txtCalculator = new javax.swing.JTextField();
        button_div = new javax.swing.JButton();
        button_Clear = new javax.swing.JButton();
        button_x = new javax.swing.JButton();
        button_minus = new javax.swing.JButton();
        button_8 = new javax.swing.JButton();
        button_9 = new javax.swing.JButton();
        button_7 = new javax.swing.JButton();
        button_multiply = new javax.swing.JButton();
        button_equals = new javax.swing.JButton();
        button_5 = new javax.swing.JButton();
        button_6 = new javax.swing.JButton();
        button_4 = new javax.swing.JButton();
        button_1 = new javax.swing.JButton();
        button_0 = new javax.swing.JButton();
        button_plus = new javax.swing.JButton();
        button_2 = new javax.swing.JButton();
        button_3 = new javax.swing.JButton();
        button_dot = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Bill");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Items Requests");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 0, -1, 32));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 570, 30));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel4.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 38, 340, 30));

        btnAdd.setBackground(new java.awt.Color(0, 153, 153));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.setPreferredSize(new java.awt.Dimension(63, 32));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 90, 30));

        tblItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItems);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 550, 260));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 570, 350));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Billings");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Home");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 60, -1, -1));

        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PatientsInfo/home.jpg"))); // NOI18N
        jLabelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 80, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 80));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 199, 490, -1));

        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });
        jPanel5.add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 340, 30));

        btnSearchPatient.setBackground(new java.awt.Color(0, 153, 153));
        btnSearchPatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchPatient.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchPatient.setText("Search Patient");
        btnSearchPatient.setPreferredSize(new java.awt.Dimension(63, 32));
        btnSearchPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPatientActionPerformed(evt);
            }
        });
        jPanel5.add(btnSearchPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 150, 30));

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 400, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Room No:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Name:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Gender:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        lblRoomno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(lblRoomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 90, 20));

        lblGender.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 100, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Age:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("Address:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("Check-in:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 50, 20));

        lblCheckin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(lblCheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 90, 20));

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 200, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setText("Room Type:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        lblRoomType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel5.add(lblRoomType, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 90, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 570, 220));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bill Items");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 0, -1, 32));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 720, 30));

        tblItems2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Particulars", "Department", "Price"
            }
        ));
        jScrollPane3.setViewportView(tblItems2);

        jPanel7.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 630, 200));

        btnDelete.setBackground(new java.awt.Color(0, 153, 153));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Cashier/delete_edit.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel7.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 100, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 660, 300));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Room Rate Payment");
        jPanel14.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 0, -1, 32));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("No. of Days Checked-in:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Room Rate:");

        txtRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRateActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("*");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Total Payment ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("for Check-in:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Room Type:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Rate per Room:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Ward");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Private");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("₱ 750.00");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("₱ 1,000.00");

        btnRoomPayment.setBackground(new java.awt.Color(0, 153, 153));
        btnRoomPayment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRoomPayment.setForeground(new java.awt.Color(255, 255, 255));
        btnRoomPayment.setText("Total");
        btnRoomPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomPaymentActionPerformed(evt);
            }
        });

        jSeparator10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(349, 349, 349))))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(158, 158, 158))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCheckinPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(115, 115, 115)
                                .addComponent(jLabel33)
                                .addGap(14, 14, 14))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(btnRoomPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCheckinPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel27))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnRoomPayment)
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Room Payment", jPanel13);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bill Details");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 0, -1, 32));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 660, 30));
        jPanel9.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 440, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Total:");
        jPanel9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));
        jPanel9.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 440, 10));
        jPanel9.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 440, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Net Total:");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 115, 60, 30));
        jPanel9.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 440, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Tendered:");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));
        jPanel9.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 440, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Change:");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));
        jPanel9.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 440, 20));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 20, 180));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 20, 180));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 20, 180));
        jPanel9.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 230, 30));

        jLabel_total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_total.setText("0.00");
        jPanel9.add(jLabel_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 140, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setText("₱");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 10, 30));

        jCheckBox_discount.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_discount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox_discount.setText("10% Discount");
        jCheckBox_discount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox_discountMouseClicked(evt);
            }
        });
        jCheckBox_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_discountActionPerformed(evt);
            }
        });
        jPanel9.add(jCheckBox_discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 120, 30));

        lbl_discount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_discount.setText("0.00");
        jPanel9.add(lbl_discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 150, -1));

        btn_Settle.setBackground(new java.awt.Color(0, 153, 153));
        btn_Settle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_Settle.setForeground(new java.awt.Color(255, 255, 255));
        btn_Settle.setText("Settle");
        btn_Settle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SettleActionPerformed(evt);
            }
        });
        jPanel9.add(btn_Settle, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 140, 30));

        btn_Total.setBackground(new java.awt.Color(0, 153, 153));
        btn_Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Total.setForeground(new java.awt.Color(255, 255, 255));
        btn_Total.setText("Total");
        btn_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TotalActionPerformed(evt);
            }
        });
        jPanel9.add(btn_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 157, 70, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Discount:");
        jPanel9.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel_netTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel_netTotal.setText("0.00");
        jPanel9.add(jLabel_netTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 150, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("₱");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 10, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("-");
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 20, 30));

        lblChange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblChange.setText("0.00");
        jPanel9.add(lblChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 190, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("₱");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 10, 40));

        btnClear.setBackground(new java.awt.Color(0, 153, 153));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel9.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 157, 70, -1));

        jTabbedPane1.addTab("Bill", jPanel9);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCalculator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalculatorActionPerformed(evt);
            }
        });
        jPanel12.add(txtCalculator, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 350, 30));

        button_div.setBackground(new java.awt.Color(0, 153, 153));
        button_div.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        button_div.setForeground(new java.awt.Color(255, 255, 255));
        button_div.setText("/");
        button_div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_divActionPerformed(evt);
            }
        });
        jPanel12.add(button_div, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 80, 30));

        button_Clear.setBackground(new java.awt.Color(0, 153, 153));
        button_Clear.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        button_Clear.setForeground(new java.awt.Color(255, 255, 255));
        button_Clear.setText("C");
        button_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ClearActionPerformed(evt);
            }
        });
        jPanel12.add(button_Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 170, 30));

        button_x.setBackground(new java.awt.Color(0, 153, 153));
        button_x.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_x.setForeground(new java.awt.Color(255, 255, 255));
        button_x.setText("x");
        button_x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_xActionPerformed(evt);
            }
        });
        jPanel12.add(button_x, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 80, 30));

        button_minus.setBackground(new java.awt.Color(0, 153, 153));
        button_minus.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        button_minus.setForeground(new java.awt.Color(255, 255, 255));
        button_minus.setText("-");
        button_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_minusActionPerformed(evt);
            }
        });
        jPanel12.add(button_minus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 80, 30));

        button_8.setBackground(new java.awt.Color(0, 153, 153));
        button_8.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_8.setForeground(new java.awt.Color(255, 255, 255));
        button_8.setText("8");
        button_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8ActionPerformed(evt);
            }
        });
        jPanel12.add(button_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 80, 30));

        button_9.setBackground(new java.awt.Color(0, 153, 153));
        button_9.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_9.setForeground(new java.awt.Color(255, 255, 255));
        button_9.setText("9");
        button_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_9ActionPerformed(evt);
            }
        });
        jPanel12.add(button_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 80, 30));

        button_7.setBackground(new java.awt.Color(0, 153, 153));
        button_7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_7.setForeground(new java.awt.Color(255, 255, 255));
        button_7.setText("7");
        button_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_7ActionPerformed(evt);
            }
        });
        jPanel12.add(button_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 80, 30));

        button_multiply.setBackground(new java.awt.Color(0, 153, 153));
        button_multiply.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        button_multiply.setForeground(new java.awt.Color(255, 255, 255));
        button_multiply.setText("*");
        button_multiply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_multiplyActionPerformed(evt);
            }
        });
        jPanel12.add(button_multiply, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 80, 30));

        button_equals.setBackground(new java.awt.Color(0, 153, 153));
        button_equals.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_equals.setForeground(new java.awt.Color(255, 255, 255));
        button_equals.setText("=");
        button_equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_equalsActionPerformed(evt);
            }
        });
        jPanel12.add(button_equals, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 80, 30));

        button_5.setBackground(new java.awt.Color(0, 153, 153));
        button_5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_5.setForeground(new java.awt.Color(255, 255, 255));
        button_5.setText("5");
        button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5ActionPerformed(evt);
            }
        });
        jPanel12.add(button_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 80, 30));

        button_6.setBackground(new java.awt.Color(0, 153, 153));
        button_6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_6.setForeground(new java.awt.Color(255, 255, 255));
        button_6.setText("6");
        button_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_6ActionPerformed(evt);
            }
        });
        jPanel12.add(button_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 80, 30));

        button_4.setBackground(new java.awt.Color(0, 153, 153));
        button_4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_4.setForeground(new java.awt.Color(255, 255, 255));
        button_4.setText("4");
        button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4ActionPerformed(evt);
            }
        });
        jPanel12.add(button_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 80, 30));

        button_1.setBackground(new java.awt.Color(0, 153, 153));
        button_1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_1.setForeground(new java.awt.Color(255, 255, 255));
        button_1.setText("1");
        button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_1ActionPerformed(evt);
            }
        });
        jPanel12.add(button_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 80, 30));

        button_0.setBackground(new java.awt.Color(0, 153, 153));
        button_0.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_0.setForeground(new java.awt.Color(255, 255, 255));
        button_0.setText("0");
        button_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_0ActionPerformed(evt);
            }
        });
        jPanel12.add(button_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 80, 30));

        button_plus.setBackground(new java.awt.Color(0, 153, 153));
        button_plus.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_plus.setForeground(new java.awt.Color(255, 255, 255));
        button_plus.setText("+");
        button_plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_plusActionPerformed(evt);
            }
        });
        jPanel12.add(button_plus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 80, 30));

        button_2.setBackground(new java.awt.Color(0, 153, 153));
        button_2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_2.setForeground(new java.awt.Color(255, 255, 255));
        button_2.setText("2");
        button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2ActionPerformed(evt);
            }
        });
        jPanel12.add(button_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 80, 30));

        button_3.setBackground(new java.awt.Color(0, 153, 153));
        button_3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_3.setForeground(new java.awt.Color(255, 255, 255));
        button_3.setText("3");
        button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_3ActionPerformed(evt);
            }
        });
        jPanel12.add(button_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 80, 30));

        button_dot.setBackground(new java.awt.Color(0, 153, 153));
        button_dot.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        button_dot.setForeground(new java.awt.Color(255, 255, 255));
        button_dot.setText(".");
        button_dot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_dotActionPerformed(evt);
            }
        });
        jPanel12.add(button_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 80, 30));

        jButton22.setBackground(new java.awt.Color(0, 153, 153));
        jButton22.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("+/-");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 80, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jTabbedPane1.addTab("Calculator", jPanel11);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 660, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SettleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SettleActionPerformed
        
        TableModel model1 = tblItems2.getModel();
        int indexs[] = tblItems2.getSelectedRows();
        
        Object[] row = new Object[4];
        
        Print pr = new Print();
        
        DefaultTableModel model2 = (DefaultTableModel)pr.tbl_Bill.getModel();
        
        for(int i=0; i < indexs.length; i++)
        {
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
            row[2] = model1.getValueAt(indexs[i], 2);
            
            model2.addRow(row);
        }

        //function for adding selected column(PRICE)in tblItems2 passing to tbl_Bill
        double sum1 = 0.00;
        
        for(int i=0; i < tblItems2.getRowCount(); i++)
        {
            sum1 = sum1 + Double.parseDouble(tblItems2.getValueAt(i, 2).toString());
        }
        Print.lblItems.setText(Double.toString(sum1));
        
        
        //passing the patients details to another jframe
        Print.ID.setText(Billing.txtSearch1.getText());
        Print.Name.setText(Billing.lblName.getText());
        Print.Gender.setText(Billing.lblGender.getText());
        Print.Age.setText(Billing.lblAge.getText());
        Print.Address.setText(Billing.lblAddress.getText());
        Print.Admission.setText(Billing.lblCheckin.getText());
        Print.RoomType.setText(Billing.lblRoomType.getText());
        Print.RoomNo.setText(Billing.lblRoomno.getText());
        
        //passing the total bill to another jframe
        Print.Total.setText(Billing.jLabel_total.getText());
        Print.Discount.setText(Billing.lbl_discount.getText());
        Print.NetTotal.setText(Billing.jLabel_netTotal.getText());
        Print.Cash.setText(Billing.txtCash.getText());
        Print.Change.setText(Billing.lblChange.getText());
        
        //passing the total room pay
        Print.lblDaysP.setText(Billing.txtDays.getText());
        Print.lblRateP.setText(Billing.txtRate.getText());
        Print.lblCheckinPayment.setText(Billing.txtCheckinPayment.getText());
        
        pr.setVisible(true);
//        ArrayList <String> s = new ArrayList<>();
//        s.add(txtSearch1.getText());
//        s.add(lblName.getText());
//        s.add(lblGender.getText());
//        s.add(lblAge.getText());
//        s.add(lblAddress.getText());
//        s.add(lblCheckin.getText());
//        s.add(lblRoomno.getText());
//        
//        new Print(s).setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_SettleActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
      /* function to add selected rows to another jtable*/
        
        TableModel model1 = tblItems.getModel();
        int indexs[] = tblItems.getSelectedRows();
        
        Object[] row = new Object[4];
        //defaultablemodel for passing to tblItems2
        DefaultTableModel model2 = (DefaultTableModel)tblItems2.getModel();

        for(int i=0; i < indexs.length; i++)
        {
            row[0] = model1.getValueAt(indexs[i], 0);
            row[1] = model1.getValueAt(indexs[i], 1);
            row[2] = model1.getValueAt(indexs[i], 2);
            
            model2.addRow(row);
        }
        
        //function for adding selected column(PRICE) passing to tblItems2
        double sum = 0.0;
        
        for(int i=0; i < tblItems2.getRowCount(); i++)
        {
            sum = sum + Double.parseDouble(tblItems2.getValueAt(i, 2).toString());
            
        }
        
        double checkinPayment = Double.parseDouble(txtCheckinPayment.getText());
        bill = checkinPayment + sum;
        
        String total = String.format("%.02f", bill);
        jLabel_total.setText(total);


    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        findBill();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void btnSearchPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPatientActionPerformed
        //method for searching patient details
        
        String id = txtSearch1.getText();
        
        InPatient2 reg = new InPatient2();
        ResultSet res = reg.getInfo(id);        
        
        try{
            res.beforeFirst();
            while(res.next()){
                txtSearch1.setText(res.getString("PatientId"));
                lblName.setText(res.getString("FullName"));
                lblGender.setText(res.getString("Gender"));
                lblAge.setText(res.getString("Age"));
                //res.getString("Age");
                lblAddress.setText(res.getString("Address"));
                //res.getString("Address");
                //Consultant.setText(res.getString("Age"));
                lblCheckin.setText(res.getString("Checkin"));
                //res.getString("Checkin");
                lblRoomType.setText(res.getString("RoomType"));
                lblRoomno.setText(res.getString("RoomNo"));
                
            }
        } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Id does not exist!");
        }
    }//GEN-LAST:event_btnSearchPatientActionPerformed

    private void tblItemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemsMouseClicked
        int index = tblItems.getSelectedRow();
        
        TableModel model = tblItems.getModel();
        String particulars = model.getValueAt(index, 0).toString();
        
        txtSearch.setText(particulars);
    }//GEN-LAST:event_tblItemsMouseClicked

    private void txtCalculatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalculatorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalculatorActionPerformed

    private void button_divActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_divActionPerformed
        //Division operator
        firstNum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations ="/";
        
    }//GEN-LAST:event_button_divActionPerformed

    private void button_xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_xActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_xActionPerformed

    private void button_minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_minusActionPerformed
        //subtraction operator
        firstNum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations ="-";
    }//GEN-LAST:event_button_minusActionPerformed

    private void button_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_8ActionPerformed
        String enterNumber = txtCalculator.getText() + button_8.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_8ActionPerformed

    private void button_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_9ActionPerformed
        String enterNumber = txtCalculator.getText() + button_9.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_9ActionPerformed

    private void button_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_7ActionPerformed

        String enterNumber = txtCalculator.getText() + button_7.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_7ActionPerformed

    private void button_multiplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_multiplyActionPerformed
        //multiplication operator
        firstNum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations ="*";
    }//GEN-LAST:event_button_multiplyActionPerformed

    private void button_equalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_equalsActionPerformed
        String answer;
        secondNum = Double.parseDouble(txtCalculator.getText());
        if(operations == "+"){
            result = firstNum + secondNum;
            answer = String.format("%.2f",result);
            txtCalculator.setText(answer);
        }
        else if(operations == "-"){
            result = firstNum - secondNum;
            answer = String.format("%.2f",result);
            txtCalculator.setText(answer);
        }
        else if(operations == "*"){
            result = firstNum * secondNum;
            answer = String.format("%.2f",result);
            txtCalculator.setText(answer);
        }
        else if(operations == "/"){
            result = firstNum / secondNum;
            answer = String.format("%.2f",result);
            txtCalculator.setText(answer);
        }
    }//GEN-LAST:event_button_equalsActionPerformed

    private void button_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_5ActionPerformed
        String enterNumber = txtCalculator.getText() + button_5.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_5ActionPerformed

    private void button_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_6ActionPerformed
        String enterNumber = txtCalculator.getText() + button_6.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_6ActionPerformed

    private void button_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_4ActionPerformed
        String enterNumber = txtCalculator.getText() + button_4.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_4ActionPerformed

    private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_1ActionPerformed
        String enterNumber = txtCalculator.getText() + button_1.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_1ActionPerformed

    private void button_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_0ActionPerformed
        String enterNumber = txtCalculator.getText() + button_0.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_0ActionPerformed

    private void button_plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_plusActionPerformed
        //addition operator
        firstNum = Double.parseDouble(txtCalculator.getText());
        txtCalculator.setText("");
        operations ="+";
    }//GEN-LAST:event_button_plusActionPerformed

    private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_2ActionPerformed
        String enterNumber = txtCalculator.getText() + button_2.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_2ActionPerformed

    private void button_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_3ActionPerformed
        String enterNumber = txtCalculator.getText() + button_3.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_3ActionPerformed

    private void button_dotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_dotActionPerformed
        String enterNumber = txtCalculator.getText() + button_dot.getText();
        txtCalculator.setText(enterNumber);
    }//GEN-LAST:event_button_dotActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void button_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ClearActionPerformed
        //Clear Display
        txtCalculator.setText("");
    }//GEN-LAST:event_button_ClearActionPerformed

    private void jCheckBox_discountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox_discountMouseClicked

    }//GEN-LAST:event_jCheckBox_discountMouseClicked

    private void jCheckBox_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_discountActionPerformed

    private void btn_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TotalActionPerformed
        
        String change3 = txtCash.getText();
        
        double total2 = 0.0;
        if(jCheckBox_discount.isSelected()){
           
        bill = Double.parseDouble(jLabel_total.getText());
        double discount1 = (bill) * .10;
        String answer = String.format("%.2f",discount1);
        lbl_discount.setText(answer);
        
        
        double netTotal = Double.parseDouble(jLabel_total.getText());
        double ans = netTotal - discount1;
        String ans2 = String.format("%.2f",ans);
        jLabel_netTotal.setText(ans2);
        
//        double cash1 = Double.parseDouble(txtCash.getText());
//        double netTotal = Double.parseDouble(jLabel_total.getText());
//        double change = cash1 - netTotal;
        
        
        
        if(change3.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter the cash tendered!!");
        }
        else{
        double cash1 = Double.parseDouble(txtCash.getText());
        double cash2 = cash1 - ans;
        String change = String.format("%.2f",cash2);
        lblChange.setText(change);
        }
        }
        else{
        lbl_discount.setText("0.00");        
        jLabel_netTotal.setText(jLabel_total.getText());
        
        double cash1 = Double.parseDouble(txtCash.getText());
        double netTotal = Double.parseDouble(jLabel_total.getText());
        double change = cash1 - netTotal;
        
        String change2 = String.format("%.2f", change);
        lblChange.setText(change2);
        }
        
        
    }//GEN-LAST:event_btn_TotalActionPerformed

    private void jLabelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseClicked
        // TODO add your handling code here:
        AdminPortal ap = new AdminPortal();
        ap.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHomeMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int column = tblItems2.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblItems2.getRowHeight();
        
        if(row < tblItems2.getRowCount() && row >= 0 && column < tblItems2.getColumnCount() && column >= 0){
            Object rowValue = tblItems2.getValueAt(row, column);
            DefaultTableModel tableModel = (DefaultTableModel)this.tblItems2.getModel();
            int[] selectedRows = tblItems2.getSelectedRows();
            for(int i = 0; i < selectedRows.length; i++)
                tableModel.removeRow(selectedRows[i]);
        }
        
        //function for subtracting selected column(PRICE)
        
//        double cash1 = Double.parseDouble(txtCash.getText());
//        double netTotal = Double.parseDouble(jLabel_total.getText());
//        double change = cash1 - netTotal;
//        
//        String change2 = String.format("%.2f", change);
//        lblChange.setText(change2);
//        
        
        double total2 = 0.0;
        for(int i = 0; i < tblItems2.getRowCount(); i++)
        {
            total2 = Double.parseDouble(tblItems2.getValueAt(i, 2).toString());
        }
        
        double netTotal = Double.parseDouble(jLabel_total.getText());
        bill2 = netTotal - total2;
        
        String difference = String.format("%.02f", bill2);
        jLabel_total.setText(difference);
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void txtRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRateActionPerformed

    private void btnRoomPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomPaymentActionPerformed
        //adding the room payment
        
        double total = 0.0;
        double days = Double.parseDouble(txtDays.getText());
        double rate = Double.parseDouble(txtRate.getText());
        total = days * rate;
        
        String total2 = String.format("%.2f", total);
        txtCheckinPayment.setText(total2);
        jLabel_total.setText(total2);
        
        
    }//GEN-LAST:event_btnRoomPaymentActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblItems2.getModel();
        model.setRowCount(0);
        String checkinPayment = txtCheckinPayment.getText();
        jLabel_total.setText(checkinPayment);
        
    }//GEN-LAST:event_btnClearActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String date = sdf.format(new Date());
    System.out.println(date);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRoomPayment;
    private javax.swing.JButton btnSearchPatient;
    private javax.swing.JButton btn_Settle;
    private javax.swing.JButton btn_Total;
    private javax.swing.JButton button_0;
    private javax.swing.JButton button_1;
    private javax.swing.JButton button_2;
    private javax.swing.JButton button_3;
    private javax.swing.JButton button_4;
    private javax.swing.JButton button_5;
    private javax.swing.JButton button_6;
    private javax.swing.JButton button_7;
    private javax.swing.JButton button_8;
    private javax.swing.JButton button_9;
    private javax.swing.JButton button_Clear;
    private javax.swing.JButton button_div;
    private javax.swing.JButton button_dot;
    private javax.swing.JButton button_equals;
    private javax.swing.JButton button_minus;
    private javax.swing.JButton button_multiply;
    private javax.swing.JButton button_plus;
    private javax.swing.JButton button_x;
    private javax.swing.JButton jButton22;
    private javax.swing.JCheckBox jCheckBox_discount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelHome;
    public static javax.swing.JLabel jLabel_netTotal;
    public static javax.swing.JLabel jLabel_total;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblAddress;
    public static javax.swing.JLabel lblAge;
    public static javax.swing.JLabel lblChange;
    public static javax.swing.JLabel lblCheckin;
    public static javax.swing.JLabel lblGender;
    public static javax.swing.JLabel lblName;
    public static javax.swing.JLabel lblRoomType;
    public static javax.swing.JLabel lblRoomno;
    public static javax.swing.JLabel lbl_discount;
    private javax.swing.JTable tblItems;
    public javax.swing.JTable tblItems2;
    private javax.swing.JTextField txtCalculator;
    public static javax.swing.JTextField txtCash;
    public static javax.swing.JTextField txtCheckinPayment;
    public static javax.swing.JTextField txtDays;
    public static javax.swing.JTextField txtRate;
    public javax.swing.JTextField txtSearch;
    public static javax.swing.JTextField txtSearch1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nurse;

import Login.MyConnection;
import PatientsInfo.AdminPortal;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author kli ann
 */
public class Nurse extends javax.swing.JFrame {

    /**
     * Creates new form Nurse
     */
    public Nurse() {
        initComponents();
        
        populateJTable();

        getConnection();

        ImageIcon ad = new ImageIcon(getClass().getResource("nurse.png"));
        Image image = ad.getImage().getScaledInstance(90, 110, Image.SCALE_SMOOTH);
        Logo.setIcon(new ImageIcon(image));
        Logo1.setIcon(new ImageIcon(image));
        Logo2.setIcon(new ImageIcon(image));
        Logo3.setIcon(new ImageIcon(image));

        ImageIcon home = new ImageIcon(getClass().getResource("home.jpg"));
        Image img = home.getImage().getScaledInstance(52, 57, Image.SCALE_SMOOTH);
        jLabelHome.setIcon(new ImageIcon(img));
        jLabelHome1.setIcon(new ImageIcon(img));
        jLabelHome2.setIcon(new ImageIcon(img));
        jLabelHome3.setIcon(new ImageIcon(img));

//        TableColumnModel tcm = tblRecords.getColumnModel();
//        tcm.getColumn(0).setPreferredWidth(3);
//        tcm.getColumn(1).setPreferredWidth(15);
//        tcm.getColumn(2).setPreferredWidth(15);
//        tcm.getColumn(3).setPreferredWidth(10);
//        tcm.getColumn(4).setPreferredWidth(20);
//        tcm.getColumn(5).setPreferredWidth(100);
//        tcm.getColumn(6).setPreferredWidth(15);
//        tcm.getColumn(7).setPreferredWidth(10);
//        tcm.getColumn(8).setPreferredWidth(30);
//        tcm.getColumn(9).setPreferredWidth(10);
//        tcm.getColumn(10).setPreferredWidth(20);
//
//        //for displaying data from table in Mysql
//        DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
//        model.setRowCount(0);
//
//        Nurse2 n = new Nurse2();
//        ResultSet res = null;
//        try {
//            res = n.getAll();
//            res.beforeFirst();
//            while (res.next()) {
//                model.addRow(new Object[]{Integer.parseInt(res.getString(1)), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11)});
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Cannot display" + e.toString());
//        }

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        btnClear.setEnabled(false);
        btnDelete1.setEnabled(false);
        btnClear1.setEnabled(false);
        btnClear2.setEnabled(false);
        btnUpdate.setEnabled(false);

        showDate();
    }

    String ImgPath = null;

    //For choosing image from files
    public ImageIcon ResizeImage(String imagePath, byte[] pix) {
        ImageIcon myImage = null;

        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pix);
        }
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Date.setText(s.format(d));
    }

    //Connection to database
    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/Hospital", "root", "");
            return con;
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Not connected" + ex);
            return null;
        }
    }

    //Check for inputs
    public boolean checkInputs() {
        if (txtFname.getText() == null
                || txtLname.getText() == null
                || txtBdate.getText() == null
                || txtAddress.getText() == null
                || txtPhone.getText() == null
                || txtEmail.getText() == null
                || txtContract.getText() == null) {
            return false;
        } else {
            try {
                Float.parseFloat(txtPhone.getText());
                return true;
            } catch (Exception ex) {
                return false;
            }
        }

    }
    
    public void populateJTable(){
        MyConnection mc = new MyConnection();
        ArrayList<Nurse2> list = mc.BindTable();
        String[] columnName = {"NurseID","Fname","Lname","Sex","Image","Bdate","Address","Phone","Status","Email","ContractNo","DEmployed"};
        Object[][] rows = new Object[list.size()][12];
        for(int i=0; i<list.size(); i++){
            rows[i][0] = list.get(i).getId();
            rows[i][1] = list.get(i).getFname();
            rows[i][2] = list.get(i).getLname();
            rows[i][3] = list.get(i).getSex();
            
            if(list.get(i).getMyImage() != null){
                ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));

            rows[i][4] = image;
            }
            else{
                rows[i][4] = null;
            }
            
            rows[i][5] = list.get(i).getBdate();
            rows[i][6] = list.get(i).getAddress();
            rows[i][7] = list.get(i).getPhone();
            rows[i][8] = list.get(i).getStatus();
            rows[i][9] = list.get(i).getEmail();
            rows[i][10] = list.get(i).getContract();
            rows[i][11] = list.get(i).getDate();
            
        }
        
        TheModel model = new TheModel(rows,columnName);
        tblRecords.setModel(model);
        tblRecords.setRowHeight(120);
        tblRecords.getColumnModel().getColumn(4).setPreferredWidth(150);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Date = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabelHome = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtBdate = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtContract = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        cmboStatus = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        lbl_image = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btn_Image = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabelHome1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Logo1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        txtLname1 = new javax.swing.JTextField();
        txtBdate1 = new javax.swing.JTextField();
        txtSearch1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtContract1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtPhone1 = new javax.swing.JTextField();
        rdoMale1 = new javax.swing.JRadioButton();
        rdoFemale1 = new javax.swing.JRadioButton();
        cmboStatus1 = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        btnDelete1 = new javax.swing.JButton();
        lblNurse1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnSearch1 = new javax.swing.JButton();
        txtEmail1 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtFname1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        btnClear1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabelHome2 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        Logo2 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtAddress2 = new javax.swing.JTextField();
        txtLname2 = new javax.swing.JTextField();
        txtBdate2 = new javax.swing.JTextField();
        txtSearch2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtContract2 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtPhone2 = new javax.swing.JTextField();
        rdoMale2 = new javax.swing.JRadioButton();
        rdoFemale2 = new javax.swing.JRadioButton();
        cmboStatus2 = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel15 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        lbl_image2 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btnSearch2 = new javax.swing.JButton();
        txtEmail2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtFname2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        btnClear2 = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        btn_ImageUpdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabelHome3 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        Logo3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecords = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Add Nurse");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Receptionist/home.jpg"))); // NOI18N
        jLabelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseClicked(evt);
            }
        });
        jPanel6.add(jLabelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 90, 60));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Home");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 70, -1, -1));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nurse/nurse.png"))); // NOI18N
        jPanel6.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 120, 110));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 94));

        jLabel14.setBackground(new java.awt.Color(204, 204, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Address:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 520, -1, -1));

        jLabel17.setBackground(new java.awt.Color(204, 204, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 153));
        jLabel17.setText("Last Name:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, -1, -1));

        jLabel18.setBackground(new java.awt.Color(204, 204, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setText("Sex:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jLabel19.setBackground(new java.awt.Color(204, 204, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setText("B-date:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        jLabel20.setBackground(new java.awt.Color(204, 204, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 153));
        jLabel20.setText("Marital Status:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, -1, 20));

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel5.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 690, 40));

        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });
        jPanel5.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 240, 40));

        txtBdate.setText("dd-MM-yyyy");
        txtBdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBdateMouseClicked(evt);
            }
        });
        jPanel5.add(txtBdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 240, 40));

        jLabel23.setBackground(new java.awt.Color(204, 204, 255));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 153));
        jLabel23.setText("Phone:");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));
        jPanel5.add(txtContract, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 240, 40));

        jLabel25.setBackground(new java.awt.Color(204, 204, 255));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 153));
        jLabel25.setText("Contract No.:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, -1, -1));
        jPanel5.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 240, 40));

        rdoMale.setBackground(new java.awt.Color(51, 255, 153));
        buttonGroup1.add(rdoMale);
        rdoMale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoMale.setForeground(new java.awt.Color(0, 102, 102));
        rdoMale.setText("Male");
        rdoMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMaleActionPerformed(evt);
            }
        });
        jPanel5.add(rdoMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        rdoFemale.setBackground(new java.awt.Color(51, 255, 153));
        buttonGroup1.add(rdoFemale);
        rdoFemale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoFemale.setForeground(new java.awt.Color(0, 102, 102));
        rdoFemale.setText("Female");
        jPanel5.add(rdoFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, -1));

        cmboStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmboStatus.setForeground(new java.awt.Color(0, 153, 153));
        cmboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Single", "Married", "Divorced", "Widow" }));
        jPanel5.add(cmboStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 240, 40));

        jPanel7.setBackground(new java.awt.Color(51, 255, 153));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 240, 40));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nurse/nurse.png"))); // NOI18N
        jPanel5.add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 180, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 204), new java.awt.Color(0, 204, 204)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 170, 200, 210));
        jPanel5.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 370, 240, 40));

        jLabel30.setBackground(new java.awt.Color(204, 204, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 153));
        jLabel30.setText("Email:");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, -1, -1));
        jPanel5.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 240, 40));

        jLabel21.setBackground(new java.awt.Color(204, 204, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 153));
        jLabel21.setText("First Name:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, -1, -1));

        btnClear.setBackground(new java.awt.Color(0, 153, 153));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel5.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 490, 110, 30));

        btnAdd.setBackground(new java.awt.Color(0, 153, 153));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel5.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 490, 120, 30));

        btn_Image.setBackground(new java.awt.Color(0, 153, 153));
        btn_Image.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Image.setForeground(new java.awt.Color(255, 255, 255));
        btn_Image.setText("Choose Image");
        btn_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImageActionPerformed(evt);
            }
        });
        jPanel5.add(btn_Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 380, 200, 30));

        jTabbedPane1.addTab("Add Nurse", jPanel5);

        jPanel9.setBackground(new java.awt.Color(204, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Delete Nurse");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabelHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Receptionist/home.jpg"))); // NOI18N
        jLabelHome1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHome1MouseClicked(evt);
            }
        });
        jPanel10.add(jLabelHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 90, 60));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Home");
        jPanel10.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 70, -1, -1));

        Logo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nurse/nurse.png"))); // NOI18N
        jPanel10.add(Logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 120, 110));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 94));

        jLabel22.setBackground(new java.awt.Color(204, 204, 255));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 153));
        jLabel22.setText("Address:");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, -1, -1));

        jLabel24.setBackground(new java.awt.Color(204, 204, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 153));
        jLabel24.setText("Nurse ID:");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel27.setBackground(new java.awt.Color(204, 204, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 153));
        jLabel27.setText("Last Name:");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));

        jLabel28.setBackground(new java.awt.Color(204, 204, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 153));
        jLabel28.setText("Sex:");
        jPanel9.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jLabel32.setBackground(new java.awt.Color(204, 204, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 153));
        jLabel32.setText("B-date:");
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jLabel33.setBackground(new java.awt.Color(204, 204, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 153, 153));
        jLabel33.setText("Marital Status:");
        jPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, 20));

        txtAddress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress1ActionPerformed(evt);
            }
        });
        jPanel9.add(txtAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 690, 40));

        txtLname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLname1ActionPerformed(evt);
            }
        });
        jPanel9.add(txtLname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 240, 40));
        jPanel9.add(txtBdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 240, 40));

        txtSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch1ActionPerformed(evt);
            }
        });
        jPanel9.add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 200, 30));

        jLabel34.setBackground(new java.awt.Color(204, 204, 255));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 153, 153));
        jLabel34.setText("Phone:");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));
        jPanel9.add(txtContract1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 240, 40));

        jLabel35.setBackground(new java.awt.Color(204, 204, 255));
        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 153, 153));
        jLabel35.setText("Contract No.:");
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));
        jPanel9.add(txtPhone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 240, 40));

        rdoMale1.setBackground(new java.awt.Color(51, 255, 153));
        buttonGroup1.add(rdoMale1);
        rdoMale1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoMale1.setForeground(new java.awt.Color(0, 102, 102));
        rdoMale1.setText("Male");
        rdoMale1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMale1ActionPerformed(evt);
            }
        });
        jPanel9.add(rdoMale1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        rdoFemale1.setBackground(new java.awt.Color(51, 255, 153));
        buttonGroup1.add(rdoFemale1);
        rdoFemale1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoFemale1.setForeground(new java.awt.Color(0, 102, 102));
        rdoFemale1.setText("Female");
        jPanel9.add(rdoFemale1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        cmboStatus1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmboStatus1.setForeground(new java.awt.Color(0, 153, 153));
        cmboStatus1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Single", "Married", "Divorced", "Widow" }));
        jPanel9.add(cmboStatus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 240, 40));
        jPanel9.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1450, 10));

        jPanel11.setBackground(new java.awt.Color(51, 255, 153));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 240, 40));

        btnDelete1.setBackground(new java.awt.Color(0, 153, 153));
        btnDelete1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete1.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel9.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 520, 120, 30));

        lblNurse1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nurse/nurse.png"))); // NOI18N
        jPanel9.add(lblNurse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 220, -1, -1));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 204), new java.awt.Color(0, 204, 204)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 210, 200, 210));

        btnSearch1.setBackground(new java.awt.Color(0, 153, 153));
        btnSearch1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setText("Search");
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });
        jPanel9.add(btnSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 110, 30));
        jPanel9.add(txtEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, 240, 40));

        jLabel37.setBackground(new java.awt.Color(204, 204, 255));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 153, 153));
        jLabel37.setText("Email:");
        jPanel9.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, -1, -1));
        jPanel9.add(txtFname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 240, 40));

        jLabel38.setBackground(new java.awt.Color(204, 204, 255));
        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 153, 153));
        jLabel38.setText("First Name:");
        jPanel9.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        btnClear1.setBackground(new java.awt.Color(0, 153, 153));
        btnClear1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear1.setForeground(new java.awt.Color(255, 255, 255));
        btnClear1.setText("Clear");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });
        jPanel9.add(btnClear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 520, 110, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1544, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Delete Nurse", jPanel1);

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Update Nurse");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabelHome2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Receptionist/home.jpg"))); // NOI18N
        jLabelHome2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHome2MouseClicked(evt);
            }
        });
        jPanel14.add(jLabelHome2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 90, 60));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Home");
        jPanel14.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 70, -1, -1));

        Logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nurse/nurse.png"))); // NOI18N
        jPanel14.add(Logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 120, 110));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 94));

        jLabel40.setBackground(new java.awt.Color(204, 204, 255));
        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 153, 153));
        jLabel40.setText("Address:");
        jPanel13.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, -1, -1));

        jLabel41.setBackground(new java.awt.Color(204, 204, 255));
        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 153, 153));
        jLabel41.setText("Nurse ID:");
        jPanel13.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel42.setBackground(new java.awt.Color(204, 204, 255));
        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 153, 153));
        jLabel42.setText("Last Name:");
        jPanel13.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));

        jLabel43.setBackground(new java.awt.Color(204, 204, 255));
        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 153, 153));
        jLabel43.setText("Sex:");
        jPanel13.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jLabel44.setBackground(new java.awt.Color(204, 204, 255));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 153, 153));
        jLabel44.setText("B-date:");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jLabel45.setBackground(new java.awt.Color(204, 204, 255));
        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 153, 153));
        jLabel45.setText("Marital Status:");
        jPanel13.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, -1, 20));

        txtAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddress2ActionPerformed(evt);
            }
        });
        jPanel13.add(txtAddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 690, 40));

        txtLname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLname2ActionPerformed(evt);
            }
        });
        jPanel13.add(txtLname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 270, 240, 40));
        jPanel13.add(txtBdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 240, 40));

        txtSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearch2ActionPerformed(evt);
            }
        });
        jPanel13.add(txtSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 200, 30));

        jLabel46.setBackground(new java.awt.Color(204, 204, 255));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 153, 153));
        jLabel46.setText("Phone:");
        jPanel13.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));
        jPanel13.add(txtContract2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 240, 40));

        jLabel47.setBackground(new java.awt.Color(204, 204, 255));
        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 153, 153));
        jLabel47.setText("Contract No.:");
        jPanel13.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, -1, -1));
        jPanel13.add(txtPhone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 330, 240, 40));

        rdoMale2.setBackground(new java.awt.Color(51, 255, 153));
        buttonGroup1.add(rdoMale2);
        rdoMale2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoMale2.setForeground(new java.awt.Color(0, 102, 102));
        rdoMale2.setText("Male");
        rdoMale2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMale2ActionPerformed(evt);
            }
        });
        jPanel13.add(rdoMale2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        rdoFemale2.setBackground(new java.awt.Color(51, 255, 153));
        buttonGroup1.add(rdoFemale2);
        rdoFemale2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoFemale2.setForeground(new java.awt.Color(0, 102, 102));
        rdoFemale2.setText("Female");
        jPanel13.add(rdoFemale2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, -1, -1));

        cmboStatus2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmboStatus2.setForeground(new java.awt.Color(0, 153, 153));
        cmboStatus2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Single", "Married", "Divorced", "Widow" }));
        jPanel13.add(cmboStatus2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 240, 40));
        jPanel13.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1450, 10));

        jPanel15.setBackground(new java.awt.Color(51, 255, 153));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 240, 40));

        btnUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel13.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 520, 120, 30));

        lbl_image2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nurse/nurse.png"))); // NOI18N
        jPanel13.add(lbl_image2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 220, -1, -1));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 204), new java.awt.Color(0, 204, 204)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel13.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 210, 200, 210));

        btnSearch2.setBackground(new java.awt.Color(0, 153, 153));
        btnSearch2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setText("Search");
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });
        jPanel13.add(btnSearch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 110, 30));
        jPanel13.add(txtEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 240, 40));

        jLabel49.setBackground(new java.awt.Color(204, 204, 255));
        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 153, 153));
        jLabel49.setText("Email:");
        jPanel13.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        txtFname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFname2ActionPerformed(evt);
            }
        });
        jPanel13.add(txtFname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 240, 40));

        jLabel50.setBackground(new java.awt.Color(204, 204, 255));
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 153, 153));
        jLabel50.setText("First Name:");
        jPanel13.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        btnClear2.setBackground(new java.awt.Color(0, 153, 153));
        btnClear2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear2.setForeground(new java.awt.Color(255, 255, 255));
        btnClear2.setText("Clear");
        btnClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear2ActionPerformed(evt);
            }
        });
        jPanel13.add(btnClear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 520, 110, 30));
        jPanel13.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 240, 30));

        jLabel51.setBackground(new java.awt.Color(204, 204, 255));
        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 153, 153));
        jLabel51.setText("DateEmployed:");
        jPanel13.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 510, -1, 20));

        btn_ImageUpdate.setBackground(new java.awt.Color(0, 153, 153));
        btn_ImageUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ImageUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btn_ImageUpdate.setText("Choose Image");
        btn_ImageUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImageUpdateActionPerformed(evt);
            }
        });
        jPanel13.add(btn_ImageUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 420, 200, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1544, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 1544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Update Nurse", jPanel2);

        jPanel17.setBackground(new java.awt.Color(204, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(0, 204, 204));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("View Nurses");
        jPanel18.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabelHome3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Receptionist/home.jpg"))); // NOI18N
        jLabelHome3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHome3MouseClicked(evt);
            }
        });
        jPanel18.add(jLabelHome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, 90, 60));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Home");
        jPanel18.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 70, -1, -1));

        Logo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Nurse/nurse.png"))); // NOI18N
        jPanel18.add(Logo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 120, 110));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 94));

        tblRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblRecords);

        jPanel17.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 167, 1310, 430));

        btnRefresh.setBackground(new java.awt.Color(0, 153, 153));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel17.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 120, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1544, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 1544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("View Nurses", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Date)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 166, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Date)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseClicked
        // TODO add your handling code here:
        new AdminPortal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHomeMouseClicked

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void rdoMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoMaleActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtFname.setText("");
        txtLname.setText("");
        buttonGroup1.clearSelection();
        txtBdate.setText("");
        cmboStatus.getModel().setSelectedItem("Select");
        txtAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtContract.setText("");
        
        ImageIcon ad = new ImageIcon(getClass().getResource("nurse.png"));
        Image image = ad.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        lbl_image.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (checkInputs() && ImgPath != null) {
            try {
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO nurse(Fname, Lname, Sex, Bdate, Address, Phone, Status, Email, ContractNO, DEmployed, image)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, txtFname.getText());
                ps.setString(2, txtLname.getText());
                String sex = "";
                if (rdoMale.isSelected()) {
                    sex = "Male";
                }
                if (rdoFemale.isSelected()) {
                    sex = "Female";
                }
                ps.setString(3, sex);
                ps.setString(4, txtBdate.getText());
                ps.setString(5, txtAddress.getText());
                String status = "";
                if (cmboStatus.getSelectedItem().equals("Single")) {
                    status = "Single";
                }
                if (cmboStatus.getSelectedItem().equals("Married")) {
                    status = "Married";
                }
                if (cmboStatus.getSelectedItem().equals("Divorced")) {
                    status = "Divorced";
                }
                if (cmboStatus.getSelectedItem().equals("Widow")) {
                    status = "Widow";
                }
                ps.setString(6, txtPhone.getText());
                ps.setString(8, txtEmail.getText());
                ps.setString(7, status);
                ps.setString(9, txtContract.getText());
                ps.setString(10, Date.getText());

                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(11, img);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "New nurse added!");
            } catch (SQLException | FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are empty");
        }

        btnClear.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jLabelHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHome1MouseClicked
        // TODO add your handling code here:
        new AdminPortal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHome1MouseClicked

    private void txtAddress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress1ActionPerformed

    private void txtLname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLname1ActionPerformed

    private void txtSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1ActionPerformed

    private void rdoMale1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMale1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoMale1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        
        if(!txtSearch1.getText().equals("")){
            try{
                Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM nurse WHERE NurseID = ?");
                int id = Integer.parseInt(txtSearch1.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Nurse Deleted");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Nurse not deleted"+ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nurse not deleted : No ID to delete");
        }
        
        
//        String id = txtSearch1.getText();
//        Nurse2 n = new Nurse2();
//        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete a Nurse?", "Hospital Management System", JOptionPane.YES_NO_OPTION);
//        if (p == 0) {
//            n.deleteRecord(id);
//            JOptionPane.showMessageDialog(null, "Successfully deleted!");
//        }
//
//        txtSearch1.setText("");
//        txtFname1.setText("");
//        txtLname1.setText("");
//        buttonGroup1.clearSelection();
//        txtBdate1.setText("");
//        cmboStatus1.getModel().setSelectedItem("Select");
//        txtAddress1.setText("");
//        txtPhone1.setText("");
//        txtEmail1.setText("");
//        txtContract1.setText("");
        
        ImageIcon ad = new ImageIcon(getClass().getResource("nurse.png"));
        Image image = ad.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        lblNurse1.setIcon(new ImageIcon(image));
        
        txtSearch1.setText("");
        txtFname1.setText("");
        txtLname1.setText("");
        buttonGroup1.clearSelection();
        txtBdate1.setText("");
        cmboStatus1.getModel().setSelectedItem("Select");
        txtAddress1.setText("");
        txtPhone1.setText("");
        txtEmail1.setText("");
        txtContract1.setText("");

        btnDelete1.setEnabled(false);
        btnClear1.setEnabled(false);

    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
        
         
        String id = txtSearch1.getText();
        Nurse2 ad = new Nurse2();
        ResultSet res = ad.getInfo(id);

        try {
            res.beforeFirst();
            while (res.next()) {
                byte[] img = res.getBytes("image");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(lblNurse1.getWidth(),lblNurse1.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                lblNurse1.setIcon(newImage);
                
                txtSearch1.setText(res.getString("NurseID"));
                txtFname1.setText(res.getString("Fname"));
                txtLname1.setText(res.getString("Lname"));

                String sex = res.getString("Sex");
                if (sex.equals("Male")) {
                    rdoMale1.setSelected(true);
                } else if (sex.equals("Female")) {
                    rdoFemale1.setSelected(true);
                }

                txtBdate1.setText(res.getString("Bdate"));
                txtAddress1.setText(res.getString("Address"));
                txtPhone1.setText(res.getString("Phone"));

                String status = res.getString("Status");
                if (status.equals("Single")) {
                    cmboStatus1.getModel().setSelectedItem("Single");
                } else if (status.equals("Married")) {
                    cmboStatus1.getModel().setSelectedItem("Married");
                } else if (status.equals("Divorced")) {
                    cmboStatus1.getModel().setSelectedItem("Divorced");
                } else if (status.equals("Widow")) {
                    cmboStatus1.getModel().setSelectedItem("Widow");
                }

                txtEmail1.setText(res.getString("Email"));
                txtContract1.setText(res.getString("ContractNo"));
                Date.setText(res.getString("DEmployed"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Id does not exist!"+ex);
        }

        btnDelete1.setEnabled(true);
        btnClear1.setEnabled(true);

    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        // TODO add your handling code here:
        txtSearch1.setText("");
        txtFname1.setText("");
        txtLname1.setText("");
        buttonGroup1.clearSelection();
        txtBdate1.setText("");
        cmboStatus1.getModel().setSelectedItem("Select");
        txtAddress1.setText("");
        txtPhone1.setText("");
        txtEmail1.setText("");
        txtContract1.setText("");
        
        ImageIcon ad = new ImageIcon(getClass().getResource("nurse.png"));
        Image image = ad.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        lblNurse1.setIcon(new ImageIcon(image));

        btnClear1.setEnabled(false);
        btnDelete1.setEnabled(false);
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void jLabelHome2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHome2MouseClicked
        // TODO add your handling code here:
        AdminPortal ap = new AdminPortal();
        ap.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHome2MouseClicked

    private void txtAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddress2ActionPerformed

    private void txtLname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLname2ActionPerformed

    private void txtSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch2ActionPerformed

    private void rdoMale2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMale2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoMale2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

//        if (checkInputs() && txtSearch2.getText() != null) {
//            String UpdateQuery = null;
//            PreparedStatement ps = null;
//            Connection con = getConnection();
//
//            //update without image
//            if (ImgPath == null) {
//                try {
//                    UpdateQuery = "UPDATE nurse SET Fname = ?, Lname = ?, Sex = ?, Bdate = ?"
//                            + ", Address = ?, Phone = ?, Status = ?, Email = ?, ContractNO = ?"
//                            + ", DEmployed = ? WHERE NurseID = ?";
//                    ps = con.prepareStatement(UpdateQuery);
//
//                    ps.setString(1, txtFname.getText());
//                    ps.setString(2, txtLname.getText());
//                    String sex = "";
//                    if (rdoMale.isSelected()) {
//                        sex = "Male";
//                    }
//                    if (rdoFemale.isSelected()) {
//                        sex = "Female";
//                    }
//                    ps.setString(3, sex);
//                    ps.setString(4, txtBdate.getText());
//                    ps.setString(5, txtAddress.getText());
//                    String status = "";
//                    if (cmboStatus.getSelectedItem().equals("Single")) {
//                        status = "single";
//                    }
//                    if (cmboStatus.getSelectedItem().equals("Married")) {
//                        status = "married";
//                    }
//                    if (cmboStatus.getSelectedItem().equals("Divorced")) {
//                        status = "divorced";
//                    }
//                    if (cmboStatus.getSelectedItem().equals("Widow")) {
//                        status = "widow";
//                    }
//                    ps.setString(6, txtPhone.getText());
//                    ps.setString(8, txtEmail.getText());
//                    ps.setString(7, status);
//                    ps.setString(9, txtContract.getText());
//                    ps.setString(10, Date.getText());
//
//                    ps.setInt(11, Integer.parseInt(txtSearch2.getText()));
//
//                    ps.executeUpdate();
//                    
//                } catch (SQLException ex) {
//                    Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            //update with image
//            else{
//                try{
//                InputStream img = new FileInputStream(new File(ImgPath));
//                
//                UpdateQuery = "UPDATE nurse SET Fname = ?, Lname = ?, Sex = ?, Bdate = ?"
//                            + ", Address = ?, Phone = ?, Status = ?, Email = ?, ContractNO = ?"
//                            + ", DEmployed = ? WHERE NurseID = ?";
//                ps = con.prepareStatement(UpdateQuery);
//
//                    ps.setString(1, txtFname.getText());
//                    ps.setString(2, txtLname.getText());
//                    String sex = "";
//                    if (rdoMale.isSelected()) {
//                        sex = "Male";
//                    }
//                    if (rdoFemale.isSelected()) {
//                        sex = "Female";
//                    }
//                    ps.setString(3, sex);
//                    ps.setString(4, txtBdate.getText());
//                    ps.setString(5, txtAddress.getText());
//                    String status = "";
//                    if (cmboStatus.getSelectedItem().equals("Single")) {
//                        status = "single";
//                    }
//                    if (cmboStatus.getSelectedItem().equals("Married")) {
//                        status = "married";
//                    }
//                    if (cmboStatus.getSelectedItem().equals("Divorced")) {
//                        status = "divorced";
//                    }
//                    if (cmboStatus.getSelectedItem().equals("Widow")) {
//                        status = "widow";
//                    }
//                    ps.setString(6, txtPhone.getText());
//                    ps.setString(8, txtEmail.getText());
//                    ps.setString(7, status);
//                    ps.setString(9, txtContract.getText());
//                    ps.setString(10, Date.getText());
//
//                    ps.setBlob(11, img);
//                    
//                    ps.setInt(12, Integer.parseInt(txtSearch2.getText()));
//                    
//                    ps.executeUpdate();
//                    
//                }catch(Exception ex){
//                    JOptionPane.showMessageDialog(null, ex.getMessage());
//                }
//            }
//        }else{
//            JOptionPane.showMessageDialog(null, "Öne or more fields are empty or wrong");
//        }
        
        

        String fname = txtFname2.getText();
        String lname = txtLname2.getText();

        String sex = "";
        if (rdoMale2.isSelected()) {
            sex = "Male";
        }
        if (rdoFemale2.isSelected()) {
            sex = "Female";
        }

        String bdate = txtBdate2.getText();
        String address = txtAddress2.getText();
        //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
        //String bdate = dateformat.format(Bdate.getText()/*getDate()*/);

        String phone = txtPhone2.getText();

        String status = "";
        if (cmboStatus2.getSelectedItem().equals("Single")) {
            status = "Single";
        }
        if (cmboStatus2.getSelectedItem().equals("Married")) {
            status = "Married";
        }
        if (cmboStatus2.getSelectedItem().equals("Divorced")) {
            status = "Divorced";
        }
        if (cmboStatus2.getSelectedItem().equals("Widow")) {
            status = "Widow";
        }

        String email = txtEmail2.getText();
        String contract = txtContract2.getText();
        String date = txtDate.getText();
        if(ImgPath != null){
            try {
                InputStream img = new FileInputStream(ImgPath);
                String UpdateQuery = "UPDATE nurse SET image = ? WHERE NurseID = ?";
                int id = Integer.parseInt(txtSearch2.getText());
                PreparedStatement ps = getConnection().prepareStatement(UpdateQuery);
                ps.setBlob(1, img);
                ps.setInt(2, id);
                if(ps.executeUpdate() == 1){
                    JOptionPane.showMessageDialog(null,"Image Updsted");
                }
                else{
                    JOptionPane.showMessageDialog(null,"No Image exist with this id");
                }
            } catch (FileNotFoundException | SQLException ex) {
                Logger.getLogger(Nurse.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Nurse2 n = new Nurse2();
        if (n.updateInfo(fname, lname, sex, bdate, address, phone, status, email, contract, date)) {
            JOptionPane.showMessageDialog(null, "Successfully updated the record!");
        }
        
        
        
       

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        // TODO add your handling code here:
        String id = txtSearch2.getText();
        Nurse2 ad = new Nurse2();
        ResultSet res = ad.getInfo(id);

        try {
            res.beforeFirst();
            while (res.next()) {
                byte[] img = res.getBytes("image");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(lblNurse1.getWidth(),lblNurse1.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                lbl_image2.setIcon(newImage);
                
                txtSearch2.setText(res.getString("NurseID"));
                txtFname2.setText(res.getString("Fname"));
                txtLname2.setText(res.getString("Lname"));

                String sex = res.getString("Sex");
                if (sex.equals("Male")) {
                    rdoMale2.setSelected(true);
                } else if (sex.equals("Female")) {
                    rdoFemale2.setSelected(true);
                }

                txtBdate2.setText(res.getString("Bdate"));
                txtAddress2.setText(res.getString("Address"));
                txtPhone2.setText(res.getString("Phone"));

                String status = res.getString("Status");
                if (status.equals("Single")) {
                    cmboStatus2.getModel().setSelectedItem("Single");
                } else if (status.equals("Married")) {
                    cmboStatus2.getModel().setSelectedItem("Married");
                } else if (status.equals("Divorced")) {
                    cmboStatus2.getModel().setSelectedItem("Divorced");
                } else if (status.equals("Widow")) {
                    cmboStatus2.getModel().setSelectedItem("Widow");
                }

                txtEmail2.setText(res.getString("Email"));
                txtContract2.setText(res.getString("ContractNo"));
                txtDate.setText(res.getString("DEmployed"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Id does not exist!");
        }
        btnClear2.setEnabled(true);
        btnUpdate.setEnabled(true);

    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear2ActionPerformed
        // TODO add your handling code here:
        txtSearch2.setText("");
        txtFname2.setText("");
        txtLname2.setText("");
        buttonGroup1.clearSelection();
        txtBdate2.setText("");
        cmboStatus2.getModel().setSelectedItem("Select");
        txtAddress2.setText("");
        txtPhone2.setText("");
        txtEmail2.setText("");
        txtContract2.setText("");
        txtDate.setText("");

        btnClear2.setEnabled(false);
        btnUpdate.setEnabled(false);

    }//GEN-LAST:event_btnClear2ActionPerformed

    private void txtFname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFname2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFname2ActionPerformed

    private void jLabelHome3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHome3MouseClicked
        // TODO add your handling code here:
        new AdminPortal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHome3MouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        //for refreshing data from table in Mysql
        
        populateJTable();
        
//        DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
//        model.setRowCount(0);
//
//        Nurse2 n = new Nurse2();
//        ResultSet res = null;
//        try {
//            res = n.getAll();
//            res.beforeFirst();
//            while (res.next()) {
//                model.addRow(new Object[]{Integer.parseInt(res.getString(1)), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11)});
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Cannot display" + e.toString());
//        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtBdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBdateMouseClicked
        // TODO add your handling code here:
        txtBdate.setText("");
    }//GEN-LAST:event_txtBdateMouseClicked

    private void btn_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImageActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image.setIcon(ResizeImage(path, null));
            ImgPath = path;
        } else {
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
    }//GEN-LAST:event_btn_ImageActionPerformed

    private void btn_ImageUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImageUpdateActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_image2.setIcon(ResizeImage(path, null));
            ImgPath = path;
        } else {
            JOptionPane.showMessageDialog(null, "No File Selected!");
        }
        
        
    }//GEN-LAST:event_btn_ImageUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nurse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Logo1;
    private javax.swing.JLabel Logo2;
    private javax.swing.JLabel Logo3;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnClear2;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_Image;
    private javax.swing.JButton btn_ImageUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmboStatus;
    private javax.swing.JComboBox cmboStatus1;
    private javax.swing.JComboBox cmboStatus2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelHome1;
    private javax.swing.JLabel jLabelHome2;
    private javax.swing.JLabel jLabelHome3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNurse1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_image2;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoFemale1;
    private javax.swing.JRadioButton rdoFemale2;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JRadioButton rdoMale1;
    private javax.swing.JRadioButton rdoMale2;
    private javax.swing.JTable tblRecords;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtBdate;
    private javax.swing.JTextField txtBdate1;
    private javax.swing.JTextField txtBdate2;
    private javax.swing.JTextField txtContract;
    private javax.swing.JTextField txtContract1;
    private javax.swing.JTextField txtContract2;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtFname1;
    private javax.swing.JTextField txtFname2;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtLname1;
    private javax.swing.JTextField txtLname2;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhone1;
    private javax.swing.JTextField txtPhone2;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    // End of variables declaration//GEN-END:variables
}

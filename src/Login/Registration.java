/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import PatientsInfo.Home;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Registration extends javax.swing.JFrame {

    private JFrame frame;

    /**
     * Creates new form Registration
     */
    public Registration() {
        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        showDate();
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Date.setText(s.format(d));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtUname = new javax.swing.JTextField();
        btnRegDoctor = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btnRegAdmin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFname1 = new javax.swing.JTextField();
        txtLname1 = new javax.swing.JTextField();
        txtUname1 = new javax.swing.JTextField();
        btnRegister2 = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        jLabelLogin1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        Age1 = new javax.swing.JFormattedTextField();
        btnRegister3 = new javax.swing.JButton();
        btnRegReceptionist = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtBdate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        cmboStatus = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rdoFemale = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        txtContract = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPhone = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Personal Information Registration");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(190, 20, 570, 40);

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 950, 80));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Last Name:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(90, 120, 78, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Username:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(510, 70, 74, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(510, 120, 72, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("BirthDate:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(90, 260, 80, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("First Name:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(90, 70, 79, 17);

        txtFname.setBackground(new java.awt.Color(204, 255, 255));
        txtFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFnameActionPerformed(evt);
            }
        });
        jPanel2.add(txtFname);
        txtFname.setBounds(210, 60, 230, 30);

        txtLname.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.add(txtLname);
        txtLname.setBounds(210, 110, 230, 30);

        txtUname.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.add(txtUname);
        txtUname.setBounds(640, 60, 230, 30);

        btnRegDoctor.setBackground(new java.awt.Color(0, 153, 153));
        btnRegDoctor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegDoctor.setForeground(new java.awt.Color(255, 255, 255));
        btnRegDoctor.setText("Register as Doctor");
        btnRegDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegDoctorActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegDoctor);
        btnRegDoctor.setBounds(230, 490, 200, 30);

        btnExit.setBackground(new java.awt.Color(204, 0, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit);
        btnExit.setBounds(740, 420, 100, 30);

        jPasswordField.setBackground(new java.awt.Color(204, 255, 255));
        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordField);
        jPasswordField.setBounds(640, 110, 230, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Contract No.:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(510, 260, 110, 17);

        btnRegAdmin.setBackground(new java.awt.Color(0, 153, 153));
        btnRegAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegAdmin.setForeground(new java.awt.Color(255, 255, 255));
        btnRegAdmin.setText("Register as Admin");
        btnRegAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegAdminActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegAdmin);
        btnRegAdmin.setBounds(230, 390, 200, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Last Name:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(40, 130, 78, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Username:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(40, 180, 74, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Password:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(40, 230, 72, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Age:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(40, 280, 32, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("First Name:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(40, 80, 79, 17);

        txtFname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFname1ActionPerformed(evt);
            }
        });
        jPanel3.add(txtFname1);
        txtFname1.setBounds(150, 70, 230, 30);
        jPanel3.add(txtLname1);
        txtLname1.setBounds(150, 120, 230, 30);
        jPanel3.add(txtUname1);
        txtUname1.setBounds(150, 170, 230, 30);

        btnRegister2.setBackground(new java.awt.Color(0, 255, 0));
        btnRegister2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegister2.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister2.setText("Register");
        btnRegister2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegister2ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegister2);
        btnRegister2.setBounds(200, 360, 140, 30);

        btnExit1.setBackground(new java.awt.Color(204, 0, 0));
        btnExit1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit1.setForeground(new java.awt.Color(255, 255, 255));
        btnExit1.setText("Exit");
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnExit1);
        btnExit1.setBounds(300, 430, 90, 30);

        jLabelLogin1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelLogin1.setText("click here to Login");
        jLabelLogin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogin1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabelLogin1);
        jLabelLogin1.setBounds(110, 440, 130, 17);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jPasswordField1);
        jPasswordField1.setBounds(150, 220, 230, 30);
        jPanel3.add(Age1);
        Age1.setBounds(150, 270, 230, 30);

        btnRegister3.setBackground(new java.awt.Color(0, 255, 0));
        btnRegister3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegister3.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister3.setText("Register");
        btnRegister3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegister3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegister3);
        btnRegister3.setBounds(200, 320, 140, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 0, 0);

        btnRegReceptionist.setBackground(new java.awt.Color(0, 153, 153));
        btnRegReceptionist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegReceptionist.setForeground(new java.awt.Color(255, 255, 255));
        btnRegReceptionist.setText("Register as Receptionist");
        btnRegReceptionist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegReceptionistActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegReceptionist);
        btnRegReceptionist.setBounds(230, 440, 200, 30);

        txtAddress.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.add(txtAddress);
        txtAddress.setBounds(210, 310, 660, 30);

        txtEmail.setBackground(new java.awt.Color(204, 255, 255));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel2.add(txtEmail);
        txtEmail.setBounds(210, 210, 230, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Email:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(90, 220, 41, 17);

        txtBdate.setBackground(new java.awt.Color(204, 255, 255));
        txtBdate.setText("MM-dd-yyyy");
        txtBdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBdateMouseClicked(evt);
            }
        });
        jPanel2.add(txtBdate);
        txtBdate.setBounds(210, 260, 230, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Address:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(90, 310, 61, 17);

        btnClear.setBackground(new java.awt.Color(255, 51, 0));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear);
        btnClear.setBounds(600, 420, 100, 30);

        cmboStatus.setBackground(new java.awt.Color(153, 255, 255));
        cmboStatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmboStatus.setForeground(new java.awt.Color(0, 153, 153));
        cmboStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select...", "Single", "Married", "Divorced", "Widow" }));
        jPanel2.add(cmboStatus);
        cmboStatus.setBounds(640, 160, 230, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Sex:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(90, 170, 40, 17);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Civil Status:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(510, 170, 90, 17);

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rdoFemale.setBackground(new java.awt.Color(153, 255, 255));
        buttonGroup1.add(rdoFemale);
        rdoFemale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoFemale.setForeground(new java.awt.Color(0, 102, 102));
        rdoFemale.setText("Female");
        rdoFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFemaleActionPerformed(evt);
            }
        });
        jPanel5.add(rdoFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, -1));

        rdoMale.setBackground(new java.awt.Color(153, 255, 255));
        buttonGroup1.add(rdoMale);
        rdoMale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoMale.setForeground(new java.awt.Color(0, 102, 102));
        rdoMale.setText("Male");
        jPanel5.add(rdoMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        jPanel2.add(jPanel5);
        jPanel5.setBounds(210, 160, 230, 40);

        txtContract.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.add(txtContract);
        txtContract.setBounds(640, 260, 230, 30);

        btnLogin.setBackground(new java.awt.Color(0, 153, 153));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin);
        btnLogin.setBounds(670, 480, 110, 30);

        txtPhone.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.add(txtPhone);
        txtPhone.setBounds(640, 210, 230, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Phone No.:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(510, 210, 110, 17);

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 950, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1410, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Date)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Date)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegDoctorActionPerformed
        // for Doctor Registration
        String fname = txtFname.getText();
        String lname = txtLname.getText();

        String sex = "";
        if (rdoMale.isSelected()) {
            sex = "Male";
        }
        if (rdoFemale.isSelected()) {
            sex = "Female";
        }

        String bdate = txtBdate.getText();
        String address = txtAddress.getText();
        String uname = txtUname.getText();
        String pass = String.valueOf(jPasswordField.getPassword());
        //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
        //String bdate = dateformat.format(Bdate.getText()/*getDate()*/);

        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String date = Date.getText();
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

        String contract = txtContract.getText();

        PreparedStatement ps;
        String query = "INSERT INTO `doc_registration`(`u_fname`, `u_lname`, `u_sex`, `u_bdate`, `u_address`,`u_username`, `u_pass`, `u_phone`, `u_status`,`u_email`, `u_contract`, `u_dregistered`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, sex);
            ps.setString(4, bdate);
            ps.setString(5, address);
            ps.setString(6, uname);
            ps.setString(7, pass);
            ps.setString(8, phone);
            ps.setString(9, status);
            ps.setString(10, email);
            ps.setString(11, contract);
            ps.setString(12, date);

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your First Name!");
            } else if (lname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Last Name!");
            } else if (sex.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your sex!");
            } else if (bdate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your birth date!");
            } else if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your Address!");
            } else if (uname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username!");
            } else if (checkDocUsername(uname)) {
                JOptionPane.showMessageDialog(null, "A Doctor is already using this username!\n Please try another one.");
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter password!");
            } else if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter phone number!");
            } else if (status.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your status!");
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your email!");
            } else if (contract.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter contract no.!");
            } else if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Registered sucessfully as Doctor!");
            } else {
                JOptionPane.showMessageDialog(null, "Cannot save:(");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegDoctorActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        frame = new JFrame();
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Registration Form",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldActionPerformed

    private void txtFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFnameActionPerformed

    private void btnRegAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAdminActionPerformed
        // for Admin Registration
        String fname = txtFname.getText();
        String lname = txtLname.getText();

        String sex = "";
        if (rdoMale.isSelected()) {
            sex = "Male";
        }
        if (rdoFemale.isSelected()) {
            sex = "Female";
        }

        String bdate = txtBdate.getText();
        String address = txtAddress.getText();
        String uname = txtUname.getText();
        String pass = String.valueOf(jPasswordField.getPassword());
        //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
        //String bdate = dateformat.format(Bdate.getText()/*getDate()*/);

        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String date = Date.getText();
        
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

        String contract = txtContract.getText();

        PreparedStatement ps;
        String query = "INSERT INTO `admin_registration`(`u_fname`, `u_lname`, `u_sex`, `u_bdate`, `u_address`,`u_username`, `u_pass`, `u_phone`, `u_status`, `u_email`, `u_contract`, `u_dregistered`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, sex);
            ps.setString(4, bdate);
            ps.setString(5, address);
            ps.setString(6, uname);
            ps.setString(7, pass);
            ps.setString(8, phone);
            ps.setString(9, status);
            ps.setString(10, email);
            ps.setString(11, contract);
            ps.setString(12, date);

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your First Name!");
            } else if (lname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Last Name!");
            } else if (sex.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your sex!");
            } else if (bdate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your birth date!");
            } else if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your Address!");
            } else if (uname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username!");
            } else if (checkUsername(uname)) {
                JOptionPane.showMessageDialog(null, "An Admin is already using this username!\n Please try another one.");
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter password!");
            } else if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter phone number!");                
            } else if (status.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your status!");
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your email!");    
            } else if (contract.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter contract no.!");
            } else if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Registered sucessfully as Admin!");
            } else {
                JOptionPane.showMessageDialog(null, "Cannot save:(");
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_btnRegAdminActionPerformed

    private void txtFname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFname1ActionPerformed

    private void btnRegister2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegister2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegister2ActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void jLabelLogin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogin1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelLogin1MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void btnRegister3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegister3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegister3ActionPerformed

    private void btnRegReceptionistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegReceptionistActionPerformed
        // for Receptionist Registration
        String fname = txtFname.getText();
        String lname = txtLname.getText();

        String sex = "";
        if (rdoMale.isSelected()) {
            sex = "Male";
        }
        if (rdoFemale.isSelected()) {
            sex = "Female";
        }

        String bdate = txtBdate.getText();
        String address = txtAddress.getText();
        String uname = txtUname.getText();
        String pass = String.valueOf(jPasswordField.getPassword());
        //SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
        //String bdate = dateformat.format(Bdate.getText()/*getDate()*/);

        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String date = Date.getText();
        
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

        String contract = txtContract.getText();

        PreparedStatement ps;
        String query = "INSERT INTO `receptionist_registration`(`u_fname`, `u_lname`, `u_sex`, `u_bdate`, `u_address`,`u_username`, `u_pass`, `u_phone`, `u_status`, `u_email`, `u_contract`, `u_dregistered`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);

            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, sex);
            ps.setString(4, bdate);
            ps.setString(5, address);
            ps.setString(6, uname);
            ps.setString(7, pass);
            ps.setString(8, phone);
            ps.setString(9, status);
            ps.setString(10, email);
            ps.setString(11, contract);
            ps.setString(12, date);

            if (fname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your First Name!");
            } else if (lname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your Last Name!");
            } else if (sex.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter your sex!");
            } else if (bdate.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your birth date!");
            } else if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your Address!");
            } else if (uname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter username!");
            } else if (checkRecepUsername(uname)) {
                JOptionPane.showMessageDialog(null, "This Receptionists username already exist!\n Please try another one.");
            } else if (pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter password!");
            } else if (phone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter phone number!");                
            } else if (status.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your status!");
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your email!");    
            } else if (contract.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter contract no.!");
            } else if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Registered sucessfully as Receptionist!");
            } else {
                JOptionPane.showMessageDialog(null, "Cannot save:(");
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnRegReceptionistActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtFname.setText("");
        txtLname.setText("");
        buttonGroup1.clearSelection();
        txtBdate.setText("");
        txtAddress.setText("");
        txtUname.setText("");
        jPasswordField.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        cmboStatus.getModel().setSelectedItem("Select...");
        txtContract.setText("");

    }//GEN-LAST:event_btnClearActionPerformed

    private void rdoFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoFemaleActionPerformed

    private void txtBdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBdateMouseClicked
        // TODO add your handling code here:
        txtBdate.setText("");
    }//GEN-LAST:event_txtBdateMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        Home h = new Home();
        h.setVisible(true);
        dispose();
        /*String c = JOptionPane.showInputDialog(null, "Press 1: For Admin Login\n"
                + "Press 2: For Receptionist Login\n"
                + "Press 3: For Doctor Login");
        int choice = Integer.parseInt(c);
        switch (choice) {
            case 1:
                AdminLogin ad = new AdminLogin();
                ad.setVisible(true);
                dispose();
                break;
            case 2:
                ReceptionistLogin r = new ReceptionistLogin();
                r.setVisible(true);
                dispose();
                break;
            case 3:
                DoctorLogin d = new DoctorLogin();
                d.setVisible(true);
                dispose();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Wrong input!!");
                break;
        }*/
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    //function to check if the Admin already exist
    public boolean checkUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkuser = false;

        String query = "SELECT * FROM `admin_registration` WHERE `u_username` =?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {
                checkuser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkuser;
    }

    //function to check if the receptionist already exist
    public boolean checkRecepUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkuser = false;

        String query = "SELECT * FROM `receptionist_registration` WHERE `u_username` =?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {
                checkuser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkuser;
    }

    //function to check if the Doctor already exist
    public boolean checkDocUsername(String username) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkuser = false;

        String query = "SELECT * FROM `doc_registration` WHERE `u_username` =?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {
                checkuser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkuser;
    }

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField Age1;
    private javax.swing.JLabel Date;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegAdmin;
    private javax.swing.JButton btnRegDoctor;
    private javax.swing.JButton btnRegReceptionist;
    private javax.swing.JButton btnRegister2;
    private javax.swing.JButton btnRegister3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelLogin1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBdate;
    private javax.swing.JTextField txtContract;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtFname1;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtLname1;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUname;
    private javax.swing.JTextField txtUname1;
    // End of variables declaration//GEN-END:variables
}

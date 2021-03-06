/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReceptionistPortal;

import PatientsInfo.*;
import Login.MyConnection;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author kli ann
 */
public class AppointmentsR extends javax.swing.JFrame {

    /**
     * Creates new form Appointments
     */
    public AppointmentsR() {
        initComponents();
        ImageIcon ad = new ImageIcon(getClass().getResource("bd.jpg")); 
        Image image = ad.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        LogoAdd.setIcon(new ImageIcon(image) );
        LogoView.setIcon(new ImageIcon(image) );
        
        ImageIcon home = new ImageIcon(getClass().getResource("home.jpg")); 
        Image img = home.getImage().getScaledInstance(51, 57, Image.SCALE_SMOOTH);
        jLabelHome.setIcon(new ImageIcon(img) );
        jLabelHome1.setIcon(new ImageIcon(img) );
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        TableColumnModel tcm = tblRecords.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(3);
        tcm.getColumn(1).setPreferredWidth(3);
        tcm.getColumn(2).setPreferredWidth(30);
        tcm.getColumn(3).setPreferredWidth(20);
        tcm.getColumn(4).setPreferredWidth(20);
        tcm.getColumn(5).setPreferredWidth(10);
        tcm.getColumn(6).setPreferredWidth(10);
        
        //for displaying data from table in Mysql
        DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
        model.setRowCount(0);

        Appointments2 ap = new Appointments2();
        ResultSet res = null;
        try{
            res = ap.getAll();
            res.beforeFirst();
            while(res.next()){
                model.addRow(new Object[]{Integer.parseInt(res.getString(1)),Integer.parseInt(res.getString(2)),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Cannot display" + e.toString());
        }
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecords = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        LogoView = new javax.swing.JLabel();
        jLabelHome1 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        btRefresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rdoUrgent = new javax.swing.JRadioButton();
        rdoCheckup = new javax.swing.JRadioButton();
        rdoTherapy = new javax.swing.JRadioButton();
        cmbDoctor = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelHome = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LogoAdd = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        AppointmentID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbTime = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel14.setBackground(new java.awt.Color(204, 255, 255));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel14MousePressed(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AppointmentID", "PatientId", "FullName", "Doctor", "VisitNature", "Time", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblRecords.setGridColor(new java.awt.Color(255, 255, 255));
        tblRecords.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblRecordsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblRecords);

        jPanel14.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 1140, 500));

        jPanel15.setBackground(new java.awt.Color(0, 204, 204));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Appointments");
        jPanel15.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        LogoView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PatientsInfo/bd.jpg"))); // NOI18N
        jPanel15.add(LogoView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 90));

        jLabelHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PatientsInfo/home.jpg"))); // NOI18N
        jLabelHome1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHome1MouseClicked(evt);
            }
        });
        jPanel15.add(jLabelHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 90, 60));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Home");
        jPanel15.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 70, -1, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 90));

        btRefresh.setBackground(new java.awt.Color(0, 153, 153));
        btRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btRefresh.setText("Refresh");
        btRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshActionPerformed(evt);
            }
        });
        jPanel14.add(btRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 110, -1));

        jTabbedPane1.addTab("View Details", jPanel14);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        jPanel4.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 210, 30));

        btnClear.setBackground(new java.awt.Color(0, 153, 153));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel4.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 590, 90, 30));

        btnAdd.setBackground(new java.awt.Color(0, 153, 153));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("ADD");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 590, 90, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Full Name:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 90, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Patient Id:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, 20));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setText("LastName/ FirstName");
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        jPanel4.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 210, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText(" Date:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Doctor:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, -1, -1));

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        jPanel4.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 210, 30));

        jToolBar1.setRollover(true);
        jPanel4.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 570, 0, 10));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 153));
        jLabel15.setText("Visit Nature:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, -1, 20));

        jPanel5.setBackground(new java.awt.Color(0, 255, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rdoUrgent.setBackground(new java.awt.Color(0, 255, 102));
        buttonGroup1.add(rdoUrgent);
        rdoUrgent.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoUrgent.setForeground(new java.awt.Color(0, 102, 102));
        rdoUrgent.setText("Urgent");
        rdoUrgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoUrgentActionPerformed(evt);
            }
        });
        jPanel5.add(rdoUrgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));

        rdoCheckup.setBackground(new java.awt.Color(0, 255, 102));
        buttonGroup1.add(rdoCheckup);
        rdoCheckup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoCheckup.setForeground(new java.awt.Color(0, 102, 102));
        rdoCheckup.setText("Follow Up Check-up");
        rdoCheckup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCheckupActionPerformed(evt);
            }
        });
        jPanel5.add(rdoCheckup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        rdoTherapy.setBackground(new java.awt.Color(0, 255, 102));
        buttonGroup1.add(rdoTherapy);
        rdoTherapy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoTherapy.setForeground(new java.awt.Color(0, 102, 102));
        rdoTherapy.setText("Follow Up Therapy");
        rdoTherapy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTherapyActionPerformed(evt);
            }
        });
        jPanel5.add(rdoTherapy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 400, 210, 110));

        cmbDoctor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDoctor.setForeground(new java.awt.Color(0, 153, 153));
        cmbDoctor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Doctor...", "Janah Uy", "Ana Bas", "Peter Lim", "Liza Ybañes" }));
        cmbDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDoctorActionPerformed(evt);
            }
        });
        jPanel4.add(cmbDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 210, 30));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient Appointment");
        jPanel6.add(jLabel2);
        jLabel2.setBounds(150, 30, 340, 52);
        jPanel6.add(jSeparator2);
        jSeparator2.setBounds(0, -22, 1080, 2);

        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PatientsInfo/home.jpg"))); // NOI18N
        jLabelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseClicked(evt);
            }
        });
        jPanel6.add(jLabelHome);
        jLabelHome.setBounds(1230, 20, 70, 60);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Home");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(1230, 80, 60, 14);

        LogoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PatientsInfo/bd.jpg"))); // NOI18N
        jPanel6.add(LogoAdd);
        LogoAdd.setBounds(0, 10, 160, 90);

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1380, 100));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -18, -1, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PatientsInfo/patient.png"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 220, 210, 200));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 204, 204), null));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 210, 230, 220));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Appointment Id:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, 20));

        AppointmentID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AppointmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppointmentIDActionPerformed(evt);
            }
        });
        jPanel4.add(AppointmentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 210, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 153));
        jLabel17.setText("Time:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, -1, -1));

        cmbTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbTime.setForeground(new java.awt.Color(0, 153, 153));
        cmbTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Time", "8:00 A.M", "9:00 A.M", "10:00 A.M", "1:00 P.M", "2:00 P.M", "4:00 P.M" }));
        jPanel4.add(cmbTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 210, 30));

        jTabbedPane1.addTab("Appointment Registration", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1687, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        AppointmentID.setText("");
        txtId.setText("");
        txtName.setText("");
        txtDate.setText("");
        cmbTime.getModel().setSelectedItem("Select Time");
        cmbDoctor.getModel().setSelectedItem("Select Doctor");
        buttonGroup1.clearSelection();

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        String appid = AppointmentID.getText();
        String id = txtId.getText();
        String name = txtName.getText();

        String date = txtDate.getText();
        String time = "";
        if(cmbTime.getSelectedItem().equals("8:00 A.M")){
            time = "8:00 A.M";
        }
        if(cmbTime.getSelectedItem().equals("9:00 A.M")){
            time = "9:00 A.M";
        }
        if(cmbTime.getSelectedItem().equals("10:00 A.M")){
            time = "10:00 A.M";
        }
        if(cmbTime.getSelectedItem().equals("1:00 P.M")){
            time = "1:00 P.M";
        }
        if(cmbTime.getSelectedItem().equals("2:00 P.M")){
            time = "2:00 P.M";
        }
        if(cmbTime.getSelectedItem().equals("4:00 P.M")){
            time = "4:00 P.M";
        }
        
        String doctor = "";
        if(cmbDoctor.getSelectedItem().equals("Janah Uy")){
            doctor = "Janah Uy";
        }
        if(cmbDoctor.getSelectedItem().equals("Peter Lim")){
            doctor = "Peter Lim";
        }
        if(cmbDoctor.getSelectedItem().equals("Ana Bas")){
            doctor = "Ana Bas";
        }
        if(cmbDoctor.getSelectedItem().equals("Liza Ybañes")){
            doctor = "Liza Ybañes";
        }
        

        String visitn = "";
        if(rdoUrgent.isSelected()){
            visitn="Urgent";
        }
        if(rdoCheckup.isSelected()){
            visitn="Follow Up Therapy";
        }
        if(rdoCheckup.isSelected()){
            visitn="Follow Up Checkup";
        }


        Appointments2 reg = new Appointments2(appid,id,name,date,time,doctor,visitn);
        if(appid.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter appointment id");
        }
        else if (checkappId(appid)) {
            JOptionPane.showMessageDialog(null, "Patient ID already exist!\n Please try another one.");
        }
        else if(id.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter patient id");
        }
        else if (checkId(id)) {
            JOptionPane.showMessageDialog(null, "Patient ID already exist!\n Please try another one.");
        }
        else if(name.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter patient name");
        }
        else if(date.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter date");
        }
        else if(time.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please enter time");
        }
        else if(doctor.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please Choose a doctor");
        }
        else if(visitn.isEmpty()){
            JOptionPane.showMessageDialog(null,"Please choose the purpose of appointment");
        }
        else if(reg.addNew())
        JOptionPane.showMessageDialog(null,"New Appointment added!");
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        // TODO add your handling code here:
        txtName.setText("");
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void rdoCheckupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCheckupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoCheckupActionPerformed

    private void rdoUrgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoUrgentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoUrgentActionPerformed

    private void cmbDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDoctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDoctorActionPerformed

    private void jLabelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseClicked
        // TODO add your handling code here:
        ReceptionistModule rm = new ReceptionistModule();
        rm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHomeMouseClicked

    private void AppointmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppointmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AppointmentIDActionPerformed

    private void rdoTherapyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTherapyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoTherapyActionPerformed

    private void tblRecordsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRecordsMousePressed
        // code for clearing table
        /*DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
        model.setRowCount(0);*/
    }//GEN-LAST:event_tblRecordsMousePressed

    private void jLabelHome1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHome1MouseClicked
        // TODO add your handling code here:
        AdminPortal ap = new AdminPortal();
        ap.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabelHome1MouseClicked

    private void btRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshActionPerformed

        //for displaying data from table in Mysql
        DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
        model.setRowCount(0);
        
        Appointments2 a = new Appointments2();
        ResultSet res = null;
        try{
            res = a.getAll();
            res.beforeFirst();
            while(res.next()){
                model.addRow(new Object[]{Integer.parseInt(res.getString(1)),Integer.parseInt(res.getString(2)),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Cannot display" + e.toString());
        }
    }//GEN-LAST:event_btRefreshActionPerformed

    private void jPanel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MousePressed

//function to check if Patient Id already exist
    public boolean checkappId(String pid) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkuser = false;

        String query = "SELECT * FROM `appointments` WHERE `AppointmentID` =?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, pid);

            rs = ps.executeQuery();

            if (rs.next()) {
                checkuser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkuser;
    }    
    
    //function to check if Patient Id already exist
    public boolean checkId(String pid) {
        PreparedStatement ps;
        ResultSet rs;
        boolean checkuser = false;

        String query = "SELECT * FROM `appointments` WHERE `PatientId` =?";

        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, pid);

            rs = ps.executeQuery();

            if (rs.next()) {
                checkuser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InPatient.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(AppointmentsR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentsR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentsR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentsR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentsR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AppointmentID;
    private javax.swing.JLabel LogoAdd;
    private javax.swing.JLabel LogoView;
    private javax.swing.JButton btRefresh;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbDoctor;
    private javax.swing.JComboBox cmbTime;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelHome1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JRadioButton rdoCheckup;
    private javax.swing.JRadioButton rdoTherapy;
    private javax.swing.JRadioButton rdoUrgent;
    private javax.swing.JTable tblRecords;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}

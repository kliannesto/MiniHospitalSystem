/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientsInfo;

import java.awt.Frame;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author kli ann
 */
public class PrescriptionsRecord extends javax.swing.JFrame {

    /**
     * Creates new form PrescriptionsRecord
     */
    public PrescriptionsRecord() {
        initComponents();
        TableColumnModel tcm = tblRecords.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(20);
        tcm.getColumn(1).setPreferredWidth(90);
        tcm.getColumn(2).setPreferredWidth(5);
        tcm.getColumn(3).setPreferredWidth(10);
        tcm.getColumn(4).setPreferredWidth(100);
        tcm.getColumn(5).setPreferredWidth(30);
        tcm.getColumn(6).setPreferredWidth(30);
        tcm.getColumn(7).setPreferredWidth(20);
        tcm.getColumn(8).setPreferredWidth(60);
        tcm.getColumn(9).setPreferredWidth(70);
        tcm.getColumn(10).setPreferredWidth(20);
        tcm.getColumn(11).setPreferredWidth(80);
        tcm.getColumn(12).setPreferredWidth(30);
        tcm.getColumn(13).setPreferredWidth(30);
        tcm.getColumn(14).setPreferredWidth(20);

        
        
        
        //for displaying data from table in Mysql
        DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
        model.setRowCount(0);
        
        Prescription2 pr = new Prescription2();
        ResultSet res = null;
        try{
            res = pr.getAll();
            res.beforeFirst();
            while(res.next()){
                model.addRow(new Object[]{Integer.parseInt(res.getString(1)),res.getString(2),Integer.parseInt(res.getString(3)),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14),res.getString(15)});
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Cannot display" + e.toString());
        }
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecords = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        btnPrescription = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Id", "FullName", "Age", "Sex", "Address", "Illness", "Medicine", "Dosage", "DailyDose", "DoseandAdmins", "Storage", "Precautions", "Physician", "Date", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblRecordsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblRecords);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1350, 480));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Prescriptions Record");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PatientsInfo/prescription.png"))); // NOI18N
        jPanel2.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, -1));

        btnPrescription.setBackground(new java.awt.Color(0, 153, 153));
        btnPrescription.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPrescription.setForeground(new java.awt.Color(255, 255, 255));
        btnPrescription.setText("Add Prescription");
        btnPrescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrescriptionActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1410, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRecordsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRecordsMousePressed
        // code for clearing table
        /*DefaultTableModel model = (DefaultTableModel) tblRecords.getModel();
        model.setRowCount(0);*/
    }//GEN-LAST:event_tblRecordsMousePressed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1MousePressed

    private void btnPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrescriptionActionPerformed
        // TODO add your handling code here:
        PatientPrescription p = new PatientPrescription();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPrescriptionActionPerformed

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
            java.util.logging.Logger.getLogger(PrescriptionsRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrescriptionsRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrescriptionsRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrescriptionsRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrescriptionsRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrescription;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRecords;
    // End of variables declaration//GEN-END:variables
}

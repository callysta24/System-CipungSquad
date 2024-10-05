package HalamanUtama;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import komponen.AksesorisHp;
import komponen.DatabaseConnector;
import komponen.menu1;

public class konfirmasi extends javax.swing.JFrame {

    public konfirmasi() throws SQLDataException {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tombolTekan();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        border21 = new swing.Border2();
        backButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        try {
            pesanan12 = new komponen.pesanan1();
        } catch (java.sql.SQLDataException e1) {
            e1.printStackTrace();
        }
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        backButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        homeButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        homeButton.setText("Home");

        jScrollPane1.setOpaque(false);
        jScrollPane1.setViewportView(pesanan12);

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 36)); // NOI18N
        jLabel1.setText("AVORAYA CELL");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Jawa Timur, Jalan Bendungan Sigura-gura No. 1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("MALANG");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Sabtu, 23 Sept 2023      13:33");

        javax.swing.GroupLayout border21Layout = new javax.swing.GroupLayout(border21);
        border21.setLayout(border21Layout);
        border21Layout.setHorizontalGroup(
            border21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(border21Layout.createSequentialGroup()
                .addGroup(border21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, border21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeButton))
                    .addGroup(border21Layout.createSequentialGroup()
                        .addGroup(border21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(border21Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(border21Layout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(jLabel2))
                            .addGroup(border21Layout.createSequentialGroup()
                                .addGap(434, 434, 434)
                                .addComponent(jLabel3))
                            .addGroup(border21Layout.createSequentialGroup()
                                .addGap(374, 374, 374)
                                .addComponent(jLabel4)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        border21Layout.setVerticalGroup(
            border21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, border21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(border21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(backButton)
                    .addComponent(homeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border21, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border21, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    public void tombolTekan(){
         homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    makeKeranjangEmpty();
                } catch (SQLException ex) {
                    Logger.getLogger(konfirmasi.class.getName()).log(Level.SEVERE, null, ex);
                }
                    try {
                        dashbord m = new dashbord();
                        m.setVisible(true);
                        dispose();
                        m.setLocationRelativeTo(null);
                        m.setDefaultCloseOperation(dashbord.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(dashbord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
         
    }
    
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
            java.util.logging.Logger.getLogger(konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(konfirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new konfirmasi().setVisible(true);
                } catch (SQLDataException ex) {
                    Logger.getLogger(konfirmasi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void makeKeranjangEmpty() throws SQLException {

        String query = "DELETE from keranjang";
        Statement statement = DatabaseConnector.connection.createStatement();
        statement.executeQuery(query);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private swing.Border2 border21;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private komponen.pesanan1 pesanan12;
    // End of variables declaration//GEN-END:variables
}

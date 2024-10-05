package komponen;

import HalamanUtama.aksesorisLaptopPage;
import HalamanUtama.aksesorisLainPage;
import HalamanUtama.loginPage;
import HalamanUtama.dashbord;
import HalamanUtama.aksesorisHpPage;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class menu2 extends javax.swing.JPanel {
    
    String kategori;

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public menu2() {
        initComponents();
        setOpaque(false);
        tombolTekan();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonDashbord = new javax.swing.JButton();
        buttonAksHp = new javax.swing.JButton();
        buttonAksLaptop = new javax.swing.JButton();
        buttonAksLain = new javax.swing.JButton();
        buttonReport = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(2, 3, 0, 20));

        buttonDashbord.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonDashbord.setForeground(new java.awt.Color(255, 255, 204));
        buttonDashbord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dash40.png"))); // NOI18N
        buttonDashbord.setText("Dashbord");
        buttonDashbord.setBorderPainted(false);
        buttonDashbord.setContentAreaFilled(false);
        buttonDashbord.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonDashbord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonDashbordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonDashbordMouseExited(evt);
            }
        });
        buttonDashbord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDashbordActionPerformed(evt);
            }
        });
        jPanel2.add(buttonDashbord);

        buttonAksHp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonAksHp.setForeground(new java.awt.Color(255, 255, 204));
        buttonAksHp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hp40.png"))); // NOI18N
        buttonAksHp.setText("Aksesoris Handphone");
        buttonAksHp.setBorderPainted(false);
        buttonAksHp.setContentAreaFilled(false);
        buttonAksHp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAksHp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAksHpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAksHpMouseExited(evt);
            }
        });
        buttonAksHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAksHpActionPerformed(evt);
            }
        });
        jPanel2.add(buttonAksHp);

        buttonAksLaptop.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonAksLaptop.setForeground(new java.awt.Color(255, 255, 204));
        buttonAksLaptop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/laptop40.png"))); // NOI18N
        buttonAksLaptop.setText("Aksesoris Laptop");
        buttonAksLaptop.setBorderPainted(false);
        buttonAksLaptop.setContentAreaFilled(false);
        buttonAksLaptop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAksLaptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAksLaptopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAksLaptopMouseExited(evt);
            }
        });
        jPanel2.add(buttonAksLaptop);

        buttonAksLain.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonAksLain.setForeground(new java.awt.Color(255, 255, 204));
        buttonAksLain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lain40.png"))); // NOI18N
        buttonAksLain.setText("Aksesoris Lainnya");
        buttonAksLain.setBorderPainted(false);
        buttonAksLain.setContentAreaFilled(false);
        buttonAksLain.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonAksLain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonAksLainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonAksLainMouseExited(evt);
            }
        });
        jPanel2.add(buttonAksLain);

        buttonReport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonReport.setForeground(new java.awt.Color(255, 255, 204));
        buttonReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/history40.png"))); // NOI18N
        buttonReport.setText("History");
        buttonReport.setBorderPainted(false);
        buttonReport.setContentAreaFilled(false);
        buttonReport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonReportMouseExited(evt);
            }
        });
        jPanel2.add(buttonReport);

        buttonLogOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 204));
        buttonLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout40.png"))); // NOI18N
        buttonLogOut.setText("Log Out");
        buttonLogOut.setBorderPainted(false);
        buttonLogOut.setContentAreaFilled(false);
        buttonLogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        buttonLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonLogOutMouseExited(evt);
            }
        });
        jPanel2.add(buttonLogOut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void buttonAksHpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAksHpMouseEntered
        buttonAksHp.setContentAreaFilled(true);
        buttonAksHp.setBorderPainted(true);
        buttonAksHp.setForeground(Color.BLACK);
    }//GEN-LAST:event_buttonAksHpMouseEntered

    private void buttonAksHpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAksHpMouseExited
        buttonAksHp.setContentAreaFilled(false);
        buttonAksHp.setBorderPainted(false);
        buttonAksHp.setForeground(new java.awt.Color(255, 255, 204));
    }//GEN-LAST:event_buttonAksHpMouseExited

    private void buttonAksLaptopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAksLaptopMouseEntered
        buttonAksLaptop.setContentAreaFilled(true);
        buttonAksLaptop.setBorderPainted(true);
        buttonAksLaptop.setForeground(Color.BLACK);
    }//GEN-LAST:event_buttonAksLaptopMouseEntered

    private void buttonAksLaptopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAksLaptopMouseExited
        buttonAksLaptop.setContentAreaFilled(false);
        buttonAksLaptop.setBorderPainted(false);
        buttonAksLaptop.setForeground(new java.awt.Color(255, 255, 204));
    }//GEN-LAST:event_buttonAksLaptopMouseExited

    private void buttonAksLainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAksLainMouseEntered
        buttonAksLain.setContentAreaFilled(true);
        buttonAksLain.setBorderPainted(true);
        buttonAksLain.setForeground(Color.BLACK);
    }//GEN-LAST:event_buttonAksLainMouseEntered

    private void buttonAksLainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAksLainMouseExited
        buttonAksLain.setContentAreaFilled(false);
        buttonAksLain.setBorderPainted(false);
        buttonAksLain.setForeground(new java.awt.Color(255, 255, 204));
    }//GEN-LAST:event_buttonAksLainMouseExited

    private void buttonReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReportMouseEntered
        buttonReport.setContentAreaFilled(true);
        buttonReport.setBorderPainted(true);
        buttonReport.setForeground(Color.BLACK);
    }//GEN-LAST:event_buttonReportMouseEntered

    private void buttonReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReportMouseExited
        buttonReport.setContentAreaFilled(false);
        buttonReport.setBorderPainted(false);
        buttonReport.setForeground(new java.awt.Color(255, 255, 204));
    }//GEN-LAST:event_buttonReportMouseExited

    private void buttonLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogOutMouseEntered
        buttonLogOut.setContentAreaFilled(true);
        buttonLogOut.setBorderPainted(true);
        buttonLogOut.setForeground(Color.BLACK);
    }//GEN-LAST:event_buttonLogOutMouseEntered

    private void buttonLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLogOutMouseExited
        buttonLogOut.setContentAreaFilled(false);
        buttonLogOut.setBorderPainted(false);
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 204));
    }//GEN-LAST:event_buttonLogOutMouseExited

    private void buttonAksHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAksHpActionPerformed
        
    }//GEN-LAST:event_buttonAksHpActionPerformed

    private void buttonDashbordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDashbordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonDashbordActionPerformed

    private void buttonDashbordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDashbordMouseExited
        buttonDashbord.setContentAreaFilled(false);
        buttonDashbord.setBorderPainted(false);
        buttonDashbord.setForeground(new java.awt.Color(255, 255, 204));
    }//GEN-LAST:event_buttonDashbordMouseExited

    private void buttonDashbordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDashbordMouseEntered
        buttonDashbord.setContentAreaFilled(true);
        buttonDashbord.setBorderPainted(true);
        buttonDashbord.setForeground(Color.BLACK);
    }//GEN-LAST:event_buttonDashbordMouseEntered

     public void tombolTekan(){
         buttonDashbord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        dashbord m = new dashbord();
                        m.setVisible(true);
                        SwingUtilities.getWindowAncestor(menu2.this).dispose();
                        m.setLocationRelativeTo(null);
                        m.setDefaultCloseOperation(dashbord.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(dashbord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        buttonAksHp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        aksesorisHpPage m = new aksesorisHpPage();
                        m.setVisible(true);
                        SwingUtilities.getWindowAncestor(menu2.this).dispose();
                        m.setLocationRelativeTo(null);
                        m.setDefaultCloseOperation(aksesorisHpPage.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(AksesorisHp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        buttonAksLaptop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        aksesorisLaptopPage m = new aksesorisLaptopPage();
                        m.setVisible(true);
                        SwingUtilities.getWindowAncestor(menu2.this).dispose();
                        m.setLocationRelativeTo(null);
                        m.setDefaultCloseOperation(aksesorisLaptopPage.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(dashbord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        buttonAksLain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        aksesorisLainPage m = new aksesorisLainPage();
                        m.setVisible(true);
                        SwingUtilities.getWindowAncestor(menu2.this).dispose();
                        m.setLocationRelativeTo(null);
                        m.setDefaultCloseOperation(aksesorisLainPage.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(dashbord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        buttonReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        aksesorisHpPage m = new aksesorisHpPage();
                        m.setVisible(true);
                        SwingUtilities.getWindowAncestor(menu2.this).dispose();
                        m.setLocationRelativeTo(null);
                        m.setDefaultCloseOperation(aksesorisHpPage.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(dashbord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
        buttonLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try {
                        loginPage m = new loginPage();
                        m.setVisible(true);
                        SwingUtilities.getWindowAncestor(menu2.this).dispose();
                        m.setLocationRelativeTo(null);
                        m.setDefaultCloseOperation(loginPage.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(dashbord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
    }
    
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D d2 = (Graphics2D) g;
        d2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gd = new GradientPaint(0, 0, Color.decode("#1A2980"), 0, getHeight(), Color.decode("#26D0CE"));
        d2.setPaint(gd);
        d2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintChildren(g);
    }

    private int x;
    private int y;

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAksHp;
    private javax.swing.JButton buttonAksLain;
    private javax.swing.JButton buttonAksLaptop;
    private javax.swing.JButton buttonDashbord;
    private javax.swing.JButton buttonLogOut;
    private javax.swing.JButton buttonReport;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

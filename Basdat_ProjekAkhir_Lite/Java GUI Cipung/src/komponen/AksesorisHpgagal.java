package komponen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.HashMap;

public class AksesorisHpgagal extends javax.swing.JPanel {

    int total_harga = 0;
    int banyakBarang = 0;
    

    private HashMap<String, Integer> jumlahBarangMap = new HashMap<>();

    private JPanel[] panels;

    public AksesorisHpgagal() throws SQLException {
        initComponents();
        setOpaque(false);
        try {
            DatabaseConnector.getConnection(); // Try to establish the connection
            if (DatabaseConnector.connection == null) {
                // Handle connection failure
                throw new SQLException("Failed to establish a database connection.");
            }
            setOpaque(false);
            loadBarang();
        } catch (SQLException e) {
            // Handle the exception, log the error, or show a message to the user
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalLabel = new javax.swing.JLabel();
        banyakBarangLabel = new javax.swing.JLabel();
        buatPesananButton = new javax.swing.JButton();
        buttonPanel = new javax.swing.JPanel();

        totalLabel.setText("jLabel1");

        banyakBarangLabel.setText("jLabel1");

        buatPesananButton.setText("jButton1");

        setOpaque(false);

        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadBarang() throws SQLException {
        DatabaseConnector.getConnection();
        String query = "SELECT nama_barang, harga_satuan FROM Barang";
        PreparedStatement preparedStatement;
        preparedStatement = DatabaseConnector.connection.prepareStatement(query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        int rowCount = resultSet.getRow();
        panels = new JPanel[rowCount];

        resultSet.beforeFirst();
        int index = 0;
        buttonPanel.setLayout(new GridLayout(0, 1));
        buttonPanel.setOpaque(false);
        panels = new JPanel[rowCount]; // Reset panels array

        while (resultSet.next()) {
            String namaBarang = resultSet.getString("nama_barang");
            int hargaSatuan = resultSet.getInt("harga_satuan");

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
            panel.setOpaque(false);
            // Menggunakan FlowLayout dengan pengaturan
            // RIGHT

            JLabel nameLabel = new JLabel(namaBarang);
            nameLabel.setForeground(Color.WHITE);
            nameLabel.setFont(new java.awt.Font("Sitka Small", 1, 15));
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    panel.setOpaque(true);
                    panel.setBackground(Color.RED);
                    nameLabel.setForeground(Color.BLACK);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    panel.setBackground(null);
                    panel.setOpaque(false);
                    nameLabel.setForeground(Color.WHITE);
                }
            });

            panel.add(nameLabel, BorderLayout.WEST);

            JButton plusButton = new JButton("+");
            plusButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    total_harga += hargaSatuan;
                    totalLabel.setText((banyakBarang + 1) + " Item       " + total_harga);

                    banyakBarang++;
                    updateBanyakBarangLabel(banyakBarang);

                    // Menambah jumlah barang untuk nama barang tertentu
                    jumlahBarangMap.put(namaBarang, jumlahBarangMap.getOrDefault(namaBarang, 0) + 1);
                    nameLabel.setText(namaBarang + " (" + jumlahBarangMap.get(namaBarang) + ")");
                }
            });
            

            JButton minusButton = new JButton("-");
            minusButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (banyakBarang > 0 && jumlahBarangMap.get(namaBarang) > 0) {
                        total_harga -= hargaSatuan;
                        totalLabel.setText((banyakBarang - 1) + " Item       " + total_harga);

                        banyakBarang--;
                        updateBanyakBarangLabel(banyakBarang);

                        // Mengurangi jumlah barang untuk nama barang tertentu
                        int currentCount = jumlahBarangMap.getOrDefault(namaBarang, 0);
                        if (currentCount > 0) {
                            jumlahBarangMap.put(namaBarang, currentCount - 1);
                        }

                        nameLabel.setText(namaBarang + " (" + jumlahBarangMap.get(namaBarang) + ")");
                    }
                }
            });
            

            panel.add(nameLabel, BorderLayout.WEST);
            panel.add(minusButton);
            panel.add(plusButton);

            panels[index++] = panel;
        }

        for (JPanel panel : panels) {
            buttonPanel.add(panel);
        }
        
        totalLabel = new JLabel((banyakBarang) + " Item       " + total_harga);
        buttonPanel.add(totalLabel);

    }

    private void updateBanyakBarangLabel(int banyakBarang) {
        banyakBarangLabel.setText("(" + banyakBarang + ")");
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banyakBarangLabel;
    private javax.swing.JButton buatPesananButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}

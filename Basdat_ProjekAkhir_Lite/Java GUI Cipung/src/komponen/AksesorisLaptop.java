package komponen;

import HalamanUtama.konfirmasi;
import HalamanUtama.aksesorisHpPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AksesorisLaptop extends javax.swing.JPanel {

    int total_harga = 0;
    int banyakBarang = 0;
    private JButton pesan;
    private HashMap<String, Integer> jumlahBarangMap = new HashMap<>();
    private JLabel totalLabel;
    private JPanel[] panels;
    private static Set<String> generatedCodes = new HashSet<>();
    private static Set<String> existingDatabaseKeys = new HashSet<>();
    private String invoice = generateUniqueRandomCode();

    public AksesorisLaptop() throws SQLDataException {
        initComponents();
        setOpaque(false);
        geser.setVerticalScrollBar(new JScrollBar());
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

        banyakBarangLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesanPanel = new javax.swing.JPanel();
        geser = new javax.swing.JScrollPane();
        buttonPanel = new javax.swing.JPanel();

        banyakBarangLabel.setText("jLabel1");

        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 35));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Aksesoris Laptop");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 507, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        pesanPanel.setBackground(new java.awt.Color(153, 174, 224));
        pesanPanel.setPreferredSize(new java.awt.Dimension(100, 50));
        pesanPanel.setLayout(new java.awt.BorderLayout());
        add(pesanPanel, java.awt.BorderLayout.SOUTH);

        buttonPanel.setOpaque(false);

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        geser.setViewportView(buttonPanel);

        add(geser, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void loadBarang() throws SQLException {
        DatabaseConnector.getConnection();
        String query = "SELECT nama_barang, harga_satuan FROM Barang WHERE kategori ='laptop'";
        PreparedStatement preparedStatement;
        preparedStatement = DatabaseConnector.connection.prepareStatement(query,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        int rowCount = resultSet.getRow();
        panels = new JPanel[rowCount];
        totalLabel = new JLabel();
        resultSet.beforeFirst();
        int index = 0;
        pesan = new JButton("Pesan");
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
                    panel.setBackground(Color.BLUE);
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
        pesanPanel.add(totalLabel, BorderLayout.WEST);
        pesanPanel.add(pesan, BorderLayout.CENTER);

        pesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if there are items in the order
                if (banyakBarang > 0) {
                    try {
                        // Save order details to a temporary file
                        saveOrderDetails();
                        konfirmasi t = new konfirmasi();
                        aksesorisHpPage m = new aksesorisHpPage();
                        t.setVisible(true);
                        SwingUtilities.getWindowAncestor(AksesorisLaptop.this).dispose();
                        t.setLocationRelativeTo(null);
                        t.setDefaultCloseOperation(konfirmasi.EXIT_ON_CLOSE);
                    } catch (SQLException ex) {
                        Logger.getLogger(AksesorisLaptop.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    // Perform any other actions to end the session or navigate to the next page
                    // ...
                    // For example, display a message

                    // Perform any other actions to end the session or navigate to the next page
                    // ...
                    // For example, display a message

                    // Perform any other actions to end the session or navigate to the next page
                    // ...
                    // For example, display a message

                    // Perform any other actions to end the session or navigate to the next page
                    // ...
                    // For example, display a message
                } else {
                    // If no items in the order, you might want to display a message
                    JOptionPane.showMessageDialog(AksesorisLaptop.this, "No items in the order.");
                }
            }
        });

    }

    private void updateBanyakBarangLabel(int banyakBarang) {
        banyakBarangLabel.setText("(" + banyakBarang + ")");
    }

    private void saveOrderDetails() throws SQLException {

            for (String namaBarang : jumlahBarangMap.keySet()) {
                int jumlah = jumlahBarangMap.get(namaBarang);
//                int total = jumlahBarangMap.get(namaBarang);
                if (jumlah > 0) {
                    int hargaSatuan = getHargaSatuan(namaBarang); // Assuming you have a method to get harga_satuan
                    int totalHarga = jumlah * hargaSatuan;
                    insertTransaction(invoice, namaBarang, "hp", jumlah, hargaSatuan, totalHarga);
                }
            }
    }

    private int getHargaSatuan(String namaBarang) {

        String query = "SELECT harga_satuan FROM Barang WHERE nama_barang = ?";

        try (PreparedStatement preparedStatement = DatabaseConnector.connection.prepareStatement(query)) {
            preparedStatement.setString(1, namaBarang);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("harga_satuan");
                }
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(AksesorisLaptop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void loadExistingKeysFromDatabase() {
        String sql = "SELECT invoice FROM Transaksi";
        try (PreparedStatement statement = DatabaseConnector.connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                existingDatabaseKeys.add(resultSet.getString("invoice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String generateUniqueRandomCode() {
        // Format tanggal yang diinginkan dalam awalan kode
        String dateFormat = "yyMMdd";

        // Mendapatkan tanggal hari ini menggunakan kelas LocalDate
        LocalDate today = LocalDate.now();

        // Menggunakan DateTimeFormatter untuk memformat tanggal ke dalam string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        String todayDate = today.format(formatter);

        // Awalan kode dengan tanggal hari ini
        String prefix = "TRX#" + todayDate;

        // Panjang karakter yang diinginkan setelah awalan
        int length1 = 3;
        int length2 = 3;

        // Karakter yang diizinkan dalam kode
        String allowedHuruf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String allowedAngkaa = "0123456789";

        // Membuat objek Random
        Random random = new Random();

        // Membuat StringBuilder untuk menyimpan kode
        StringBuilder codeBuilder = new StringBuilder(prefix);

        // Menghasilkan karakter acak dan menambahkannya ke StringBuilder
        for (int i = 0; i < length1; i++) {
            int randomIndex = random.nextInt(allowedHuruf.length());
            char randomChar = allowedHuruf.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }

        for (int i = 0; i < length2; i++) {
            int randomIndex = random.nextInt(allowedAngkaa.length());
            char randomChar = allowedAngkaa.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }

        // Mendapatkan kode akhir
        String generatedCode = codeBuilder.toString();

        // Memeriksa apakah kode sudah ada dalam generatedCodes atau existingDatabaseKeys
        while (generatedCodes.contains(generatedCode) || existingDatabaseKeys.contains(generatedCode)) {
            // Jika sudah ada, menghasilkan kode baru
            generatedCode = generateUniqueRandomCode();
        }

        // Menambahkan kode ke set generatedCodes
        generatedCodes.add(generatedCode);

        // Mengembalikan hasil akhir
        return generatedCode;
    }

    private void insertTransaction(String invoice, String namaBarang, String kategori, int jumlah, int hargaSatuan, int totalHarga) throws SQLException {
        String query = "INSERT INTO keranjang (invoice, nama_barang, kategori, jumlah, harga_satuan, sub_total) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = DatabaseConnector.connection.prepareStatement(query)) {
            preparedStatement.setString(1, invoice);
            preparedStatement.setString(2, namaBarang);
            preparedStatement.setString(3, kategori);
            preparedStatement.setInt(4, jumlah);
            preparedStatement.setInt(5, hargaSatuan);
            preparedStatement.setInt(6, totalHarga);

            // Execute the insert statement
            preparedStatement.executeUpdate();
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banyakBarangLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JScrollPane geser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pesanPanel;
    // End of variables declaration//GEN-END:variables
}

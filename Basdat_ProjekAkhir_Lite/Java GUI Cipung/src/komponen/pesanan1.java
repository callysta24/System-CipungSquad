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

public class pesanan1 extends javax.swing.JPanel {

    int total_harga = 0;
    int banyakBarang = 0;
    private JButton pesan;
    private HashMap<String, Integer> jumlahBarangMap = new HashMap<>();
    private JLabel totalLabel;
    private JPanel[] panels;
    private static Set<String> generatedCodes = new HashSet<>();
    private static Set<String> existingDatabaseKeys = new HashSet<>();
    private String invoice;

    public pesanan1() throws SQLDataException {
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

        banyakBarangLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelInvoice = new javax.swing.JLabel();
        pesanPanel = new javax.swing.JPanel();
        geser = new javax.swing.JScrollPane();
        buttonPanel = new javax.swing.JPanel();

        banyakBarangLabel.setText("jLabel1");

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(250, 100));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 100));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setOpaque(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(679, 35));

        labelInvoice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelInvoice.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInvoice)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.PAGE_START);

        pesanPanel.setBackground(new java.awt.Color(153, 174, 224));
        pesanPanel.setPreferredSize(new java.awt.Dimension(100, 50));
        pesanPanel.setLayout(new java.awt.BorderLayout());
        add(pesanPanel, java.awt.BorderLayout.SOUTH);

        geser.setOpaque(false);

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
        String query = "SELECT * FROM keranjang";
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
            String invoice1 = resultSet.getString("invoice");
            invoice = invoice1;
            String namaBarang = resultSet.getString("nama_barang");
            String kategori = resultSet.getString("kategori");
            int hargaSatuan = resultSet.getInt("harga_satuan");
            int jumlah = resultSet.getInt("jumlah");
            int sub_total = resultSet.getInt("sub_total");
            

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
            panel.setOpaque(false);
            // Menggunakan FlowLayout dengan pengaturan
            // RIGHT

            JLabel nameLabel = new JLabel(namaBarang + " || " + kategori + " || " + hargaSatuan + " || " +jumlah+ " || " +sub_total);
            nameLabel.setForeground(Color.BLACK);
            nameLabel.setFont(new java.awt.Font("Sitka Small", 1, 15));

            panel.add(nameLabel, BorderLayout.EAST);
            panel.setOpaque(false);

            panels[index++] = panel;
        }

        for (JPanel panel : panels) {
            buttonPanel.add(panel);
        }
        labelInvoice.setText("Invoice : \t" + invoice);
        pesanPanel.add(jPanel1, BorderLayout.EAST);
        pesanPanel.add(jPanel2, BorderLayout.WEST);
        pesanPanel.add(pesan, BorderLayout.CENTER);

    }

    private void updateBanyakBarangLabel(int banyakBarang) {
        banyakBarangLabel.setText("(" + banyakBarang + ")");
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

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D d2 = (Graphics2D) g;
        d2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gd = new GradientPaint(0, 0, Color.decode("#1A2980"), 0, getHeight(), Color.decode("#26D0CE"));
        d2.setPaint(gd);
        d2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        d2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banyakBarangLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JScrollPane geser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel labelInvoice;
    private javax.swing.JPanel pesanPanel;
    // End of variables declaration//GEN-END:variables
}

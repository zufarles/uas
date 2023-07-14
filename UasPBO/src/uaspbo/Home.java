/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uaspbo;

import java.sql.PreparedStatement;

import java.awt.HeadlessException;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Administrator
 */
public final class Home extends javax.swing.JFrame {

public Connection getConnection() throws SQLException {

    String url = "jdbc:mysql://localhost:3306/dbhome?zeroDateTimeBehavior=CONVERT_TO_NULL"; // Ganti dengan URL koneksi MySQL Anda
    String username = "root"; // Ganti dengan username MySQL Anda
    String password = ""; // Ganti dengan password MySQL Anda
    
     

    Connection connection = DriverManager.getConnection(url, username, password);
    return connection;
}
    /**
     * Creates new form Home
     */
    public Home() {        initComponents();
        cetak.addActionListener((java.awt.event.ActionEvent evt) -> {
            cetakActionPerformed(evt);
    });
        table();
    }                                        
    public void table(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Judul Film");
        tbl.addColumn("Jam Tayang");
        tbl.addColumn("NO Kursi");
        tbl.addColumn("Jumlah Kursi");
        tbl.addColumn("Harga Tiket");
        try{
            Statement st = (Statement) Koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dbtabel");
            
            while (rs.next()){
                tbl.addRow(new Object[]{
                    rs.getString("jdl_film"),
                    rs.getString("jm_tayang"),
                    rs.getString("no_kursi"),
                    rs.getString("jmlh_kursi"),
                    rs.getString("harga")
                });
                dttabel.setModel(tbl);
            }
            JOptionPane.showMessageDialog(null, "koneksi Database Berhasil");
            
        }catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "koneksi Database gagal" + ex.getMessage());
        }
    } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jdl_film = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jm_tayang = new javax.swing.JComboBox<>();
        no_kursi = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dttabel = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        lihat = new javax.swing.JButton();
        harga = new javax.swing.JLabel();
        jmlh_kursi = new javax.swing.JComboBox<>();
        cetak = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        jLabel1.setText("Judul Film      :");

        jdl_film.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Mission: Impossible - Dead Reckoning Part One", "Indiana Jones and the Dial of Destiny", "Elemental", "The Flash", "The Childe" }));
        jdl_film.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdl_filmActionPerformed(evt);
            }
        });

        jLabel2.setText("Jam Tayang   :");

        jLabel3.setText("No Kursi         :");

        jm_tayang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "12 : 25", "15 : 20", "18 : 15", "21 : 10" }));

        no_kursi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        no_kursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_kursiActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah Kursi :");

        jLabel5.setText("Harga Tiker   :");

        jLabel6.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        jLabel6.setText("Penjualan Tiket Bioskop");

        dttabel.setAutoCreateRowSorter(true);
        dttabel.setBackground(new java.awt.Color(153, 255, 0));
        dttabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Judul Film", "Jam Tayang", "No Kursi", "Jumlah Kursi", "Harga Tiket"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dttabel.setColumnSelectionAllowed(true);
        dttabel.getTableHeader().setReorderingAllowed(false);
        dttabel.setVerifyInputWhenFocusTarget(false);
        dttabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dttabelMouseClicked(evt);
            }
        });
        dttabel.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dttabelInputMethodTextChanged(evt);
            }
        });
        jScrollPane2.setViewportView(dttabel);
        dttabel.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        simpan.setText("Simpan");
        simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanMouseClicked(evt);
            }
        });
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        lihat.setText("Lihat");
        lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatActionPerformed(evt);
            }
        });

        harga.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        harga.setText("Rp");

        jmlh_kursi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jmlh_kursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmlh_kursiActionPerformed(evt);
            }
        });

        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jm_tayang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jdl_film, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(no_kursi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jmlh_kursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(harga))))
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(simpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lihat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cetak)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jdl_film, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jm_tayang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(no_kursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jmlh_kursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(harga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit)
                    .addComponent(hapus)
                    .addComponent(lihat)
                    .addComponent(simpan)
                    .addComponent(cetak))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
Integer value = Integer.valueOf("123");
        String judulFilm = jdl_film.getSelectedItem().toString();
        String jamTayang = jm_tayang.getSelectedItem().toString();
        String noKursi = no_kursi.getSelectedItem().toString();
        String jumlahKursi = jmlh_kursi.getSelectedItem().toString();
        String jk = null;

        // Lakukan validasi jika ada data yang belum diisi
        if (judulFilm.equals("Pilih") || jamTayang.equals("Pilih") || noKursi.equals("Pilih") || jumlahKursi.equals("Pilih")) {
            JOptionPane.showMessageDialog(this, "Harap isi semua data terlebih dahulu.");
            return; // Hentikan proses lebih lanjut
        }

        // Buat koneksi ke database
        Connection conn;
        try {
            conn = Koneksi.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + e.getMessage());
            return; // Hentikan proses lebih lanjut
        }

        // Hitung harga tiket berdasarkan jumlah kursi
        int jumlahKursiInt = Integer.parseInt(jumlahKursi);
        int hargaTiket = 40000 * jumlahKursiInt;

        try {
            // Buat pernyataan SQL untuk menyimpan data ke database
            String sql = "INSERT INTO dbtabel (jdl_film, jm_tayang, no_kursi, jmlh_kursi, harga) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            pst.setString(1, judulFilm);
            pst.setString(2, jamTayang);
            pst.setString(3, noKursi);
            pst.setString(4, jumlahKursi);
            pst.setInt(5, hargaTiket);

            // Jalankan pernyataan SQL untuk menyimpan data
            pst.executeUpdate();

            // Tambahkan data ke tabel
            DefaultTableModel model = (DefaultTableModel) dttabel.getModel();
            Object[] rowData = {judulFilm, jamTayang, noKursi, jumlahKursi, hargaTiket};
            model.addRow(rowData);

            // Tampilkan harga tiket
            harga.setText("Rp " + hargaTiket);

            // Tampilkan pesan sukses
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");

            // Reset input fields
            jdl_film.setSelectedIndex(0);
            jm_tayang.setSelectedIndex(0);
            no_kursi.setSelectedIndex(0);
            jmlh_kursi.setSelectedIndex(0);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        }

    }//GEN-LAST:event_simpanActionPerformed

    private void jmlh_kursiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmlh_kursiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmlh_kursiActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
      int selectedRow = dttabel.getSelectedRow();

    // Pastikan ada baris yang dipilih
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Harap pilih data yang akan diedit.");
        return; // Hentikan proses lebih lanjut
    }

    // Ambil data dari tabel
    String judulFilm = jdl_film.getSelectedItem().toString();
    String jamTayang = jm_tayang.getSelectedItem().toString();
    String noKursi = no_kursi.getSelectedItem().toString();
    String jumlahKursi = jmlh_kursi.getSelectedItem().toString();
    String jk = null;

    // Lakukan validasi jika ada data yang belum diisi
    if (judulFilm.equals("Pilih") || jamTayang.equals("Pilih") || noKursi.equals("Pilih") || jumlahKursi.equals("Pilih")) {
        JOptionPane.showMessageDialog(this, "Harap isi semua data terlebih dahulu.");
        return; // Hentikan proses lebih lanjut
    }

    // Ambil nilai judul film dari baris yang dipilih
    String judulFilmSebelumnya = dttabel.getValueAt(selectedRow, 0).toString();

    // Buat koneksi ke database
    Connection conn;
    try {
        conn = Koneksi.getConnection();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + e.getMessage());
        return; // Hentikan proses lebih lanjut
    }

    // Hitung harga tiket berdasarkan jumlah kursi
    int jumlahKursiInt = Integer.parseInt(jumlahKursi);
    int hargaTiket = 40000 * jumlahKursiInt;

    try {
        // Buat pernyataan SQL untuk mengupdate data di database
        String sql = "UPDATE dbtabel SET jdl_film=?, jm_tayang=?, no_kursi=?, jmlh_kursi=?, harga=? WHERE jdl_film=?";
          java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, judulFilm);
        pst.setString(2, jamTayang);
        pst.setString(3, noKursi);
        pst.setString(4, jumlahKursi);
        pst.setInt(5, hargaTiket);
        pst.setString(6, judulFilmSebelumnya);

        // Jalankan pernyataan SQL untuk mengupdate data
        pst.executeUpdate();

        // Update data di tabel
        DefaultTableModel model = (DefaultTableModel) dttabel.getModel();
        model.setValueAt(judulFilm, selectedRow, 0);
        model.setValueAt(jamTayang, selectedRow, 1);
        model.setValueAt(noKursi, selectedRow, 2);
        model.setValueAt(jumlahKursi, selectedRow, 3);
        model.setValueAt(hargaTiket, selectedRow, 4);

        // Tampilkan harga tiket
        harga.setText("Rp " + hargaTiket);

        // Tampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Data berhasil diupdate.");

        // Reset input fields
        jdl_film.setSelectedIndex(0);
        jm_tayang.setSelectedIndex(0);
        no_kursi.setSelectedIndex(0);
        jmlh_kursi.setSelectedIndex(0);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mengupdate data: " + e.getMessage());
    }
    }//GEN-LAST:event_editActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
   int selectedRow = dttabel.getSelectedRow();

    // Pastikan ada baris yang dipilih
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Harap pilih data yang akan dihapus.");
        return; // Hentikan proses lebih lanjut
    }

    // Ambil data dari tabel
    String judulFilm = dttabel.getValueAt(selectedRow, 0).toString();

    // Buat koneksi ke database
    Connection conn;
    try {
        conn = Koneksi.getConnection();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Koneksi ke database gagal: " + e.getMessage());
        return; // Hentikan proses lebih lanjut
    }

    try {
        // Buat pernyataan SQL untuk menghapus data dari database
        String sql = "DELETE FROM dbtabel WHERE jdl_film=?";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, judulFilm);

        // Jalankan pernyataan SQL untuk menghapus data
        pst.executeUpdate();

        // Hapus data dari tabel
        DefaultTableModel model = (DefaultTableModel) dttabel.getModel();
        model.removeRow(selectedRow);

        // Tampilkan pesan sukses
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");

        // Reset input fields
        jdl_film.setSelectedIndex(0);
        jm_tayang.setSelectedIndex(0);
        no_kursi.setSelectedIndex(0);
        jmlh_kursi.setSelectedIndex(0);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menghapus data: " + e.getMessage());
    }
    }//GEN-LAST:event_hapusActionPerformed

    private void lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatActionPerformed
 int selectedRow = dttabel.getSelectedRow();
        
        // Pastikan ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Harap pilih data yang akan dilihat.");
            return; // Hentikan proses lebih lanjut
        }
        
        // Ambil data dari tabel
        String judulFilm = dttabel.getValueAt(selectedRow, 0).toString();
        String jamTayang = dttabel.getValueAt(selectedRow, 1).toString();
        String noKursi = dttabel.getValueAt(selectedRow, 2).toString();
        String jumlahKursi = dttabel.getValueAt(selectedRow, 3).toString();
        String hargaTiket = dttabel.getValueAt(selectedRow, 4).toString();
        
        // Tampilkan data dalam dialog
        String message = "Judul Film: " + judulFilm
                + "\nJam Tayang: " + jamTayang
                + "\nNo Kursi: " + noKursi
                + "\nJumlah Kursi: " + jumlahKursi
                + "\nHarga Tiket: Rp " + hargaTiket;
        
        JOptionPane.showMessageDialog(this, message, "Detail Tiket", JOptionPane.INFORMATION_MESSAGE);
                                     }//GEN-LAST:event_lihatActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
    String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/dbhome?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String user = "root";
    String pass = "";
    String dirr = "";
    
    try {
        Class.forName(jdbc_driver);
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stat = conn.createStatement();
        String sql = "SELECT * FROM dbtabel";
        dirr = new File("").getAbsolutePath() + "/src/Datact/";
        
        // Compile and load the JasperReport template
        JasperDesign design = JRXmlLoader.load(dirr + "report.jrxml");
        JasperReport jr = JasperCompileManager.compileReport(design);
        
        
        // Retrieve the data from the database
        ResultSet rs = stat.executeQuery(sql);
        
        // Create a JRDataSource from the ResultSet
        JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
        
        // Fill the report with data
        JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap<>(), rsDataSource);
        
        // Display the report in JasperViewer
        JasperViewer.viewReport(jp, false);
    } catch (ClassNotFoundException | SQLException | JRException ex) {
        JOptionPane.showMessageDialog(null, "Gagal Mencetak\n" + ex, "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_cetakActionPerformed

    private void dttabelInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dttabelInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_dttabelInputMethodTextChanged

    private void jdl_filmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdl_filmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jdl_filmActionPerformed

    private void no_kursiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_kursiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_kursiActionPerformed

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
       
    }//GEN-LAST:event_editMouseClicked

    private void dttabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dttabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dttabelMouseClicked

    private void simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanMouseClicked
     
    }//GEN-LAST:event_simpanMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak;
    private javax.swing.JTable dttabel;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jdl_film;
    private javax.swing.JComboBox<String> jm_tayang;
    private javax.swing.JComboBox<String> jmlh_kursi;
    private javax.swing.JButton lihat;
    private javax.swing.JComboBox<String> no_kursi;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables

   
}

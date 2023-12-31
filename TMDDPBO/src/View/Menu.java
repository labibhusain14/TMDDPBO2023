/**
 * Filename = Menu.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package View untuk menampilkan menu utama
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package View;

import java.io.ObjectInputFilter.Config;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.TableScore;
import ViewModel.ProsesTabel;
import ViewModel.Music;
import ViewModel.Game;

public class Menu extends javax.swing.JFrame {

    private ProsesTabel prosesTabel;
    private String username; // username
    public Game game;
    Music music;

    // Properties
    public Menu() {
        initComponents();
        this.username = ""; // inisialisasi username
        this.prosesTabel = new ProsesTabel();
        // Set Table
        table_account.setModel(prosesTabel.getPlayerTable());
        // music = new Sound(Sound.MENU);
        // music.play();
    }

    public void setTable() {
        // Mengupdate table dengan data yang diterima dari viewmodel
        table_account.setModel(prosesTabel.getPlayerTable());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_account = new javax.swing.JTable();
        btn_quit = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        btn_play = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_account.setBorder(null);
        table_account.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null },
                        { null, null, null },
                        { null, null, null },
                        { null, null, null }
                },
                new String[] {
                        "Username", "Score", "Standing"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        table_account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_accountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_account);
        if (table_account.getColumnModel().getColumnCount() > 0) {
            table_account.getColumnModel().getColumn(0).setPreferredWidth(120);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 410, 230));

        btn_quit.setOpaque(false);
        btn_quit.setContentAreaFilled(false);
        btn_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_quit, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 442, 140, 40));

        txtUsername.setBackground(new java.awt.Color(217, 217, 217));
        txtUsername.setBorder(null);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 190, 30));

        btn_play.setOpaque(false);
        btn_play.setContentAreaFilled(false);
        btn_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_playActionPerformed(evt);
            }
        });
        jPanel1.add(btn_play, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/bg-image.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtUsernameActionPerformed

    private void btn_playActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_playActionPerformed
        // Memeriksa apakah teks pada txtUsername tidak kosong
        if (!txtUsername.getText().equals("")) {
            // Membuat objek Game dengan menggunakan teks dari txtUsername sebagai username
            // akun
            game = new Game(txtUsername.getText());
            // Membuat objek Display untuk menampilkan permainan dengan menggunakan objek
            // game dan this (kelas Menu) sebagai parameter konstruktor
            Display display = new Display(game, this);
            // Mengosongkan nilai pada txtUsername setelah game dimulai
            txtUsername.setText("");
            // Memulai permainan dengan memanggil start(display) dari objek game
            game.start(display);
            // Mengubah tampilan menu menjadi tidak terlihat dengan memanggil
            // setVisible(false) pada objek this (kelas Menu)
            this.setVisible(false);
            // Menghapus menu window dari memori dengan memanggil dispose()
            this.dispose();
            // menghentikan musik menu
            // music.stop();
        } else {
            // Menampilkan pesan dialog dengan teks "Isi Username!" menggunakan
            // JOptionPane.showMessageDialog()
            JOptionPane.showMessageDialog(null, "Username Tidak Boleh Kosong!");
        }
    }// GEN-LAST:event_btn_playActionPerformed

    private void btn_quitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_quitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        // Menghapus menu window dari memori dengan memanggil dispose()
        System.exit(0);
    }// GEN-LAST:event_btn_quitActionPerformed

    private void table_accountMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_table_accountMouseClicked
        // Mengambil data yang dipilih (username) dari tabel
        int row = table_account.getSelectedRow();
        String selectedNama = table_account.getModel().getValueAt(row, 0).toString();
        // Mengatur nilai pada txtUsername menjadi selectedNama
        txtUsername.setText(selectedNama);
    }// GEN-LAST:event_table_accountMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */

        // </editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_play;
    private javax.swing.JButton btn_quit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_account;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

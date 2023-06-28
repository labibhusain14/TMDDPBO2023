/**
 * Filename = DB.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package model untuk mengakses basis data
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    // Mendeklarasikan variabel ConAddress yang menyimpan URL koneksi JDBC ke basis
    // data MySQL
    private String ConAddress = "jdbc:mysql://localhost/db_tmd?user=root&password=";
    // Mendeklarasikan variabel stmt sebagai objek Statement yang digunakan untuk
    // menjalankan pernyataan SQL pada koneksi basis data.
    private Statement stmt = null;
    /*
     * Mendeklarasikan variabel rs sebagai objek ResultSet yang digunakan untuk
     * menyimpan hasil eksekusi query yang mengembalikan data.
     */
    private ResultSet rs = null;
    /*
     * Mendeklarasikan variabel conn sebagai objek Connection yang digunakan untuk
     * menghubungkan ke basis data MySQL.
     */
    private Connection conn = null;

    public DB() throws Exception, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // membuat koneksi MySQL dan basis data
            conn = DriverManager.getConnection(ConAddress, "root", ""); // Menghubungkan ke basis data MySQL dengan
                                                                        // menggunakan URL, nama pengguna, dan kata
                                                                        // sandi yang diberikan.
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED); // Mengatur tingkat isolasi transaksi
                                                                                   // menjadi READ UNCOMMITTED.
        } catch (SQLException es) {
            System.out.println("Error Constructor"); // Menampilkan pesan kesalahan jika terjadi SQLException pada
                                                     // konstruktor.
            throw es;
        }
    }

    public void createQuery(String Query) throws Exception, SQLException {
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(Query); // Mengeksekusi pernyataan SQL yang diberikan dan menyimpan hasilnya dalam
                                           // objek ResultSet.
            if (stmt.execute(Query)) {
                rs = stmt.getResultSet(); // Mengambil objek ResultSet yang dihasilkan oleh pernyataan SQL jika hasil
                                          // eksekusi mengembalikan hasil.
            }
        } catch (SQLException es) {
            System.out.println("Error create Query"); // Menampilkan pesan kesalahan jika terjadi SQLException pada
                                                      // metode createQuery.
            throw es;
        }
    }

    public int createUpdate(String Query) throws Exception, SQLException {
        try {
            stmt = conn.createStatement();
            return stmt.executeUpdate(Query); // Mengeksekusi pernyataan SQL yang diberikan dan mengembalikan jumlah
                                              // baris yang terpengaruh oleh eksekusi.
        } catch (SQLException es) {
            throw es;
        }
    }

    public ResultSet getResult() throws Exception {
        ResultSet Temp = null;
        try {
            return rs; // Mengembalikan objek ResultSet yang berisi hasil eksekusi query.
        } catch (Exception e) {
            return Temp;
        }
    }

    public void closeResult() throws Exception, SQLException {
        if (rs != null) {
            try {
                rs.close(); // Menutup objek ResultSet.
            } catch (SQLException es) {
                rs = null;
                throw es;
            }
        }
        if (stmt != null) {
            try {
                stmt.close(); // Menutup objek Statement.
            } catch (SQLException es) {
                stmt = null;
                throw es;
            }
        }
    }

    public void closeConnection() throws Exception, SQLException {
        if (conn != null) {
            try {
                conn.close(); // Menutup objek Connection.
            } catch (SQLException es) {
                conn = null;
            }
        }
    }

}
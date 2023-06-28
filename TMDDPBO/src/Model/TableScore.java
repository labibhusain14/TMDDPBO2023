/**
 * Filename = TableScore.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package model untuk mengakses table 
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableScore extends DB {
    public TableScore() throws Exception, SQLException {
        super();
    }

    /**
     * Memperbarui skor dalam tabel "model" untuk username yang ditentukan atau
     * memasukkan skor baru jika tidak ada catatan yang ada.
     *
     * @param username username pemain.
     * @param score    skor yang akan diperbarui atau dimasukkan.
     * @param standing standing yang akan diperbarui atau dimasukkan.
     */
    public void setPoint(String username, int score, int standing) {
        // Metode untuk memperbarui skor dalam tabel "model" atau memasukkan skor baru
        try {
            String query = "UPDATE model SET score = " + score + ", standing = " + standing
                    + " WHERE username = '" + username + "'";
            // Eksekusi query untuk memperbarui data
            if (createUpdate(query) == 0) {
                // Jika tidak ada catatan yang diperbarui, buat catatan baru
                query = "INSERT INTO model VALUES(NULL, '" + username + "', " + Integer.toString(score) + ", "
                        + Integer.toString(standing) + ")";
                createUpdate(query);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Mengambil skor dari tabel "model" berdasarkan username yang ditentukan.
     *
     * @param username username pemain.
     * @return skor yang sesuai dengan username.
     */
    public int getScoreByUsername(String username) {
        int score = 0;
        try {
            String query = "SELECT score FROM model WHERE username = '" + username + "'";
            createQuery(query);
            ResultSet resultSet = getResult();

            if (resultSet.next()) {
                score = resultSet.getInt("score");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return score;
    }

    /**
     * Mengambil standing dari tabel "model" berdasarkan username yang ditentukan.
     *
     * @param username username pemain.
     * @return standing yang sesuai dengan username.
     */
    public int getStandingByUsername(String username) {
        int standing = 0;
        try {
            String query = "SELECT standing FROM model WHERE username = '" + username + "'";
            createQuery(query);
            ResultSet resultSet = getResult();

            if (resultSet.next()) {
                standing = resultSet.getInt("standing");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return standing;
    }

    /**
     * Mengambil semua catatan dari tabel "model".
     */
    public void getAll() {
        // Eksekusi query untuk mengambil semua data dari tabel "model"
        String query = "SELECT * FROM model ORDER BY (score + standing) DESC";
        try {
            createQuery(query);
        } catch (Exception ex) {
            Logger.getLogger(TableScore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

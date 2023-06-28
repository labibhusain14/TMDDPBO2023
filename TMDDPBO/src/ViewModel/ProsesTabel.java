/**
 * Filename = ProsesTabel.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package ViewModel untuk mengakses dan memproses data pada tabel pemain
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package ViewModel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Model.TableScore;

public class ProsesTabel {
    TableScore tableExp;

    /**
     * Konstruktor kelas ProsesTabel.
     */
    public ProsesTabel() {
        try {
            this.tableExp = new TableScore();
        } catch (Exception ex) {
            Logger.getLogger(ProsesTabel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Mengambil data tabel player dan mengembalikannya sebagai objek
     * DefaultTableModel.
     *
     * @return objek DefaultTableModel berisi data tabel player.
     */
    public DefaultTableModel getPlayerTable() {
        DefaultTableModel dataTabel = null;
        try {
            // Mendefinisikan kolom-kolom tabel.
            Object[] column = { "Username", "Score", "Standing" };
            dataTabel = new DefaultTableModel(null, column);

            // Mengambil semua data pemain dari tabel menggunakan objek TableScore.
            this.tableExp.getAll();
            while (this.tableExp.getResult().next()) {
                // Menambahkan setiap baris data pemain ke dalam objek DefaultTableModel.
                Object[] row = new Object[3];
                row[0] = this.tableExp.getResult().getString(2);
                row[1] = this.tableExp.getResult().getString(3);
                row[2] = this.tableExp.getResult().getString(4);
                dataTabel.addRow(row);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return dataTabel;
    }
}

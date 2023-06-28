/**
 * Filename = Main.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package model untuk mengakses kelas player 
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

// mengakses package view
import View.Menu;

public class Main {
    public static void main(String[] args) {
        // Memanggil menu untuk memunculkan window menu utama
        new Menu().setVisible(true);
    }
}

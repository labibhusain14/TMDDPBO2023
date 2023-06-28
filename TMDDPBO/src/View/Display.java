/**
 * Filename = Display.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package view untuk menampilkan game dalam sebuah window.
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package View;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

import ViewModel.Game;
import ViewModel.Music;

public class Display extends Canvas {
    // JFrame declaration.
    private JFrame frame;
    public static final int width = 703;
    public static final int height = 512;
    public Menu menu;
    Music music;

    /**
     * Konstruktor untuk kelas Display.
     *
     * @param game objek Game yang akan ditampilkan di dalam jendela.
     * @param menu objek Menu yang akan terkait dengan jendela.
     */
    public Display(Game game, Menu menu) {
        // Inisialisasi frame dan dimensi jendela.
        String title = "Tugas Masa Depan - Mohammad Labib Husain (NIM: 2101989)";
        this.menu = menu;
        this.frame = new JFrame(title);
        this.frame.add(game);
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setMinimumSize(new Dimension(width, height));
        this.frame.setMaximumSize(new Dimension(width, height));

        // Inisialisasi opsi tambahan.
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setResizable(false);

        // Inisialisasi musik latar.
        music = new Music(Music.STAGE);
        music.play();
    }

    /**
     * Menutup tampilan game dan kembali ke menu utama.
     */
    public void close() {
        // Menampilkan kembali menu utama.
        menu.setVisible(true);
        menu.setTable();
        // menu.playMusic();

        // Menutup window game.
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    /**
     * Menghentikan pemutaran musik pada jendela game.
     */
    public void stopMusic() {
        music.stop();
    }

}

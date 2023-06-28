/**
 * Filename = Sound.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package ViewModel untuk memutar musik
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package ViewModel;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
    public static final String STAGE = "src/assets/sound.wav"; // Lokasi file suara
    private Clip clip; // Objek Clip untuk memainkan suara

    /**
     * Constructor.
     * 
     * @param fileUrl Lokasi file suara.
     */
    public Music(String fileUrl) {
        try {
            // Mendapatkan AudioInputStream dari file suara.
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(fileUrl).getAbsoluteFile());
            // Mendapatkan objek Clip untuk memainkan suara.
            clip = AudioSystem.getClip();
            // Membuka audio clip dan memuat sampel dari input stream audio.
            clip.open(audioIn);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Memainkan suara.
     */
    public void play() {
        clip.setMicrosecondPosition(0); // Mengatur posisi pemutaran suara ke awal
        clip.start(); // Memulai pemutaran suara
        clip.loop(Clip.LOOP_CONTINUOUSLY); // Mengulang pemutaran suara secara terus-menerus
    }

    /**
     * Menghentikan pemutaran suara.
     */
    public void stop() {
        clip.stop(); // Menghentikan pemutaran suara
    }

}

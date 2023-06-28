/**
 * Filename = Game.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package ViewModel ini bertanggung jawab untuk mengatur logika permainan dan berinteraksi dengan kelas lain dalam aplikasi.
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package ViewModel;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import Model.Box;
import Model.GameObject;
import Model.Player;
import Model.TableScore;
import View.Display;

public class Game extends Canvas implements Runnable {
    /**
     *
     * Deklarasi Atribut.
     */
    /* Atribut terkait tampilan. */
    public static final int width = 703;
    public static final int height = 512;
    private Display display;
    private String username; // username
    private Random rand; // Randomizer.
    private int boxSpawnTimer = 0; // Waktu jeda antara pembuatan box (dalam frame)
    private int boxSpawnDelay = 0; // Waktu jeda minimum antara pembuatan box baru (dalam frame)
    private Player player; // player
    private boolean gameOver = false;

    /* Atribut terkait proses. */
    private boolean running;
    private Handler handler;
    private Thread thread;

    /* Atribut terkait animasi. */
    private boolean startCounting = false;
    private int score;
    private int standing;
    private int counter = 0;
    private int stateCounter = 0;
    private int direction = 0;
    private TableScore tp;

    // Konstruktor default.
    public Game(String username) {
        try {
            // Inisialisasi tampilan.
            // display = new Display(width, height, "TMD Mohammad Labib Husain 2101989");
            // display.open(this);
            this.username = username;
            tp = new TableScore();
            // this.score = score;
            this.score = getScoreByUsername(username);
            this.standing = getStandingByUsername(username);
            // Inisialisasi game handler.
            handler = new Handler();
            this.rand = new Random();

            // Inisialisasi controller (input keyboard).
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(new Controller(this, handler, username));

            // Inisialisasi semua objek.
            running = true;
            if (running) {
                handler.add(new Player(120, 5));
            }
        } catch (Exception e) {
            System.err.println("Gagal menginstansi data.");
        }
    }

    // Fungsi untuk mendapatkan angka acak antara min dan max (inklusif)
    private int getRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * 
     * Getter dan Setter.
     */

    /* Status permainan berjalan. */

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    // Mengambil nilai score berdasarkan username
    public int getScoreByUsername(String username) {
        return tp.getScoreByUsername(username);
    }

    // Mengambil nilai standing berdasarkan username
    public int getStandingByUsername(String username) {
        return tp.getStandingByUsername(username);
    }

    public void setUsername(String username) {
        // Mengeset username permainan.
        this.username = username;
    }

    public String getUsername() {
        // Mengambil username permainan.
        return username;
    }

    // Metode clamp untuk memastikan pemain tidak keluar dari batas tampilan.
    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        }

        return var;
    }

    // Menutup tampilan.
    public void close() {
        display.close();
    }

    /**
     * 
     * Game controller.
     */

    // Start threading.
    public synchronized void start(Display display) {
        thread = new Thread(this);
        thread.start();
        this.display = display; // membuat window
        running = true;

    }

    // Stop threading.
    public synchronized void stop() {
        try {
            running = false;
            display.stopMusic();
            // Mengupload Skor
            this.uploadPoint();
            JOptionPane.showMessageDialog(null, "Username: " + this.username + "\n" + "Skor: "
                    + score + "\n" + "Standing: " + standing, "GAME OVER",
                    JOptionPane.INFORMATION_MESSAGE);
            gameOver = true;
            // Menghancurkan jendela permainan
            display.close();
            thread.join();
            // Menunggu thread dari game ini berhenti
        } catch (InterruptedException e) {
            System.out.println("Kesalahan pada thread: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadPoint() throws Exception {
        // Mengunggah skor ke database
        tp.setPoint(username, score, standing);
    }

    // Menginisialisasi permainan saat pertama kali dijalankan.
    public void render() {
        // Menggunakan buffer strategy.
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(SOMEBITS);
            return;
        }
        // Menginisialisasi grafik.
        Graphics g = bs.getDrawGraphics();
        Image bg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/assets/bg-game.png"));
        g.drawImage(bg, 0, 0, null);

        if (running == true) {
            // Render handler.
            handler.render(g);

            // Render skor.
            Font oldFont = g.getFont();
            Font newFont = oldFont.deriveFont(oldFont.getSize() * 1.3f);
            g.setFont(newFont);

            g.setColor(Color.blue);
            g.drawString("Skor: " + Integer.toString(score), 20, 30);
            g.drawString("Standing: " + Integer.toString(standing), 20, 50);
        }

        // Melooping proses sehingga terlihat seperti "FPS".
        g.dispose();
        bs.show();
    }

    public void loop() {
        GameObject box = null; // Deklarasi variabel box dengan nilai awal null
        boxSpawnTimer++; // Menaikkan nilai boxSpawnTimer

        if (boxSpawnTimer >= boxSpawnDelay) {
            Random rand = new Random();
            // Menambahkan objek box ke dalam koordinat 0 (pojok kiri) dan koordinat y
            // sebesar 492 (dari titik paling bawah) serta merandom lebar dari setiap box
            handler.add(new Box(0, 492, rand.nextInt(400) + 30));
            boxSpawnTimer = 0; // Mengatur ulang boxSpawnTimer ke 0
            // Menghasilkan delay acak untuk pembuatan kotak berikutnya
            boxSpawnDelay = rand.nextInt(30) + 20;
        }

        handler.loop(); // Memanggil metode loop dari objek handler

        if (this.running) {
            counter++; // Menaikkan nilai counter

            if (startCounting) {
                stateCounter++; // Menaikkan nilai stateCounter
            }

            if (stateCounter >= 40) {
                stateCounter = 0; // Mengatur ulang stateCounter ke 0
                startCounting = false; // Menonaktifkan startCounting
            }

            if (counter >= 50) {
                // Mengubah nilai direction antara 0 dan 1
                direction = (direction == 0) ? 1 : 0;
                counter = 0; // Mengatur ulang counter ke 0
            }

            for (int i = 0; i < handler.count(); i++) {
                if (handler.get(i) instanceof Player) {
                    player = (Player) handler.get(i);
                    // Membuat player terus turun
                    player.setVelY(+3); // Mengatur kecepatan vertikal player ke +3
                    if (player.getY() <= 3) {
                        stop(); // Menghentikan permainan jika player mencapai batas atas
                    }
                    if (player.getY() > 492 - 40) {
                        stop(); // Menghentikan permainan jika player mencapai batas bawah
                    }
                } else if (handler.get(i).getType().equals("Box")) {
                    box = handler.get(i);
                    // Membuat box untuk tetap naik
                    box.setVelY(-2); // Mengatur kecepatan vertikal box ke -2
                    // Memeriksa tabrakan antara player dan box
                    if (player.getBoundBottom().intersects(box.getBounds())) {
                        // Menggeser player tepat di atas objek yang bertabrakan
                        player.setY(box.getBounds().y - player.getHeight());
                        if (box instanceof Box) {
                            Box boxObject = (Box) box;
                            if (!boxObject.isTouched()) {
                                score += boxObject.getPoints();
                                standing++; // Menaikkan nilai standing
                                boxObject.setTouched(true); // Menandai kotak sebagai sudah disentuh oleh pemain
                            }
                        }
                    }
                    if (player.getBoundTop().y < 0) {
                        // Terjadi tabrakan di bagian atas
                        player.setY(0); // Mengatur posisi player tepat di atas layar
                    }
                    if (player.getBoundRight().intersects(box.getBounds())) {
                        // Terjadi tabrakan di bagian kanan
                        // Memperbarui posisi player tepat di sebelah kiri objek yang bertabrakan
                        player.setX(box.getBounds().x - player.getWidth() - 1);
                    }
                    if (player.getBoundLeft().intersects(box.getBounds())) {
                        // Terjadi tabrakan di bagian kiri
                        // Memperbarui posisi player tepat di sebelah kanan objek yang bertabrakan
                        player.setX(box.getBounds().x + box.getBounds().width);
                    }
                }
            }
        }
    }

    /**
     * 
     * Override interface.
     */

    @Override
    public void run() {
        double fps = 60.0;
        double ns = (1000000000 / fps);
        double delta = 0;

        // Timer attributes.
        long time = System.nanoTime();
        long now = 0;
        long timer = System.currentTimeMillis();

        int frames = 0;
        while (running) {
            now = System.nanoTime();
            delta += ((now - time) / ns);
            time = now;

            while (delta > 1) {
                loop(); // Memanggil metode loop
                delta--;
            }

            if (running) {
                render(); // Memanggil metode render
                frames++;
            }

            if ((System.currentTimeMillis() - timer) > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
    }

}

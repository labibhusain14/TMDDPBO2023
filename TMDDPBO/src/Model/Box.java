/**
 * Filename = Box.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package model untuk mengakses kelas box 
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package Model;

import ViewModel.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Box extends GameObject {
    private Color color; // Menyimpan warna box
    private int width; // Menyimpan lebar box yang akan digenerate secara random
    private int points; // Menyimpan poin setiap box
    private boolean touched = false; // Menyimpan status apakah box sudah tersentuh atau belum
    int score = 0; // Menyimpan skor
    int standing = 0; // Menyimpan status berdiri

    // Default constructor.
    public Box() {
        super(0, 0, "Box");
        super.setHeight(30);
        super.setWidth(width);
        this.color = generateRandomColor();
        this.width = 30;
        this.points = calculatePoints(width);
    }

    // Constructor with player position.
    public Box(int x, int y, int width) {
        super(x, y, "Box");
        super.setHeight(30);
        // mengatur lebar box dengan nominal random dari variabel width
        this.width = width;
        // mengatur warna box sesuai dengan method generateRandomColor
        this.color = generateRandomColor();
        super.setWidth(width);
        // mengatur point setiap box sesuai dengan method calculatePoints
        this.points = calculatePoints(width);
    }

    // Menghasilkan warna acak.
    Color generateRandomColor() {
        Random rand = new Random();
        /* Merandom nilai R G B untuk membentuk warna yang berbeda untuk setiap box */
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r, g, b);
    }

    // Menghitung poin berdasarkan lebar box.
    private int calculatePoints(int width) {
        // panjang 30 - 80 akan mengembalikan score 50
        if (width >= 30 && width <= 80) {
            return 50;
        }
        // panjang 81 - 130 akan mengembalikan score 45
        else if (width >= 81 && width <= 130) {
            return 45;
        }
        // panjang 131 - 180 akan mengembalikan score 40
        else if (width >= 131 && width <= 180) {
            return 40;
        }
        // panjang 181 - 230 akan mengembalikan score 35
        else if (width >= 181 && width <= 230) {
            return 35;
        }
        // panjang 231 - 280 akan mengembalikan score 30
        else if (width >= 231 && width <= 280) {
            return 30;
        }
        // panjang 281 - 330 akan mengembalikan score 25
        else if (width >= 281 && width <= 330) {
            return 25;
        }
        // panjang 331 - 380 akan mengembalikan score 20
        else if (width >= 331 && width <= 380) {
            return 20;
        }
        // panjang 381 - 430 akan mengembalikan score 15
        else if (width >= 381 && width <= 430) {
            return 15;
        }
        // Jika width tidak berada dalam rentang yang ditentukan, poinnya 0
        else {
            return 0;
        }
    }

    // Mengunggah poin berdasarkan username ke database.
    public void uploadPoint(String username) throws Exception {
        TableScore tp = new TableScore();
        tp.setPoint(username, score, standing);
    }

    // Setter untuk warna box.
    public void setColor(Color color) {
        this.color = color;
    }

    // Getter untuk status tersentuh.
    public boolean isTouched() {
        return touched;
    }

    // Setter untuk status tersentuh.
    public void setTouched(boolean touched) {
        this.touched = touched;
    }

    // Getter untuk poin.
    public int getPoints() {
        return points;
    }

    // Menggambar box dan poin pada layar.
    @Override
    public void render(Graphics object) {
        // Mengatur bentuk box.
        object.setColor(color);
        object.fillRect(x, y, width, 30);

        // Render poin sejajar dengan kotak
        object.setColor(Color.WHITE);
        // Meletakkan poin untuk setiap box di tengah
        object.drawString(Integer.toString(points), x + (width / 2), y + 20);
    }

    // Pergerakan box.
    @Override
    public void loop() {
        // Menginisialisasi kecepatan, sehingga objek dapat bergerak.
        this.x += this.velX;
        this.y += this.velY;
        x = Game.clamp(x, 0, (Game.width - 50));
    }
}

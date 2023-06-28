/**
 * Filename = GameObject.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package model untuk mengakses GameObject
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package Model;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject implements GameInterface {
    /**
     * Deklarasi atribut.
     */
    protected int x, y; // Posisi.
    protected int width, height; // Dimensi.
    protected int velX, velY; // Kecepatan.
    protected String type; // Tipe objek.

    /**
     * Konstruktor.
     */

    // Konstruktor default.
    public GameObject() {
        this.x = 0;
        this.y = 0;
        this.type = "";
    }

    // Konstruktor dengan koordinat objek.
    public GameObject(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    // Konstruktor dengan koordinat dan bentuk objek.
    public GameObject(int x, int y, int width, int height, String type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    /**
     * Mengembalikan objek Rectangle yang mewakili batas objek.
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Mengembalikan objek Rectangle yang mewakili batas tabrakan bagian bawah
     * objek.
     */
    public Rectangle getBoundBottom() {
        int boundWidth = width / 2; // menghasilkan setengah dari lebar objek
        int boundHeight = height / 2; // menghasilkan setengah dari panjang objek
        int boundX = (int) (x + (width / 2) - (boundWidth / 2)); // menghitung posisi X kiri dari batas bawah
        int boundY = (int) (y + (height / 2)); // untuk menghitung posisi Y atas dari batas bawah objek dengan
                                               // mempertimbangkan tinggi objek
        // menghitung posisi dan ukuran dari objek Rectangle yang akan mewakili batas
        // bawah
        return new Rectangle(boundX, boundY, boundWidth, boundHeight);
    }

    /**
     * Mengembalikan objek Rectangle yang mewakili batas tabrakan bagian atas objek.
     */
    public Rectangle getBoundTop() {
        int boundWidth = width / 2; // menghasilkan setengah dari lebar objek
        int boundHeight = height / 2; // menghasilkan setengah dari panjang objek
        int boundX = (int) (x + (width / 2) - (boundWidth / 2)); // menghitung posisi X kiri dari batas bawah atau batas
                                                                 // atas objek dengan mempertimbangkan lebar objek
        int boundY = (int) y; // Posisi Y
        // menghitung posisi dan ukuran dari objek Rectangle yang akan mewakili batas
        // atas
        return new Rectangle(boundX, boundY, boundWidth, boundHeight);
    }

    /**
     * Mengembalikan objek Rectangle yang mewakili batas tabrakan bagian kanan
     * objek.
     */
    public Rectangle getBoundRight() {
        int boundX = (int) (x + width); // menghitung posisi X untuk batas kanan objek
        int boundY = (int) (y + 5); // menghitung posisi Y untuk batas atas objek
        int boundWidth = 5; // Lebar batas
        int boundHeight = height - 5; // Tinggi batas
        // menghitung posisi dan ukuran dari objek Rectangle yang akan mewakili batas
        // kanan
        return new Rectangle(boundX, boundY, boundWidth, boundHeight);
    }

    /**
     * Mengembalikan objek Rectangle yang mewakili batas tabrakan bagian kiri objek.
     */
    public Rectangle getBoundLeft() {
        int boundX = (int) x; // Posisi X batas
        int boundY = (int) (y + 5); // menghitung posisi Y untuk batas atas objek
        int boundWidth = 5; // Lebar batas
        int boundHeight = height - 5; // Tinggi batas
        // menghitung posisi dan ukuran dari objek Rectangle yang akan mewakili batas
        // kiri
        return new Rectangle(boundX, boundY, boundWidth, boundHeight);
    }

    /**
     * Getter dan Setter.
     */

    /* Mendapatkan posisi X objek. */

    public int getX() {
        return x;
    }

    /* Mengatur posisi X objek. */

    public void setX(int x) {
        this.x = x;
    }

    /* Mendapatkan posisi Y objek. */

    public int getY() {
        return y;
    }

    /* Mengatur posisi Y objek. */

    public void setY(int y) {
        this.y = y;
    }

    /* Mendapatkan lebar objek. */

    public int getWidth() {
        return width;
    }

    /* Mengatur lebar objek. */

    public void setWidth(int width) {
        this.width = width;
    }

    /* Mendapatkan tinggi objek. */

    public int getHeight() {
        return height;
    }

    /* Mengatur tinggi objek. */

    public void setHeight(int height) {
        this.height = height;
    }

    /* Mendapatkan kecepatan X objek. */

    public int getVelX() {
        return velX;
    }

    /* Mengatur kecepatan X objek. */

    public void setVelX(int velX) {
        this.velX = velX;
    }

    /* Mendapatkan kecepatan Y objek. */

    public int getVelY() {
        return velY;
    }

    /* Mengatur kecepatan Y objek. */

    public void setVelY(int velY) {
        this.velY = velY;
    }

    /* Mendapatkan tipe objek. */

    public String getType() {
        return type;
    }

    /* Mengatur tipe objek. */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Implementasi metode render dari GameInterface (tidak digunakan, hanya untuk
     * menghindari kesalahan).
     */
    @Override
    public void render(Graphics object) {

    }

    /**
     * Implementasi metode loop dari GameInterface (tidak digunakan, hanya untuk
     * menghindari kesalahan).
     */
    @Override
    public void loop() {

    }
}

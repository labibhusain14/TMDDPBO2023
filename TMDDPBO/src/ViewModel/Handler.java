/**
 * Filename = Handler.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package ViewModel untuk mengelola objek game dalam permainan.
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package ViewModel;

import java.awt.Graphics;
import java.util.ArrayList;
import Model.GameInterface;
import Model.GameObject;

public class Handler implements GameInterface {
    /**
     * Attribute declaration.
     */

    private ArrayList<GameObject> object; // Array / List of GameObject.

    /**
     * Konstruktor.
     */

    // Konstruktor default.
    public Handler() {
        this.object = new ArrayList<>();
    }

    /**
     * Akses dan manipulasi objek.
     */

    // Menambahkan objek ke dalam list.
    public void add(GameObject object) {
        this.object.add(object);
    }

    // Mengakses objek dari list berdasarkan indeksnya.
    public GameObject get(int i) {
        return this.object.get(i);
    }

    // Menghitung total objek dalam list.
    public int count() {
        return this.object.size();
    }

    // Menghapus objek dari list berdasarkan indeksnya.
    public void remove(int i) {
        this.object.remove(i);
    }

    // Menghapus objek dari list.
    public void remove(GameObject object) {
        this.object.remove(object);
    }

    /**
     * 
     * Implementasi metode dari interface.
     * 
     * @param player
     * @param box
     */

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp; // Deklarasi variabel temp sebagai GameObject
            temp = object.get(i); // Mengambil objek dari list dengan indeks i
            temp.render(g); // Memanggil metode render() pada objek temp
        }
    }

    @Override
    public void loop() {
        for (int i = 0; i < object.size(); i++) {
            GameObject temp; // Deklarasi variabel temp sebagai GameObject
            temp = object.get(i); // Mengambil objek dari list dengan indeks i
            temp.loop(); // Memanggil metode loop() pada objek temp
        }
    }
}

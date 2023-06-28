/**
 * Filename = GameInterface.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package model untuk memberikan kerangka dasar bagi kelas-kelas yang terlibat
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package Model;

import java.awt.Graphics;

public interface GameInterface {
    public void render(Graphics object); // Render object.

    public void loop(); // Loop / refresh object.
}

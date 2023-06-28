/**
 * Filename = Player.java
 * Programmer = Mohammad Labib Husain
 * Date = 2023-06-17
 * Email = labibhusain14@upi.edu
 * Deskripsi = Package model untuk mengakses kelas player 
 */

/* Saya Mohammad Labib Husain 2101989 mengerjakan evaluasi Tugas Masa Depan dalam mata kuliah Desain dan Pemrograman Berorientasi Objek
 untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin. */

package Model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import ViewModel.Game;

public class Player extends GameObject {
    /**
     * Constructor.
     */

    // Default constructor.
    private int score = 0;
    private int standing = 0;

    public Player() {
        super(0, 0, "Player");
        super.setHeight(40);
        super.setWidth(40);
    }

    // Constructor with player position.
    public Player(int x, int y) {
        super(x, y, "Player");
        super.setHeight(40);
        super.setWidth(40);
    }

    /**
     * Override interface.
     */

    @Override
    public void render(Graphics object) {
        // Set player icon.
        ImageIcon icon = new ImageIcon("src/assets/balloon.png");
        Image image = icon.getImage();
        object.drawImage(image, x, y, 40, 40, null);
    }

    @Override
    public void loop() {
        // Initialize velocity, so object can move.
        this.x += this.velX;
        this.y += this.velY;
        // Initialize player bound, so it won't get offset the display.
        x = Game.clamp(x, 0, (Game.width - 50));
        // System.out.println(x);
    }

    public void setScore(int score) {
        // set score
        this.score = score;
    }

    public void setStanding(int standing) {
        // set standing
        this.standing = standing;
    }
}

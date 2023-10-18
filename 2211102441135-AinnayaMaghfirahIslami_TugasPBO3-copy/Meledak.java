import greenfoot.*; // Import Greenfoot library
import java.util.Random;

public class Meledak extends Actor {
    private int speed = 2; // Kecepatan pergerakan
    private Random rand = new Random();

    public void act() {
        move(speed); // Bergerak maju dengan kecepatan
        checkCollision(); // Cek tabrakan saat pergerakan
        checkEdge(); // Cek jika objek mencapai tepi dunia
        randomTurn(); // Pergi ke arah acak
    }

    public void checkCollision() {
        Actor actor = getOneIntersectingObject(null);

        if (actor != null) {
            getWorld().removeObject(actor);
        }
    }

    public void checkEdge() {
        // Jika objek mencapai tepi dunia, balik arah pergerakan
        if (isAtEdge()) {
            turn(180);
        }
    }

    public void randomTurn() {
        // Berputar ke arah acak (0-359 derajat) setiap beberapa langkah
        if (rand.nextInt(100) < 5) {
            int turnAmount = rand.nextInt(360);
            turn(turnAmount);
        }
    }
}

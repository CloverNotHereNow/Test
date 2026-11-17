import java.awt.*;

// Every screen of the game (menu, playing, paused...) implements this.
public interface GameState {
    void update(double dt);          // change game data (dt = seconds since last frame)
    void draw(Graphics2D g2);        // draw only, never change data here
    void keyPressed(int key);
    void mousePressed(int x, int y);
}

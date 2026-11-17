import java.awt.*;
import java.awt.event.KeyEvent;

public class PausedState implements GameState {
    private final Game game;
    private final PlayingState playing; // kept so we can resume exactly where we left off

    public PausedState(Game game, PlayingState playing) {
        this.game = game;
        this.playing = playing;
    }

    @Override
    public void update(double dt) { } // nothing moves while paused

    @Override
    public void draw(Graphics2D g2) {
        playing.draw(g2); // draw the frozen game underneath
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, Game.width, Game.height);
        Game.drawCentered(g2, "PAUSED", Game.height / 2, 64);
        Game.drawCentered(g2, "Press P to resume", Game.height / 2 + 50, 24);
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_P) {
            game.setState(playing);
        }
    }

    @Override
    public void mousePressed(int x, int y) { }
}

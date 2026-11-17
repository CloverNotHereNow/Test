import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverState implements GameState {
    private final Game game;
    private final int waveReached;

    public GameOverState(Game game, int waveReached) {
        this.game = game;
        this.waveReached = waveReached;
    }

    @Override
    public void update(double dt) { }

    @Override
    public void draw(Graphics2D g2) {
        Game.drawCentered(g2, "GAME OVER", Game.height / 2 - 20, 64);
        Game.drawCentered(g2, "You reached wave " + waveReached, Game.height / 2 + 30, 28);
        Game.drawCentered(g2, "Press ENTER to restart", Game.height / 2 + 80, 24);
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_ENTER) {
            game.setState(new PlayingState(game)); // new PlayingState = fresh game
        }
    }

    @Override
    public void mousePressed(int x, int y) { }
}

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState implements GameState {
    private final Game game;

    public MenuState(Game game) {
        this.game = game;
    }

    @Override
    public void update(double dt) { }

    @Override
    public void draw(Graphics2D g2) {
        Game.drawCentered(g2, Game.title, Game.height / 2 - 20, 64);
        Game.drawCentered(g2, "Press ENTER to start", Game.height / 2 + 40, 24);
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_ENTER) {
            game.setState(new PlayingState(game));
        }
    }

    @Override
    public void mousePressed(int x, int y) { }
}

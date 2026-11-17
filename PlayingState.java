import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayingState implements GameState {
    private final Game game;

    // Placeholder data. Replace with your Player / Map / Enemy / Tower classes.
    private int baseHp = 100;
    private int money = 100;
    private int wave = 1;
    private double demoX = 0; // demo square so you can see the loop working; delete later

    // TODO: private Map map;
    // TODO: private ArrayList<Enemy> enemies = new ArrayList<>();
    // TODO: private ArrayList<Tower> towers = new ArrayList<>();
    // TODO: private Player player;

    public PlayingState(Game game) {
        this.game = game;
        // TODO: load the map, set up wave 1
    }

    @Override
    public void update(double dt) {
        demoX = (demoX + 200 * dt) % Game.width; // demo only

        // TODO: for (Enemy e : enemies) e.update(dt);        // walk along the path
        // TODO: for (Tower t : towers)  t.update(dt, enemies); // find target, shoot
        // TODO: remove dead enemies, give money
        // TODO: if an enemy reaches the end -> baseHp -= damage

        if (baseHp <= 0) {
            game.setState(new GameOverState(game, wave));
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        // TODO: map.draw(g2);
        // TODO: for (Tower t : towers)  t.draw(g2);
        // TODO: for (Enemy e : enemies) e.draw(g2);
        g2.setColor(Color.ORANGE);
        g2.fillRect((int) demoX, Game.height / 2, 40, 40); // demo only

        drawHud(g2);
    }

    private void drawHud(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("SansSerif", Font.BOLD, 22));
        g2.drawString("Base HP: " + baseHp, 20, 35);
        g2.drawString("Money: " + money, 20, 65);
        g2.drawString("Wave: " + wave, 20, 95);
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_P) {
            game.setState(new PausedState(game, this));
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        // TODO: place a tower at (x, y) if the player has enough money
        // and the spot is not on the enemy path
        System.out.println("Clicked at " + x + ", " + y);
    }
}

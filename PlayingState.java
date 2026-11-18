import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayingState implements GameState {
    private final Game game;
    private final Maps map;      // your Maps parent class (Map1 is the current level)
    private final Player player; // your Player class: money, health, placement limit

    private int wave = 1;

    // Placeholder enemy: one red dot that walks the map's enemy path.
    // Replace with your Enemies classes later. Position is in tile units.
    private static final double WALKER_SPEED = 8; // tiles per second
    private double walkerCol, walkerRow;
    private int walkerTarget; // index of the path point it is walking toward

    private String lastClick = "Click the map to test it";

    // TODO: use map.getEnemies() / map.getTowers() once Enemies and Towers are ready

    public PlayingState(Game game) {
        this.game = game;
        this.map = new Map1();
        this.player = new Player(100, 100, 10); // money, health, placementLim (placeholder numbers)
        resetWalker();
    }

    private void resetWalker() {
        int[] start = map.getEnemyPath().get(0);
        walkerCol = start[0] + 0.5; // +0.5 = centre of the tile
        walkerRow = start[1] + 0.5;
        walkerTarget = 1;
    }

    @Override
    public void update(double dt) {
        // Move the placeholder enemy toward its next path point
        java.util.List<int[]> path = map.getEnemyPath();
        int[] target = path.get(walkerTarget);
        double tx = target[0] + 0.5;
        double ty = target[1] + 0.5;
        double dx = tx - walkerCol;
        double dy = ty - walkerRow;
        double dist = Math.hypot(dx, dy);
        double step = WALKER_SPEED * dt;

        if (dist <= step) {
            // arrived: snap to the point and aim for the next one
            walkerCol = tx;
            walkerRow = ty;
            walkerTarget++;
            if (walkerTarget >= path.size()) {
                player.setHealth(player.getHealth() - 20); // reached the end: hurt the base
                resetWalker();
            }
        } else {
            walkerCol += dx / dist * step;
            walkerRow += dy / dist * step;
        }

        if (player.getHealth() <= 0) {
            game.setState(new GameOverState(game, wave));
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        int w = game.getWidth();
        int h = game.getHeight();

        map.draw(g2, w, h);

        // placeholder enemy
        double cx = map.toPixelX(walkerCol, w, h);
        double cy = map.toPixelY(walkerRow, w, h);
        double r = map.getTileSize(w, h) * 0.6;
        g2.setColor(Color.RED);
        g2.fillOval((int) (cx - r), (int) (cy - r), (int) (2 * r), (int) (2 * r));

        drawHud(g2);
    }

    private void drawHud(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("SansSerif", Font.BOLD, 22));
        g2.drawString("Base HP: " + player.getHealth(), 20, 35);
        g2.drawString("Money: " + player.getMoney(), 20, 65);
        g2.drawString("Wave: " + wave, 20, 95);
        g2.drawString(lastClick, 20, 125);
    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_P) {
            game.setState(new PausedState(game, this));
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        int w = game.getWidth();
        int h = game.getHeight();
        double col = map.toTileX(x, w, h);
        double row = map.toTileY(y, w, h);
        int c = (int) Math.floor(col);
        int r = (int) Math.floor(row);

        // TODO: place a tower here if the player has enough money and the spot is free
        String where;
        if (c < 0 || r < 0 || c >= map.getX() || r >= map.getY()) {
            where = "outside the map";
        } else if (map.isOnPath(col, row)) {
            where = "the enemy path";
        } else if (isSpot(map.getGroundTowersPlacement(), c, r)) {
            where = "a ground tower spot";
        } else if (isSpot(map.getElevatedTowersPlacement(), c, r)) {
            where = "an elevated tower spot";
        } else {
            where = "empty ground (no tower spot)";
        }
        lastClick = "Tile (" + c + ", " + r + "): " + where;
    }

    private boolean isSpot(java.util.List<int[]> spots, int c, int r) {
        for (int[] s : spots) {
            if (s[0] == c && s[1] == r) return true;
        }
        return false;
    }
}

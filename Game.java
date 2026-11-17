import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements Runnable {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int width = screenSize.width;
    public static final int height = screenSize.height;
    public static final String title = "Fire Defense";

    private static final int FPS = 60;
    private Thread gameThread;
    private volatile boolean running = false;

    // The game only knows about the current screen. The state does the rest.
    private volatile GameState current;

    public Game() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        setFocusable(true);

        current = new MenuState(this);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
                current.keyPressed(e.getKeyCode());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                current.mousePressed(e.getX(), e.getY());
            }
        });
    }

    // States call this to switch screens, e.g. game.setState(new PlayingState(game))
    public void setState(GameState next) {
        current = next;
    }

    public void start() {
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        final long frameTime = 1_000_000_000L / FPS;
        long last = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            double dt = (now - last) / 1_000_000_000.0;
            last = now;

            current.update(dt);
            repaint();

            long sleepMs = (frameTime - (System.nanoTime() - now)) / 1_000_000;
            if (sleepMs > 0) {
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    running = false;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        current.draw(g2);
    }

    // Shared helper so every state can draw centered text
    public static void drawCentered(Graphics2D g2, String text, int y, int size) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("SansSerif", Font.BOLD, size));
        int textWidth = g2.getFontMetrics().stringWidth(text);
        g2.drawString(text, (width - textWidth) / 2, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();

            JFrame frame = new JFrame(title);
            frame.add(game);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            game.requestFocusInWindow();
            game.start();
        });
    }
}

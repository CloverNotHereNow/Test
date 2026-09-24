import javax.swing.*;
import java.awt.*
import java.awt.event.*;
import java.util.*;

public class Game extends JPanel implements Runnable{
	
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final int width = screenSize.width;
	private static final int height = screenSize.height;
	private static final String title = "Fire Defense";
}
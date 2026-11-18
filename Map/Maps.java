import java.util.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public abstract class Maps{
	private int x;
	private int y;
	
	private int[][] map;
	
	private List<int[]> enemyPath = new ArrayList<> ();
	private List<int[]> groundTowersPlacement = new ArrayList<> ();
	private List<int[]> elevatedTowerPlacement = new ArrayList<> ();
	
	
	private List<Enemies> enemies = new ArrayList<> ();
	private List<Towers> towers = new ArrayList<> ();
	
	protected abstract void createMap();
	protected abstract void createEnemyPath();
	protected abstract void createGroundTowerPlacement();
	protected abstract void createElevatedTowerPlacement();
	
	public Maps(int x, int y){
		this.x = x;
		this.y = y;
		
		createMap();
		createEnemyPath();
		createGroundTowerPlacement();
		createElevatedTowerPlacement();
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int[][] getMap(){
		return map;
	}	
	
	public List<int[]> getEnemyPath(){
		return enemyPath;
	}
	
	public List<int[]> getGroundTowersPlacement(){
		return groundTowersPlacement;
	}
	
	public List<int[]> getElevatedTowersPlacement(){
		return elevatedTowerPlacement;
	}
	
	public List<Enemies> getEnemies(){
		return enemies;
	}
	
	public List<Towers> getTowers(){
		return towers;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setMap(int x, int y){
		map = new int[x][y];
	}
	
	public void setEnemyPath(int[] path){
		enemyPath.add(path);
	}
	
	public void setGroundTowerPlacemet(int[] placement){
		groundTowersPlacement.add(placement);
	}
	
	public void setElevatedTowerPlacemet(int[] placement){
		elevatedTowerPlacement.add(placement);
	}
	
	public void setEnemies(Enemies enemies){
		this.enemies.add(enemies);
	}
	
	public void setTowers(Towers towers){
		this.towers.add(towers);
	}
	
	public void killedEnemies(Enemies deletedEnemies){
		enemies.remove(deletedEnemies);
	}
	
	public void deletedTowers(Towers deletedTowers){
		towers.remove(deletedTowers);
	}
	
	// ---------- Drawing and screen <-> tile conversion ----------
	// The map is a grid of x by y tiles. Tile (col, row) covers col..col+1, row..row+1.
	// Points in enemyPath / placements are {col, row} tile numbers.
	// sw and sh are the width and height of the area the map is drawn in.
	
	public double getTileSize(int sw, int sh){
		return Math.min((double) sw / x, (double) sh / y);
	}
	
	public double toPixelX(double col, int sw, int sh){
		double t = getTileSize(sw, sh);
		return (sw - t * x) / 2.0 + col * t;
	}
	
	public double toPixelY(double row, int sw, int sh){
		double t = getTileSize(sw, sh);
		return (sh - t * y) / 2.0 + row * t;
	}
	
	public double toTileX(double px, int sw, int sh){
		double t = getTileSize(sw, sh);
		return (px - (sw - t * x) / 2.0) / t;
	}
	
	public double toTileY(double py, int sw, int sh){
		double t = getTileSize(sw, sh);
		return (py - (sh - t * y) / 2.0) / t;
	}
	
	// True if the point (col, row), in tile units, is on the enemy path
	public boolean isOnPath(double col, double row){
		for(int i = 0; i < enemyPath.size() - 1; i++){
			int[] a = enemyPath.get(i);
			int[] b = enemyPath.get(i + 1);
			if(Line2D.ptSegDist(a[0] + 0.5, a[1] + 0.5, b[0] + 0.5, b[1] + 0.5, col, row) <= 0.75){
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics2D g2, int sw, int sh){
		double t = getTileSize(sw, sh);
		double ox = (sw - t * x) / 2.0;
		double oy = (sh - t * y) / 2.0;
		
		// grass
		g2.setColor(new Color(34, 85, 40));
		g2.fill(new Rectangle2D.Double(ox, oy, t * x, t * y));
		
		// enemy path: a thick line through the centre of each path tile
		if(enemyPath.size() >= 2){
			Path2D.Double path = new Path2D.Double();
			int[] first = enemyPath.get(0);
			path.moveTo(ox + (first[0] + 0.5) * t, oy + (first[1] + 0.5) * t);
			for(int i = 1; i < enemyPath.size(); i++){
				int[] p = enemyPath.get(i);
				path.lineTo(ox + (p[0] + 0.5) * t, oy + (p[1] + 0.5) * t);
			}
			Stroke oldStroke = g2.getStroke();
			g2.setStroke(new BasicStroke((float) (t * 1.5), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2.setColor(new Color(194, 160, 105));
			g2.draw(path);
			g2.setStroke(oldStroke);
		}
		
		// tower spots: blue = ground, purple = elevated
		g2.setColor(new Color(70, 130, 200));
		for(int[] spot : groundTowersPlacement){
			g2.fill(new Rectangle2D.Double(ox + spot[0] * t, oy + spot[1] * t, t, t));
		}
		g2.setColor(new Color(150, 100, 200));
		for(int[] spot : elevatedTowerPlacement){
			g2.fill(new Rectangle2D.Double(ox + spot[0] * t, oy + spot[1] * t, t, t));
		}
	}
}

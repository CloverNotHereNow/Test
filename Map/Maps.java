import java.util.*;

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
}
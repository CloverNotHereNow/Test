// Test level used to try out the game. Not the real Map1.
public class PlaceholderMap extends Maps{
	public PlaceholderMap(){
		super(50, 50);
	}
	
	@Override
	protected void createMap(){
		setMap(50, 50);
	}
	
	// Each point is {column, row} in tiles. Enemies walk the points in order.
	@Override
	protected void createEnemyPath(){
		int[][] points = {
			{0, 10}, {12, 10}, {12, 35}, {27, 35},
			{27, 15}, {40, 15}, {40, 40}, {49, 40}
		};
		for(int[] p : points){
			setEnemyPath(p);
		}
	}
	
	@Override
	protected void createGroundTowerPlacement(){
		int[][] spots = {
			{10, 12}, {14, 12}, {14, 33}, {25, 33}, {29, 33},
			{25, 17}, {29, 17}, {38, 13}, {42, 17}, {42, 38}
		};
		for(int[] s : spots){
			setGroundTowerPlacemet(s);
		}
	}
	
	@Override
	protected void createElevatedTowerPlacement(){
		int[][] spots = {
			{20, 25}, {34, 28}, {6, 13}, {45, 35}
		};
		for(int[] s : spots){
			setElevatedTowerPlacemet(s);
		}
	}
}

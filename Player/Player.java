public class Player{
	private int money;
	private int health;
	private int placementLim;
	
	public Player(int money, int health, int placementLim){
		this.money = money;
		this.health = health;
		this.placementLim = placementLim;
	}
	
	public int getMoney(){
		return money;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getPlacementLim(){
		return placementLim;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public void setPlacementLim(int placementLim){
		this.placementLim = placementLim;
	}
}
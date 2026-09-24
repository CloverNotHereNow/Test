import java.awt.*;

public class Tower1 extends Towers implements Upgrade{
	private static final int[] damageStats = {1, 2, 8, 25};
	private static final double[] atkrateStats = {1, 0.95, 0.9, 0.85}; 
	private static final double[] rangeStats = {1, 1,  2, 5};
	private static final int[] upcostPerLvl = {100, 75, 235, 495};
	
	public Tower1(int x_coord, int y_coord){
		super(x_coord, y_coord);
		
		this.setDamage(damageStats[0]);
		this.setAtkrate(atkrateStats[0]);
		this.setRange(rangeStats[0]);
		this.setUpcost(upcostPerLvl[0]);
		
		this.setSize(1);
		this.setMaxlvl(damageStats.length);
		
		this.setTotalcost(getUpcost());
		this.setSellCost((int) (getTotalcost() * 0.25));
		this.setDesc("Is it getting hot in here? A tower that can help defend against fire quite effectively for a while.");
	}
	
	@Override
	public void upgrade(){
		if(this.getCurrlvl() >= this.getMaxlvl()){
			System.out.println("Max upgrade.");
		}
		else{
			this.lvlup();
			this.setDamage(damageStats[getCurrlvl() - 1]);
			this.setAtkrate(atkrateStats[getCurrlvl() - 1]);
			this.setRange(rangeStats[getCurrlvl() - 1]);
			this.setUpcost(upcostPerLvl[getCurrlvl() - 1]);
			
			this.setTotalcost(getUpcost() + getTotalcost());
			this.setSellCost((int) (getTotalcost() * 0.25));
			
			System.out.println("Tower upgraded!");
		}
	}
	
	@Override
	public void sprite(Graphics g){
		//Later
	}
}
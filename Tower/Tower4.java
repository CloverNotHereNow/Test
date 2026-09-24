import java.awt.*;

public class Tower4 extends Towers implements Upgrade{
	private static final int[] damageStats = {7, 7, 15, 19, 55};
	private static final double[] atkrateStats = {4.5, 4, 4, 4, 5.5}; 
	private static final double[] rangeStats = {10, 11,  17, 20, 30};
	private static final int[] upcostPerLvl = {325, 150, 750, 990, 2890};
	
	public Tower4(int x_coord, int y_coord){
		super(x_coord, y_coord);
		
		this.setDamage(damageStats[0]);
		this.setAtkrate(atkrateStats[0]);
		this.setRange(rangeStats[0]);
		this.setUpcost(upcostPerLvl[0]);
		
		this.setSize(1.5);
		this.setMaxlvl(damageStats.length);
		
		this.setTotalcost(getUpcost());
		this.setSellCost((int) (getTotalcost() * 0.25));
		this.setDesc("Brrrrrrrrr!!! Fast attack rate but low damage tower may and will shread enemies.");
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
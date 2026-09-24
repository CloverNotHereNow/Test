import java.awt.*;

public class Tower2 extends Towers implements Upgrade{
	private static final int[] damageStats = {1, 1, 2, 1, 3};
	private static final double[] atkrateStats = {0.75, 0.45, 0.45, 0.40, 0.15}; 
	private static final double[] rangeStats = {0.75, 0.75,  3, 7, 9};
	private static final int[] upcostPerLvl = {150, 100, 450, 600, 1500};
	
	
	public Tower2(int x_coord, int y_coord){
		super(x_coord, y_coord);

		this.setDamage(damageStats[0]);
		this.setAtkrate(atkrateStats[0]);
		this.setRange(rangeStats[0]);
		this.setUpcost(upcostPerLvl[0]);
		
		this.setSize(1);
		this.setMaxlvl(damageStats.length);
		
		this.setTotalcost(getUpcost());
		this.setSellCost((int) (getTotalcost() * 0.25));
		this.setDesc("Watch out! A tower that starts out slow but will speed up at max potential.");
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
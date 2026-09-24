import java.awt.*;

public abstract class Towers{
	private int x_coord;
	private int y_coord;
	private double size;
	private double atkrate;
	private double range;
	private int dmg;
	private int currlvl = 0;
	private int maxlvl;
	private int upcost;
	private int sellcost;
	private int totalcost;
	private String desc;

	public Towers(int x_coord, int y_coord){
		this.x_coord = x_coord;
		this.y_coord = y_coord;
	}
	
	public abstract void upgrade();
	public abstract void sprite(Graphics g);

	public double getSize(){
		return size;
	}
	
	public double getAtkrate(){
		return atkrate;
	}
	
	public double getRange(){
		return range;
	}
	
	public int getDmg(){
		return dmg;
	}
	
	public int getCurrlvl(){
		return currlvl;
	}
	
	public int getMaxlvl(){
		return maxlvl;
	}
	
	public int getUpcost(){
		return upcost;
	}
	
	public int getSellcost(){
		return sellcost;
	}
	
	public int getTotalcost(){
		return totalcost;
	}
	
	public String desc(){
		return desc;
	}
	
	public void setSize(double size){
		this.size = size;
	}
	
	public void setAtkrate(double atkrate){
		this.atkrate = atkrate;
	}
	
	public void setRange(double range){
		this.range = range;
	}
	
	public void setDamage(int damage){
		this.dmg = damage;
	}
	
	public void setMaxlvl(int maxlvl){
		this.maxlvl = maxlvl;
	}
	
	public void setUpcost(int upcost){
		this.upcost = upcost;
	}
	
	public void setSellCost(int sellcost){
		this.sellcost = sellcost;
	}
	
	public void setTotalcost(int totalcost){
		this.totalcost = totalcost;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public void lvlup(){
		currlvl++;
	}
}
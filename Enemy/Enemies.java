import java.awt.*;

public abstract class Enemies{
	private int x_coord;
	private int y_coord;
	private int hp;
	private int def;
	private int cashDrop;
	private double speed;
	private double size;
	private String desc;
	private boolean isAlive = true;
	
	public Enemies(int x_coord, int y_coord, int hp, int def, int cashDrop, double speed, double size, String desc){
		this.x_coord = x_coord;
		this.y_coord = y_coord;
		this.hp = hp;
		this.def = def;
		this.cashDrop = cashDrop;
		this.speed = speed;
		this.size = size;
		this.desc = desc;
	}
	
	public int getX(){
		return x_coord;
	}
	
	public int getY(){
		return y_coord;
	}
	
	public int getHp(){
		return hp;
	}
	
	public int getDef(){
		return def;
	}
	
	public int getCashDrop(){
		return cashDrop;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public double getSize(){
		return size;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public void setX(){
		this.x_coord = x_coord;
	}
	
	public void setY(){
		this.y_coord = y_coord;
	}
	
	public void setHp(int hp){
		this.hp = hp;
	}
	
	public void setDef(int def){
		this.def = def;
	}
	
	public void setCashDrop(int cashDrop){
		this.cashDrop = cashDrop;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setSize(double size){
		this.size = size;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public void update(){
		//other logics
		
		if(hp <= 0){
			isAlive = false;
		}
	}
	
	public abstract void sprite(Graphics g);
}
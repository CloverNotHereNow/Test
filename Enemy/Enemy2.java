import java.awt.*;

public class Enemy2 extends Enemies{
	public Enemy2(int x_coord, int y_coord, int hp, int def, int cashDrop, double speed, double size, String desc){
		super(x_coord, y_coord, hp, def, cashDrop, speed, size, desc);
	}
	//hp 5, def 0, cash drop 5, speed 3, size 0.8, desc fast-speading fire
	
	@Override
	public void sprite(Graphics g){
		//Later
	}
}
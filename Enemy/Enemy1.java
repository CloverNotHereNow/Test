import java.awt.*;

public class Enemy1 extends Enemies{
	public Enemy1(int x_coord, int y_coord, int hp, int def, int cashDrop, double speed, double size, String desc){
		super(x_coord, y_coord, hp, def, cashDrop, speed, size, desc);
	}
	//hp 10, def 0, cash drop 10, speed 1, size 1, desc fire
	
	@Override
	public void sprite(Graphics g){
		//Later
	}
}
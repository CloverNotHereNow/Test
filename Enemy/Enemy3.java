import java.awt.*;

public class Enemy3 extends Enemies{
	public Enemy3(int x_coord, int y_coord, int hp, int def, int cashDrop, double speed, double size, String desc){
		super(x_coord, y_coord, hp, def, cashDrop, speed, size, desc);
	}
	//hp 20, def 0, cash drop 15, speed 0.5, size 3, desc slow-spearding fire
	
	@Override
	public void sprite(Graphics g){
		//Later
	}
}
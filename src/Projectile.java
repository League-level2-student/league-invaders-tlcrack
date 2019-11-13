import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 2;
	}
	
	public void update(){
		y-=speed;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}

}

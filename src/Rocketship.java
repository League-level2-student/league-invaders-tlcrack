import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
public int xSpeed = 0;
public int ySpeed = 0;
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		
		// TODO Auto-generated constructor stub
	}

	
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}

	 public void up() {
	        ySpeed=-speed;
	    }
	 public void down() {
	        ySpeed=speed;
	    }
	 public void right() {
	        xSpeed=speed;
	    }
	 public void left() {
	        xSpeed=-speed;
	    }
	 public void update() {
		 if(x>=5&&xSpeed<=0) {
		 x+=xSpeed;
	 }
	 	if(x<=445&&xSpeed>=0) {
	 		x+=xSpeed;
	 	}
	 	if(y>=5&&ySpeed<=0) {
	 		y+=ySpeed;
	 	}
	 	if(y<=725&&ySpeed>=0) {
	 		y+=ySpeed;
	 	}
	 }
	 
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {
public int xSpeed = 0;
public int ySpeed = 0;

public static BufferedImage image;
public static boolean needImage = true;
public static boolean gotImage = false;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		
		// TODO Auto-generated constructor stub
		
		if (needImage) {
		    loadImage ("rocket.png");
		}
		
	}

	
	
	void draw(Graphics g) {
		
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		super.draw(g);
		
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
	 
	 void loadImage(String imageFile) {
	    if (needImage) {
	      try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
          } catch (Exception e) {
	            
	      }
          needImage = false;
	    }
	 }
	 
	 
	 public Projectile getProjectile() {
	        return new Projectile(x+width/2, y, 40, 40);
	} 
}

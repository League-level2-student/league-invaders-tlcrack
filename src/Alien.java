import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Alien extends GameObject {

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	int superspeed = 10;
	Random r = new Random();
	int random = 0;
	
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
		random = r.nextInt(5);
		if(random==1) {
			speed=superspeed;
		}
		if (needImage) {
		    loadImage ("alien.png");
		}

	}
	
	public void update(){
		y+=speed;
		super.update();
	}
	
	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
		super.draw(g);
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
	
}

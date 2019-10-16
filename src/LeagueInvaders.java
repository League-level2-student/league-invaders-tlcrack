import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame background;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	
	GamePanel gp;
	
	public static void main(String[] args) {
		LeagueInvaders inner = new LeagueInvaders();
		
	}
	LeagueInvaders(){
		this.background = new JFrame();
		this.gp = new GamePanel();
		setup();
	}
	
	void setup() {
		background.add(gp);
		background.setSize(new Dimension(WIDTH, HEIGHT));
		background.setVisible(true);
		background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

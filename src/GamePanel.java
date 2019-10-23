import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = END;
    Font titleFont;
    Font subtext1;
    Font subtext2;
	
	GamePanel(){
		this.titleFont = new Font("Arial", Font.PLAIN, 48);
		this.subtext1 = new Font("New Roman", Font.PLAIN, 24);
		this.subtext2 = new Font("New Roman", Font.PLAIN, 24);
	}

	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	 public void updateMenuState() {  
		 
	 }
	 
	 public void updateGameState() {  
		 
	 }
	 public void updateEndState()  {  
		 
	 }
	 public void drawMenuState(Graphics g) {
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.YELLOW);
		 g.drawString("LEAGUE INVADERS", 35, 150);
		 
		 g.setFont(subtext1);
		 g.setColor(Color.YELLOW);
		 g.drawString("Press ENTER to start", 110, 300);
		 
		 g.setFont(subtext2);
		 g.setColor(Color.YELLOW);
		 g.drawString("Press SPACE for instructions", 80, 450);
	 }
	 public void drawGameState(Graphics g) {
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
	 public void drawEndState(Graphics g)  {
		 g.setColor(Color.RED);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(titleFont);
		 g.setColor(Color.GREEN);
		 g.drawString("GAME OVER", 100, 100);
		 
		 g.setFont(subtext1);
		 g.setColor(Color.GREEN);
		 g.drawString("You killed " + " enemies", 100, 300);
		 
		 g.setFont(subtext2);
		 g.setColor(Color.GREEN);
		 g.drawString("Press ENTER to restart", 100, 300);
		 
		 g.setFont(subtext1);
		 g.setColor(Color.GREEN);
		 g.drawString("ngrsjgmoijmrd,odcj", 100, 500);
		 
		 g.setFont(subtext1);
		 g.setColor(Color.GREEN);
		 g.drawString("ekoawppcvaskdgzs;k", 100, 500);

	 }

}

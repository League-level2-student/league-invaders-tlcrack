import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
    Font titleFont;
    Font subtext1;
    Font subtext2;
    Timer frameDraw;
    Rocketship rocket = new Rocketship(250, 700, 50, 50);
	boolean direction_pressed = false;
	
    
	GamePanel(){
		this.titleFont = new Font("Arial", Font.PLAIN, 48);
		this.subtext1 = new Font("New Roman", Font.PLAIN, 24);
		this.subtext2 = new Font("New Roman", Font.PLAIN, 24);
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
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
		 rocket.draw(g);
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
		 
		
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		
		if (currentState == GAME) {
			if (key==KeyEvent.VK_UP) {
				if(rocket.y>0) {
					rocket.up();
					}
			}
			else if (key==KeyEvent.VK_DOWN) {
			    if(rocket.y<730) {
					rocket.down();
					}
			}
			else if (key==KeyEvent.VK_RIGHT) {
			    if(rocket.x<450) {
					rocket.right();
					}
			}
			else if (key==KeyEvent.VK_LEFT) {
			    if(rocket.x>0) {
					rocket.left();
					}
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

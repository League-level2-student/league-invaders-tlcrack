import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font subtext1;
	Font subtext2;
	Timer frameDraw;
	Timer alienSpawn;
	Rocketship rocket = new Rocketship(250, 700, 55, 66);
	boolean direction_pressed = false;
	ObjectManager manager = new ObjectManager(rocket);
	public static BufferedImage backgroundImage;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	GamePanel() {
		if (needImage) {
			loadImage("background.jpg");
		}

		this.titleFont = new Font("Arial", Font.PLAIN, 48);
		this.subtext1 = new Font("New Roman", Font.PLAIN, 24);
		this.subtext2 = new Font("New Roman", Font.PLAIN, 24);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		if (rocket.isActive == false) {
			currentState = END;
			rocket = new Rocketship(250, 700, 55, 66);
			manager = new ObjectManager(rocket);
		}

		rocket.update();
		manager.update();
	}

	public void updateEndState() {

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
		if (gotImage) {
			g.drawImage(backgroundImage, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		manager.draw(g);
		g.drawString("Score:" + manager.getScore(), 20, 20);
	}

	public void drawEndState(Graphics g) {
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
		g.drawString("Press ENTER to restart", 100, 500);

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				backgroundImage = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

	void startGame() {
		alienSpawn = new Timer(1000, manager);
		alienSpawn.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
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
		if (key == KeyEvent.VK_ENTER) {
			currentState++;
			System.out.println("checkiroodles");

			if (currentState == GAME) {
				startGame();
			} else if (currentState == END) {
				System.out.println("and check");
				currentState = MENU;
				alienSpawn.stop();
				rocket = new Rocketship(250, 700, 55, 66);
				manager = new ObjectManager(rocket);

			}

		}

		if (currentState == GAME) {
			if (key == KeyEvent.VK_UP) {
				if (rocket.y > 0) {
					rocket.up();
				}
			} else if (key == KeyEvent.VK_DOWN) {
				if (rocket.y < LeagueInvaders.HEIGHT - rocket.height) {
					rocket.down();
				}
			} else if (key == KeyEvent.VK_RIGHT) {
				if (rocket.x < LeagueInvaders.WIDTH - rocket.width) {
					rocket.right();
				}
			} else if (key == KeyEvent.VK_LEFT) {
				if (rocket.x > 0) {
					rocket.left();
				}
			} else if (key == KeyEvent.VK_SPACE) {
				manager.addProjectile(rocket.getProjectile());
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT)
			rocket.xSpeed = 0;
		rocket.ySpeed = 0;
	}

}

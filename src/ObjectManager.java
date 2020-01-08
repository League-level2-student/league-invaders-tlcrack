import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship r;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;

	ObjectManager(Rocketship r) {
		this.r = r;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);

	}
	
	
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH - 50), 0, 50, 74));

	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y > 800) {
				aliens.get(i).isActive = false;
				r.isActive=false;
			}
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y < 0) {
				projectiles.get(i).isActive = false;
			}
		}

		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		r.draw(g);

		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isActive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isActive == false) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (r.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive = false;
				r.isActive = false;
			} else {
				for (int a = 0; a < projectiles.size(); a++) {
					if (projectiles.get(a).collisionBox.intersects(aliens.get(i).collisionBox)) {
						aliens.get(i).isActive = false;
						projectiles.get(a).isActive = false;
						score += 1;
					}
				}
			}
		}
	}

	int getScore() {
		return score;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}

}

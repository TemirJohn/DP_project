package org.Temirjohn.entity.enemies;

import java.awt.Graphics2D;

public interface IEnemy extends Cloneable {
	public EnemyManager getComposite();	

	public void update();	
	
	public void draw(Graphics2D g2);
	
	public int getDistanceTraveled();	
	
	public void takeDamage(int damage);
	
	public int getX();	
	
	public int getY();	
	

	public int getHealth();
	
	public int getStrength();
	
	public void setHealth(int health);
	
	public void setStrength(int strength);

	public void destroy();
	
	public IEnemy clone();

	public void setOriginalHealth(int health);
    
	public int getOriginalHealth();
}
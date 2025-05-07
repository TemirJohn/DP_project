package org.Temirjohn.entity.towers;

import org.Temirjohn.main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class acts as a composite, allowing GamePanel to update and draw all the player's towers at once rather
 * than having to loop through each one.
 *
 *
 */
public class TowerManager implements ITower {

	protected List<ITower> children = new ArrayList<ITower>();

	/**
	 * Calls the update function on all towers individually.
	 */
	@Override
	public void update() {
		for(ITower t : children) {
			t.update();
		}
	}

	/**
	 * Calls the draw function on all towers individually.
	 */
	@Override
	public void draw(Graphics2D g2) {
		for(ITower t : children) {
			t.draw(g2);
		}
	}

	/**
	 * Add a tower to the TowerManager's children.
	 * @param t Tower to be added
	 */
	public void add(ITower t) {
		t.getCollisionBox().setLocation(t.getX() + (t.getType().getCollisionInfo()[0] * GamePanel.getInstance().SCALE), t.getY() + (t.getType().getCollisionInfo()[1] * GamePanel.getInstance().SCALE));
		System.out.println("Tower at X=" + t.getX() + ", Y=" + t.getY());
		System.out.println("Collision box at X=" + t.getCollisionBox().getLocation().x + ", Y=" + t.getCollisionBox().getLocation().y);
		children.add(t);
	}

	/**
	 * Remove a tower from the TowerManager's children.
	 * @param t Tower to be removed
	 */
	public void remove(ITower t) { children.remove(t); }

	/**
	 * Find and return a specific child from TowerManager
	 * @param target Tower being searched for
	 * @return Tower if found, otherwise null
	 */
	public ITower getChild(ITower target) {
		for(ITower t : children) {
			if(t.equals(target))
				return t;
		}
		return null;
	}

	/**
	 * Get the list of towers managed by this TowerManager
	 * @return List of {@link ITower} objects
	 */
	public List<ITower> getChildren() { return children; }

	@Override
	public TowerManager getComposite() { return this; }

	@Override
	public void updateTarget() {}

	@Override
	public void attack() {}

	@Override
	public double getFireRate() { return 0; }

	@Override
	public Rectangle getCollisionBox() {
		return null;
	}

	@Override
	public void setCollisionBox(Rectangle box) {
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public TowerType getType() {
		return null;
	}

	@Override
	public int getRange() {
		return 0;
	}
}

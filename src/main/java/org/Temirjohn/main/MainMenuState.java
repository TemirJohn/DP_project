package org.Temirjohn.main;

import org.Temirjohn.entity.SpriteNotFoundException;
import org.Temirjohn.entity.enemies.EnemyManager;
import org.Temirjohn.entity.towers.TowerManager;
import org.Temirjohn.levels.Level;
import org.Temirjohn.ui.MainMenuUI;

import java.awt.*;

/**
 * Game state used when the player is on the main menu of the game

 */
public class MainMenuState implements GameState{

	private MainMenuUI ui;
	

	public MainMenuState() {
		try {
			ui = new MainMenuUI();
		}
		catch(SpriteNotFoundException e) {
			System.out.println("Error: MainMenuUI could not find necessary images.");
		}
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void endState() {
		ui.remove();
	}

	@Override
	public StateType getType() {
		return StateType.MENU;
	}

	@Override
	public Level getLevel() {
		return null;
	}

	@Override
	public TowerManager getTowerManager() {
		return null;
	}

	@Override
	public EnemyManager getEnemyManager() {
		return null;
	}

	@Override
	public Player getPlayer() {
		return null;
	}

}

package com.mhms.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mhms.game.Game;
import com.mhms.game.load.LoadLevel;
import com.mhms.game.objects.properties.PlayerControlProperty;
import com.mhms.game.utils.GameConstants;


/**
 * This class stores the data of a particular game instance, whether new or saved.
 * The galaxy can be used to dig down and find specific locations to travel to.
 * All other location variables are used to store which places the player in this
 * instance is currently located in.
 * 
 * The currentCollection determines the specific place that should currently be rendered
 * to the screen.
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class PacGameInstance extends GameInstance {

	private boolean paused;
	private Level level;
	private Player pacman;
	private Player ghost;
	
	public PacGameInstance(){
		level = LoadLevel.load("level0");
		pacman = new Player();
		pacman.setName("pacman");
		pacman.setImg(Game.getGlobal().getImgByName("pacman-open"));
		pacman.setPosBox(new Rectangle(70,70,GameConstants.BLOCKSIZE/2,GameConstants.BLOCKSIZE/2));
		pacman.getProperties().add(new PlayerControlProperty(1));
		
		ghost = new Player();
		ghost.setName("ghost");
		ghost.setImg(Game.getGlobal().getImgByName("redghost-left"));
		ghost.setPosBox(new Rectangle(70,70,GameConstants.BLOCKSIZE/2, GameConstants.BLOCKSIZE/2));
		ghost.getProperties().add(new PlayerControlProperty(2));
		
	}

	public void render(SpriteBatch batch){
		pacman.render(batch);
		ghost.render(batch);
		level.render(batch);
	}
	
	int count=0;
	
	public void update(){
		pacman.update();
		ghost.update();
	}

	public boolean isPaused() {
		return paused;
	}
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Player getPacman() {
		return pacman;
	}

	public void setPacman(Player pacman) {
		this.pacman = pacman;
	}

	public Player getGhost() {
		return ghost;
	}

	public void setGhost(Player ghost) {
		this.ghost = ghost;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
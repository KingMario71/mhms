package com.mhms.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mhms.game.Game;
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
	
	public PacGameInstance(){
		level = new Level();
		pacman = new Player();
		pacman.setName("pacman");
		pacman.setImg(Game.getGlobal().getImgByName("pacman-open"));
		pacman.setPosBox(new Rectangle(0,0,GameConstants.BLOCKSIZE,GameConstants.BLOCKSIZE));
		pacman.getProperties().add(new PlayerControlProperty());
		
	}

	public void render(SpriteBatch batch){
		pacman.render(batch);
	}
	
	int count=0;
	
	public void update(){
		pacman.update();
	}

	public boolean isPaused() {
		return paused;
	}
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
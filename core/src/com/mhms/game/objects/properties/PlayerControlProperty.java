package com.mhms.game.objects.properties;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mhms.game.Game;
import com.mhms.game.objects.Block;
import com.mhms.game.objects.Ent;
import com.mhms.game.objects.PacGameInstance;
import com.mhms.game.objects.Property;

public class PlayerControlProperty extends Property{

	public PlayerControlProperty(){
		super();
		this.setName("PlayerControlProperty");
	}
	
	public void update(Ent e){
		float startX = e.getX();
		float startY = e.getY();
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			e.setX(e.getX()-1);
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			e.setX(e.getX()+1);
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			e.setY(e.getY()+1);
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			e.setY(e.getY()-1);
		}
		
		PacGameInstance game = (PacGameInstance)Game.getGlobal().getGame();
		
		boolean collided = false;
		for(Block b : game.getLevel().getBlocks()){
			boolean collidable = false;
			for(Property p : b.getProperties()){
				if (p.getName().equals("CollidableProperty")){
					collidable = true;
					break;
				}
			}
			if (collidable && b.getPosBox().overlaps(e.getPosBox())){
				collided = true;
				break;
			}
		}
		
		if (collided){
			e.setX(startX);
			e.setY(startY);
		}
	}
}

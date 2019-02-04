package com.mhms.game.objects.properties;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mhms.game.objects.Ent;
import com.mhms.game.objects.Property;

public class PlayerControlProperty extends Property{

	public void update(Ent e){
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
		
	}
}

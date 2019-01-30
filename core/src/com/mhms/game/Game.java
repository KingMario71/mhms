package com.mhms.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.mhms.game.objects.Global;

public class Game extends ApplicationAdapter {

	private static Global global; //object oriented programming allows you to create your own types.
	
	
	@Override
	public void create () {
		global = new Global(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()); //it understnds you are using the new constructor because two inputs.// width of the window that is open //for the global variable. We are setting it up as a new instance of object type golbal.
	
	}

	@Override
	public void render () {
		
	}
	
	@Override
	public void dispose () {

	}

	public static Global getGlobal() {
		return global;
	}
}

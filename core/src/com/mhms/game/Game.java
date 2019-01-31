package com.mhms.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mhms.game.load.LoadImgs;
import com.mhms.game.load.LoadMenus;
import com.mhms.game.objects.Global;

public class Game extends ApplicationAdapter {

	private static Global global; //object oriented programming allows you to create your own types.
	
	
	@Override
	public void create () {
		global = new Global(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()); //it understnds you are using the new constructor because two inputs.// width of the window that is open //for the global variable. We are setting it up as a new instance of object type golbal.
		LoadImgs.load();
		LoadMenus.load();
		
	}

	@Override
	public void render () {
		
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch batch = global.getBatch();
		SpriteBatch menuBatch = global.getMenuBatch();
		
		
		global.getCurrentMenu().update(global.getStateTime());
		if (global.getGame() != null){
			global.getGame().update();
		}
		
		//RENDERS
		batch.begin();
		if (global.getGame() != null){
			global.getGame().render(batch);
		}
		batch.end();
		
		menuBatch.begin();
		global.getCurrentMenu().render(menuBatch);
		menuBatch.end();
		
		//System.out.println(Gdx.graphics.getFramesPerSecond());
	}
	
	@Override
	public void dispose () {

	}

	public static Global getGlobal() {
		return global;
	}
}

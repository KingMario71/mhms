package com.mhms.game.objects;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mhms.game.Game;
import com.mhms.game.objects.Ent;
import com.mhms.game.objects.Menu;


public class GameMenu extends Menu{
	
	
	
	public GameMenu(){
		load();
		
	}
	
	public void load(){
		this.setName("game");
		
		ArrayList<Ent> ents = new ArrayList<Ent>();
		
		
		this.setEnts(ents);
		
	}
	
	public void render(SpriteBatch batch){
		for(Ent e : this.getEnts()){
				e.render(batch);
		}
	}
	
	public void update(float stateTime){

	}
	
	public void buttonSelect(){
		Ent selected = this.getSelectedEnt();
		if (selected.getName().equals("btnStart")){
			Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("game"));
			Game.getGlobal().setGame(null);
		}
	}
	
	public void buttonDeselect(){
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)){
			Gdx.app.exit();
		}
	}
	

}
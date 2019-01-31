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


public class MainMenu extends Menu{
	
	
	
	public MainMenu(){
		load();
		
	}
	
	public void load(){
		this.setName("main");
		
	
		ArrayList<Ent> ents = new ArrayList<Ent>();
		Ent buttonStart = new Ent();  // creating a new object called buttonStart
		buttonStart.setName("buttonStart"); //we are setting a string variable called buttonStart for that object so if we have to find button start, we can search through array list
		buttonStart.setImg(Game.getGlobal().getImgByName("Start"));
		buttonStart.setPosBox(new Rectangle(
				(Game.getGlobal().getDefaultScreenWidth()/2)-50, //accounting for width of image
				(Game.getGlobal().getDefaultScreenHeight()/2)-25, //accounting for the height of the image
				
				100,
				50));
				 //we are pulling width and height from the user's screen. 
		
		ents.add(buttonStart);
		this.setEnts(ents);
		
	}
	
	public void render(SpriteBatch batch){
		for(Ent e : this.getEnts()){
				e.render(batch);
		}
	}
	
	public void update(float stateTime){
		if (Gdx.input.justTouched()) {
			Rectangle cursorPosition = new Rectangle();
			cursorPosition.x = Gdx.input.getX(); // method getX
			cursorPosition.y = Game.getGlobal().getDefaultScreenHeight()-Gdx.input.getY(); 
			cursorPosition.width = 1;
			cursorPosition.height = 1;
			for (Ent n: getEnts()) {
				if (cursorPosition.overlaps(n.getPosBox())) {
					if (n.getName().equals("buttonStart")) { // if the mouse is clicked and the position is anywhere on the entity of the start button
						Game.getGlobal().setCurrentMenu(Game.getGlobal().getMenuByName("game"));
						Game.getGlobal().setGame(new GameInstance());
					}
				}
			}
		}
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
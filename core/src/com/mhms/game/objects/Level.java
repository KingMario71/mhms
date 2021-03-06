package com.mhms.game.objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {

	private String name;
	private int id;
	private ArrayList<Block> blocks;
	
	public Level(){
		this.blocks = new ArrayList<Block>();
	}
	
	public void render(SpriteBatch batch){
		for(Block b : blocks){
			b.render(batch);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}
	
	
}

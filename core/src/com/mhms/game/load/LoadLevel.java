package com.mhms.game.load;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.mhms.game.objects.Block;
import com.mhms.game.objects.Level;
import com.mhms.game.objects.properties.CollidableProperty;
import com.mhms.game.utils.GameConstants;

public class LoadLevel {

	public static Level load(String levelName){
		Level level = new Level();
		level.setName(levelName);
		FileHandle fileLevel = Gdx.files.local("data/level/"+levelName+".txt");
		String strLevel = fileLevel.readString();
		
		char[] charLevel = strLevel.toCharArray();
		
		int x=0;
		int y=0;
		for(int index=charLevel.length-1; index>=0; index--){
			char c = charLevel[index];
			if (c=='0'){
				Block b = generateWallBlock(x,y);
				level.getBlocks().add(b);
			}
			x += GameConstants.BLOCKSIZE;
			if (c=='\n'){
				x=0;
				y += GameConstants.BLOCKSIZE;
			}
		}
		
		
		return level;
	}
	
	public static Block generateWallBlock(int x, int y){
		Block b = new Block();
		b.setName("wall");
		b.setPosBox(new Rectangle(x,y,GameConstants.BLOCKSIZE,GameConstants.BLOCKSIZE));
		b.setColor(Color.RED);
		b.getProperties().add(new CollidableProperty());
		
		return b;
	}
}

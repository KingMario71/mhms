package com.mhms.game.objects;

import com.mhms.game.Game;

public class Block extends Ent {

	public Block(){
		super();
		this.setImg(Game.getGlobal().getImgByName("block"));
	}
}

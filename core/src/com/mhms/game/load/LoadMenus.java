package com.mhms.game.load;

import java.util.ArrayList;

import com.mhms.game.Game;
import com.mhms.game.objects.GameMenu;
import com.mhms.game.objects.MainMenu;
import com.mhms.game.objects.Menu;


/**
 * This class loads the in game menu screens and populates them with 
 * all the entities and where they're lcoated
 * @author Matt Schrum - slyvr89
 * @date 10/25/2013
 */
public class LoadMenus {

	public static void load(){
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		menus.add(new MainMenu());
		menus.add(new GameMenu());
		Game.getGlobal().setMenus(menus);
		Game.getGlobal().setCurrentMenu(menus.get(0));
	}
}
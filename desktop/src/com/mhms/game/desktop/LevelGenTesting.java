package com.mhms.game.desktop;

import java.util.ArrayList;

public class LevelGenTesting {

	static ArrayList<ArrayList<Character>> level;
	
	static int height = 22;
	static int width = 20;
	
	public static void main(String[] args) {
		level = new ArrayList<ArrayList<Character>>();
		
		for(int y=0; y<=height; y++){
			ArrayList<Character> xVals = new ArrayList<Character>();
			for(int x=0; x<=width; x++){
				char c = '.';
				//Add sides
				if (y==0 || y==height || x==0 || x==width){
					c = '0';
				}
				//Add center box
				if ((y==10 || y==12) && (x>=7 && x<=13)){
					c = '0';
				}
				if ((y==11 && x==7) || (y==11 && x==13)){
					c = '0';
				}
				if (y==10 && x==width/2){
					c = '.';
				}
				//Add center path
				if ((y==11 && x==0) || (y==11 && x==width)){
					c = '.';
				}
				
				xVals.add(c);
			}
			level.add(xVals);
		}
		
		
		for(ArrayList<Character> xVals : level){
			for(Character c : xVals){
				System.out.print(c);
			}
			System.out.print("\n");
		}
		
	}

}

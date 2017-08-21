package com.clovisleoncio.gameoflife.generator;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final int LINES = 20;
	private static final int COLUMNS = 30;

    public static void main( String[] args )
    {
    	boolean[][] ecossystem = createRandomEcossystem();
    	
    	print(ecossystem);
    }

	private static void print(boolean[][] ecossystem) {
		for (int i = 0; i < ecossystem.length; i++) {
			for (int j = 0; j < ecossystem[i].length; j++) {
				System.out.print(ecossystem[i][j] ? '*' : ' ');
			}
			System.out.println();
		}
	}

	private static boolean[][] createRandomEcossystem() {
		
		Random random = new Random();		
		
		boolean[][] ecossystem = new boolean[LINES][COLUMNS];
		for (int i = 0; i < ecossystem.length; i++) {
			for (int j = 0; j < ecossystem[i].length; j++) {
				ecossystem[i][j] = random.nextBoolean();
			}
		}
		return ecossystem;
	}

}

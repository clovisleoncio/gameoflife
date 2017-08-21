package com.clovisleoncio.gameoflife;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App {
	
	private static final int LINES = 20;
	private static final int COLUMNS = 30;
	
	public static void main(String[] args) {
		
		boolean[][] ecossystem = createRandomEcossystem();

		print(ecossystem);
		
		while (true) {
			System.out.println("----------");
			ecossystem = applyRules(ecossystem);
			print(ecossystem);
		}
		
	}

	private static boolean[][] applyRules(boolean[][] ecossystem) {
		boolean[][] result = new boolean[ecossystem.length][ecossystem[0].length];
		
		for (int i = 0; i < ecossystem.length; i++) {
			for (int j = 0; j < ecossystem[i].length; j++) {
				boolean isAlive = ecossystem[i][j];
				int liveCellsAround = liveCellsAround(i, j, ecossystem);
				if (isAlive) { // live cell
					if (liveCellsAround < 2 || liveCellsAround > 3) {
						isAlive = false; // underpopulation
					}
				}
				else {
					if (liveCellsAround == 3) {
						isAlive = true;
					}
				}
				result[i][j] = isAlive;
			}
		}
		
		return result;
	}

	private static int liveCellsAround(int i, int j, boolean[][] ecossystem) {
		int result = 0;
		
		result += aliveToNumber(i - 1, j + 1, ecossystem);
		result += aliveToNumber(i - 1, j, ecossystem);
		result += aliveToNumber(i - 1, j - 1, ecossystem);
		result += aliveToNumber(i, j + 1, ecossystem);
		result += aliveToNumber(i, j - 1, ecossystem);
		result += aliveToNumber(i + 1, j + 1, ecossystem);
		result += aliveToNumber(i + 1, j, ecossystem);
		result += aliveToNumber(i + 1, j - 1, ecossystem);
		
		return result;
	}

	private static int aliveToNumber(int i, int j, boolean[][] ecossystem) {
		if (i < 0 || i >= ecossystem.length) {
			return 0;
		}
		if (j < 0 || j >= ecossystem[0].length) {
			return 0;
		}
		return ecossystem[i][j] ? 1 : 0;
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

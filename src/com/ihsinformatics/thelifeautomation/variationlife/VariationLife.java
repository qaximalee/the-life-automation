package com.ihsinformatics.thelifeautomation.variationlife;

import com.ihsinformatics.thelifeautomation.interfaces.ILifeRules;
import com.ihsinformatics.thelifeautomation.output.Output;

/*
 * @author qasim.ali@ihsinformatics.com
 * */

public class VariationLife implements ILifeRules {

	int[][] generationCounter;

	public VariationLife(int row, int col) {
		generationCounter = new int[row][col];
	}

	@Override
	public String[][] step(String[][] data, int generation, int counter) {
		if (generation == 0) {
			return null;
		} else {
			// TODO Auto-generated method stub
			String[][] returnData = new String[data.length][data[0].length];

			int neighborCount = 0;
			int cellStatus = 0;
			// Count Neighbor
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {

					/*
					 * Below are the conditions which counts the horizontal and vertical neighbor of
					 * a cell
					 */
					// FOR RIGHT
					if (j + 1 < data[i].length && data[i][j + 1].equals("+")) {
						neighborCount++;
					}

					// FOR LEFT
					if (j - 1 >= 0 && data[i][j - 1].equals("+")) {
						neighborCount++;
					}

					// FOR BOTTOM
					if (i + 1 < data.length && data[i + 1][j].equals("+")) {
						neighborCount++;
					}

					// FOR UP
					if (i - 1 >= 0 && data[i - 1][j].equals("+")) {
						neighborCount++;
					}

					// Checks if the current cell is alive or survived
					if (data[i][j].equals("+") || data[i][j].equals("X")) {
						cellStatus = 1;
						generationCounter[i][j]++;
					}

					if (deathRule(neighborCount, cellStatus, generationCounter[i][j])) {
						returnData[i][j] = "null";
					} else if (survivalRule(neighborCount, cellStatus, generationCounter[i][j])) {
						if (data[i][j].equals("+"))
							returnData[i][j] = "X";
						else
							returnData[i][j] = data[i][j];
					} else if (birthRule(neighborCount, cellStatus, generationCounter[i][j])) {
						returnData[i][j] = "+";
					} else {
						returnData[i][j] = "null";
					}

					cellStatus = 0;
					neighborCount = 0;

				}
			}
			counter++;
			Output output = new Output();
			output.printGeneration(returnData, counter);
			generation--;
			return step(returnData, generation, counter);
		}
	}

	/*
	 * Death: if the current cell has already survived 2 generations, the current
	 * cell is switched off.
	 * 
	 * @param neighborCount this value isn't required for VariationLife
	 * 
	 * @param cellStatus this value isn't required for VariationLife
	 * 
	 * @param generationSurvived this is the value which we compare
	 * 
	 * @return death rule will return true if the condition is true
	 */
	@Override
	public boolean deathRule(int neighborCount, int cellStatus, int generationSurvived) {
		// TODO Auto-generated method stub
		if (generationSurvived == 2)
			return true;
		else
			return false;
	}

	/*
	 * Survival: if the current cell has survived exactly 1 generation, the current
	 * cell is left unchanged.
	 * 
	 * @param neighborCount this value isn't required for VariationLife
	 * 
	 * @param cellStatus this value isn't required VariationLife
	 * 
	 * @param generationSurvived this is the value which we compare
	 * 
	 * @return survival rule will return true if the condition is true
	 */
	@Override
	public boolean survivalRule(int neighborCount, int cellStatus, int generationSurvived) {
		// TODO Auto-generated method stub
		if (generationSurvived == 1)
			return true;
		else
			return false;
	}

	/*
	 * Birth: if the current cell is off and the count is exactly 1, the current
	 * cell is switched on.
	 * 
	 * @param neighborCount is the no of live cell around a cell
	 * 
	 * @param cellStatus the evaluating cell is on or of
	 * 
	 * @param generationSurvived this value isn't required for VariationLife
	 * 
	 * @return birth rule will return true if the condition is true
	 */
	@Override
	public boolean birthRule(int neighborCount, int cellStatus, int generationSurvived) {
		// TODO Auto-generated method stub
		if (neighborCount == 1 && cellStatus == 0)
			return true;
		else
			return false;
	}
}

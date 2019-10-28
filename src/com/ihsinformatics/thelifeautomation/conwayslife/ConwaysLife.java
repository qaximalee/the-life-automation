package com.ihsinformatics.thelifeautomation.conwayslife;

import com.ihsinformatics.thelifeautomation.interfaces.ILifeRules;
import com.ihsinformatics.thelifeautomation.output.Output;

/*
 * @author qasim.ali@ihsinformatics.com
 * */

public class ConwaysLife implements ILifeRules {

	@Override
	public String[][] step(String[][] data, int generation, int counter) {
		// TODO Auto-generated method stub
		if (generation == 0) {
			return null;
		} else {
			String[][] returnData = new String[data.length][data[0].length];

			int cellStatus = 2;
			int neighborCount = 0;
			// Count Neighbor
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {

					/*
					 * Below Conditions are for checking the surrounding 8 cells
					 */
					// FOR RIGHT
					if (j + 1 < data[i].length && (data[i][j + 1].equals("+") || data[i][j + 1].equals("X"))) {
						neighborCount++;
					}

					// FOR LEFT
					if (j - 1 >= 0 && (data[i][j - 1].equals("+") || data[i][j - 1].equals("X"))) {
						neighborCount++;
					}

					// FOR BOTTOM
					if (i + 1 < data.length && (data[i + 1][j].equals("+") || data[i + 1][j].equals("X"))) {
						neighborCount++;
					}

					// FOR BOTTOM LEFT
					if (i + 1 < data.length && j - 1 >= 0
							&& (data[i + 1][j - 1].equals("+") || data[i + 1][j - 1].equals("X"))) {
						neighborCount++;
					}

					// FOR BOTTOM RIGHT
					if (i + 1 < data.length && j + 1 < data[j].length
							&& (data[i + 1][j + 1].equals("+") || data[i + 1][j + 1].equals("X"))) {
						neighborCount++;
					}

					// FOR UP
					if (i - 1 >= 0 && (data[i - 1][j].equals("+") || data[i - 1][j].equals("X"))) {
						neighborCount++;
					}

					// FOR UP LEFT
					if (i - 1 >= 0 && j - 1 >= 0
							&& (data[i - 1][j - 1].equals("+") || data[i - 1][j - 1].equals("X"))) {
						neighborCount++;
					}

					// FOR UP RIGHT
					if (i - 1 >= 0 && j + 1 < data[j].length
							&& (data[i - 1][j + 1].equals("+") || data[i - 1][j + 1].equals("X"))) {
						neighborCount++;
					}

					// Putting Cell Status
					if (data[i][j].equals("+") || data[i][j].equals("X"))
						cellStatus = 1;
					else if (data[i][j].equals("null"))
						cellStatus = 0;

					/*
					 * Applying the logic by using below statements 3rd param of each conditional
					 * methods are 0 because there is no generation usage in this Game of Life.
					 */
					if (deathRule(neighborCount, cellStatus, 0)) {
						returnData[i][j] = "null";
					} else if (survivalRule(neighborCount, cellStatus, 0)) {
						if (data[i][j].equals("+"))
							returnData[i][j] = "X";
						else
							returnData[i][j] = data[i][j];
					} else if (birthRule(neighborCount, cellStatus, 0)) {
						returnData[i][j] = "+";
					} else {
						returnData[i][j] = "null";
					}

					neighborCount = 0;
					cellStatus = 0;
				}
			}
			counter++;
			Output output = new Output();
			output.printGeneration(returnData, counter);
			generation--;
			return step(returnData, generation, counter);
		}
	}

	// int counter = 1;

	/*
	 * Death: if the count is less than 2 or greater than 3, and the current cell is
	 * on, the current cell is switched off.
	 * 
	 * @param neighborCount is the no of live cell around a cell
	 * 
	 * @param cellStatus the evaluating cell is on or of
	 * 
	 * @param generationSurvived it will be 0 for Conway's Life
	 * 
	 * @return death rule will return true if the condition is true
	 */
	@Override
	public boolean deathRule(int neighborCount, int cellStatus, int generationSurvived) {
		// TODO Auto-generated method stub
		if ((neighborCount < 2 || neighborCount > 3) && cellStatus == 1)
			return true;
		else
			return false;
	}

	/*
	 * Survival: if (a) the count is exactly 2, or (b) the count is exactly 3 and
	 * the current cell is on, the current cell is left unchanged.
	 * 
	 * @param neighborCount is the no of live cell around a cell
	 * 
	 * @param cellStatus the evaluating cell is on or of
	 * 
	 * @param generationSurvived it will be 0 for Conway's Life
	 * 
	 * @return survival rule will return true if the condition is true
	 */
	@Override
	public boolean survivalRule(int neighborCount, int cellStatus, int generationSurvived) {
		// TODO Auto-generated method stub
		if ((neighborCount == 2 || neighborCount == 3) && cellStatus == 1)
			return true;
		else
			return false;
	}

	/*
	 * Birth: if the current cell is off and the count is exactly 3, the current
	 * cell is switched on.
	 * 
	 * @param neighborCount is the no of live cell around a cell
	 * 
	 * @param cellStatus the evaluating cell is on or of
	 * 
	 * @param generationSurvived it will be 0 for Conway's Life
	 * 
	 * @return birth rule will return true if the condition is true
	 */
	@Override
	public boolean birthRule(int neighborCount, int cellStatus, int generationSurvived) {
		// TODO Auto-generated method stub
		if (neighborCount == 3 && cellStatus == 0)
			return true;
		else
			return false;
	}
}

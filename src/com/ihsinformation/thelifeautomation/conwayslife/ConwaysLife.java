package com.ihsinformation.thelifeautomation.conwayslife;

import com.ihsinformatics.thelifeautomation.interfaces.ILifeRules;

public class ConwaysLife implements ILifeRules {

	/*
	 * 0 for Death, 1 for Born & 2 for Survived
	 */
	private int cellStatus;

	private int neighborCount;

	private String[][] cellData;

	@Override
	public String[][] applyRules(String[][] data, int generation) {
		// TODO Auto-generated method stub

		String[][] returnData = new String[data.length][data[0].length];

		// Count Neighbor
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {

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

				// FOR BOTTOM LEFT
				if (i + 1 < data.length && j - 1 >= 0 && data[i + 1][j - 1].equals("+")) {
					neighborCount++;
				}

				// FOR BOTTOM RIGHT
				if (i + 1 < data.length && j + 1 < data[j].length && data[i + 1][j + 1].equals("+")) {
					neighborCount++;
				}

				// FOR UP
				if (i - 1 >= 0 && data[i - 1][j].equals("+")) {
					neighborCount++;
				}

				// FOR UP LEFT
				if (i - 1 >= 0 && j - 1 >= 0 && data[i - 1][j - 1].equals("+")) {
					neighborCount++;
				}

				// FOR UP RIGHT
				if (i - 1 >= 0 && j + 1 < data[j].length && data[i - 1][j + 1].equals("+")) {
					neighborCount++;
				}

				// Cell Status
				if (data[i][j].equals("+"))
					cellStatus = 1;
				else if (data[i][j].equals("X"))
					cellStatus = 0;
				else if (data[i][j].equals(""))
					cellStatus = 2;

				if (deathRule()) {
					returnData[i][j] = "";
				} else if (survivalRule()) {
					returnData[i][j] = "X";// data[i][j];
				} else if (birthRule()) {
					returnData[i][j] = "+";
				} else {
					returnData[i][j] = "";
				}
				cellStatus = 5;
				neighborCount = 0;
			}
		}

		return returnData;
	}

	// int counter = 1;

	/*
	 * Death: if the count is less than 2 or greater than 3, and the current cell is
	 * on, the current cell is switched off.
	 * 
	 * @return death rule will return true if the condition is true
	 */
	@Override
	public boolean deathRule() {

		// System.out.println("Neighbor Count :" + (counter++) + " >> " +
		// neighborCount);
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
	 * @return survival rule will return true if the condition is true
	 */
	@Override
	public boolean survivalRule() {
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
	 * @return birth rule will return true if the condition is true
	 */
	@Override
	public boolean birthRule() {
		// TODO Auto-generated method stub
		if (neighborCount == 3 && cellStatus == 2)//
			return true;
		else
			return false;
	}
}

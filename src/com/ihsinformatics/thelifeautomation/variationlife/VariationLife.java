package com.ihsinformatics.thelifeautomation.variationlife;

import com.ihsinformatics.thelifeautomation.interfaces.ILifeRules;

public class VariationLife implements ILifeRules {

	/*
	 * 0 for Death, 1 for Born & 2 for Survived
	 */
	private int cellStatus;

	private int noOfGenSurvived;

	private int neighborCount;

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

				// FOR UP
				if (i - 1 >= 0 && data[i - 1][j].equals("+")) {
					neighborCount++;
				}

				// Cell Status
				if (data[i][j].equals("+"))
					cellStatus = 1;
				else if (data[i][j].equals(""))
					cellStatus = 0;
				else if (data[i][j].equals("X"))
					cellStatus = 2;

				if (deathRule()) {
					returnData[i][j] = "";
				} else if (survivalRule()) {
					returnData[i][j] = "X";
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

	@Override
	public boolean deathRule() {
		// TODO Auto-generated method stub
		if (noOfGenSurvived == 2 && (cellStatus == 1 || cellStatus == 2))
			return true;
		else
			return false;
	}

	@Override
	public boolean survivalRule() {
		// TODO Auto-generated method stub
		if (noOfGenSurvived == 1 && (cellStatus == 1 || cellStatus == 2))
			return true;
		else
			return false;
	}

	@Override
	public boolean birthRule() {
		// TODO Auto-generated method stub
		if (neighborCount == 1 && cellStatus == 0)
			return true;
		else
			return false;
	}
}

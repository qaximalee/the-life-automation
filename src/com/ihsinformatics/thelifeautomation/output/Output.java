package com.ihsinformatics.thelifeautomation.output;

/*
 * @author qasim.ali@ihsinformatics.com
 * */

public class Output {

	private String[][] populatedCellsData;
	private int noOfGenerations;
	private String gameChoice;

	public void printOutput(String[][] initialGenerationData) {
		System.out.println("\n\n");
		System.out.println("The INITIAL GENERATION:");
		System.out.println("---------------------");
		System.out.print(" ");

		for (int i = 0; i < initialGenerationData[0].length; i++) {
			System.out.print("  |");
		}
		System.out.println();
		for (int i = 0; i < initialGenerationData.length; i++) {
			System.out.print("-- ");
			for (int j = 0; j < initialGenerationData[i].length; j++) {
				System.out.print(initialGenerationData[i][j] + "   ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
		System.out.println("\n");
	}

	/*
	 * This method print out the Generation-wise data
	 * 
	 * @param genCellData it is the modified data of cells in grid
	 * 
	 * @param noOfGen it is the no of generation for which the data has modified
	 */
	public void printGeneration(String[][] data, int counter) {
		System.out.println("Generation no: " + counter);
		System.out.println("---------------------");
		System.out.print(" ");

		for (int i = 0; i < data[0].length; i++) {
			System.out.print("  |");
		}
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(i + ">> ");
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j].equals("null"))
					System.out.print(data[i][j] + "  ");
				else
					System.out.print(data[i][j] + "     ");
				// System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

	public String[][] getPopulatedCellsData() {
		return populatedCellsData;
	}

	public void setPopulatedCellsData(String[][] populatedCellsData) {
		this.populatedCellsData = populatedCellsData;
	}

	public int getNoOfGenerations() {
		return noOfGenerations;
	}

	public void setNoOfGenerations(int noOfGenerations) {
		this.noOfGenerations = noOfGenerations;
	}

	public String getGameChoice() {
		return gameChoice;
	}

	public void setGameChoice(String gameChoice) {
		this.gameChoice = gameChoice;
	}
}

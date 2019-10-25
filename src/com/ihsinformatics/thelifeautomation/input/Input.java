package com.ihsinformatics.thelifeautomation.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Input {

	private String gameChoice;
	private int noOfGenerations;
	private String initFilePath;
	private String[][] cellsPosition;

	/*
	 * This method is the starting point of the Program. It will take input from
	 * user as a command and break them and initialize the data into global fields
	 */
	public void printInputInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter grid size, choice of Game, data file path and no of generation.\n"
				+ "Enter command as following:\n" + "5x5 C D:\\initLife.data +" + "\n\n"
				+ "5x5 for 5 rows and 5 columns of Grid\n" + "C for Conway's Life or V for Variation of Life\n"
				+ "D:\\initLife.data for the path of Initial Gen Values\n"
				+ "+ for ONE Generation OR ANY INTEGER NUM for the Generation");
		String fullCommandInput = scan.nextLine();

		// Splitting commands with space between them
		String[] commands = fullCommandInput.split("\\s+");

		// Getting no of rows and columns for Grid
		String[] gridRowCol = commands[0].split("x");
		int gridRows = Integer.parseInt(gridRowCol[0]);
		int gridCols = Integer.parseInt(gridRowCol[1]);
		putCellsDataIntoGrid(gridRows, gridCols, commands[2]);
		// cellsPosition = new String[gridRows][gridCols];

		setGameChoice(commands[1]);
		setInitFilePath(commands[2]);
		setNoOfGenerations(commands[3]);

	}

	/*
	 * This method take no of rows and columns for the grid and populate data with
	 * respect to the initLife file
	 * 
	 * @param rows this is the no of rows of Grid
	 * 
	 * @param rows this is the no of columns of Grid
	 */
	public void putCellsDataIntoGrid(int rows, int cols, String filePath) {
		File file = new File(filePath);
		String[][] cellsData = new String[rows][cols];

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				String[] rowsCols = st.split("\\s+");
				cellsData[Integer.parseInt(rowsCols[0])][Integer.parseInt(rowsCols[1])] = "+";
			}

			for (int i = 0; i < cellsData.length; i++) {
				for (int j = 0; j < cellsData[i].length; j++) {
					if (cellsData[i][j] == null) {
						cellsData[i][j] = "";
					}
				}
			}

			setCellsPosition(cellsData);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getGameChoice() {
		return gameChoice;
	}

	public void setGameChoice(String gameChoice) {
		this.gameChoice = gameChoice;
	}

	public int getNoOfGenerations() {
		return noOfGenerations;
	}

	public void setNoOfGenerations(String noOfGenerations) {
		if (noOfGenerations.equals("+"))
			this.noOfGenerations = 1;
		else
			this.noOfGenerations = Integer.parseInt(noOfGenerations);
	}

	public String getInitFilePath() {
		return initFilePath;
	}

	public void setInitFilePath(String initFilePath) {
		this.initFilePath = initFilePath;
	}

	public String[][] getCellsPosition() {
		return cellsPosition;
	}

	public void setCellsPosition(String[][] cellsPosition) {
		this.cellsPosition = cellsPosition;
	}
}

package com.ihsinformatics.thelifeautomation;

import com.ihsinformatics.thelifeautomation.input.Input;
import com.ihsinformatics.thelifeautomation.interfaces.ILifeRules;
import com.ihsinformatics.thelifeautomation.output.Output;
import com.ihsinformation.thelifeautomation.conwayslife.ConwaysLife;

public class TheLifeAutomation {
	public static void main(String[] args) {
		Input input = new Input();
		input.printInputInfo();

		Output output = new Output();
		// output.setGameChoice(input.getGameChoice());
		// output.setNoOfGenerations(input.getNoOfGenerations());
		// output.setPopulatedCellsData(input.getCellsPosition());

		ILifeRules lifeRule = new ConwaysLife();
		String[][] data = lifeRule.applyRules(input.getCellsPosition(), input.getNoOfGenerations());
		int gen = input.getNoOfGenerations();
		String[][] data1 = lifeRule.applyRules(data, gen);
		output.setGameChoice(input.getGameChoice());
		output.setNoOfGenerations(input.getNoOfGenerations());
		output.setPopulatedCellsData(input.getCellsPosition());
		output.setNoOfGenerations(input.getNoOfGenerations());
		output.printOutput();
		output.printGeneration(data);
		output.printGeneration(data1);
	}
}

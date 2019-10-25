package com.ihsinformatics.thelifeautomation;

import com.ihsinformatics.thelifeautomation.input.Input;
import com.ihsinformatics.thelifeautomation.interfaces.ILifeRules;
import com.ihsinformatics.thelifeautomation.output.Output;
import com.ihsinformatics.thelifeautomation.variationlife.VariationLife;
import com.ihsinformation.thelifeautomation.conwayslife.ConwaysLife;

public class TheLifeAutomation {
	public static void main(String[] args) {
		Input input = new Input();
		input.printInputInfo();

		Output output = new Output();
		output.printOutput(input.getCellsPosition());
		// output.setGameChoice(input.getGameChoice());
		// output.setNoOfGenerations(input.getNoOfGenerations());
		// output.setPopulatedCellsData(input.getCellsPosition());
		String choice = input.getGameChoice();
		if (choice.equals("C")) {
			ILifeRules lifeRule = new ConwaysLife();
			String[][] data = lifeRule.applyRules(input.getCellsPosition(), input.getNoOfGenerations());

			output.setNoOfGenerations(input.getNoOfGenerations());
			output.setPopulatedCellsData(input.getCellsPosition());
			output.setNoOfGenerations(input.getNoOfGenerations());
			output.printGeneration(data);
		} else if (choice.equals("V")) {
			ILifeRules lifeRule = new VariationLife();
			String[][] data = lifeRule.applyRules(input.getCellsPosition(), input.getNoOfGenerations());
			output.setNoOfGenerations(input.getNoOfGenerations());
			output.setPopulatedCellsData(input.getCellsPosition());
			output.setNoOfGenerations(input.getNoOfGenerations());
			output.printGeneration(data);
		} else {
			System.out.println("ENTER V for Variation or C for Conway's Life Automation");
		}
	}
}

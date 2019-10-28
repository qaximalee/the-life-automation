package com.ihsinformatics.thelifeautomation;

import com.ihsinformatics.thelifeautomation.conwayslife.ConwaysLife;
import com.ihsinformatics.thelifeautomation.input.Input;
import com.ihsinformatics.thelifeautomation.interfaces.ILifeRules;
import com.ihsinformatics.thelifeautomation.output.Output;
import com.ihsinformatics.thelifeautomation.variationlife.VariationLife;

/*
 * @author qasim.ali@ihsinformatics.com
 * */

public class TheLifeAutomation {
	public static void main(String[] args) {
		Input input = new Input();
		input.printInputInfo();

		Output output = new Output();
		output.printOutput(input.getCellsPosition());

		String choice = input.getGameChoice();
		if (choice.equals("C")) {
			ILifeRules lifeRule = new ConwaysLife();
			lifeRule.step(input.getCellsPosition(), input.getNoOfGenerations(), 0);

		} else if (choice.equals("V")) {
			ILifeRules lifeRule = new VariationLife(input.getCellsPosition().length,
					input.getCellsPosition()[0].length);
			lifeRule.step(input.getCellsPosition(), input.getNoOfGenerations(), 0);

		} else {
			System.out.println("ENTER V for Variation or C for Conway's Life Automation");
		}
	}
}

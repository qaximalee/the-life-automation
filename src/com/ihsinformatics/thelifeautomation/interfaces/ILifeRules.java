package com.ihsinformatics.thelifeautomation.interfaces;

/*
 * @author qasim.ali@ihsinformatics.com
 * */

public interface ILifeRules {

	boolean deathRule(int neighborCount, int cellStatus, int generationSurvived);

	boolean survivalRule(int neighborCount, int cellStatus, int generationSurvived);

	boolean birthRule(int neighborCount, int cellStatus, int generationSurvived);

	public String[][] step(String[][] data, int generation, int counter);
}

package com.ihsinformatics.thelifeautomation.interfaces;

public interface ILifeRules {

	boolean deathRule();

	boolean survivalRule();

	boolean birthRule();

	public String[][] applyRules(String[][] data, int generation);
}

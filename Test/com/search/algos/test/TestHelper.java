package com.search.algos.test;

import com.search.input.Choice;

public class TestHelper {
	
	final static String dirName = "/tmp";
	
	public static Choice getChoiceName(){
		Choice choice = new Choice();
		choice.setOutputChoice(1);
		return choice;
	}
	
	public static Choice getChoiceModifier(){
		Choice choice = new Choice();
		choice.setOutputChoice(2);
		return choice;
	}
	
}

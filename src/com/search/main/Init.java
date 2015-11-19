package com.search.main;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.search.helper.Utility;
import com.search.input.Choice;
/*
 * Main program - to start the application
 */
public class Init {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(Init.class);
		Scanner in = new Scanner(System.in);
		Choice choice = new Choice();
		
		/*
		 * Get the directory to be traversed
		 */
		Utility.printMessage("Enter Directory");
		boolean validInput = false;
		String directory = null;
		while(!validInput){
			directory = in.nextLine();
			validInput = Utility.validateFile(directory);
			if(!validInput)
				Utility.printMessage("Please enter a valid file path");
		}
		choice.setDirName(directory);
		
		/*
		 * Get the traversal method
		 * 1. Breadth First Search
		 * 2. Depth First Search
		 */
		Utility.printMessage("Pick a traversal method");
		Utility.printMessage("1. BFS");
		Utility.printMessage("2. DFS");
		validInput = false;
		int traversalChoice = -1;
		while(!validInput){
			traversalChoice = Utility.intParser(in.nextLine());
			validInput = Utility.validateChoice(traversalChoice);
			if(!validInput)
				Utility.printMessage("Please enter a valid choice, 1 or 2");
		}
		choice.setTraversalChoice(traversalChoice);
		logger.debug("Search chosen {}", traversalChoice);
		
		/*
		 * Get the display startey
		 * 1. Displays names of file and directories
		 * 2. Displays name, size and last modified of file and directories 
		 */
		Utility.printMessage("Pick a display choice");
		Utility.printMessage("1. File and Dir Names");
		Utility.printMessage("2. aditionally size and date modified");
		
		validInput = false;
		int outputFormat = -1;
		while(!validInput){
			outputFormat = Utility.intParser(in.nextLine());
			validInput = Utility.validateChoice(outputFormat);
			if(!validInput)
				Utility.printMessage("Please enter a valid choice, 1 or 2");
		}
		
		choice.setOutputChoice(outputFormat);
		logger.debug("Output Format {}", outputFormat);
		
		in.close();
		
		
		InputProcessor processor = new InputProcessor();
		processor.process(choice);
		
	}

}

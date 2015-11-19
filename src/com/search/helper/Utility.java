package com.search.helper;

import java.io.File;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.search.input.Choice;

/*
 * Has the utility methods used in this application.
 */
public class Utility {
	final static Logger logger = LoggerFactory.getLogger(Utility.class);
	/*
	 * Utility to print on the console.
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
	
	/*
	 * Validates if the give number is within the choices
	 */
	public static boolean validateChoice(int choice) {
		return (choice == 1 || choice == 2);
	}
	
	/*
	 * Validates if the file exists 
	 */
	public static boolean validateFile(String choice) {
		File file = new File(choice);
		return file.exists();
	}
	
	/*
	 * Utility to convert string to integer
	 */
	public static int intParser(String str) {
		return Integer.parseInt(str);
	}
	/*
	 * Prints on the console as per the inputs
	 * Case1:
	 * 		Only the name is displayed
	 * Case2:
	 * 		Name, size and last modified are displayed
	 */
	public static void printOutput(Choice choice,File file){
		switch (choice.getOutputChoice()){
		case 1:
			printName(file);
			break;
		case 2:
			printName(file);
			printSize(file);
			printModified(file);
			break;
		}
		Utility.printMessage("");
	}
	
	/*
	 * prints the qualified name of the file
	 */
	public static void printName(File file){
		System.out.print(file.getName() + " ");
	}
	/*
	 * prints the size of the file in long
	 */
	public static void printSize(File file){
		System.out.print(file.length() + " ");
	}
	/*
	 * Prints the last modified date of the file.
	 */
	public static void printModified(File file){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		System.out.print(sdf.format(file.lastModified()) + " ");
	}

}

package com.search.input;

/*
 * holds the input choices 
 */
public class Choice {
	/*
	 * Can be 
	 * 1. BFS
	 * 2. DFS
	 */
	private int traversalChoice;
	/*
	 * Can be
	 * 1. File and Directory names
	 * 2. Names, size and last modified
	 */
	private int outputChoice;
	/*
	 * Input path
	 */
	private String dirName;
	
	public int getTraversalChoice() {
		return traversalChoice;
	}
	public void setTraversalChoice(int traversalChoice) {
		this.traversalChoice = traversalChoice;
	}
	public int getOutputChoice() {
		return outputChoice;
	}
	public void setOutputChoice(int outputChoice) {
		this.outputChoice = outputChoice;
	}
	public String getDirName() {
		return dirName;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	
}

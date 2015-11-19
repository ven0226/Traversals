package com.search.algos;

import java.io.File;
import java.util.Stack;

import com.search.helper.Utility;
import com.search.input.Choice;
import com.search.output.ITraversing;

public class DFS implements ITraversing {
	/*
	 * (non-Javadoc)
	 * @see com.instantly.coding.output.ITraversing#search(com.instantly.coding.input.Choice)
	 * 
	 * Implements depth first search algorithm to display the structure of a file system
	 */
	public boolean search(Choice choice){
		File file = new File(choice.getDirName());
		boolean traversed = true;
		
		// return false if the input path is incorrect 
		if(!file.exists()){
			traversed = false;
		}else{
			Stack<File> fileS = new Stack<File>();
			fileS.push(file);
			while(fileS.size() > 0){
				File tmpFile = fileS.pop();
				Utility.printOutput(choice, tmpFile);
				File[] listFiles = tmpFile.listFiles();
				if(listFiles != null){
					for (File fileInDir: listFiles){
						fileS.add(fileInDir);
					}
				}
			}
			Utility.printMessage("");
		}
		
		return traversed;
	}
}

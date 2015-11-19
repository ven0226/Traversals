package com.search.algos;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.search.helper.Utility;
import com.search.input.Choice;
import com.search.output.ITraversing;

public class BFS implements ITraversing {
	final Logger logger = LoggerFactory.getLogger(BFS.class);
	/*
	 * (non-Javadoc)
	 * @see com.instantly.coding.output.ITraversing#search(com.instantly.coding.input.Choice)
	 * 
	 * Implements breadth first search algorithm to display the structure of a file system
	 */
	public boolean search(Choice choice){
		File inputDir = new File(choice.getDirName());
		boolean traversed = true;
		
		// return false if the input path is incorrect 
		if(!inputDir.exists()){
			traversed = false;
		}else{
			Queue<File> fileQ = new LinkedList<File>();
			fileQ.add(inputDir);
			Utility.printOutput(choice, inputDir);
			Utility.printMessage("");
			
			while(fileQ.size() > 0){
				File tmpFile = fileQ.remove();
				File[] listFiles = tmpFile.listFiles();
				if(listFiles != null){
					for (File fileInDir: listFiles){
						if(fileInDir.isDirectory())
							fileQ.add(fileInDir);
						Utility.printOutput(choice, fileInDir);
					}
					Utility.printMessage("");
				}
			}
		}
		return traversed;
	}
}

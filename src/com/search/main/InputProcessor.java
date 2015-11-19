package com.search.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.search.algos.BFS;
import com.search.algos.DFS;
import com.search.input.Choice;
import com.search.output.ITraversing;

public class InputProcessor {
	/*
	 * Calls the traverse class based on the traverse method selected.
	 */
	public void process(Choice choice){
		final Logger logger = LoggerFactory.getLogger(InputProcessor.class);
		logger.debug("Processing input");
		ITraversing traverse = null;
		switch (choice.getTraversalChoice()){
		case 1:
			logger.debug("BFS was selected");
			traverse = new BFS();
			traverse.search(choice);
			break;
		case 2:
			logger.debug("DFS was selected");
			traverse = new DFS();
			traverse.search(choice);
			break;
		}
	}
}

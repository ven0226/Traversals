package com.search.algos.test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.search.algos.BFS;
import com.search.input.Choice;
import com.search.output.ITraversing;

import junit.framework.TestCase;

public class TestBFS extends TestCase{
	
	private File input = null;
	private Choice choice = null;
	private ITraversing traverse = null;
	@Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	@Before
	public void setUp() throws Exception {
		
		input = temporaryFolder.newFolder("l1");
		String inputPath  = input.getPath(); 
		temporaryFolder.newFolder(inputPath + "/l2");
		temporaryFolder.newFile(inputPath + "/3.txt");
		temporaryFolder.newFile(inputPath + "/1.txt");
		temporaryFolder.newFile(inputPath + "/4.txt");
		temporaryFolder.newFolder(inputPath + "/l2/6.txt");
		temporaryFolder.newFolder(inputPath + "/l2/7.txt");
		traverse = new BFS();
		choice = new Choice();
		choice.setDirName(inputPath);
		choice.setTraversalChoice(1);
	}
	
	@After
	public void tearDown() throws Exception {
		input = null;
		choice = null;
		traverse = null;
	}
	
	@Test
	public void testBFSName() {
		choice.setOutputChoice(1);
		assertEquals(true, traverse.search(choice));
	}
	
	@Test
	public void testBFSSizeModified() {
		choice.setOutputChoice(2);
		assertEquals(true, traverse.search(choice));
	}
}

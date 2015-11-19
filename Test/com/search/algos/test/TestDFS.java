package com.search.algos.test;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;

import com.search.algos.DFS;
import com.search.input.Choice;
import com.search.output.ITraversing;

import junit.framework.TestCase;

public class TestDFS extends TestCase {
	
	private File input = null;
	private Choice choice = null;
	private ITraversing traverse = null;
	
	@Rule 
	public TestName name = new TestName();
	
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
		traverse = new DFS();
		choice = new Choice();
		choice.setDirName(inputPath);
		choice.setTraversalChoice(2);
	}
	
	@After
	public void tearDown() throws Exception {
		input = null;
		choice = null;
		traverse = null;
	}
	
	@Test
	public void testDFSName() {
		choice.setOutputChoice(1);
		assertEquals(true, traverse.search(choice));
	}
	
	@Ignore
	public void testDFSSizeModified() {
		choice.setOutputChoice(2);
		assertEquals(true, traverse.search(choice));
	}

}

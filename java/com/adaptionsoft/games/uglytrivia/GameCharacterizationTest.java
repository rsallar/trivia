package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class GameCharacterizationTest {
	private Game game;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	private final String caption1 = "Lincoln was added They are player number 1 Lincoln is the current player They have rolled a 1 Lincoln's new location is 1 The category is Science Science Question 0 ";
	private final String caption2 = "Lincoln was added They are player number 1 Question was incorrectly answered Lincoln was sent to the penalty box ";
		
	
	@Before
	public void before(){
		System.setOut(new PrintStream(out));
		game = new Game();
	}
	
	@Test
	public void run_with_single_user(){
		game.add("Lincoln");
		game.roll(1);
		assertEquals(caption1, out.toString().replace("\r\n", " "));
	}
	
	@Test
	public void run_with_single_user_when_goes_to_penalty_box(){
		game.add("Lincoln");
		game.wrongAnswer();
		assertEquals(caption2, out.toString().replace("\r\n", " "));
	}
	

}

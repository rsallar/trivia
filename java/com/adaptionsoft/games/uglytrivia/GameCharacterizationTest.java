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
	private final String caption3 = "Lincoln was added They are player number 1 Question was incorrectly answered Lincoln was sent to the penalty box Lincoln is the current player They have rolled a 2 Lincoln is not getting out of the penalty box ";
	private final String caption4 = "Lincoln was added They are player number 1 Question was incorrectly answered Lincoln was sent to the penalty box Lincoln is the current player They have rolled a 1 Lincoln is getting out of the penalty box Lincoln's new location is 1 The category is Science Science Question 0 "; 
	private final String caption5 = "Lincoln was added They are player number 1 Answer was corrent!!!! Lincoln now has 1 Gold Coins. Lincoln is the current player They have rolled a 1 Lincoln's new location is 1 The category is Science Science Question 0 ";
	private final String caption6 = "Lincoln was added They are player number 1 Question was incorrectly answered Lincoln was sent to the penalty box Lincoln is the current player They have rolled a 1 Lincoln is getting out of the penalty box Lincoln's new location is 1 The category is Science Science Question 0 Answer was correct!!!! Lincoln now has 1 Gold Coins. ";
	private final String caption7 = "Lincoln was added They are player number 1 Question was incorrectly answered Lincoln was sent to the penalty box Lincoln is the current player They have rolled a 2 Lincoln is not getting out of the penalty box ";
	
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
	
	@Test
	public void user_can_not_leaves_penalty_box(){
		game.add("Lincoln");
		game.wrongAnswer();
		game.roll(2);
		assertEquals(caption3, out.toString().replace("\r\n", " "));
	}
	
	@Test
	public void user_leaves_penalty_box(){
		game.add("Lincoln");
		game.wrongAnswer();
		game.roll(1);
		assertEquals(caption4, out.toString().replace("\r\n", " "));
	}
	
	@Test
	public void user_right_answer_when_not_in_penalty_box(){
		game.add("Lincoln");
		game.wasCorrectlyAnswered();
		game.roll(1);
		assertEquals(caption5, out.toString().replace("\r\n", " "));
	}
	
	@Test
	public void user_right_answer_when_getting_out_of_penalty_box(){
		game.add("Lincoln");
		game.wrongAnswer();
		game.roll(1);
		game.wasCorrectlyAnswered();
		assertEquals(caption6, out.toString().replace("\r\n", " "));
	}
	
	@Test
	public void user_right_answer_when_not_getting_out_of_penalty_box(){
		game.add("Lincoln");
		game.wrongAnswer();
		game.roll(2);
		game.wasCorrectlyAnswered();
		assertEquals(caption7, out.toString().replace("\r\n", " "));
	}
	
	
	
	
	
	
	

}

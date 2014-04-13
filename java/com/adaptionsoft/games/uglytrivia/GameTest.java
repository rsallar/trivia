package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private Game game;
	@Before
	public void before(){
	
		game = new Game();
	}

	@Test
	public void game_should_allow_a_sixth_user(){
		game.add("Lincoln");
		game.add("Zapatero");
		game.add("Hollande");
		game.add("Evita");
		game.add("Karl");
		
		assertEquals(true, game.add("Einstein"));
	}
	
	@Test
	public void game_should_allow_a_user_to_leave_during_a_game(){
		game.add("Lincoln");
		game.add("Zapatero");
		
		game.roll(1);
		assertEquals(true, game.remove("Zapatero"));
	}

}

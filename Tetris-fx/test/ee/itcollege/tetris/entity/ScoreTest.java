package ee.itcollege.tetris.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void testScore() {
		
		Score score = new Score("Mati", 12);
		assertEquals("Mati", score.getPlayerName());
		assertEquals(12, score.getScore());
		
		try {
			score = new Score("", 15);
			fail("Score should not allow empty strings");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Mati", score.getPlayerName());
		}
		
		try {
			score = new Score("   ", 16);
			fail("Score should not allow empty strings");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Mati", score.getPlayerName());
		}
		
		try {
			score = new Score(null, -12);
			fail("Score should not allow null name");
			
		} catch (IllegalArgumentException e) {
			assertEquals("Mati", score.getPlayerName());
		}
		
		try {
			score = new Score("Toomas", -12);
			fail("Score should not be negative");
			
		} catch (IllegalArgumentException e) {
			assertEquals(12, score.getScore());
		}
	}
	
	@Test
	public void testTrim() {
		Score score = new Score("  M a ti  ", 11);
		assertEquals("M a ti", score.getPlayerName());
		assertEquals(11, score.getScore());
	}

}

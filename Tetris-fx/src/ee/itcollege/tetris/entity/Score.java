package ee.itcollege.tetris.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Score implements Serializable{
		
	private String playerName;
	private int score;
	
	public Score(String playerName, int score) {
		setPlayerName(playerName);
		setScore(score);
	}

	public String getPlayerName() {
		return playerName;
	}
	
	private void setPlayerName(String playerName) {
		if (playerName == null || "".equals(playerName.trim())) {
			throw new IllegalArgumentException("Empty name!");
		}
		this.playerName = playerName.trim();
	}
	
	public int getScore() {
		return score;
	}
	
	private void setScore(int score) {
		if (score < 0) {
			throw new IllegalArgumentException("Negative score not allowed");
		}
		this.score = score;
	}
	
	

}

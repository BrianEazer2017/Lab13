package rockPaperScissorsPackage;

public class RandomPlayer extends Player {
	public RandomPlayer() {};
	
	public RandomPlayer(String name) {
		super(name);
	}
	
	@Override
	public Roshambo generateRoshambo() {
		int randomNum = (int)(Math.random() * 3);
		Roshambo[] rArray = {Roshambo.ROCK, Roshambo.PAPER, Roshambo.SCISSORS};
		return rArray[randomNum];
	}
}

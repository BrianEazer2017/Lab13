package rockPaperScissorsPackage;

public class RandomPlayer extends Player {
	public RandomPlayer() {};
	
	public RandomPlayer(String name) {
		super(name);
	}
	
	@Override
	public Roshambo generateRoshambo() {
		int randomNum = (int)(Math.random() * 3);
		return Roshambo.values()[randomNum];
	}
}

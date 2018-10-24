package rockPaperScissorsPackage;

import java.util.Scanner;

public class UserPlayer extends Player {

	public UserPlayer() {}
	public UserPlayer(String name) {
		super(name);
	}

	@Override
	public Roshambo generateRoshambo() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String choice = Validator.getStringMatchingRegex(sc, 
				"Choose between 'ROCK', 'PAPER', and 'SCISSORS'.", "ROCK|PAPER|SCISSORS");
		Roshambo userRoshambo;
		 if (choice.equals("ROCK")){ 
			 userRoshambo = Roshambo.ROCK;
		} else if (choice.equals("PAPER")) {
			 userRoshambo = Roshambo.PAPER;
		} else {
			userRoshambo = Roshambo.SCISSORS;
	}
	return userRoshambo;
	}

}

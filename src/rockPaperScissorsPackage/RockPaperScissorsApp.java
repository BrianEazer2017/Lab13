package rockPaperScissorsPackage;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RockPaperScissorsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputName();
	}

	private static void inputName() {
		Scanner sc = new Scanner(System.in);
		String name = Validator
				.getStringMatchingRegex(sc, "Enter your name: ", "[a-zA-Z]+");
		System.out.print("Hi " + name + ". ");
		inputOpponent(sc, name); 
	}

	private static void inputOpponent(Scanner sc, String name) {
		String opponent = Validator.getStringMatchingRegex
				(sc, "Who would you like to compete against? "
				+ "Type exactly 'The Jets' or 'The Sharks'", "The Jets|The Sharks");
		createPlayers(sc, name, opponent);
	}
	private static void createPlayers(Scanner sc, String name, String opponent) {
		UserPlayer user = new UserPlayer(name);
		RandomPlayer sharkUser = new RandomPlayer(opponent);
		AlwaysRock jetUser = new AlwaysRock(opponent);
		TreeMap<Player, Integer> score = new TreeMap<>();
		if (opponent.equals("The Jets"))
			inputRPS(sc, name, opponent, user, jetUser, score);
		if (opponent.equals("The Sharks"))
			inputRPS(sc, name, opponent, user, sharkUser, score);
	}

	private static void inputRPS(Scanner sc, String name, String stringOpponent, UserPlayer user,
			Player opponent, TreeMap<Player, Integer> score) {
		Roshambo userChoice = user.generateRoshambo();
		Roshambo opponentChoice = opponent.generateRoshambo();
		play(sc, name, stringOpponent, user, opponent, userChoice, opponentChoice, score);
	}

	private static void play(Scanner sc, String name, String stringOpponent, UserPlayer user,
			Player opponent, Roshambo userChoice, Roshambo opponentChoice, TreeMap<Player, Integer> score) {
		displayChoices(sc, name, stringOpponent, user, opponent, userChoice, opponentChoice);
		if (userChoice.equals(Roshambo.PAPER)) {
			if (opponentChoice.equals(Roshambo.ROCK)) {
				displayWinner(user, opponent);
				score = updateScore(user, opponent, score);
				displayScore(score);
				askToContinue(sc, stringOpponent, user, opponent, score);
			}
			else if (opponentChoice.equals(Roshambo.SCISSORS)) {
				displayWinner(opponent, user);
				score = updateScore(opponent, user, score);
				displayScore(score);
				askToContinue(sc, stringOpponent, user, opponent, score);
			} else {
				System.out.println("Draw!");
				askToContinue(sc,  stringOpponent, user, opponent, score);
			}
		} else if (userChoice.equals(Roshambo.ROCK)) {
			if (opponentChoice.equals(Roshambo.PAPER)) {
				displayWinner(opponent, user);
				score = updateScore(opponent, user, score);
				displayScore(score);
				askToContinue(sc,  stringOpponent, user, opponent, score);
			}
			else if (opponentChoice.equals(Roshambo.SCISSORS)) {
				displayWinner(user, opponent);
				score = updateScore(user, opponent, score);
				displayScore(score);
				askToContinue(sc, stringOpponent, user, opponent, score);
			} else {
				System.out.println("Draw!");
				askToContinue(sc, stringOpponent, user, opponent,  score);
			}
		} else {
			if (opponentChoice.equals(Roshambo.PAPER)) {
				displayWinner(user, opponent);
				score = updateScore(user, opponent, score);
				displayScore(score);
				askToContinue(sc, stringOpponent, user, opponent, score);
			}
			else if (opponentChoice.equals(Roshambo.ROCK)) {
				displayWinner(opponent, user);
				score = updateScore(opponent, user, score);
				displayScore(score);
				askToContinue(sc, stringOpponent, user, opponent, score);
			}
			else {
				System.out.println("Draw!");
				askToContinue(sc, stringOpponent, user, opponent, score);
			}
		}
	}

	private static void askToContinue(Scanner sc, String name, UserPlayer user,
			Player opponent,  TreeMap<Player, Integer> score) {
			String stringOpponent = "";
		    if (Validator.getString(sc, "Would you like to continue?").matches("[yY][eE]*[sS]*")){
		    	inputRPS(sc, name, stringOpponent, user, opponent, score);
		    } else if (Validator.getString(sc, "Would you like to continue?").matches("[nN][oO]*")){
		    	System.out.println("Peace.");
		    } else {
		    	askToContinue(sc, name, user, opponent, score);
		    }
	}

	private static void displayScore(TreeMap<Player, Integer> score) {
		for (Player player : score.keySet()) {
			System.out.println(player + " has " + score.get(player));
		}
	}

	private static TreeMap<Player, Integer> updateScore(Player winner, Player loser,
			TreeMap<Player, Integer> score) {
		
		/*if (score.containsKey(winner) == false) {
		    score.put(winner, 1);
		    score.put(loser, 0);
		}
		else {
		    score.put(winner, count + 1);
		}*/
		return score;
	}

	private static void displayChoices(Scanner sc, String name, String stringOpponent, UserPlayer user,
			Player opponent, Roshambo userChoice, Roshambo opponentChoice) {
		System.out.println(user.getName() + " chose " + userChoice + " and " + opponent.getName() + " chose " + opponentChoice);
	}

	private static void displayWinner(Player winner, Player loser) {
		System.out.println(winner.getName() + " beat " + loser.getName() + "!!!!");
	}
}

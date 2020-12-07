package rockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		
		boolean gameOn = true;
		boolean ai = false;
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		int inputPlayerOne;
		int inputPlayerTwo;
		
		while (gameOn) {
			inputPlayerOne = handleInput(scan.nextLine());
			
			if (ai) {
				inputPlayerTwo = random.nextInt(3) + 1;
				System.out.println(inputPlayerTwo);
			} else {
				inputPlayerTwo = handleInput(scan.nextLine());
			}
			
			if (inputPlayerOne == inputPlayerTwo) {
				System.out.println("draw, try again:");
			} else if (inputPlayerOne + inputPlayerTwo < 7) {
				checkResult(inputPlayerOne, inputPlayerTwo, ai);				
			}
			
			if (inputPlayerOne == 8 || inputPlayerTwo == 8) {
				ai = !ai;
			}
			
			if (inputPlayerOne == 9 || inputPlayerTwo == 9) {
				gameOn = false;
			}
		}
		
		scan.close();
	}
	
	public static int handleInput(String input) {
		switch(input.toLowerCase())
		{
			case "rock":
				return 1;
			case "paper":
				return 2;
			case "scissors":
				return 3;
			case "1":
				return 1;
			case "2":
				return 2;
			case "3":
				return 3;
			case "ai":
				return 8;
			case "quit":
				return 9;
		}
		return 10;
	}
	
	public static void checkResult(int playerOne, int playerTwo, boolean aiPlayer) {
		int sum = playerOne - playerTwo;

		if (sum == 1 || sum == -2) {
			System.out.println("player one wins");
		} else {
			if (aiPlayer) {
				System.out.println("ai player wins");	
			} else {
				System.out.println("player two wins");				
			}
		}
	}
	
}
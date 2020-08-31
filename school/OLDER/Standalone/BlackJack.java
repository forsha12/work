
/**
 * @author Paige Forsha
 * @vers 11/3/16
 * Description: This program allows a user to play the game "Blackjack". They can play it as many times as they'd like.
 * Pseudocode: The program prints the instructions to the game "Blackjack". It then selects two cards for both players. 
 * 				Card selection is based on a random number 1-13. (The drawCard method is invoked for any card drawing.)
 * 				It adds the value of the card to their total unless it is an "Ace". (The value is determined by the valueOf method.)
 * 				It stores the amount of aces the player has for later. All dealer aces are equal to 1.
 *  
 * 				Once it "draws" two cards for the player and the dealer, the player's turn begins.
 * 				The user is asked if they would like to draw another card. If they say "yes", the program enters a loop.
 * 				This loop will draw a card and store the value in similar fashion to the previous part.
 * 				It then asks again if they would like to draw another card. It exits the loop when they do not say "yes".
 * 				The program then tells the user how many Aces they have. If they have any, it enters a loop that gives
 * 				the user the option to make that Ace either a 1 or an 11. It adds their selection to their score. It exits this
 * 				loop when there are no more Aces.
 * 
 * 				The dealer's turn commences. The dealer will automatically draw until their total equals or is greater than 17.
 * 				
 * 				After both turns are over, the program compares the two scores using the determineWinner method. 
 * 				It then prints a statement declaring whether the player won, the dealer won, or if there was a tie. 
 * 				
 * 				The program then tells the player how many times they won and asks if they would like to play again.
 * 				If they say anything other than "no", the game commences again.
 * 
 * 				The program resets the values of both scores AND the ace counter at the beginning of each match.
 *
 *
 */
import java.util.Scanner;
public class BlackJack 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int playerScore; //value to store the stacking card value for the player
		int dealerScore; //same as above, just for dealer
		int playerCard; //stores value for current card to add to score for player
		int dealerCard; //stores value for current card to add to score for dealer
		String card; //for storing the result of the drawCard() method
		String answer; //for storing players answer on if they want to continue to draw cards AND for when they decide what to do with their aces AND if they want to play again
		boolean playAgain = false; //whenever the user says they'd like to play again, this is set to true
		int aceCount; //stores the amount of aces a player has so that they can choose what to do with them in the end
		String winner; //stores result of using determineWinner() method
		int wins = 0; //adds 1 each time the player wins
		
		
		displayInstructions(); //displays instructions to the game
		
		do 
		{
			playerScore = 0; //resets the scores for both so that it doesn't add from the first game
			dealerScore = 0;
			aceCount = 0; //must also be reset.
			System.out.println("\nPlayer draws two cards: "); //first two player cards
			for (int k = 1; k <= 2; k++) //draws two cards for player
			{	
				card = drawCard();
				if (!(card.equals("Ace")))
				{
					playerCard = valueOf(card);
					playerScore += playerCard;
				}	
				else //if it's an ace, it saves the fact that the player has an ace and moves on
				{
					aceCount++;
				}
				System.out.println("Card " + k + ": " + card);
			}
			System.out.println("\nDealer draws two cards: "); //first two dealer cards
			for (int k = 1; k <= 2; k++) //draws two cards for dealer
			{	
				card = drawCard();
				
				dealerCard = valueOf(card);
				dealerScore += dealerCard;
				
				System.out.println("Card " + k + ": " + card);
			}
			
			/*players turn!*/
			System.out.println("\nWould you like to draw another card? (yes or no)");
			answer = input.nextLine();
			while (answer.equals("yes")) //keeps asking if they want another card until they say no
			{
				card = drawCard();
				if (!(card.equals("Ace")))
				{
					playerCard = valueOf(card);
					playerScore += playerCard;
				}	
				else //saves that player got an ace and continues
				{
					aceCount++;
				}
				System.out.println("You drew a " + card);	
				
				System.out.println("Would you like to draw another card? (yes or no)");	
				answer = input.nextLine();	
			}
			if (aceCount != 0) 
			{
				System.out.println("You have " + aceCount + " aces.");
				for (int j = 1; j <= aceCount; j++) //lets user decide what they would like to do with all of their aces
				{
					System.out.println("Would you like Ace " + j + " to be counted as a 1 or an 11?");
					answer = input.nextLine();
					if (answer.equals("1")) //adds one to their score if they choose "1"
						playerScore += 1;
					else //if they say "11" it will add 11 to their value. 
						playerScore += 11; //if they say anything other than 1 or 11, it will still add 11 because they should listen better. they will certainly lose now.
				}
			}
			else
				System.out.println("\nYou have zero aces."); //prints when user received no aces
		
			/*dealer's turn!*/
			do 
			{
				card = drawCard();
				
				dealerCard = valueOf(card);
				dealerScore += dealerCard;	
			} while (dealerScore < 17);
			
			
			winner = determineWinner(playerScore, dealerScore);
			System.out.println("\nYour total is " + playerScore + "\nThe dealer's total is " + dealerScore);
			
			if (winner.equals("player")) //determines which line will print based on who wins
			{
				System.out.println("You won!");
				wins++;
			}
			else if (winner.equals("dealer")) 
			{
				System.out.println("The dealer wins this round. :(");
			}
			else 
			{
				System.out.println("It's a tie.");
			}
			
			System.out.println("\nYou have " + wins + " wins. \n\nWould you like to play again?");
			answer = input.nextLine();
			
			if (answer.equals("no")) //sets playAgain to true or false depending on answer. game repeats until playAgain is false
				playAgain = false;
			else //if they say "yes" or anything else. 
				playAgain = true; 
			
		} while (playAgain);
		
		
System.out.println("Thanks for playing!"); //indicates that the program is over
	}

	
	
	static void displayInstructions() //displays instructions
	{
		System.out.println("First, the dealer and player each start with two cards drawn. \nThe goal of the game is to get as close to 21 card points as possible. \nHaving a card total of 21 points results in a win (unless the dealer also has a total of 21 points, in which case, it is a tie). \nIf anyone goes over 21 points, they automatically lose. \nIf both the dealer and player get over 21 card points, it is a tie. \nOtherwise, whoever is closest to 21 is deemed winner.");
	}
	
	static String drawCard() 
	{
		int cardSelect;
		
		cardSelect = (int)((Math.random() * 13) + 1); //gets number between 1-13 to select a card value
		
		switch (cardSelect) //sends back card depending on the randomly selected number
		{
		case 1:
			return "Ace";
		case 2:
			return "2";
		case 3: 
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9: 
			return "9";
		case 10:
			return "Jack";
		case 11:
			return "Queen";
		case 12:
			return "King";
		case 13:
			return "Ace";
		default:
			return "null"; //shouldn't happen ever but needed for determineCard to ALWAYS return a String.
		}
	}
	static String determineWinner(int p, int d)	//determines winner
	{
		if (d == 21 && p == 21) //for when someone has 21
			return "tie";
		else if (p == 21)
			return "player";
		else if (d == 21)
			return "dealer";
		
		else if (d > 21 && p > 21) //for when someone goes over 21
			return "tie";
		else if (d > 21)
			return "player";
		else if (p > 21)
			return "dealer";
		
		else if (p > d) //for when both are under 21. if they have the same number, it's a tie
			return "player";
		else if (d > p)
			return "dealer";
		else 
			return "tie";	
	}
	
	
	static int valueOf(String c) //gets value of card for any NON aces, so that it can be add to the score
	{
		switch(c) 
		{
		case "2":
			return 2;
		case "3":
			return 3;
		case "4":
			return 4;
		case "5":
			return 5;
		case "6": 
			return 6;
		case "7":
			return 7;
		case "8":
			return 8;
		case "9":
			return 9;
		case "Jack":
		case "Queen":
		case "King":
			return 10;
		default:
			return 1; //happens only when the dealer gets an ace. this program assumes all dealer aces are equal to one.
		}
	}
}

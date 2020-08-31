/*
 * @author Paige Forsha
 * @vers 11/10/16
 * Program: CardGame
 * 
 * Some Notes: CANNOT end in draw. 
 * Spades > Diamonds > Clubs > Hearts
 */

import java.util.Scanner;
import java.util.Arrays;

public class CardGame 
{

	public static void main(String[] args) 
	{
	
				int[] deck = new int[52]; //created deck
				    String[] suits = {"Hearts", "Clubs", "Diamonds","Spades" };
				    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
				      "10", "Jack", "Queen", "King"}; //to give the cards names. ordered from least to most
				    
				Scanner input = new Scanner(System.in);
				int choice;
				
				    for (int i = 0; i < deck.length; i++)
				        deck[i] = i; //gives cards numerical values from 0-51
				    
				  
				   for (int i = 0; i < deck.length; i++) //shuffles cards
				    {
				    	   // Generate an index randomly
				    	       int index = (int)(Math.random() * deck.length);
				            int temp = deck[i];
				            deck[i] = deck[index]; 
				    	         deck[index] = temp;
				    }
				   
				    do 
				    {
				    	System.out.print("Would you like to play part 1 or part 2? Enter 1 or 2:");
				    	choice = input.nextInt();
				    } while (choice != 1 && choice != 2); //allows user to select which part they want and validates
				    
				    if (choice == 1)
				    	part1(deck); //sends the deck to part 1
				    else
				    	part2(deck);
				    	 //sends the deck to part 2
	}

	
	static void part1(int[] deck) 
	{
		int playerCard;
		int computerCard;
		Scanner input = new Scanner(System.in);
		String[] suits = {"Hearts", "Clubs", "Diamonds","Spades" };
	    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
	      "10", "Jack", "Queen", "King"}; //to give the cards names. ordered from least to most
	    String playerSuit; 
	    String playerRank;
	    String compSuit;
	    String compRank;
	    int playerIndexS;
	    int playerIndexR;
	    int compIndexS;
	    int compIndexR;
	
		do 
		{
		System.out.print("Choose a number from 0 to 51 to pick a card out of a 52 card deck: ");
		playerCard = input.nextInt();
		}while (playerCard < 0 && playerCard > 51); //allows user to pick a card number
		
	
		playerSuit = suits[deck[playerCard] / 13];
		playerRank = ranks[deck[playerCard] % 13]; //assigns names to the card for player
		
		System.out.println("The computer chose a card.\n");
		do {
			computerCard = (int)(Math.random() * 52);
		} while (computerCard == playerCard); //gets card number for computer
		
		compSuit = suits[deck[computerCard] / 13];
		compRank = ranks[deck[computerCard] % 13]; //assigns names to card for computer 
		
		System.out.println("Your card is: " + playerRank + " of " + playerSuit); //prints user card based on number
		System.out.println("Computer card is: " + compRank + " of " + compSuit); //prints computers card based on number
		
		playerIndexR = Arrays.asList(ranks).indexOf(playerRank);
		playerIndexS = Arrays.asList(suits).indexOf(playerSuit); //gets players rank and suit position for comparing
		
		compIndexR = Arrays.asList(ranks).indexOf(compRank);
		compIndexS = Arrays.asList(suits).indexOf(compSuit); //gets computer rank and suit for comparing
		
		if (playerIndexR > compIndexR) //compares ranks first 
			System.out.println("You won!");
		else if (playerIndexR < compIndexR)
			System.out.println("You lose.");
		
		else if (playerIndexS > compIndexS) //when ranks are the same---this goes off Spades > Diamonds > Clubs > Hearts.
			System.out.println("You win!");
		else 
			System.out.println("You lose.");
	
		
		
	}
	
	static void part2(int[] deck) 
	{
		int comp1Card;
		int comp2Card;
		Scanner input = new Scanner(System.in);
		String[] suits = {"Hearts", "Clubs", "Diamonds","Spades" };
	    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
	      "10", "Jack", "Queen", "King"}; //to give the cards names. ordered from least to most
	    String comp1Suit; 
	    String comp1Rank;
	    String comp2Suit;
	    String comp2Rank;
	    int comp1IndexS;
	    int comp1IndexR;
	    int comp2IndexS;
	    int comp2IndexR;
	
	    for(int k = 0; k < 100; k++)
	    {
			
			
			
			comp1Card = (int)(Math.random() * 52);
		
			comp1Suit = suits[deck[comp1Card] / 13];
			comp1Rank = ranks[deck[comp1Card] % 13]; //assigns names to the card for comp1
			
			do 
			{
				comp2Card = (int)(Math.random() * 52);
			} while (comp2Card == comp1Card); //gets card number for computer 2
			
			comp2Suit = suits[deck[comp2Card] / 13];
			comp2Rank = ranks[deck[comp2Card] % 13]; //assigns names to card for computer 2
			
			System.out.println("Computer 1 card is: " + comp1Rank + " of " + comp1Suit); //prints user card based on number
			System.out.println("Computer 2 card is: " + comp2Rank + " of " + comp2Suit); //prints computers card based on number
			
			comp1IndexR = Arrays.asList(ranks).indexOf(comp1Rank);
			comp1IndexS = Arrays.asList(suits).indexOf(comp1Suit); //gets comp 1 rank and suit position for comparing
			
			comp2IndexR = Arrays.asList(ranks).indexOf(comp2Rank);
			comp2IndexS = Arrays.asList(suits).indexOf(comp2Suit); //gets computer 2 rank and suit for comparing
			
			if (comp1IndexR > comp2IndexR) //compares ranks first 
				System.out.println("Computer 1 won.");
			else if (comp1IndexR < comp2IndexR)
				System.out.println("Computer 2 wins.");
			
			else if (comp1IndexS > comp2IndexS) //when ranks are the same---this goes off Spades > Diamonds > Clubs > Hearts.
				System.out.println("Computer 1 won.");
			else 
				System.out.println("Computer 2 wins.");
			
			System.out.println("\n\n");
			
			 for (int i = 0; i < deck.length; i++) //shuffles cards
			    {
			    	
			    	    int index = (int)(Math.random() * deck.length);
			            int temp = deck[i];
			            deck[i] = deck[index]; 
			    	         deck[index] = temp;
			    }
	    }
		
		
	}
}

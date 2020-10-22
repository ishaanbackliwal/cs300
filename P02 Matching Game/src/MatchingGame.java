//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P02 Matching Game
// Files:           MatchingGame.java
// Course:          CS 300, Fall 2019
//
// Author:          Ishaan Backliwal
// Email:           backliwal@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Sabrina Huang
// Partner Email:   shuang377@wisc.edu
// Partner Lecturer's Name: Gary Dahl
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  The Java API
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class MatchingGame {
	// Congratulations message
	private final static String CONGRA_MSG = "CONGRATULATIONS! YOU WON!";
	// Cards not matched message
	private final static String NOT_MATCHED = "CARDS NOT MATCHED. Try again!";
	// Cards matched message
	private final static String MATCHED = "CARDS MATCHED! Good Job!";
	// 2D-array which stores cards coordinates on the window display
	private final static float[][] CARDS_COORDINATES = new float[][] {{170, 170},  {324, 170}, 
	  {478, 170}, {632, 170}, {170, 324}, {324, 324}, {478, 324}, {632, 324}, {170, 478}, 
	  {324, 478}, {478, 478}, {632, 478}};
	// Array that stores the card images filenames
	private final static String[] CARD_IMAGES_NAMES = new String[] {"apple.png", "ball.png", 
	    "peach.png", "redFlower.png", "shark.png", "yellowFlower.png"};
	
	private static PApplet processing;	// PApplet object that represents the graphic display window
	private static Card[] cards; 		// one dimensional array of cards
	private static PImage[] images; 	// array of images of the different cards
	private static Random randGen; 		// generator of random numbers
	private static Card selectedCard1; 	// First selected card
	private static Card selectedCard2;	// Second selected card
	private static boolean winner;		// boolean evaluated true if the game is won, and false otherwise
	private static int matchedCardsCount; // number of cards matched so far in one session of the game
	private static String message; 		// Displayed message to the display window
	
	/**
	 * Runs the application
	 * @param args
	 */
	public static void main(String[] args) {
		Utility.runApplication();
	}
	/**
	* Defines the initial environment properties of this game as the program starts
	*/
	public static void setup(PApplet processing) {
		images = new PImage[6];
		for (int i = 0; i < 6; i++) {
			images[i] = processing.loadImage("images" + File.separator + CARD_IMAGES_NAMES[i]);
		}
		MatchingGame.processing = processing;
		initGame();
	}
	/**
	* Initializes the Game
	*/
	public static void initGame() {
		randGen = new Random(Utility.getSeed());
		selectedCard1 = null;
		selectedCard2 = null;
		matchedCardsCount = 0;
		winner = false;
		message = "";
		cards = new Card[CARD_IMAGES_NAMES.length * 2];
		int [] count = new int[6];
		for(int i = 0; i < 6; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < cards.length; i++) {
			do {
				int num = randGen.nextInt(6);
				if (count[num] < 2) {
					cards[i] = new Card(images[num], CARDS_COORDINATES[i][0], CARDS_COORDINATES[i][1]);
					count[num] += 1;
				}
			}
			while(cards[i] == null);
		}
	}
	/**
	* Callback method called each time the user presses a key
	*/
	public static void keyPressed() {
		if (processing.key == 'n' || processing.key == 'N') {
			initGame();
		}
	}
	/**
	* Callback method draws continuously this application window display
	*/
	public static void draw() {
		processing.background(245, 255, 250); // Mint cream color
		for(int i = 0; i < cards.length; i++) {
			cards[i].draw();
		}
		displayMessage(message);
	}
	/**
	* Displays a given message to the display window
	* @param message to be displayed to the display window
	*/
	public static void displayMessage(String message) {
		processing.fill(0);
		processing.textSize(20);
		processing.text(message, processing.width / 2, 50);
		processing.textSize(12);
	}
	/**
	* Checks whether the mouse is over a given Card
	* @return true if the mouse is over the storage list, false otherwise
	*/
	public static boolean isMouseOver(Card card) {
		int halfDimension = card.getWidth() / 2;
		if(processing.mouseX < card.getX() + halfDimension && processing.mouseX > card.getX() 
		    - halfDimension && processing.mouseY < card.getY() + halfDimension && processing.mouseY
		    > card.getY() - halfDimension) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	* Callback method called each time the user presses the mouse
	*/
	public static void mousePressed() {
		if(selectedCard2 != null && selectedCard1 != null) {
			if(matchingCards(selectedCard1, selectedCard2) == false) {
				selectedCard1.setVisible(false);
				selectedCard2.setVisible(false);
				selectedCard1.deselect();
				selectedCard2.deselect();
			}
			selectedCard1 = null;
	        selectedCard2 = null;
	    }
		for (int i = 0; i < cards.length; i++) {
			if (isMouseOver(cards[i])) {
				if(cards[i].isVisible() == false) {
					if(selectedCard1 == null) {
						selectedCard1 = cards[i];
						cards[i].setVisible(true);
						cards[i].select();
					}
					else {
						selectedCard2 = cards[i];
						cards[i].setVisible(true);
						cards[i].select();
					}
				}
			}
		}
		if(selectedCard1 != null && selectedCard2 != null) {
			if(matchingCards(selectedCard1, selectedCard2)) {
				matchedCardsCount++;
				message = MATCHED;
				selectedCard1.deselect();
				selectedCard2.deselect();
			}
			else {
				message = NOT_MATCHED;
			}
		}
		if (matchedCardsCount == 6) {
			message = CONGRA_MSG;
			winner = true;
		}
	}
	/**
	* Checks whether two cards match or not
	* @param card1 reference to the first card
	* @param card2 reference to the second card
	* @return true if card1 and card2 image references are the same, false otherwise
	*/
	public static boolean matchingCards(Card card1, Card card2) {
		if(card1.getImage().equals(card2.getImage()) == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
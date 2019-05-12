package blackjack;

public class Kaartenset {
	static String[] deck = new String[52];
	static String[] deck1 = new String[52];
	String[] ShuffledDeck = new String[52];

//	public static void main(String[] args) {
	public static String[][] makeDeck() {

		String[] SUITS = { "Klaver", "Ruiten", "Harten", "Schoppen" };

		String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Vrouw", "Koning", "Aas" };

		String[] RANKS1 = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "10", "10", "10", "11" };

		// initialize deck
		int n = SUITS.length * RANKS.length;
		String[][] deck = new String[n][3];
	//	String[] deck1 = new String[n];
		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				deck[SUITS.length * i + j][0] = SUITS[j] + " " + RANKS[i];
				deck[SUITS.length * i + j][1] = RANKS1[i]; 	//SUITS[j] + " " + 
				//deck[SUITS.length * i + j][2] = RANKS1[i];
				
			}
		}
		return deck;
				
	}

	

	public static String[][] shuffle() {
	        // shuffle
	        	int n = 52;
	        	String shuffledDeck[][] = new String[n][2];
	        	
	        for (int i1 = 0; i1 < n; i1++) {
	            int r = i1 + (int) (Math.random() * (n-i1));
			/*
			 * String temp = makeDeck()[r][0]; shuffledDeck[r] = makeDeck()[i1][0];
			 * shuffledDeck[i1] = temp;
			 */
	            shuffledDeck[r][0] = makeDeck()[i1][0];
	            shuffledDeck[i1][0] = makeDeck()[r][0];
	            shuffledDeck[r][1] = makeDeck()[i1][1];
	            shuffledDeck[i1][1] = makeDeck()[r][1];
	            
	        }
//	        System.out.println(shuffledDeck);
			return shuffledDeck;
	        }

	/*
	 * // print shuffled deck for (int i = 0; i < n; i++) {
	 * System.out.println(deck[i]); }
	 */

}

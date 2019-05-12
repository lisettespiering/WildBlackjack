package blackjack;

public class Kaart {
static int pos = 0;
String Card;

	public static String[] trekKaart(String[][] sDeck) {

        	String[] Card = new String[2];

        	Card[0] = sDeck[pos][0];
        	Card[1] = sDeck[pos][1];
        	pos += 1;
		return Card;
	}
	
	

}

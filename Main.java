package blackjack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	static String[][] Deck = new String[52][2];
	static String[][] SDeck = new String[52][2];
	public static int nSpelers;
//	public static String[] Spelers = new String[nSpelers];

	public static void main(String[] args) {
		Deck = Kaartenset.makeDeck();
		SDeck = Kaartenset.shuffle();
		Scanner sc = new Scanner(System.in);

		// INTRODUCTIE VAN HET SPEL
		System.out.println("Welkom bij het Wilde Westen casino. Met hoeveel mensen wilt u spelen?");
		nSpelers = sc.nextInt();
		String[] Spelers = new String[nSpelers];

		ArrayList<Person> players = new ArrayList<>();
		if (nSpelers > 1) {
			System.out.println("Ik wil graag jullie namen weten");
			for (int x = 0; x < nSpelers; x++) {
				System.out.println("Hoe heet speler " + (x + 1) + "?");
				Spelers[x] = sc.next();
				players.add(new Person(sc.nextLine()));
				players.get(x).naam = Spelers[x];
			}
		} else {
			System.out.println("Hoe heet u?");
			Spelers[0] = sc.next();
			players.add(new Person(sc.nextLine()));
			players.get(0).naam = Spelers[0];
		}

		System.out.print("Hallo ");
		for (int s = 0; s < nSpelers; s++) {
			System.out.print(Spelers[s]);
			if (s == nSpelers - 1 || nSpelers == 1 && s == 0) {
				System.out.print(". ");
			} else if (s == nSpelers - 2) {
				System.out.print(" en ");
			} else {
				System.out.print(", ");
			}
		}
		;
		// VRAAG OM INZET
		System.out.println(" We gaan blackjack spelen. Er kan nu geld ingezet worden");
		for (int x = 0; x < nSpelers; x++) {
			System.out.println("Hoeveel zet " + Spelers[x] + " in?");
			players.get(x).inzet = sc.nextDouble();
		}
		System.out.println("Bedankt voor uw inzetten, we gaan spelen met de volgende mensen: ");

		for (int x = 0; x < nSpelers; x++) {
			System.out.println("naam: " + players.get(x).naam + " Inzet: " + players.get(x).inzet);
		}
		waitabit();

		// UITDEELRONDE
		for (int s = 0; s < nSpelers; s++) {
			String[] Card = Kaart.trekKaart(SDeck);
			System.out.println(players.get(s).naam + " krijgt een " + Card[0]);
			kaartWaarde(players.get(s), Integer.parseInt(Card[1]));
			waitabit();

		}
		Person dealer = new Person("Dealer");
		String[] Card = Kaart.trekKaart(SDeck);
		System.out.println("De dealer krijgt een " + Card[0]);
		kaartWaarde(dealer, Integer.parseInt(Card[1]));
		waitabit();
		String[] Card1 = Kaart.trekKaart(SDeck);
		kaartWaarde(dealer, Integer.parseInt(Card1[1]));

		for (int s = 0; s < nSpelers; s++) {
			String[] Card11 = Kaart.trekKaart(SDeck);
			System.out.println(players.get(s).naam + " krijgt een " + Card11[0]);
			kaartWaarde(players.get(s), Integer.parseInt(Card11[1]));
			waitabit();
		}
		System.out.println("De dealer krijgt een gesloten kaart");
		waitabit();

		// LETS PLAY THE GAME =D ///////////////////

		
		System.out.println("De spelers hebben de volgende punten in hun handen: ");
		for (int h = 0; h < nSpelers; h++) {
			System.out.println(players.get(h).naam + ": " + players.get(h).hand);
		}
		waitabit();
		for (int g = 0; g < nSpelers; g++) {
			System.out.println(players.get(g).naam + ", kopen of passen? typ een k voor kopen en een p voor passen");
			switch (sc.nextLine()) {
				case "k":
					String[] Card2 = Kaart.trekKaart(SDeck);
					System.out.println(players.get(g).naam + ", U krijgt een: " + Card2[0]);
					kaartWaarde(players.get(g), Integer.parseInt(Card2[1]));
					System.out.println("Uw nieuwe aantal punten is: " + players.get(g).hand);
					break;
				case "p":
					System.out.println("oke volgende");
					break;
				default:
					System.out.println("try again");
					g -= 1;
					break;
			}
		}
		
		eenOverval();
		
		

		// NEEM EEN KAART
//		String[] Card = Kaart.trekKaart(SDeck);
//		System.out.println("Card: " + Card);

		sc.close();
	}

	private static void kaartWaarde(Person speler, int number) {

		if (number == 11) {// means the drawn card is an ace!
			speler.azen += 1;
			speler.hand += 11;
		} else {
			speler.hand += number;
		}
	}

	public static void waitabit() {
		// wait a short time to make the game more exciting
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void eenOverval() {
		waitabit();
		System.out.println("Een overvaller loopt het casino in...");
		waitabit(); waitabit();
		System.out.println("DIT IS EEN OVERVAL!! HEEE JIJ GEEF ME HET GELD!!");
		waitabit(); waitabit();
		System.out.println("De overvaller houdt de dealer onder schot en deze geeft al het ingezette geld weg.");
		waitabit(); waitabit();
		System.out.println("Jammer dat de avond hier eindigt. Alle spelers gaan blut naar huis vanavond.");
		waitabit(); waitabit();
		System.out.println("THE END");
	}
}

package blackjack;

public class Person {
	String naam;
	double inzet;
	int hand = 0;
	public int azen;
	
	public Person(String name, double inzet) {
		this.naam = name;
		this.inzet = inzet;
		
	}

	public Person(String name) {
		this.naam = name;
	
	}
	
	public Person(int inzet) {
		this.inzet = inzet;
	}
	


}

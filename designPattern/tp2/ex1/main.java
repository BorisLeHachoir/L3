import java.text.*;
import java.util.*;

class Main
{
	public static void main (String[] args)
	{	
		DateStandard dateStand = new DateStandard();
		DateFR datefr = new DateFR();
		DateUS dateus = new DateUS();

		DateDuJour dateOfTheDay = new DateDuJour(dateStand);

		dateOfTheDay.afficher();
		dateOfTheDay.setDate(datefr);
		dateOfTheDay.afficher();
		dateOfTheDay.setDate(dateus);
		dateOfTheDay.afficher();
	}
}
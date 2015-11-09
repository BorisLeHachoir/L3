import java.text.*;
import java.util.*;
import java.lang.*;

abstract class Sujet 
{
 	protected ArrayList<Observator> obs;
 	protected Date date;

	public Sujet(Observator o)
	{
		date = new Date();
		obs = new ArrayList<Observator>();
		obs.add(o);
	}

	public void addObs(Observator o)
	{
		obs.add(o);
	}

	public void delObs(Observator o)
	{
		obs.remove(o);
	}

	public void notifier()
	{
		for(Observator o: obs){
  			o.setData(date);
  		}
	}

	public void setDate(Date d)
	{
		date = d;
		notifier();
	}
}

class Heure extends Sujet
{
	public Heure(Observator o)
	{
		super(o);
	}
}

abstract class Observator
{
	protected DateFormat dateFormat;
	protected Date date;
	protected Sujet sujet;

	public Observator()
	{
	    dateFormat = new SimpleDateFormat( "HH:mm:ss" );
	}
	public void setData(Date d)
	{
		date = d;
		System.out.println(dateFormat.format(date));
	}
}

class Client extends Observator
{
}

class Main
{
	public static void main (String[] args)
	{
		Client c = new Client();
		Client d = new Client();
		Client f = new Client();
		Heure h = new Heure(c);
		h.addObs(d);
		h.addObs(f);
		Date date;

		while (true)
		{
			date = new Date();
			h.setDate(date);
			try
			{
				Thread.sleep(1000);
			}
			catch( Exception e )
			{}
		}
	}
}

interface Strategie 
{
	public void action();
}

class IA
{
	private String nom_;
	private Strategie strategie_;

	public IA(String nom)
	{
		nom_ = nom;
	}

	public void setStrategie(Strategie strategie)
	{
		strategie_ = strategie;
	}

	public void action()
	{
		System.out.print("Je suis " + nom_);
		strategie_.action();
	}
}

class StrategieAgressive implements Strategie
{
	public void action()
	{
		System.out.println(" jte nike.");
	}
}

class StrategieNormale implements Strategie
{
	public void action()
	{
		System.out.println(" jte fixe.");
	}
}

class StrategieDefensive implements Strategie
{
	public void action()
	{
		System.out.println(" jme casse.");
	}
}

class Main
{
	public static void main (String[] args)
	{	
		IA ia1 = new IA("Chucky");
		IA ia2 = new IA("Georges");
		IA ia3 = new IA("AIUR");

		ia1.setStrategie(new StrategieAgressive());
		ia2.setStrategie(new StrategieDefensive());
		ia3.setStrategie(new StrategieNormale());

		ia1.action();
		ia2.action();
		ia3.action();

		System.out.println("Nouvelles strats: Chucky fuit et Georges mode berserk");

		ia1.setStrategie(new StrategieDefensive());
		ia2.setStrategie(new StrategieAgressive());

		ia1.action();
		ia2.action();
	}
}
abstract class Etat
{
	protected Ventilateur fan_;

	public Etat(Ventilateur fan)
	{
		fan_ = fan;
	}

	public void bouton(){}
}

class EtatEtteint extends Etat
{
	public EtatEtteint(Ventilateur fan)
	{
		super(fan);
	}

	public void bouton()
	{
		fan_.setEtat(fan_.getEtatFaible());
		System.out.println("Faible");
	}
}

class EtatFaible extends Etat
{
	public EtatFaible(Ventilateur fan)
	{
		super(fan);
	}

	public void bouton()
	{
		fan_.setEtat(fan_.getEtatMoyen());
		System.out.println("Moyen");
	}
}

class EtatMoyen extends Etat
{
	public EtatMoyen(Ventilateur fan)
	{
		super(fan);
	}

	public void bouton()
	{
		fan_.setEtat(fan_.getEtatFort());
		System.out.println("Fort");
	}
}

class EtatFort extends Etat
{
	public EtatFort(Ventilateur fan)
	{
		super(fan);
	}

	public void bouton()
	{
		fan_.setEtat(fan_.getEtatEteint());
		System.out.println("Eteint");
	}
}

class Ventilateur
{
	private Etat etat_;
	private EtatEtteint etatEteint_;
	private EtatFaible etatFaible_;
	private EtatMoyen etatMoyen_;
	private EtatFort etatFort_;

	public Ventilateur()
	{
		etatEteint_ = new EtatEtteint(this);
		etatFaible_ = new EtatFaible(this);
		etatMoyen_ = new EtatMoyen(this);
		etatFort_ = new EtatFort(this);

		etat_ = etatEteint_;
	}

	public void bouton()
	{
		etat_.bouton();
	}

	public void setEtat(Etat e)
	{
		etat_ = e;
	}

	public Etat getEtatEteint(){return etatEteint_;}
	public Etat getEtatFaible(){return etatFaible_;}
	public Etat getEtatMoyen(){return etatMoyen_;}
	public Etat getEtatFort(){return etatFort_;}
}

class Main
{
	public static void main (String[] args)
	{
		Ventilateur fan = new Ventilateur();

		fan.bouton();
		fan.bouton();
		fan.bouton();
		fan.bouton();
		fan.bouton();
		fan.bouton();
		fan.bouton();
		fan.bouton();
		fan.bouton();
		fan.bouton();
	}	
}
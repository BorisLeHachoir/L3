abstract class Etat 
{
	protected Billet billet_;

	public Etat (Billet billet)
	{
		billet_ = billet;
	}

	public void reserver(){System.out.println("Reserver: opération impossible");}
	public void modifier(){System.out.println("Modifier: opération impossible");}
	public void annuler(){System.out.println("Annuler: pération impossible");}
	public void payer(){System.out.println("Payer: pération impossible");}
	public void expirer(){};
}

class EtatBilletDisponible extends Etat
{
	public EtatBilletDisponible(Billet billet)
	{
		super(billet);
	}

	public void reserver()
	{
		billet_.setEtat(billet_.getEtatBilletReserver());
		System.out.println("Votre billet a été reservé");		
	}
}

class EtatBilletReserver extends Etat
{
	public EtatBilletReserver(Billet billet)
	{
		super(billet);
	}

	public void annuler()
	{
		System.out.println("Votre billet a été annulé");		
		billet_.setEtat(billet_.getEtatBilletDisponible());
	}
	public void payer()
	{
		billet_.setEtat(billet_.getEtatBilletConfirmer());
		System.out.println("Votre billet a été payé");
	}
	public void modifier(){System.out.println("Votre billet a été modifié");}
}


class EtatBilletConfirmer extends Etat
{
	public EtatBilletConfirmer(Billet billet)
	{
		super(billet);
	}

	public void modifier(){System.out.println("Votre billet a été modifié");}
}

class EtatBilletExpirer extends Etat
{
	public EtatBilletExpirer(Billet billet)
	{
		super(billet);
	}

	public void expirer()
	{
		billet_.setEtat(billet_.getEtatBilletDisponible());
	}

}


class Billet
{
	private Etat etat_;
	private EtatBilletDisponible etatBilletDisponible_;
	private EtatBilletReserver etatBilletReserver_;
	private EtatBilletConfirmer etatBilletConfirmer_;
	private EtatBilletExpirer etatBilletExpirer_;

	public Billet()
	{
		etatBilletDisponible_ = new EtatBilletDisponible(this);
		etatBilletReserver_ = new EtatBilletReserver(this);
		etatBilletConfirmer_ = new EtatBilletConfirmer(this);
		etatBilletExpirer_ = new EtatBilletExpirer(this);
		etat_ = etatBilletDisponible_;
	}

	public void reserver()
	{
		etat_.reserver();
	}

	public void modifier()
	{
		etat_.modifier();
	}

	public void annuler()
	{
		etat_.annuler();
	}

	public void payer()
	{
		etat_.payer();
	}

	public void setEtat(Etat etat){etat_ = etat;}
	public Etat getEtatBilletExpirer(){return etatBilletExpirer_;}
	public Etat getEtatBilletDisponible(){return etatBilletDisponible_;}
	public Etat getEtatBilletReserver(){return etatBilletReserver_;}
	public Etat getEtatBilletConfirmer(){return etatBilletConfirmer_;}
}

class Main
{
	public static void main (String[] args)
	{
		Billet billet = new Billet();
		billet.reserver();
		billet.annuler();
		billet.reserver();
		billet.modifier();
		billet.payer();
		billet.annuler();
	}	
}
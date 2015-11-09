abstract class Etat 
{
	protected GoogleCar googleCar_;

	public Etat (GoogleCar googleCar)
	{
		googleCar_ = googleCar;
	}

	public void utiliserBouton(){};
	public void saisirAdresse(String adresse){};
	public void arrive(){};
}

class EtatArret extends Etat
{
	public EtatArret(GoogleCar googleCar)
	{
		super(googleCar);
	}

	public void utiliserBouton()
	{
		googleCar_.setEtat(googleCar_.getEtatAttente());
		System.out.println("La voiture est en état d'attente");
	}

}

class EtatAttente extends Etat
{
	public EtatAttente(GoogleCar googleCar)
	{
		super(googleCar);
	}

	public void utiliserBouton()
	{
		googleCar_.setEtat(googleCar_.getEtatArret());
		System.out.println("Le moteur est coupé");
	}

	public void saisirAdresse(String adresse)
	{
		googleCar_.setEtat(googleCar_.getEtatConduite());
		System.out.println("La voiture est en destination de "+adresse);
		googleCar_.setDestination(adresse);
	}
}


class EtatConduite extends Etat
{
	public EtatConduite(GoogleCar googleCar)
	{
		super(googleCar);
	}

	public void saisirAdresse(String adresse)
	{
		System.out.println("Changement d'itinéraire, la voiture est en destination de "+adresse);
		googleCar_.setDestination(adresse);
	}

	public void arrive()
	{
		googleCar_.setEtat(googleCar_.getEtatAttente());
		System.out.println("Nous sommes arrivés à "+googleCar_.getDestination());
	}

}

class GoogleCar
{
	private Etat etat_;
	private EtatConduite etatConduite_;
	private EtatAttente etatAttente_;
	private EtatArret etatArret_;
	private String destination_;

	public GoogleCar()
	{
		etatConduite_ = new EtatConduite(this);
		etatAttente_ = new EtatAttente(this);
		etatArret_ = new EtatArret(this);
		destination_ = "";
		etat_ = etatArret_;
	}

	public void utiliserBouton()
	{
		etat_.utiliserBouton();
	}

	public void saisirAdresse(String adresse)
	{
		etat_.saisirAdresse(adresse);
	}

	public void setEtat(Etat etat)
	{
		etat_ = etat;
	}

	public void arrive()
	{
		etat_.arrive();
	}

	public void setDestination(String destination){destination_ = destination;}
	public String getDestination(){return destination_;}
	public Etat getEtatConduite(){return etatConduite_;}
	public Etat getEtatArret(){return etatArret_;}
	public Etat getEtatAttente(){return etatAttente_;}
}

class Main
{
	public static void main (String[] args)
	{
		GoogleCar googleCar = new GoogleCar();
		googleCar.utiliserBouton();//On allume
		googleCar.saisirAdresse("Hell");
		googleCar.saisirAdresse("Heaven");
		googleCar.utiliserBouton();//On essaye de couper le moteur en route
		googleCar.arrive();
		googleCar.utiliserBouton();//On eteint
		googleCar.saisirAdresse("wesh");
	}	
}
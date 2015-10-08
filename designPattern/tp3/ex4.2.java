abstract class Etat
{
	protected Distributeur dist_;

	public Etat(Distributeur d)
	{
		dist_ = d;
	}

	public void InserPiece(){}
	public void annuler(){}
	public void tournerPoignee(){}
}

class EtatAttente extends Etat
{
	public EtatAttente(Distributeur d)
	{
		super(d);
	}

	public void InserPiece()
	{
		dist_.setEtat(dist_.getEtatAUnePiece());
	}
	public void annuler(){System.out.println("Vous n'avez pas mit de pièce !");}
	public void tournerPoignee(){System.out.println("Vous n'avez pas mit de pièce !");}
}

class EtatAUnePiece extends Etat
{
	public EtatAUnePiece(Distributeur d)
	{
		super(d);
	}

	public void tournerPoignee()
	{
		if(dist_.getnbBonbons()>1)
		{
			dist_.setEtat(dist_.getEtatAttente());
			dist_.setnbBonbons(dist_.getnbBonbons()-1);
		}
		else
		{
			dist_.setEtat(dist_.getEtatVide());
		}
		System.out.println("1 bonbon vient de tomber !");
	}

	public void InserPiece(){System.out.println("Il y a déjà une pièce !");}
	public void annuler(){System.out.println("Voici votre pièce m'sieur !");}
}

class EtatVide extends Etat
{
	public EtatVide(Distributeur d)
	{
		super(d);
	}

	public void InserPiece(){System.out.println("Plus de bonbons !");}
	public void annuler(){System.out.println("Plus de bonbons !");}
	public void tournerPoignee(){System.out.println("Plus de bonbons !");}
}

class Distributeur 
{
	private int nbBonbons_;
	private EtatAttente etatAttente_;
	private EtatAUnePiece etatAUnepièce_;
	private EtatVide etatVide_;
	private Etat etat_;

	public Distributeur(int nbBonbons)
	{
		etatVide_ = new EtatVide(this);
		etatAUnepièce_ = new EtatAUnePiece(this);
		etatAttente_ = new EtatAttente(this);
		nbBonbons_ = nbBonbons;
		etat_ = (nbBonbons > 0) ? etatAttente_ : etatVide_;
	}


	public void InserPiece(){etat_.InserPiece();}
	public void annuler(){etat_.annuler();}
	public void tournerPoignee(){etat_.tournerPoignee();}
	public int getnbBonbons(){return nbBonbons_;}
	public void setnbBonbons(int b){nbBonbons_ = b;}
	public Etat getEtatVide(){return etatVide_;}
	public Etat getEtatAttente(){return etatAttente_;}
	public Etat getEtatAUnePiece(){return etatAUnepièce_;}
	public void setEtat(Etat e){etat_ = e;}
}

class Main
{
	public static void main (String[] args)
	{
		Distributeur dist_ = new Distributeur(2);

		dist_.tournerPoignee();
		dist_.annuler();
		dist_.tournerPoignee();
		dist_.InserPiece();
		dist_.annuler();
		dist_.InserPiece();
		dist_.tournerPoignee();
		dist_.InserPiece();
		dist_.tournerPoignee();
		dist_.InserPiece();
		dist_.tournerPoignee();
	}	
}
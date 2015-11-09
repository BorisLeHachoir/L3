abstract class Etat 
{
	protected Propriete propriete_;

	public Etat (Propriete propriete)
	{
		propriete_ = propriete;
	}

	public void visitePar(Joueur J){}; 
}

class EtatLibre extends Etat
{
	public EtatLibre (Propriete propriete)
	{
		super(propriete);
	}


	public void visitePar(Joueur j)
	{
		if(j.getArgent() >= propriete_.getPrix())
		{
			System.out.print(j.getNom());
			propriete_.setProprio(j);
			System.out.print(" est maintenant proprietaire de " + propriete_.getNom());
			j.debit(propriete_.getPrix());
			System.out.println(" il lui reste maintenant " + j.getArgent() + "€");
			propriete_.setEtat(propriete_.getEtatPosseder());
		}
		else
			System.out.println(j.getNom() + " ne peut pas acheter " + propriete_.getNom());
	}
}


class EtatPosseder extends Etat
{
	public EtatPosseder (Propriete propriete)
	{
		super(propriete);
	}

	public void visitePar(Joueur j)
	{
		if(propriete_.getProprio().getNom() != j.getNom())
		{
			j.debit(propriete_.getDroitsDePassage());
			propriete_.getProprio().credit(propriete_.getDroitsDePassage());
			System.out.println(j.getNom() + " est tombé sur " + propriete_.getNom() + " qui appartient à " + propriete_.getProprio().getNom());
			System.out.println(j.getNom() + " a maintenant "+ j.getArgent() + "€");
			System.out.println(propriete_.getProprio().getNom() + " a maintenant "+ propriete_.getProprio().getArgent() + "€");
		}
		else
		{
			System.out.println(j.getNom() + " est chez lui à " + propriete_.getNom());
		}
	}
}

class Propriete
{
	private Etat etat_;
	private EtatPosseder etatposseder_;
	private EtatLibre etatlibre_;
	private String nom_;
	private int prix_;
	private int droits_;
	private Joueur proprio_;

	public Propriete(String n)
	{
		nom_ = n;
		etatlibre_ = new EtatLibre(this);
		etatposseder_ = new EtatPosseder(this);
		prix_ = 100;
		droits_ = 10;
		etat_ = etatlibre_;
	}

	public void visitePar(Joueur j)
	{
		etat_.visitePar(j);
	}

	public String getNom(){return nom_;}
	public int getPrix(){return prix_;}
	public int getDroitsDePassage(){return droits_;}
	public Joueur getProprio(){return proprio_;}
	public void setProprio(Joueur j){proprio_ = j;}
	public void setEtat(Etat etat){etat_ = etat;}
	public Etat getEtatPosseder(){return etatposseder_;}
	public Etat getEtatLibre(){return etatlibre_;}
}

class Joueur
{
	private String nom_;
	private int argent_;

	public Joueur(String n, int m)
	{
		nom_ = n;
		argent_ = m;
	}

	public String getNom(){return nom_;}
	public int getArgent(){return argent_;}
	public void debit(int n){argent_ -=n;}
	public void credit(int n){argent_ +=n;}
}

class Main
{
	public static void main (String[] args)
	{
		Propriete prop = new Propriete("Gare de l'Est");
		Joueur j1 = new Joueur("Tom", 50);
		Joueur j2 = new Joueur("Leo", 500);

		prop.visitePar(j1);
		prop.visitePar(j2);
		prop.visitePar(j1);
		prop.visitePar(j2);
		prop.visitePar(j1);
	}	
}
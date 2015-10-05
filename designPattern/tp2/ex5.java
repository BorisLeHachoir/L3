interface Transport
{
	public void seDeplacer();
}

class Apied implements Transport
{
	public void seDeplacer()
	{
		System.out.print("je suis à pied");
	}
}

class Velo implements Transport
{
	public void seDeplacer()
	{
		System.out.print("je suis en bicloo");
	}
}

class Tram implements Transport
{
	public void seDeplacer()
	{
		System.out.print("je tram");
	}
}

class Clio implements Transport
{
	public void seDeplacer()
	{
		System.out.print("je suis un thug en Clio");
	}
}

class AudiTT implements Transport
{
	public void seDeplacer()
	{
		System.out.print("zyva je traine pas avec la populace");
	}
}

abstract class CheminUniversite
{
	protected Transport transp_;

	public void setTransport(Transport transp)
	{
		transp_ = transp;
	}
	public void aller(){};
}

class Etudiant extends CheminUniversite
{
	public Etudiant(Transport transp)
	{
		transp_ = transp;
	}

	public void aller()
	{
		System.out.print("Je suis un etudiant et ");
		transp_.seDeplacer();
		System.out.println();
	}
}


class Main
{
	public static void main (String[] args)
	{	
		Transport pied = new Apied();
		Transport velo = new Velo();
		Transport tram = new Tram();
		Transport clio = new Clio();
		Transport audiTT = new AudiTT();

		CheminUniversite etudiant = new Etudiant(pied);

		etudiant.aller();
		etudiant.setTransport(velo);
		etudiant.aller();
		etudiant.setTransport(tram);
		etudiant.aller();
		etudiant.setTransport(clio);
		etudiant.aller();
		etudiant.setTransport(audiTT);
		etudiant.aller();
	}
}
interface ComportementArme
{
	public void utiliserArme();
}

class ComportementArc implements ComportementArme
{
	public void utiliserArme()
	{
		System.out.print("je tire très loin avon mon arc.");
	}
}

class ComportementHache implements ComportementArme
{
	public void utiliserArme()
	{
		System.out.print("je te coupe en deux avec ma hache.");
	}
}

class ComportementEpee implements ComportementArme
{
	public void utiliserArme()
	{
		System.out.print("ne m'oblige pas à sortir ma grosse épée.");
	}
}

class ComportementPoignard implements ComportementArme
{
	public void utiliserArme()
	{
		System.out.print("jte backstabb");
	}
}

abstract class Personnage
{
	protected ComportementArme cptArm_;

	public void setArme(ComportementArme cptArm)
	{
		cptArm_ = cptArm;
	}
	public void combattre(){};
}

class Chevalier extends Personnage
{
	public Chevalier(ComportementArme cptArm)
	{
		cptArm_ = cptArm;
	}

	public void combattre()
	{
		System.out.print("Je suis un chevalier et ");
		cptArm_.utiliserArme();
		System.out.println();
	}
}

class MarcheurBlanc extends Personnage
{
	public MarcheurBlanc(ComportementArme cptArm)
	{
		cptArm_ = cptArm;
	}

	public void combattre()
	{
		System.out.print("Je suis un MarcheurBlanc et ");
		cptArm_.utiliserArme();
		System.out.println();
	}
}

class Reine extends Personnage
{
	public Reine(ComportementArme cptArm)
	{
		cptArm_ = cptArm;
	}

	public void combattre()
	{
		System.out.print("Je suis une Reine et ");
		cptArm_.utiliserArme();
		System.out.println();
	}
}

class Roi extends Personnage
{
	public Roi(ComportementArme cptArm)
	{
		cptArm_ = cptArm;
	}

	public void combattre()
	{
		System.out.print("Je suis un Roi et ");
		cptArm_.utiliserArme();
		System.out.println();
	}
}


class Main
{
	public static void main (String[] args)
	{	
		ComportementArme cptPoign = new ComportementPoignard();
		ComportementArme cptEpee = new ComportementEpee();
		ComportementArme cptHache = new ComportementHache();
		ComportementArme cptArc = new ComportementArc();

		Personnage chevalier = new Chevalier(cptEpee);
		Personnage roi = new Roi(cptHache);
		Personnage reine = new Reine(cptPoign);
		Personnage marcheurBlanc = new MarcheurBlanc(cptArc);

		chevalier.combattre();
		roi.combattre();
		reine.combattre();
		marcheurBlanc.combattre();

		System.out.println("/***SCRAMBLE****/");

		chevalier.setArme(cptPoign);
		roi.setArme(cptArc);
		reine.setArme(cptHache);
		marcheurBlanc.setArme(cptEpee);

		chevalier.combattre();
		roi.combattre();
		reine.combattre();
		marcheurBlanc.combattre();


	}
}
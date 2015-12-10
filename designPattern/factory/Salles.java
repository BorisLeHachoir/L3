abstract class Prof
{
	protected String _desc;

	public void getDesc()
	{
		System.out.print(_desc);
	}
}

class ProfMath extends Prof
{
	public ProfMath()
	{
		_desc = "Prof de math";
	}
}

class Profinfo extends Prof
{
	public Profinfo()
	{
		_desc = "Prof de info";
	}
}

class ProfChimie extends Prof
{
	public ProfChimie()
	{
		_desc = "Prof de Chimie";
	}
}

abstract class Salle
{
	protected String _desc;

	public void getDesc()
	{
		System.out.print(_desc);
	}
}

class SalleMath extends Salle
{
	public SalleMath()
	{
		_desc = "Salle de math";
	}
}

class Salleinfo extends Salle
{
	public Salleinfo()
	{
		_desc = "Salle de info";
	}
}

class SalleChimie extends Salle
{
	public SalleChimie()
	{
		_desc = "Salle de Chimie";
	}
}

abstract class Cours
{
	protected Salle _salle;
	protected Prof _prof;

	public void afficheCours()
	{
		_salle.getDesc();
		_prof.getDesc();
		System.out.println();
	}
}

class CoursInfo extends Cours
{
	public CoursInfo()
	{
		_salle = new Salleinfo();
		_prof = new Profinfo();
	}
}

class CoursMath extends Cours
{
	public CoursMath()
	{
		_salle = new SalleMath();
		_prof = new ProfMath();
	}
}

class CoursChimie extends Cours
{
	public CoursChimie()
	{
		_salle = new SalleChimie();
		_prof = new ProfChimie();
	}
}

class edt
{
	private Cours cours;
	public edt()
}

class Main
{
	public static void main (String[] args)
	{
		Cours info = new CoursInfo();
		info.afficheCours();
	}
}
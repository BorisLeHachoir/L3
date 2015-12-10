abstract class Boisson
{
	protected String _description;
	protected double _cout;

	public Boisson(String desc, double c)
	{
		_description = desc;
		_cout = c;
	}

	public String getDescription()
	{
		return _description;
	} 

	public double cout()
	{
		return _cout;
	}
}

class Columbia extends Boisson
{
	public Columbia()
	{
		super("Un cafe Columbia", 1.50);
	}
}

class Expresso extends Boisson
{
	public Expresso()
	{
		super("Un cafe Expresso", 1.25);
	}
}

class Decorator extends Boisson
{
	protected Boisson _cafe;

	public Decorator(String desc, double c, Boisson cafe)
	{
		super(desc, c);
		_cafe = cafe;
	}

	public String getDescription()
	{
		return _cafe.getDescription() + _description;
	} 

	public double cout()
	{
		return _cout + _cafe.cout();
	}
}

class Lait extends Decorator
{
	public Lait(Boisson cafe)
	{
		super(" + supplement lait", 0.25, cafe);
	}
}

class Caramel extends Decorator
{
	public Caramel(Boisson cafe)
	{
		super(" + supplement caramel", 0.75, cafe);
	}
}

class Chantilly extends Decorator
{
	public Chantilly(Boisson cafe)
	{
		super(" + supplement Chantilly", 1.25, cafe);
	}
}

class Main
{
	public static void main (String[] args)
	{
		Boisson b = new Columbia();
		b = new Caramel(b);
		System.out.println(b.getDescription() + ":" + b.cout());
		
		Boisson c = new Expresso();
		c = new Caramel(c);
		c = new Chantilly(c);
		c = new Chantilly(c);
		c = new Chantilly(c);
		c = new Lait(c);
		System.out.println(c.getDescription() + ":" + c.cout());
	}
}
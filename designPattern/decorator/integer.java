import java.lang.Integer;

abstract class AbsInteger 
{
	abstract int getEntier();
	abstract void base();
} 

class Entier extends AbsInteger
{
	protected int _theInteger;

	public Entier(int i)
	{
		_theInteger = i;
	}

	public int getEntier()
	{
		return _theInteger;
	}

	public void base()
	{
		System.out.println("Base 10: " + _theInteger);
	}
}

abstract class Decorator extends AbsInteger
{
	protected AbsInteger _integer;

	public Decorator(AbsInteger i)
	{
		_integer = i;
	}

	public int getEntier()
	{
		return _integer.getEntier();
	}
}

class Binaire extends Decorator
{
	public Binaire(AbsInteger i)
	{
		super(i);
	}

	public void base()
	{
		System.out.println("Base 2: " + Integer.toBinaryString(_integer.getEntier()));
		_integer.base();
	}
}

class Hexa extends Decorator
{
	public Hexa(AbsInteger i)
	{
		super(i);
	}

	public void base()
	{
		System.out.println("Base 16: " + Integer.toHexString(_integer.getEntier()));
		_integer.base();
	}
}

class Main
{
	public static void main (String[] args)
	{
		AbsInteger e = new Entier(42);
		e = new Binaire(e);
		e = new Hexa(e);
		e.base();
	}
}

abstract class Bouton
{
	String _couleur;
	double _width;
	double _lenght;

	public String toString()
	{
		return _couleur + _width + _lenght;
	}
}

class BoutonWindows extends Bouton
{
	public BoutonWindows()
	{
		_couleur = "bleu";
		_width = 20;
		_lenght = 20;
	}
}

class BoutonLinux extends Bouton
{
	public BoutonLinux()
	{
		_couleur = "noir";
		_width = 35;
		_lenght = 35;
	}
}

/*MENU*/

abstract class Menu
{
	double _width;

	public String toString()
	{
		return String.valueOf(_width);
	}
}

class MenuWindows extends Menu
{
	public MenuWindows()
	{
		_width = 20;
	}
}

class MenuLinux extends Menu
{
	public MenuLinux()
	{
		_width = 35;
	}
}

/* FACTORY */
interface FactoryIG
{
	public Bouton createBouton();
	public Menu createMenu();
}

class FactIGWindows implements FactoryIG
{
	public Bouton createBouton()
	{
		return new BoutonWindows();
	}
	public Menu createMenu()
	{
		return new MenuWindows();
	}
}

class FactIGLinux implements FactoryIG
{
	public Bouton createBouton()
	{
		return new BoutonLinux();
	}
	public Menu createMenu()
	{
		return new MenuLinux();
	}
}


/*INTERFACE GRAPH*/
abstract class InterfaceGraphique
{
	protected FactoryIG ig;
	protected Menu menu;
	protected Bouton bouton;

	public InterfaceGraphique(FactoryIG f)
	{
		ig = f;
		menu = ig.createMenu();
		bouton = ig.createBouton();
	}

	public void draw()
	{
		System.out.println("Menu: " + menu + "\nBouton: " + bouton);
	}
}

class IGWindows extends InterfaceGraphique
{
	public IGWindows()
	{
		super(new FactIGWindows());
	}
}

class IGLinux extends InterfaceGraphique
{
	public IGLinux()
	{
		super(new FactIGLinux());
	}
}

class Main
{
	public static void main (String[] args)
	{
		InterfaceGraphique win = new IGWindows();
		InterfaceGraphique lin = new IGLinux();
		win.draw();
		lin.draw();
	}
}

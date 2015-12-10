interface MessageFactory
{
	public String genererMessage();
}

class MessageVisa implements MessageFactory
{
	public String genererMessage()
	{
		return "Votre carte Visa, assurance 1";
	}
}

class MessageMasterCard implements MessageFactory
{
	public String genererMessage()
	{
		return "Votre carte MasterCard, assurance 2";
	}
}

interface Carte 
{
	public String getMessage();
}

class CarteVisa implements Carte
{
	private MessageFactory mf;
	public CarteVisa()
	{
		mf = new MessageVisa();
	}
	public String getMessage()
	{
		return mf.genererMessage();
	}
}

class CarteMasterCard implements Carte
{
	private MessageFactory mf;
	public CarteMasterCard()
	{
		mf = new MessageMasterCard();
	}
	public String getMessage()
	{
		return mf.genererMessage();
	}
}

class Lettre
{
	private String _message;
	private Carte _carte;

	public Lettre(Carte carte)
	{
		_carte = carte;
		_message = carte.getMessage();
	}

	public void afficherLettre()
	{
		System.out.println(_message);
	}
}

class Main
{
	public static void main (String[] args)
	{
		Carte visa = new CarteVisa();
		Carte mastercard = new CarteMasterCard();
		Lettre l1 = new Lettre(visa);
		Lettre l2 = new Lettre(mastercard);
		l1.afficherLettre();
		l2.afficherLettre();
	}
}
class Cryptage 
{
	private String a_crypter_;
	private TypeCrypt crypt_;

	public Cryptage(String a_crypter,TypeCrypt crypt)
	{
		a_crypter_ = a_crypter;
		crypt_ = crypt;
	}

	public void setCryptage(TypeCrypt crypt)
	{
		crypt_ = crypt;		
	}

	public void afficher()
	{
		System.out.println(crypt_.crypter(a_crypter_));
	}
}
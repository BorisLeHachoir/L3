class Main
{
	public static void main (String[] args)
	{	

		CryptMD5 cryptMD5 = new CryptMD5();
		CryptSHA256 cryptSHA256 = new CryptSHA256();
		CryptSHA512 cryptSHA512 = new CryptSHA512();

		String a_crypter = "Shlag";
		Cryptage cryptage = new Cryptage(a_crypter, cryptMD5);

		System.out.println("Mot de base: "+a_crypter);
		System.out.print("Cryptage MD5: ");
		cryptage.afficher();
		cryptage.setCryptage(cryptSHA256);
		System.out.print("Cryptage SHA256: ");
		cryptage.afficher();
		cryptage.setCryptage(cryptSHA512);
		System.out.print("Cryptage SHA512: ");
		cryptage.afficher();
	}
}
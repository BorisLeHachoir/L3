#include <iostream>
#include <string>
#include <math.h>
using namespace std;

string base_converter(string nb, int baseIn, int baseOut)
{
	/* Passage du nombre d'entrée en base 10 */

	int baseDix =0;
	for (int i=0, j=nb.size()-1; i<nb.size(); ++i, --j)
	{
		//On vérifie si c'est une lettre ou un chiffre
		if(nb.at(i) >=  97 && nb.at(i) < 123)
			baseDix += (nb.at(i)-87)*pow(baseIn,j);

		else if(nb.at(i) >= 48 && nb.at(i) <58)
			baseDix += (nb.at(i)-48)*pow(baseIn,j);
		else
			cerr << "Error base_converter()" << endl;
	}

	/* Passage de la base 10 à la base de sortie */
	string resultat = "";
	int mod;
	while (baseDix)
	{
		mod = baseDix%baseOut;
		if (baseDix<baseOut)
		{
			if (mod>9)
				resultat = (char)(mod+87) + resultat;
			else
				resultat = to_string(baseDix) + resultat;
			break;
		}		
		baseDix = baseDix/baseOut;
		if (mod>9)
			resultat = (char)(mod+87) + resultat;
		else
			resultat = (char)(mod+48) + resultat;
	}

	return resultat;
}

int main()
{
	string nb;
	int baseIn, baseOut;
	cout << "Donnez un nombre, puis sa base d'entrée et sa base d'arivée\n";
	cin >> nb;
	cin >> baseIn;
	cin >> baseOut;
	cout << "base_converter(" << nb << "," << baseIn << "," << baseOut << ")=" << base_converter(nb, baseIn, baseOut) << endl;

	return 0;
} 

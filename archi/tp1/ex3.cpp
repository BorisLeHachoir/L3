#include <iostream>
#include <algorithm>
#include <iterator>
#include <vector>
#include "donnees_somme.h"

using namespace std;

bool croissant(double a, double b){  return a < b;}
bool decroissant(double a, double b){  return a > b;}

double some_recursive(const double t[],int size)
{
	double res;
	for (int i=0;i<size;++i)
		res+=t[i];
	return res;
}


double somme_croissante(const vector <double>& t)
{
	double res;
	sort(t.begin(), t.end(), croissant);
	//copy(t.begin(), t.end(), ostream_iterator<double>(cout, " "));
	cout << endl;
	for (int i=0;i<t.size();++i)
		res+=t[i];
	return res;
}

double somme_decroissante(const vector <double>& t,int size)
{
		double res;
	return res;
}


int main()
{
vector <double> Tvec= 
  { 9007199254740992.0, 999999999999.9, -999999999998.9, 3.56, 12.8766, 
    0.0123, 999394.4453, 1265356.434536, 23.53, 7889.123, 0.00002145, 0.5, 
    0.06456, 1254534536.4574, -1254534536.4575, -9007199254740992.0, 
    -999999999999.9, 999999999998.9, -3.56, -12.8766, -0.0123, 
    -999394.4453, -1265356.434536, -23.53, -7889.123, -0.00002145, 
    -0.5, -0.06456, -1254534536.4574, 1254534536.4575, 2.6 };

	vector<double> Tc(Tvec);
	vector<double> Td(Tvec);

	cout << "some_recursive: " << some_recursive(T,(sizeof(T)/sizeof(double))) << endl;
	cout << "some_croissante: " << somme_croissante(Tc);
	return 0;
}

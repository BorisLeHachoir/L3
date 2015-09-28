#include <iostream>
#include <vector>
using namespace std;

void DisplayTab(const vector<bool>& v)
{
	for (int i=0; i<v.size(); ++i)
		cout << v[i];
	cout << "\n";
}


//Binaire non signé -> CodeDeGray
vector<bool> bin2brgc(const vector<bool>& v)
{
	vector<bool> res = v;	
	int i,j;
	res[0] = v[0];
	for(i=0, j=1; j<v.size(); ++i,++j)
		res[j] = !(v[j]&&v[i]);
	return res;
}

//CodeDeGray -> Binaire non signé
vector<bool> brcg2bin(const vector<bool>& v)
{
	vector<bool> res = v;
	int i,j;
	res[0] = v[0];
	for(i=1, j=0; i<v.size(); ++i,++j)
		res[i] = !(res[j]&&v[i]);
	return res;
}

int main()
{
	vector <bool> bin =  {1,0,1,1};

	DisplayTab(bin);
	bin = bin2brgc(bin);
	DisplayTab(bin);
	bin = brcg2bin(bin);
	DisplayTab(bin);
	return 0;
} 

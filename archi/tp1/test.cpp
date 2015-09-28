#include <iostream>

void f1(char *c)
{
  std::cout<<"size of c in f1: "<<sizeof(c)<<std::endl;
}

void f2(char c[])
{
  std::cout<<"size of c in f2: "<<sizeof(c)<<std::endl;
}

void f3(char c[32])
{
  std::cout<<"size of c in f3: "<<sizeof(c)<<std::endl;
}

int main()
{
  char c[10];
  std::cout<<"size of c[10]: "<<sizeof(c)<<std::endl;
  f1(c);
  f2(c);
  f3(c);

  return 0;
}
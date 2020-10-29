#include <iostream>


int main()
{
    double a = 123456789;
    double b = 123456788;
    double d = 123456788;
    double e = 123456787;
    double c = a - b;
    double k = d - e;
    std::cout << c << std::endl << k << std::endl;
    return 0;
}

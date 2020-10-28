#include <iostream> 

int main()
{
    int x = 13;
    int y = 2;

    asm(
    "sar %[_x]\n"
    "inc %[_x]\n"
    :[_x]"+r"(x)
    :
    :"cc"
    );

    std::cout << x << std::endl;
    return 0;
}

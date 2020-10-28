#include <iostream>

int main()
{
    unsigned int a = 4294967295;
    unsigned int b = 1;
    unsigned int c;
    asm goto(
        "add %[x1],%[x2]\n"
	::[x2]"rm"(a),[x1]"r"(b)
	:"cc"
	:carry
        );
   
  
    asm goto(
        "jc %l0"
        ::
	: "cc"
	: carry
	);

    std::cout << c << "\t Answer is right"<< std::endl;
    return 0;

    carry:
    std::cout << c << "\t Answer is incorrect"<< std::endl;	
   
    return 0;
}

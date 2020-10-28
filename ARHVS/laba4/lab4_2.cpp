#include <iostream> 

int main()
{
    int x = 13;
    int y;

    asm(
    "mov    -0x8(%rbp),%eax\n"
    "mov    %eax,%edx\n"
    "shr    $0x1f,%edx\n"
    "add    %edx,%eax\n"
    "sar    %eax\n"
    "add    $0x1,%eax\n"
    "mov    %eax,-0x4(%rbp)\n"
           );

    std::cout << y << std::endl;
    return 0;
}

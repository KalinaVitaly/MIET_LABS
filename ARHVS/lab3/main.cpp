#include <iostream> //подключаем функцию вывода текста на экран cout

int main()
{
   //long long a,b;
    int x = 6;
    int y;
    //
    int z = 1 + x / 2;
    //

    asm(
    "mov    -0x8(%rbp),%eax\n"
    "mov    %eax,%edx\n"
    "shr    $0x1f,%edx\n"
    "add    %edx,%eax\n"
    "sar    %eax\n"
    "add    $0x1,%eax\n"
    "mov    %eax,-0x4(%rbp)\n"
           );

    std::cout << y;
}

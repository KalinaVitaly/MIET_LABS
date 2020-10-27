#include <iostream> //подключаем функцию вывода текста на экран cout

extern "C" void inpute();
void inpute()
{
    int inp1, inp2;
    std::cin >> inp1 >> inp2;
    std::cout << "first input: " << inp1 << std::endl << "second input: " << inp2 << std::endl;
}

int main()
{
//begin first problem
    long long a,b;
    int x = 6;
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
//end first problem

//begin second problem
    asm(
    "callq inpute\n"
          );
}

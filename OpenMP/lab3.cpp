#include <iostream>
#include <omp.h>

using namespace std;

const int N = 100;

int main()
{
	int arr[N];
	int sum = 0;

	for(int i = 0; i < N; ++i)
	{
		arr[N] = i;
		sum += i;
	}

	std::cout << "Result: " << sum << std::endl;

	int par_sum = 0;

#pragma omp parallel for
{
	for(int i = 0; i < N; ++i)
   	{
		par_sum += arr[i];
    	}
}
	
	std::cout << "Result par sum: " << par_sum << std::endl;
	return 0;	
}

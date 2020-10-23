#include <iostream>
#include <stdio.h>
#include <omp.h>
#include <cstdlib>

void InitializationArray(int *arr);
unsigned long long int CompositionFunction(int *A, int *B, bool is_parallel = true);
int MAX(int a, int b);

const size_t N = 1000;

int main (void)
{
    int *A = new int[N];
    int *B = new int[N];
    unsigned long long int composition;
    double time_begin;
    double time_end;
	
#ifdef _OPENMP
    printf ("parallel region, thread=%d\n", omp_get_thread_num());
    
    InitializationArray(A);
    InitializationArray(B);
    
    time_begin = omp_get_wtime();	
    composition = CompositionFunction(A, B, false);
    time_end = omp_get_wtime();	
    std::cout << "Composition: " << composition << " Time: " << time_end * 100000  - time_begin * 100000  <<  std::endl; 

#else
    printf ("parallel region, thread=main\n");
#endif
    delete[] A;
    delete[] B;
    return 0;
}

void InitializationArray(int *arr)
{
    size_t i;
#pragma omp parallel for shared(arr) private(i)
    for(i = 0; i < N; ++i)
    {
         arr[i] = rand() % 5;
    }
}

unsigned long long int CompositionFunction(int *A, int *B, bool is_parallel)
{
    unsigned long long int composition = 1;
    size_t i;
    int result; 

#pragma omp parallel shared(A, B) if (is_parallel)
{
#pragma omp for private(i, result) reduction(+:composition)
    for(i = 0; i < N; ++i)
    {
         if((result = MAX(A[i] + B[i], 4 * A[i] - B[i])) > 1)
         {
             composition = composition + result;
         }
    }
}
	
    return composition;
}

int MAX(int a, int b)
{
    return a > b ? a : b;
}


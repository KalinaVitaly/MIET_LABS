#include <iostream>
#include <stdio.h>
#include <omp.h>
#include <cstdlib>

void InitializationArray(int *arr);
unsigned long long int CompositionFunction(int *A, int *B, bool is_parallel = true);
int MAX(int a, int b);

const size_t N = 100000;

int main (void)
{
    int *A = new int[N];
    int *B = new int[N];
    unsigned long long int composition;
    double time_begin;
    double time_end;
	
#ifdef _OPENMP
    printf ("parallel region\n");
    time_begin = omp_get_wtime();
    InitializationArray(A);
    InitializationArray(B);    
    composition = CompositionFunction(A, B, true);
    time_end = omp_get_wtime();	
    std::cout << "Lock:\t"  << composition << " Time: " << time_end * 100000  - time_begin * 100000  <<  std::endl; 
    
    time_begin = omp_get_wtime();
#pragma omp parallel
{
    InitializationArray(A);
    InitializationArray(B);

#pragma omp barrier
    composition = CompositionFunction(A, B, true);
}
    time_end = omp_get_wtime();
    std::cout << "Barrier:\t"  << composition << " Time: " << time_end * 100000  - time_begin * 100000  <<  std::endl;
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
#pragma omp parallel for private(i)
    for(i = 0; i < N; ++i)
    {
         arr[i] = rand() % 5;
    }
}

unsigned long long int CompositionFunction(int *A, int *B, bool is_parallel)
{
    omp_lock_t lock;
    omp_init_lock(&lock);
    unsigned long long int composition = 1;
    size_t i;
    int result; 

#pragma omp parallel shared(A, B) if (is_parallel)
{
#pragma omp for private(result, i) reduction(+:composition)
    for(i = 0; i < N; ++i)
    {
         omp_set_lock(&lock);
         if((result = MAX(A[i] + B[i], 4 * A[i] - B[i])) > 1)
         {
             composition = composition + result;
         }
         omp_unset_lock(&lock);
    }
}	
    omp_destroy_lock(&lock);
    return composition;
}

int MAX(int a, int b)
{
    return a > b ? a : b;
}


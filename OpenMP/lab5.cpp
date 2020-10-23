#include <iostream>
#include <stdio.h>
#include <omp.h>
#include <cstdlib>

void InitializationArray(int *arr, int N, bool is_sections);
unsigned long long int CompositionFunction(int *A, int *B, int N, bool is_parallel = true);
int MAX(int a, int b);

int main (void)
{
    const size_t N = 100000;
    int *A = new int[N];
    int *B = new int[N];
    unsigned long long int composition = 0;
    double time_begin;
    double time_end;
    bool is_sections = true;

#ifdef _OPENMP
    printf ("parallel region, thread=%d\n", omp_get_thread_num());
    time_begin = omp_get_wtime();

    if (is_sections)
    {
    #pragma omp sections
    {
    #pragma omp section
        InitializationArray(A, N, is_sections);

    #pragma omp section
        InitializationArray(B, N, is_sections);
    }		
    }
    else
    {
        InitializationArray(A, N, is_sections);
        InitializationArray(B, N, is_sections);
    }
    
    if (is_sections)
    {
    #pragma omp sections
    {
    #pragma omp section
        composition += CompositionFunction(A, B, N / 2, is_sections);

    #pragma omp section
        composition += CompositionFunction(A + N / 2, B + N / 2, N / 2, is_sections);
    }
    }
    else
    {
        composition = CompositionFunction(A, B, N, is_sections);
    }

    time_end = omp_get_wtime();

    std::cout << "Composition: " << composition <<
	    " Time: " << time_end * 100000  - time_begin * 100000  <<  std::endl; 

#else
    printf ("parallel region, thread=main\n");
#endif
    delete[] A;
    delete[] B;
    return 0;
}

void InitializationArray(int *arr, int N, bool is_sections)
{
    size_t i;
#pragma omp parallel for private(i) if (!is_sections)
    for(i = 0; i < N; ++i)
    {
         arr[i] = rand() % 5;
    }
}

unsigned long long int CompositionFunction(int *A, int *B, int N, bool is_parallel)
{
    unsigned long long int composition = 0;
    size_t i;
    int result;

#pragma omp parallel shared(A, B) if (is_parallel)
{
#pragma omp for private(i, result) reduction(+:composition)
    for(i = 0; i < N; ++i)
    {
        if((result = MAX(A[i], B[i])) > 1)
        {
            composition = composition + result;
        }
    }
}
	
    return composition;
}

int MAX(int a, int b)
{
    int result1 = a + b;
    int result2 = 4 * a + b;
	
    return result1 > result2 ? result1 : result2;
}

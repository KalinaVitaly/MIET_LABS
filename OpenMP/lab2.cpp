#include <omp.h>
#include <stdio.h>

const int NMAX=1000;
const int LIMIT=110;

int main ()
{
	int i, j;
	float sum;
	float a[NMAX][NMAX];
	double t_start, t_end;

	for (i=0; i < NMAX; i++)
		for (j=0; j < NMAX; j++)
			a[i][j] = i+j;
	t_start = omp_get_wtime();
#pragma omp parallel shared(a) if (NMAX>LIMIT)
{
#pragma omp for private(i,j,sum)
	for (i=0; i < NMAX; i++)
	{
		sum = 0;
 		for (j=0; j < NMAX; j++)
 			sum += a[i][j];
/* 		printf ("Сумма элементов строки %d равна %f\n",i,sum);*/
	}
} /* Завершение параллельного фрагмента */
	t_end = omp_get_wtime();
	printf("Program run %lf\n", t_end - t_start);
	return 0;
}

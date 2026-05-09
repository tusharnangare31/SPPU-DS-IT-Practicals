#include <stdio.h>
#include <omp.h>

int main() {

    int n, i, sum = 0;

    printf("Enter number of elements: ");

    scanf("%d", &n);

    int arr[n];

    printf("Enter array elements:\n");

    for(i = 0; i < n; i++) {

        scanf("%d", &arr[i]);
    }

    #pragma omp parallel
    {
        int local_sum = 0;

        int thread_id = omp_get_thread_num();

        int total_threads = omp_get_num_threads();

        int start = thread_id * n / total_threads;

        int end = (thread_id + 1) * n / total_threads;

        for(i = start; i < end; i++) {

            local_sum += arr[i];
        }

        printf("Thread %d calculated partial sum = %d\n",
                thread_id, local_sum);

        #pragma omp critical
        {
            sum += local_sum;
        }
    }

    printf("\nFinal Sum = %d\n", sum);

    return 0;
}
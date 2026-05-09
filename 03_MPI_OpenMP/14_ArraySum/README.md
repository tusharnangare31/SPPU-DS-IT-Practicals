# Develop a Distributed System to Find Sum of N Elements in an Array using MPI/OpenMP

---

# AIM

To develop a distributed system to find sum of N elements in an array by distributing N/n elements to n number of processors using MPI/OpenMP and display intermediate sums calculated at different processors.

---

# OBJECTIVE

- To understand parallel and distributed computing.
- To implement array sum using OpenMP.
- To distribute array elements among processors.
- To calculate intermediate sums using multiple threads.

---

# THEORY

Parallel processing divides a task into multiple smaller tasks and executes them simultaneously using multiple processors or threads.

OpenMP (Open Multi-Processing) is an API used for shared memory multiprocessing programming in C/C++.

In this practical:
- Array elements are divided among threads.
- Each thread calculates partial sum.
- Partial sums are combined to produce final sum.

Advantages:
- Faster computation
- Efficient processor utilization
- Reduced execution time

---

# SOFTWARE REQUIREMENTS

- GCC Compiler with OpenMP Support
- Linux / Ubuntu
- Terminal

---

# HARDWARE REQUIREMENTS

- Minimum 4 GB RAM
- Multi-Core Processor

---

# ALGORITHM

1. Read number of elements.
2. Store array elements.
3. Divide array among threads.
4. Each thread calculates partial sum.
5. Display intermediate sums.
6. Combine all partial sums.
7. Display final sum.

---

# PROGRAM CODE

## ArraySum.c

```c
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

    omp_set_num_threads(4);

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
```

---

# COMPILATION

```bash
gcc -fopenmp ArraySum.c -o ArraySum
```

---

# EXECUTION

```bash
./ArraySum
```

---

# SAMPLE OUTPUT

```text
Enter number of elements: 6

Enter array elements:
1 2 3 4 5 6

Thread 0 calculated partial sum = 3
Thread 1 calculated partial sum = 7
Thread 2 calculated partial sum = 5
Thread 3 calculated partial sum = 6

Final Sum = 21
```

---

# ADVANTAGES

- Faster execution
- Efficient CPU utilization
- Supports parallel computing
- Reduces computation time

---

# DISADVANTAGES

- Synchronization overhead
- Complex debugging
- Requires multi-core processor

---

# APPLICATIONS

- Scientific Computing
- Parallel Processing
- Data Analysis
- High Performance Computing
- Distributed Systems

---

# RESULT

The distributed system to find sum of array elements using OpenMP was successfully implemented and executed.

---

# CONCLUSION

The OpenMP program successfully demonstrated distributed computation by dividing array elements among processors and calculating intermediate sums in parallel.

---

# VIVA QUESTIONS

## 1. What is OpenMP?

OpenMP is an API for parallel programming in C/C++.

---

## 2. What is parallel processing?

Executing multiple tasks simultaneously.

---

## 3. What is a thread?

Smallest unit of execution in a process.

---

## 4. What is distributed computing?

Dividing computation among multiple processors/systems.

---

## 5. What is partial sum?

Intermediate sum calculated by a thread.

---

## 6. What does `#pragma omp parallel` do?

Creates parallel threads.

---

## 7. What is synchronization?

Coordinating multiple threads/processes.

---

## 8. What is critical section?

Section executed by one thread at a time.

---

## 9. Why use OpenMP?

To simplify parallel programming.

---

## 10. What is shared memory architecture?

Processors share common memory.

---

## 11. What is thread ID?

Unique identifier of thread.

---

## 12. What is processor utilization?

Efficient usage of CPU resources.

---

## 13. What is high performance computing?

Use of powerful systems for complex computation.

---

## 14. What is multi-core processor?

Processor containing multiple CPU cores.

---

## 15. What is the benefit of parallelism?

Improved speed and performance.
import java.util.Scanner;

public class ArraySum extends Thread {

    static int arr[];
    static int sum = 0;

    int start, end;
    int localSum = 0;

    ArraySum(int start, int end) {

        this.start = start;
        this.end = end;
    }

    public void run() {

        for(int i = start; i < end; i++) {

            localSum += arr[i];
        }

        System.out.println(Thread.currentThread().getName() +
                " calculated partial sum = " + localSum);

        synchronized(ArraySum.class) {

            sum += localSum;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");

        int n = sc.nextInt();

        arr = new int[n];

        System.out.println("Enter array elements:");

        for(int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }

        int numThreads = 4;

        ArraySum threads[] = new ArraySum[numThreads];

        int part = n / numThreads;

        for(int i = 0; i < numThreads; i++) {

            int start = i * part;

            int end;

            if(i == numThreads - 1) {

                end = n;
            }
            else {

                end = start + part;
            }

            threads[i] = new ArraySum(start, end);

            threads[i].start();
        }

        for(int i = 0; i < numThreads; i++) {

            threads[i].join();
        }

        System.out.println("\nFinal Sum = " + sum);

        sc.close();
    }
}
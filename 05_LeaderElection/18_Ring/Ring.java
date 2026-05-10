import java.util.Scanner;

public class Ring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");

        int n = sc.nextInt();

        int process[] = new int[n];

        for(int i = 0; i < n; i++) {

            process[i] = i + 1;
        }

        int coordinator = n;

        System.out.println("\nProcesses are:");

        for(int i = 0; i < n; i++) {

            System.out.println("P" + process[i]);
        }

        System.out.println("\nCurrent Coordinator: P" + coordinator);

        System.out.print("\nEnter failed coordinator process: ");

        int failed = sc.nextInt();

        if(failed != coordinator) {

            System.out.println("\nCoordinator is alive. No election needed.");

            sc.close();

            return;
        }

        System.out.println("\nProcess P" + failed + " failed");

        System.out.print("\nEnter process initiating election: ");

        int initiator = sc.nextInt();

        int newCoordinator = -1;

        System.out.println("\nElection Message Passing:");

        int current = initiator - 1;

        for(int i = 0; i < n - 1; i++) {

            int next = (current + 1) % n;

            while(process[next] == failed) {

                next = (next + 1) % n;
            }

            if(process[current] != failed) {

                System.out.println("Message passed from P" +
                        process[current] + " to P" +
                        process[next]);

                if(process[next] > newCoordinator) {

                    newCoordinator = process[next];
                }
            }

            current = next;
        }

        System.out.println("\nProcess P" + newCoordinator +
                " becomes Coordinator");

        sc.close();
    }
}
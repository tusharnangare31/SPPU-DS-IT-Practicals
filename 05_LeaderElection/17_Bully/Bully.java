import java.util.Scanner;

public class Bully {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");

        int n = sc.nextInt();

        int processes[] = new int[n];

        for(int i = 0; i < n; i++) {

            processes[i] = i + 1;
        }

        int coordinator = n;

        System.out.println("\nProcesses are:");

        for(int i = 0; i < n; i++) {

            System.out.println("P" + processes[i]);
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

        System.out.println("\nElection Process:");

        for(int i = initiator; i < n; i++) {

            if(processes[i] != failed) {

                System.out.println("P" + initiator +
                        " sends Election message to P" +
                        processes[i]);
            }
        }

        for(int i = n - 1; i >= 0; i--) {

            if(processes[i] != failed) {

                coordinator = processes[i];

                break;
            }
        }

        System.out.println("\nProcess P" + coordinator +
                " becomes new Coordinator");

        sc.close();
    }
}
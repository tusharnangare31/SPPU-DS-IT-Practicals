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

        System.out.println("\nProcesses are:");

        for(int i = 0; i < n; i++) {

            System.out.println("P" + process[i]);
        }

        System.out.print("\nEnter process initiating election: ");

        int initiator = sc.nextInt();

        System.out.println("\nElection Message Passing:");

        int coordinator = initiator;

        for(int i = 0; i < n; i++) {

            int next = (initiator + i - 1) % n;

            System.out.println("Message passed from P" +
                    process[next] + " to P" +
                    process[(next + 1) % n]);

            if(process[(next + 1) % n] > coordinator) {

                coordinator = process[(next + 1) % n];
            }
        }

        System.out.println("\nProcess P" + coordinator +
                " becomes Coordinator");

        sc.close();
    }
}
import java.util.Scanner;

public class TokenRing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of processes : ");

		int n = sc.nextInt();
		int token = 0;

		while (true) {
			System.out.println("\nToken is with Process P" + (token + 1));

			System.out.print("Enter process number requesting critical section (1 to " + n + ", 0 to exit): ");

			int request = sc.nextInt();

			if (request == 0) {
				System.out.println("Program terminated.");
				break;
			}

			request = request - 1;

			while (token != request) {
				System.out.println("Passing token from P" + (token + 1) + " to P" + ((token + 1) % n + 1));

				token = (token + 1) % n;
			}

			System.out.println("Process P" + (token + 1) + " entered Critical Section");

			System.out.println("Process P" + (token + 1) + " exited Critical Section");

			token = (token + 1) % n;
		}
	}
}
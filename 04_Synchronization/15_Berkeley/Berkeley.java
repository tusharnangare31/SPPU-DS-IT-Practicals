import java.util.*;

public class Berkeley {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int sum = 0;
        System.out.print("Enter Number of Clocks: ");
        n = sc.nextInt();
        int clock[] = new int[n];
        System.out.println("Enter Clock Times:");
        for(int i = 0; i < n; i++) {
            clock[i] = sc.nextInt();
            sum = sum + clock[i];
        }
        int avg = sum / n;
        System.out.println("\nAverage Clock Time: " + avg);
        System.out.println("\nClock Synchronization:");
        for(int i = 0; i < n; i++) {
            int adjustment = avg - clock[i];
            System.out.println("Clock " + (i + 1) +
                    " Adjustment: " + adjustment);
        }
        System.out.println("\nSynchronized Clock Times:");
        for(int i = 0; i < n; i++) {
            clock[i] = avg;
            System.out.println("Clock " + (i + 1) +
                    " Time: " + clock[i]);
        }
        sc.close();
    }
}
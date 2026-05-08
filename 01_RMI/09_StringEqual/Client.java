import java.rmi.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String serverURL = "rmi://localhost/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
            System.out.print("Enter First String: ");
            String s1 = sc.nextLine();
            System.out.print("Enter Second String: ");
            String s2 = sc.nextLine();
            System.out.println("First String is " + s1);
            System.out.println("Second String is " + s2);

            System.out.println("Strings are equal: " + serverIntf.checkEqual(s1, s2));
        } catch (Exception e) {
            System.out.println("Exception Occurred At Client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
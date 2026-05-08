import java.rmi.*;
import java.util.*;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String serverURL = "rmi://localhost/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
            System.out.print("Enter First Number: ");
            double num1 = sc.nextDouble();
            System.out.print("Enter Second Number: ");
            double num2 = sc.nextDouble();
            System.out.println("First Number is " + num1);
            System.out.println("Second Number is " + num2);
            System.out.println("Addition: " + serverIntf.add(num1, num2));
        } catch (Exception e) {
            System.out.println("Exception Occurred At Client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
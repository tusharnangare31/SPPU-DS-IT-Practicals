import java.rmi.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String serverURL = "rmi://localhost/Server";
            ServerIntf serverIntf = (ServerIntf) Naming.lookup(serverURL);
            System.out.print("Enter a Number: ");
            double num = sc.nextDouble();
            System.out.println("Number is " + num);
            System.out.println("Cube: " + serverIntf.cube(num));
        } catch (Exception e) {
            System.out.println("Exception Occurred At Client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
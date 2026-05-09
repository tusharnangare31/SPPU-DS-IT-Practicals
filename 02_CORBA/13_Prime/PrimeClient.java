import PrimeApp.*;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import java.util.Scanner;

public class PrimeClient{
    public static void main(String args[]){
        try{
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                NamingContextExtHelper.narrow(objRef);

            Prime obj =
                PrimeHelper.narrow(
                    ncRef.resolve_str("PrimeService"));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number: ");

            int num = sc.nextInt();

            System.out.println("Result: " +
                    obj.checkPrime(num));

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
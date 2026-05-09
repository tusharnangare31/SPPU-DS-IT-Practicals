import CalculatorApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextExtHelper;

import org.omg.CORBA.*;

import java.util.Scanner;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			// Initialize ORB
			ORB orb = ORB.init(args, null);

			// Get naming service
			org.omg.CORBA.Object objRef = 
				orb.resolve_initial_references("NameService");

			NamingContextExt ncRef = 
				NamingContextExtHelper.narrow(objRef);

			// Get calculator Reference
			Calculator calc = 
				CalculatorHelper.narrow(
					ncRef.resolve_str("Calculator"));

            		Scanner sc = new Scanner(System.in);

            		System.out.print("Enter first number: ");
            		float a = sc.nextFloat();

            		System.out.print("Enter second number: ");
            		float b = sc.nextFloat();

            		System.out.println("\nAddition = " +
                    		calc.add(a,b));

            		System.out.println("Subtraction = " +
                    		calc.sub(a,b));

            		System.out.println("Multiplication = " +
                    		calc.mul(a,b));

            		System.out.println("Division = " +
                    		calc.div(a,b));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
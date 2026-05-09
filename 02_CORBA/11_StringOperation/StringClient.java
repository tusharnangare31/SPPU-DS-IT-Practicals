import StringApp.*;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import java.util.Scanner;

public class StringClient {
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);

			org.omg.CORBA.Object objRef = 
				orb.resolve_initial_references("NameService");

			NamingContextExt ncRef = 
				NamingContextExtHelper.narrow(objRef);

			StringOperation strObj = 
				StringOperationHelper.narrow(
					ncRef.resolve_str("StringService"));

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter String : ");

			String input = sc.nextLine();

			System.out.println("Length = " + strObj.length(input));

			System.out.println("Reverse = " + strObj.reverse(input));

			System.out.println("Uppercase = " + strObj.toUpper(input));

			System.out.println("Lowercase = " + strObj.toLower(input));	
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
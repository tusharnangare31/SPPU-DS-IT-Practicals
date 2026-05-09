import StringApp.*;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class StringServer {
	public static void main(String[] args) {
		try {
			ORB orb = ORB.init(args, null);

			POA rootpoa = 
				POAHelper.narrow(
					orb.resolve_initial_references("RootPOA"));

			rootpoa.the_POAManager().activate();
		
			StringImpl strImpl = new StringImpl();

			strImpl.setORB(orb);

			org.omg.CORBA.Object ref = 
				rootpoa.servant_to_reference(strImpl);

			StringOperation href = 
				StringOperationHelper.narrow(ref);

			org.omg.CORBA.Object objRef = 
				orb.resolve_initial_references("NameService");

			NamingContextExt ncRef = 
				NamingContextExtHelper.narrow(objRef);

			NameComponent path[] = 
				ncRef.to_name("StringService");

			ncRef.rebind(path, href);

			System.out.println("String Server ready...");

			orb.run();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
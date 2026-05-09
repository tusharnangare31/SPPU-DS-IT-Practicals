# Develop a String Operation Distributed Application using CORBA to Demonstrate Object Brokering

---

# AIM

To develop a String Operation Distributed application using CORBA to demonstrate object brokering.

---

# OBJECTIVE

- To understand CORBA architecture.
- To implement distributed communication using CORBA.
- To perform string operations remotely using CORBA.
- To demonstrate object brokering between client and server.

---

# THEORY

CORBA (Common Object Request Broker Architecture) is a middleware technology used for communication between distributed objects.

CORBA enables:
- communication between client and server applications
- platform independent communication
- language independent distributed systems

In CORBA:
- Client invokes remote methods.
- ORB (Object Request Broker) manages communication.
- IDL (Interface Definition Language) defines interfaces.

This practical demonstrates:
- remote method invocation
- object brokering
- client-server communication

The server performs various string operations:
- String Length
- Reverse String
- Uppercase Conversion
- Lowercase Conversion

---

# SOFTWARE REQUIREMENTS

- Java JDK 8
- Ubuntu/Linux
- Terminal
- CORBA Support

---

# HARDWARE REQUIREMENTS

- Minimum 4 GB RAM
- Dual Core Processor

---

# PROGRAM FILES

| File Name | Description |
|------------|-------------|
| `StringOperation.idl` | Interface Definition Language file |
| `StringImpl.java` | CORBA implementation class |
| `StringServer.java` | Server program |
| `StringClient.java` | Client program |
| `StringApp/` | Auto-generated CORBA files |

---

# ALGORITHM

1. Define interface using IDL.
2. Generate CORBA files using `idlj`.
3. Implement server logic for string operations.
4. Start ORB daemon.
5. Register server object with naming service.
6. Client connects to naming service.
7. Client sends string to server.
8. Server performs operations.
9. Server returns result to client.
10. Display results.

---

# PROGRAM CODE

---

## 1. StringOperation.idl

```idl
module StringApp{
	interface StringOperation{
		long length(in string str);
		string reverse(in string str);
		string toUpper(in string str);
		string toLower(in string str);
	};
};
```

---

## 2. StringImpl.java

```java
import StringApp.*;
import org.omg.CORBA.*;

public class StringImpl extends StringOperationPOA{
	private ORB orb;

	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	@Override
	public int length(String str) {
		return str.length();
	}

	public String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public String toUpper(String str) {
		return str.toUpperCase();
	}

	public String toLower(String str) {
		return str.toLowerCase();
	}
}
```

---

## 3. StringServer.java

```java
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
```

---

## 4. StringClient.java

```java
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
```

---

# GENERATE CORBA FILES

```bash
idlj -fall StringOperation.idl
```

---

# COMPILATION

```bash
javac *.java StringApp/*.java
```

---

# EXECUTION

## Step 1: Start ORB Daemon

```bash
orbd -ORBInitialPort 1050&
```

---

## Step 2: Run Server

```bash
java StringServer -ORBInitialPort 1050
```

### Output

```text
String Server ready...
```

---

## Step 3: Run Client

Open another terminal.

```bash
java StringClient -ORBInitialPort 1050
```

---

# SAMPLE OUTPUT

```text
Enter String :
Hello

Length = 5
Reverse = olleH
Uppercase = HELLO
Lowercase = hello
```

---

# ADVANTAGES

- Platform independent
- Supports distributed systems
- Enables object brokering
- Simplifies remote communication

---

# DISADVANTAGES

- Complex configuration
- Slower than local execution
- Obsolete technology

---

# APPLICATIONS

- Distributed Systems
- Enterprise Applications
- Banking Systems
- Remote Services

---

# RESULT

The String Operation Distributed application using CORBA to demonstrate object brokering was successfully implemented and executed.

---

# CONCLUSION

The CORBA distributed application successfully demonstrated remote string operations and object brokering between client and server.

---

# VIVA QUESTIONS

## 1. What is CORBA?

CORBA stands for Common Object Request Broker Architecture.

---

## 2. What is ORB?

ORB stands for Object Request Broker.

---

## 3. What is IDL?

IDL stands for Interface Definition Language.

---

## 4. What is object brokering?

Communication between distributed objects through ORB.

---

## 5. What is the purpose of `idlj`?

To generate CORBA helper and stub files.

---

## 6. Why use `orb.run()`?

To keep server active and waiting for client requests.

---

## 7. What is Naming Service?

Service used to register and locate remote objects.

---

## 8. What is stub in CORBA?

Client-side proxy object.

---

## 9. What is skeleton in CORBA?

Server-side receiver object.

---

## 10. Which Java version supports CORBA?

Java 8.
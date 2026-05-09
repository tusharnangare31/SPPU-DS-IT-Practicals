# Develop a Calculator Distributed Application using CORBA to Demonstrate Object Brokering

---

# AIM

To develop a Calculator Distributed application using CORBA to demonstrate object brokering.

---

# OBJECTIVE

- To understand CORBA architecture.
- To implement distributed communication using CORBA.
- To perform arithmetic operations remotely using CORBA.
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

The server performs arithmetic operations:
- Addition
- Subtraction
- Multiplication
- Division

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
| `Calculator.idl` | Interface Definition Language file |
| `CalculatorImpl.java` | CORBA implementation class |
| `CalculatorServer.java` | Server program |
| `CalculatorClient.java` | Client program |
| `CalculatorApp/` | Auto-generated CORBA files |

---

# ALGORITHM

1. Define interface using IDL.
2. Generate CORBA files using `idlj`.
3. Implement server logic for arithmetic operations.
4. Start ORB daemon.
5. Register server object with naming service.
6. Client connects to naming service.
7. Client sends numbers to server.
8. Server performs operations.
9. Server returns result to client.
10. Display results.

---

# PROGRAM CODE

---

## 1. Calculator.idl

```idl
module CalculatorApp{
	interface Calculator{
		float add(in float a, in float b);
		float sub(in float a, in float b);
		float mul(in float a, in float b);
		float div(in float a, in float b);
	};
};
```

---

## 2. CalculatorImpl.java

```java
import CalculatorApp.*;
import org.omg.CORBA.*;

public class CalculatorImpl extends CalculatorPOA {
	private ORB orb;
	
	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

	public float add(float a, float b) {
		return a + b;
	}

	public float sub(float a, float b) {
        	return a - b;
    }

    	public float mul(float a, float b) {
        	return a * b;
    }

	public float div(float a, float b) {
		if (b == 0) {
			System.out.println("Division by 0 is not allowed");
			return 0;
		}

		return a / b;
	}
}
```

---

## 3. CalculatorServer.java

```java
import CalculatorApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class CalculatorServer {
	public static void main(String[] args) {
		try {
			// Initialize ORB
			ORB orb = ORB.init(args, null);

			// Get rootpoa
			POA rootpoa = 
				POAHelper.narrow(
					orb.resolve_initial_references("RootPOA"));

			rootpoa.the_POAManager().activate();

			// Create servant
			CalculatorImpl calcImpl = new CalculatorImpl();

			calcImpl.setORB(orb);

			// Get object reference
			org.omg.CORBA.Object ref = 
				rootpoa.servant_to_reference(calcImpl);

			Calculator href = 
				CalculatorHelper.narrow(ref);

			// Get naming context
			org.omg.CORBA.Object objRef = 
				orb.resolve_initial_references("NameService");

			NamingContextExt ncRef = 
				NamingContextExtHelper.narrow(objRef);

			// Bind object
			NameComponent path[] = 
				ncRef.to_name("Calculator");

			ncRef.rebind(path, href);

			System.out.println("Calculator Server ready....");

			// Wait for requests
			orb.run();
		} 
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
```

---

## 4. CalculatorClient.java

```java
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
```

---

# GENERATE CORBA FILES

```bash
idlj -fall Calculator.idl
```

---

# COMPILATION

```bash
javac *.java CalculatorApp/*.java
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
java CalculatorServer -ORBInitialPort 1050
```

### Output

```text
Calculator Server ready....
```

---

## Step 3: Run Client

Open another terminal.

```bash
java CalculatorClient -ORBInitialPort 1050
```

---

# SAMPLE OUTPUT

```text
Enter first number: 10
Enter second number: 5

Addition = 15.0
Subtraction = 5.0
Multiplication = 50.0
Division = 2.0
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

The Calculator Distributed application using CORBA to demonstrate object brokering was successfully implemented and executed.

---

# CONCLUSION

The CORBA distributed application successfully demonstrated remote arithmetic operations and object brokering between client and server.

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
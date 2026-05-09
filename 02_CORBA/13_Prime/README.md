# Develop a Distributed Application using CORBA to Check if the Given Number is Prime or Not

---

# AIM

To develop a distributed application using CORBA to check whether the given number is prime or not.

---

# OBJECTIVE

- To understand CORBA architecture.
- To implement distributed communication using CORBA.
- To develop client-server applications using object brokering.
- To check whether a number is prime or not using CORBA.

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

A prime number is a number greater than 1 that has only two factors:
- 1
- itself

Example:
- 2 → Prime
- 5 → Prime
- 9 → Not Prime

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
| `Prime.idl` | Interface Definition Language file |
| `PrimeImpl.java` | CORBA implementation class |
| `PrimeServer.java` | Server program |
| `PrimeClient.java` | Client program |
| `PrimeApp/` | Auto-generated CORBA files |

---

# ALGORITHM

1. Define interface using IDL.
2. Generate CORBA files using `idlj`.
3. Implement server logic.
4. Start ORB daemon.
5. Register server object with naming service.
6. Client connects to naming service.
7. Client sends number to server.
8. Server checks whether number is prime or not.
9. Server returns result to client.
10. Display result.

---

# PROGRAM CODE

---

## 1. Prime.idl

```idl
module PrimeApp{
interface Prime
{
	string checkPrime(in long num);
};
};
```

---

## 2. PrimeImpl.java

```java
import PrimeApp.*;
import org.omg.CORBA.*;

public class PrimeImpl extends PrimePOA{
    private ORB orb;

    public void setORB(ORB orb_val){
        orb = orb_val;
    }

    public String checkPrime(int num){
        if(num <= 1)
            return "Not Prime";

        for(int i = 2; i <= num/2; i++){
            if(num % i == 0)
                return "Not Prime";
        }

        return "Prime";
    }
}
```

---

## 3. PrimeServer.java

```java
import PrimeApp.*;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class PrimeServer{
    public static void main(String args[]){
        try{
            ORB orb = ORB.init(args, null);

            POA rootpoa =
                POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));

            rootpoa.the_POAManager().activate();

            PrimeImpl obj = new PrimeImpl();
            obj.setORB(orb);

            org.omg.CORBA.Object ref =
                rootpoa.servant_to_reference(obj);

            Prime href =
                PrimeHelper.narrow(ref);

            org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                NamingContextExtHelper.narrow(objRef);

            NameComponent path[] =
                ncRef.to_name("PrimeService");

            ncRef.rebind(path, href);

            System.out.println("Prime Server ready...");

            orb.run();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
```

---

## 4. PrimeClient.java

```java
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
```

---

# GENERATE CORBA FILES

```bash
idlj -fall Prime.idl
```

---

# COMPILATION

```bash
javac *.java PrimeApp/*.java
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
java PrimeServer -ORBInitialPort 1050
```

### Output

```text
Prime Server ready...
```

---

## Step 3: Run Client

Open another terminal.

```bash
java PrimeClient -ORBInitialPort 1050
```

---

# SAMPLE OUTPUT

```text
Enter number: 7
Result: Prime
```

```text
Enter number: 10
Result: Not Prime
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

The distributed application using CORBA to check whether the given number is prime or not was successfully implemented and executed.

---

# CONCLUSION

The CORBA distributed application successfully demonstrated object brokering and remote communication between client and server.

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
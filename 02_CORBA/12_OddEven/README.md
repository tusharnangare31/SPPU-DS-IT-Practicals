# Develop a Distributed Application using CORBA to Check Whether the Given Number is Odd or Even

---

# AIM

To develop a distributed application using CORBA to check whether the given number is odd or even.

---

# OBJECTIVE

- To understand CORBA architecture.
- To implement distributed communication using CORBA.
- To develop client-server applications using object brokering.
- To check whether a number is odd or even using CORBA.

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

The server checks whether the given number is:
- Even → divisible by 2
- Odd → not divisible by 2

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
| `OddEven.idl` | Interface Definition Language file |
| `OddEvenImpl.java` | CORBA implementation class |
| `OddEvenServer.java` | Server program |
| `OddEvenClient.java` | Client program |
| `OddEvenApp/` | Auto-generated CORBA files |

---

# ALGORITHM

1. Define interface using IDL.
2. Generate CORBA files using `idlj`.
3. Implement server logic.
4. Start ORB daemon.
5. Register server object with naming service.
6. Client connects to naming service.
7. Client sends number to server.
8. Server checks odd/even.
9. Server returns result to client.
10. Display result.

---

# PROGRAM CODE

---

## 1. OddEven.idl

```idl
module OddEvenApp{
interface OddEven
{
	string check(in long num);
};
};
```

---

## 2. OddEvenImpl.java

```java
import OddEvenApp.*;
import org.omg.CORBA.*;

public class OddEvenImpl extends OddEvenPOA{
    private ORB orb;

    public void setORB(ORB orb_val){
        orb = orb_val;
    }
    
    public String check(int num){
        if(num % 2 == 0)
            return "Even";
        else
            return "Odd";
    }
}
```

---

## 3. OddEvenServer.java

```java
import OddEvenApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class OddEvenServer{
    public static void main(String args[]){
        try{
            ORB orb = ORB.init(args, null);

            POA rootpoa =
                POAHelper.narrow(
                    orb.resolve_initial_references("RootPOA"));

            rootpoa.the_POAManager().activate();
            OddEvenImpl obj = new OddEvenImpl();
            obj.setORB(orb);

            org.omg.CORBA.Object ref =
                rootpoa.servant_to_reference(obj);

            OddEven href =
                OddEvenHelper.narrow(ref);

            org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                NamingContextExtHelper.narrow(objRef);

            NameComponent path[] =
                ncRef.to_name("OddEvenService");

            ncRef.rebind(path, href);

            System.out.println("OddEven Server ready...");

            orb.run();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
```

---

## 4. OddEvenClient.java

```java
import OddEvenApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import java.util.Scanner;
public class OddEvenClient
{
    public static void main(String args[]){
        try{
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef =
                orb.resolve_initial_references("NameService");

            NamingContextExt ncRef =
                NamingContextExtHelper.narrow(objRef);

            OddEven obj =
                OddEvenHelper.narrow(
                    ncRef.resolve_str("OddEvenService"));

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number: ");
            int num = sc.nextInt();

            System.out.println("Result: " + obj.check(num));
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
idlj -fall OddEven.idl
```

---

# COMPILATION

```bash
javac *.java OddEvenApp/*.java
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
java OddEvenServer -ORBInitialPort 1050
```

### Output

```text
OddEven Server ready...
```

---

## Step 3: Run Client

Open another terminal.

```bash
java OddEvenClient -ORBInitialPort 1050
```

---

# SAMPLE OUTPUT

```text
Enter number: 7
Result: Odd
```

```text
Enter number: 10
Result: Even
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

The distributed application using CORBA to check whether a number is odd or even was successfully implemented and executed.

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
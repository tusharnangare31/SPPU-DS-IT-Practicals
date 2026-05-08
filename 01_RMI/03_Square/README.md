# Implement Multi-threaded Client/Server Process Communication Using RMI to Find Square of a Given Number

---

# AIM

To implement multi-threaded client/server process communication using Java RMI (Remote Method Invocation) to calculate the square of a given number.

---

# OBJECTIVE

- To understand distributed computing using Java RMI.
- To implement communication between client and server.
- To remotely invoke methods from client to server.
- To calculate the square of a number using remote method invocation.

---

# THEORY

Java RMI (Remote Method Invocation) is a mechanism that allows an object running in one Java Virtual Machine (JVM) to invoke methods on an object running in another JVM.

RMI provides distributed communication between Java applications.

In RMI architecture:
- The server creates remote objects.
- The client invokes methods on remote objects.
- Communication occurs over a network.

The RMI application consists of:
1. Remote Interface
2. Remote Object Implementation
3. Server Application
4. Client Application

---

# SOFTWARE REQUIREMENTS

- Java JDK 8 or above
- Command Prompt / Terminal
- Any Java IDE (VS Code / IntelliJ / Eclipse)

---

# HARDWARE REQUIREMENTS

- Minimum 4 GB RAM
- Dual Core Processor
- Windows / Linux / macOS

---

# ALGORITHM

1. Create a remote interface extending `Remote`.
2. Declare remote method `square()`.
3. Implement interface using `UnicastRemoteObject`.
4. Create server program and bind remote object using `Naming.rebind()`.
5. Create client program and access remote object using `Naming.lookup()`.
6. Accept number from user.
7. Invoke remote method.
8. Display square of number.

---

# PROGRAM FILES

| File Name | Description |
|------------|-------------|
| `ServerIntf.java` | Remote Interface |
| `ServerImp.java` | Remote Object Implementation |
| `Server.java` | Server Program |
| `Client.java` | Client Program |

---

# PROGRAM CODE

---

## 1. ServerIntf.java

```java
import java.rmi.*;

public interface ServerIntf extends Remote {

    public double square(double num) throws RemoteException;

}
```

---

## 2. ServerImp.java

```java
import java.rmi.*;
import java.rmi.server.*;

public class ServerImp extends UnicastRemoteObject implements ServerIntf {

    public ServerImp() throws RemoteException {
        super();
    }

    public double square(double num) throws RemoteException {

        return num * num;
    }
}
```

---

## 3. Server.java

```java
import java.rmi.*;
import java.rmi.registry.*;

public class Server {

    public static void main(String[] args) {

        try {

            try {

                LocateRegistry.createRegistry(1099);

            } catch (Exception e) {

                System.out.println("RMI Registry already running...");
            }

            ServerImp serverImp = new ServerImp();

            Naming.rebind("Server", serverImp);

            System.out.println("Server is ready...");

        } catch (Exception e) {

            System.out.println("Exception Occurred At Server: " + e.getMessage());

            e.printStackTrace();
        }
    }
}
```

---

## 4. Client.java

```java
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

            System.out.println("Square: " + serverIntf.square(num));

        } catch (Exception e) {

            System.out.println("Exception Occurred At Client: " + e.getMessage());

            e.printStackTrace();

        } finally {

            sc.close();
        }
    }
}
```

---

# COMPILATION

Open terminal inside project folder.

```bash
javac *.java
```

---

# EXECUTION

## Step 1: Run Server

```bash
java Server
```

### Output

```bash
Server is ready...
```

---

## Step 2: Run Client

Open another terminal.

```bash
java Client
```

### Output

```bash
Enter a Number: 5
Number is 5.0
Square: 25.0
```

---

# OUTPUT

## Server Side

```bash
Server is ready...
```

## Client Side

```bash
Enter a Number: 8
Number is 8.0
Square: 64.0
```

---

# ADVANTAGES

- Enables distributed computing.
- Supports client-server architecture.
- Allows remote method invocation.
- Simplifies network communication in Java.
- Supports scalable applications.

---

# DISADVANTAGES

- Slower than local method calls.
- Requires network connection.
- Java-only communication.
- More complex than standalone applications.

---

# APPLICATIONS

- Distributed Systems
- Banking Applications
- Online Reservation Systems
- Cloud Computing
- Enterprise Applications

---

# RESULT

The multi-threaded client/server communication using Java RMI to calculate the square of a given number was successfully implemented and executed.

---

# CONCLUSION

The Java RMI application successfully demonstrated remote communication between client and server processes. The client remotely invoked the square method from the server and received the computed result correctly.

---

# VIVA QUESTIONS

## 1. What is RMI?

RMI stands for Remote Method Invocation used for communication between distributed Java applications.

---

## 2. What is a remote interface?

An interface that declares methods accessible remotely.

---

## 3. Why extend `Remote` interface?

To indicate that methods can be invoked remotely.

---

## 4. Why is `RemoteException` used?

To handle network communication errors.

---

## 5. What is RMI Registry?

A naming service used to register and locate remote objects.

---

## 6. What is the default port number of RMI Registry?

1099

---

## 7. What is `Naming.lookup()`?

Used by client to access remote object from registry.

---

## 8. What is `Naming.rebind()`?

Used by server to register remote object.

---

## 9. What is `UnicastRemoteObject`?

It exports remote objects for communication.

---

## 10. Difference between local and remote method?

- Local method executes within same JVM.
- Remote method executes on another JVM/machine.

---

## 11. Which package is used for RMI?

`java.rmi`

---

## 12. What is distributed computing?

A system where multiple computers communicate and work together.

---

## 13. What is a stub in RMI?

A stub acts as a proxy between client and remote object.

---

## 14. Can RMI work without internet?

Yes, it can work on localhost or local network.

---

## 15. Which protocol does RMI use?

TCP/IP protocol.
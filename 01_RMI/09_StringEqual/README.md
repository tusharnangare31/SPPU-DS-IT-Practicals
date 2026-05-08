# Implement Multi-threaded Client/Server Process Communication Using RMI to Find Whether the Strings are Equal or Not

---

# AIM

To implement multi-threaded client/server process communication using Java RMI (Remote Method Invocation) to check whether two strings are equal or not.

---

# OBJECTIVE

- To understand distributed computing using Java RMI.
- To implement communication between client and server.
- To remotely invoke methods from client to server.
- To compare two strings using remote method invocation.

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

String comparison checks whether two strings contain the same sequence of characters.

Example:
- `hello` and `hello` → Equal
- `java` and `Java` → Not Equal

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
2. Declare remote method `checkEqual()`.
3. Implement interface using `UnicastRemoteObject`.
4. Compare two strings using `equals()`.
5. Return comparison result.
6. Create server program and bind remote object using `Naming.rebind()`.
7. Create client program and access remote object using `Naming.lookup()`.
8. Accept two strings from user.
9. Invoke remote method.
10. Display result.

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

    public String checkEqual(String str1, String str2) throws RemoteException;

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

    public String checkEqual(String str1, String str2) throws RemoteException {

        if(str1.equals(str2)) {

            return "Strings are Equal";

        } else {

            return "Strings are Not Equal";
        }
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

            System.out.print("Enter First String: ");

            String str1 = sc.nextLine();

            System.out.print("Enter Second String: ");

            String str2 = sc.nextLine();

            System.out.println("First String is " + str1);

            System.out.println("Second String is " + str2);

            System.out.println(serverIntf.checkEqual(str1, str2));

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
Enter First String: hello
Enter Second String: hello
First String is hello
Second String is hello
Strings are Equal
```

---

# OUTPUT

## Server Side

```bash
Server is ready...
```

## Client Side

```bash
Enter First String: java
Enter Second String: Python
First String is java
Second String is Python
Strings are Not Equal
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

The multi-threaded client/server communication using Java RMI to check whether two strings are equal or not was successfully implemented and executed.

---

# CONCLUSION

The Java RMI application successfully demonstrated remote communication between client and server processes. The client remotely invoked the string comparison method from the server and received the result correctly.

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

## 13. Which method is used to compare strings in Java?

`equals()`

---

## 14. What is case-sensitive comparison?

Comparison where uppercase and lowercase letters are treated differently.

---

## 15. Which protocol does RMI use?

TCP/IP protocol.
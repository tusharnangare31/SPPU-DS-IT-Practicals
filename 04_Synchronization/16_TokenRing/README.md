# Implement Token Ring Based Mutual Exclusion Algorithm

---

# AIM

To implement Token Ring based Mutual Exclusion Algorithm in a distributed system.

---

# OBJECTIVE

- To understand mutual exclusion in distributed systems.
- To implement Token Ring Algorithm.
- To simulate token passing among processes.
- To allow only one process to enter critical section at a time.

---

# THEORY

Mutual exclusion ensures that only one process can enter the critical section at a time.

Token Ring Algorithm is a distributed mutual exclusion algorithm in which:
- Processes are arranged in a logical ring.
- A special token circulates among processes.
- Only the process holding the token can enter the critical section.

Working:
1. Token is passed sequentially from one process to another.
2. If a process wants to enter critical section, it waits for token.
3. After completing execution, token is passed to next process.

Advantages:
- Prevents deadlock
- Ensures fairness
- No starvation

---

# SOFTWARE REQUIREMENTS

- Java JDK 8 or above
- Terminal / Command Prompt
- VS Code / IntelliJ / Eclipse

---

# HARDWARE REQUIREMENTS

- Minimum 4 GB RAM
- Dual Core Processor

---

# ALGORITHM

1. Initialize number of processes.
2. Assign token to first process.
3. Accept requesting process number.
4. Pass token sequentially until requesting process gets token.
5. Allow process to enter critical section.
6. After execution, process exits critical section.
7. Pass token to next process.
8. Repeat until user exits.

---

# PROGRAM CODE

## TokenRing.java

```java
import java.util.Scanner;

public class TokenRing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of processes : ");

		int n = sc.nextInt();
		int token = 0;

		while (true) {
			System.out.println("\nToken is with Process P" + (token + 1));

			System.out.print("Enter process number requesting critical section (1 to " + n + ", 0 to exit): ");

			int request = sc.nextInt();

			if (request == 0) {
				System.out.println("Program terminated.");
				break;
			}

			request = request - 1;

			while (token != request) {
				System.out.println("Passing token from P" + (token + 1) + " to P" + ((token + 1) % n + 1));

				token = (token + 1) % n;
			}

			System.out.println("Process P" + (token + 1) + " entered Critical Section");

			System.out.println("Process P" + (token + 1) + " exited Critical Section");

			token = (token + 1) % n;
		}
	}
}
```

---

# COMPILATION

```bash
javac TokenRing.java
```

---

# EXECUTION

```bash
java TokenRing
```

---

# SAMPLE OUTPUT

```text
Enter number of processes : 4

Token is with Process P1
Enter process number requesting critical section (1 to 4, 0 to exit): 3

Passing token from P1 to P2
Passing token from P2 to P3

Process P3 entered Critical Section
Process P3 exited Critical Section

Token is with Process P4
Enter process number requesting critical section (1 to 4, 0 to exit): 2

Passing token from P4 to P1
Passing token from P1 to P2

Process P2 entered Critical Section
Process P2 exited Critical Section
```

---

# ADVANTAGES

- Avoids deadlock
- Fair token distribution
- No starvation
- Simple implementation

---

# DISADVANTAGES

- Token loss affects system
- High waiting time for large systems
- Ring failure affects communication

---

# APPLICATIONS

- Distributed Systems
- Network Communication
- Resource Allocation
- Distributed Databases

---

# RESULT

The Token Ring based Mutual Exclusion Algorithm was successfully implemented and executed.

---

# CONCLUSION

The Token Ring Algorithm successfully demonstrated mutual exclusion by allowing only the process holding the token to enter the critical section.

---

# VIVA QUESTIONS

## 1. What is mutual exclusion?

Ensuring only one process accesses critical section at a time.

---

## 2. What is Token Ring Algorithm?

A distributed mutual exclusion algorithm using token passing.

---

## 3. What is a token?

A special permission message allowing access to critical section.

---

## 4. Which process can enter critical section?

Only process holding the token.

---

## 5. What happens after process exits critical section?

Token is passed to next process.

---

## 6. What is critical section?

Part of program accessing shared resources.

---

## 7. What is starvation?

A process waiting indefinitely for resource access.

---

## 8. Does Token Ring avoid deadlock?

Yes.

---

## 9. What is logical ring?

Processes connected in circular sequence.

---

## 10. Main disadvantage of Token Ring?

Token loss can stop system operation.

---

## 11. What happens if token is lost?

No process can enter critical section.

---

## 12. Is Token Ring centralized?

No.

---

## 13. Is Token Ring fair?

Yes.

---

## 14. What is distributed system?

Multiple computers working together.

---

## 15. Why is mutual exclusion important?

To prevent data inconsistency and race conditions.
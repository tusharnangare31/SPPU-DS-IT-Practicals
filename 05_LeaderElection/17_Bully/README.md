# Implement Bully Algorithm for Leader Election

---

# AIM

To implement Bully Algorithm for leader election in a distributed system.

---

# OBJECTIVE

- To understand leader election in distributed systems.
- To implement Bully Algorithm.
- To elect a coordinator among processes.
- To simulate election mechanism in distributed systems.

---

# THEORY

Bully Algorithm is a leader election algorithm used in distributed systems.

In this algorithm:
- Every process has a unique process ID.
- The process with highest ID becomes coordinator.
- When coordinator fails, another process initiates election.
- Election messages are sent to higher-ID processes.
- Highest active process becomes new coordinator.

The algorithm is called "Bully" because the highest-ID process dominates all other processes.

Working:
1. Detect coordinator failure.
2. Start election process.
3. Send election message to higher-ID processes.
4. Higher-ID processes respond.
5. Highest active process becomes coordinator.

---

# SOFTWARE REQUIREMENTS

- Java JDK 8 or above
- VS Code / IntelliJ / Eclipse
- Terminal / Command Prompt

---

# HARDWARE REQUIREMENTS

- Minimum 4 GB RAM
- Dual Core Processor

---

# ALGORITHM

1. Enter number of processes.
2. Assign process IDs.
3. Display current coordinator.
4. Enter process initiating election.
5. Send election messages to higher-ID processes.
6. Highest process becomes coordinator.
7. Display new coordinator.

---

# PROGRAM CODE

## Bully.java

```java
import java.util.Scanner;

public class Bully {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");

        int n = sc.nextInt();

        int processes[] = new int[n];

        for(int i = 0; i < n; i++) {

            processes[i] = i + 1;
        }

        int coordinator = n;

        System.out.println("\nProcesses are:");

        for(int i = 0; i < n; i++) {

            System.out.println("P" + processes[i]);
        }

        System.out.println("\nCurrent Coordinator: P" + coordinator);

        System.out.print("\nEnter process which initiates election: ");

        int initiator = sc.nextInt();

        System.out.println("\nElection Process:");

        for(int i = initiator; i < n; i++) {

            System.out.println("P" + initiator +
                    " sends Election message to P" +
                    processes[i]);
        }

        coordinator = n;

        System.out.println("\nProcess P" + coordinator +
                " becomes new Coordinator");

        sc.close();
    }
}
```

---

# COMPILATION

```bash
javac Bully.java
```

---

# EXECUTION

```bash
java Bully
```

---

# SAMPLE OUTPUT

```text
Enter number of processes: 5

Processes are:
P1
P2
P3
P4
P5

Current Coordinator: P5

Enter process which initiates election: 2

Election Process:
P2 sends Election message to P3
P2 sends Election message to P4
P2 sends Election message to P5

Process P5 becomes new Coordinator
```

---

# ADVANTAGES

- Simple implementation
- Fast leader election
- Highest process becomes coordinator

---

# DISADVANTAGES

- High communication overhead
- More message passing
- Failure detection required

---

# APPLICATIONS

- Distributed Systems
- Cluster Computing
- Distributed Databases
- Network Systems

---

# RESULT

The Bully Algorithm for leader election was successfully implemented and executed.

---

# CONCLUSION

The Bully Algorithm successfully elected the highest active process as coordinator in the distributed system.

---

# VIVA QUESTIONS

## 1. What is Bully Algorithm?

A leader election algorithm used in distributed systems.

---

## 2. Why is it called Bully Algorithm?

Because highest-ID process dominates and becomes coordinator.

---

## 3. What is coordinator?

Leader process managing system activities.

---

## 4. Which process becomes coordinator?

Highest active process ID.

---

## 5. What happens when coordinator fails?

Election process starts.

---

## 6. What is election message?

Message sent to higher-ID processes during election.

---

## 7. What is process ID?

Unique identifier assigned to each process.

---

## 8. Is Bully Algorithm centralized?

No.

---

## 9. Main disadvantage of Bully Algorithm?

High communication overhead.

---

## 10. What is distributed system?

Collection of multiple interconnected systems.

---

## 11. What triggers election?

Coordinator failure.

---

## 12. Is Bully Algorithm fault tolerant?

Partially.

---

## 13. Which process initiates election?

Any process detecting coordinator failure.

---

## 14. What is leader election?

Selecting one process as coordinator.

---

## 15. Does Bully Algorithm guarantee coordinator selection?

Yes.
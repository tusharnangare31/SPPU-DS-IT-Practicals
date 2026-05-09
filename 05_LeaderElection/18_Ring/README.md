# Implement Ring Algorithm for Leader Election

---

# AIM

To implement Ring Algorithm for leader election in a distributed system.

---

# OBJECTIVE

- To understand leader election in distributed systems.
- To implement Ring Algorithm.
- To elect a coordinator among processes.
- To simulate election process using ring topology.

---

# THEORY

Ring Algorithm is a leader election algorithm used in distributed systems.

In this algorithm:
- Processes are arranged in a logical ring.
- Every process has a unique process ID.
- Election message circulates in ring structure.
- Highest process ID becomes coordinator.

Working:
1. A process detects coordinator failure.
2. It initiates election message.
3. Election message passes through ring.
4. Each process adds its ID.
5. Highest process ID is selected as coordinator.
6. Coordinator message circulates in ring.

The Ring Algorithm ensures fair and organized leader election.

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
3. Display active processes.
4. Enter process initiating election.
5. Pass election message through ring.
6. Compare process IDs.
7. Highest process ID becomes coordinator.
8. Display elected coordinator.

---

# PROGRAM CODE

## Ring.java

```java
import java.util.Scanner;

public class Ring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");

        int n = sc.nextInt();

        int process[] = new int[n];

        for(int i = 0; i < n; i++) {

            process[i] = i + 1;
        }

        System.out.println("\nProcesses are:");

        for(int i = 0; i < n; i++) {

            System.out.println("P" + process[i]);
        }

        System.out.print("\nEnter process initiating election: ");

        int initiator = sc.nextInt();

        System.out.println("\nElection Message Passing:");

        int coordinator = initiator;

        for(int i = 0; i < n; i++) {

            int next = (initiator + i - 1) % n;

            System.out.println("Message passed from P" +
                    process[next] + " to P" +
                    process[(next + 1) % n]);

            if(process[(next + 1) % n] > coordinator) {

                coordinator = process[(next + 1) % n];
            }
        }

        System.out.println("\nProcess P" + coordinator +
                " becomes Coordinator");

        sc.close();
    }
}
```

---

# COMPILATION

```bash
javac Ring.java
```

---

# EXECUTION

```bash
java Ring
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

Enter process initiating election: 2

Election Message Passing:
Message passed from P2 to P3
Message passed from P3 to P4
Message passed from P4 to P5
Message passed from P5 to P1
Message passed from P1 to P2

Process P5 becomes Coordinator
```

---

# ADVANTAGES

- Simple implementation
- Fair leader election
- No centralized coordinator required

---

# DISADVANTAGES

- Slower for large systems
- Ring failure affects election
- More message passing

---

# APPLICATIONS

- Distributed Systems
- Token Ring Networks
- Cluster Computing
- Network Communication

---

# RESULT

The Ring Algorithm for leader election was successfully implemented and executed.

---

# CONCLUSION

The Ring Algorithm successfully elected the highest process ID as coordinator using logical ring communication.

---

# VIVA QUESTIONS

## 1. What is Ring Algorithm?

A leader election algorithm using logical ring structure.

---

## 2. What is logical ring?

Processes connected in circular order.

---

## 3. Which process becomes coordinator?

Highest active process ID.

---

## 4. What is election message?

Message circulated among processes during election.

---

## 5. What triggers election?

Coordinator failure.

---

## 6. Is Ring Algorithm centralized?

No.

---

## 7. What is coordinator?

Leader process managing activities.

---

## 8. Main disadvantage of Ring Algorithm?

High message passing for large systems.

---

## 9. Is Ring Algorithm fault tolerant?

Partially.

---

## 10. What happens if ring breaks?

Election process fails.

---

## 11. What is process ID?

Unique identifier assigned to process.

---

## 12. Does Ring Algorithm guarantee leader election?

Yes.

---

## 13. What is distributed system?

Collection of interconnected systems.

---

## 14. Is message passing sequential in Ring Algorithm?

Yes.

---

## 15. Why is leader election important?

To coordinate distributed system activities.
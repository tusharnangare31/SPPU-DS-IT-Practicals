# Implement Berkeley Algorithm for Clock Synchronization

---

# AIM

To implement Berkeley Algorithm for clock synchronization in a distributed system.

---

# OBJECTIVE

- To understand clock synchronization in distributed systems.
- To implement Berkeley synchronization algorithm.
- To synchronize clocks of different systems using a master server.
- To calculate average clock time and adjust slave clocks.

---

# THEORY

In distributed systems, every computer has its own local clock. Due to clock drift, different systems may show different times.

Berkeley Algorithm is used to synchronize clocks in distributed systems where no machine has an accurate UTC time source.

In Berkeley Algorithm:
- One machine acts as master.
- Remaining machines act as slaves.
- Master polls all slave clocks.
- Average time is calculated.
- Time difference is computed.
- Master sends adjustment values to slaves.
- All clocks become synchronized.

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

1. Start master clock.
2. Read slave clock times.
3. Calculate average clock time.
4. Compute time difference between average and slave clocks.
5. Send adjustment values to slave systems.
6. Synchronize all clocks.

---

# PROGRAM CODE

## Berkeley.java

```java
import java.util.*;

public class Berkeley {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n;
        int sum = 0;

        System.out.print("Enter Number of Clocks: ");
        n = sc.nextInt();

        int clock[] = new int[n];

        System.out.println("Enter Clock Times:");

        for(int i = 0; i < n; i++) {

            clock[i] = sc.nextInt();

            sum = sum + clock[i];
        }

        int avg = sum / n;

        System.out.println("\nAverage Clock Time: " + avg);

        System.out.println("\nClock Synchronization:");

        for(int i = 0; i < n; i++) {

            int adjustment = avg - clock[i];

            System.out.println("Clock " + (i + 1) +
                    " Adjustment: " + adjustment);
        }

        System.out.println("\nSynchronized Clock Times:");

        for(int i = 0; i < n; i++) {

            clock[i] = avg;

            System.out.println("Clock " + (i + 1) +
                    " Time: " + clock[i]);
        }

        sc.close();
    }
}
```

---

# COMPILATION

Open terminal inside project folder.

```bash
javac Berkeley.java
```

---

# EXECUTION

```bash
java Berkeley
```

---

## Berkeley.py

```python
n = int(input("Enter Number of Clocks: "))

clock = []
sum_time = 0

print("Enter Clock Times:")

for i in range(n):
    time = int(input())
    clock.append(time)
    sum_time += time

avg = sum_time // n

print("\nAverage Clock Time:", avg)

print("\nClock Synchronization:")

for i in range(n):
    adjustment = avg - clock[i]
    print("Clock", i + 1, "Adjustment:", adjustment)

print("\nSynchronized Clock Times:")

for i in range(n):
    clock[i] = avg
    print("Clock", i + 1, "Time:", clock[i])
```

---

# EXECUTION

```bash
python3 Berkeley.py
```

---

# SAMPLE OUTPUT

```bash
Enter Number of Clocks: 4
Enter Clock Times:
10
12
15
11

Average Clock Time: 12

Clock Synchronization:
Clock 1 Adjustment: 2
Clock 2 Adjustment: 0
Clock 3 Adjustment: -3
Clock 4 Adjustment: 1

Synchronized Clock Times:
Clock 1 Time: 12
Clock 2 Time: 12
Clock 3 Time: 12
Clock 4 Time: 12
```

---

# ADVANTAGES

- Simple clock synchronization method.
- Does not require UTC clock.
- Suitable for distributed systems.
- Reduces clock drift.

---

# DISADVANTAGES

- Single point of failure.
- Delay affects synchronization accuracy.
- Not suitable for large-scale systems.

---

# APPLICATIONS

- Distributed Systems
- Computer Networks
- Cloud Computing
- Parallel Processing Systems
- Data Centers

---

# RESULT

The Berkeley Algorithm for clock synchronization was successfully implemented and executed.

---

# CONCLUSION

The Berkeley Algorithm successfully synchronized multiple system clocks by calculating average time and adjusting slave clocks accordingly.

---

# VIVA QUESTIONS

## 1. What is clock synchronization?

Clock synchronization is the process of making all system clocks show the same time.

---

## 2. What is Berkeley Algorithm?

A clock synchronization algorithm used in distributed systems.

---

## 3. Who controls synchronization in Berkeley Algorithm?

Master server.

---

## 4. What are slave clocks?

Systems whose clocks are adjusted by master clock.

---

## 5. What is clock drift?

Difference in clock times between systems.

---

## 6. Is Berkeley Algorithm centralized?

Yes.

---

## 7. What is the purpose of average time?

To synchronize all clocks to a common time.

---

## 8. What is synchronization error?

Difference between actual and synchronized time.

---

## 9. Where is Berkeley Algorithm used?

Distributed systems and computer networks.

---

## 10. What is the main disadvantage of Berkeley Algorithm?

Failure of master system affects synchronization.

---

## 11. Does Berkeley Algorithm use UTC?

No.

---

## 12. What is distributed system?

A collection of multiple computers working together.

---

## 13. Why is clock synchronization needed?

To maintain consistency between systems.

---

## 14. What happens if clocks are not synchronized?

Incorrect coordination and communication errors occur.

---

## 15. Which type of architecture does Berkeley Algorithm use?

Client-Server architecture.
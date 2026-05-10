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
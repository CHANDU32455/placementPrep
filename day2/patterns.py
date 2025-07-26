def pattern1(n):
    for i in range(1,n):
        for j in range(1,n):
            print("*", end=" ")
        print()

def pattern2(n):
    count = 1
    for i in range(n):
        for j in range(n):
            print(count, end=" ")
            count+=1
        print()
def pattern3(n):
    for i in range(1,n+1):
        for j in range(n-i+1):
            print("*", end=" ")
        print()

def charsLshaped(n):
    ltr = 65
    for i in range(n+1):
        for j in range(i):
            print(chr(ltr), end=" ")
            ltr += 1
        print()

def invtriangle(n):
    for i in range(n):
        for j in range(i):
            print(" ", end=" ")
        for k in range(n-i):
            print("*", end=" ")
        for l in range(n-i-1):
            print("*", end=" ")
        print()

def upperTriangle(n):
    for i in range(n+1):
        for j in range(i):
            print("*", end=" ")
        print()

upperTriangle(5)


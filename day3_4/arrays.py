def warmup():
    arr = list(map(int, input("values: ").split()))
    print(arr)
    for ele in arr:
        print(ele, end=" ")
    print()
    oddsum = [x for x in arr if x%2 == 0]
    evensum = [x for x in arr if x%2!=0]
    print("oddsum: ", oddsum,"evensum:",evensum, "odd-even diff:", sum(oddsum)-sum(evensum))

    arr.sort()
    print(arr)

def arearrayssame(a,b):
    if len(a)!= len(b):
        return False
    for i in range(len(a)):
        if a[i] != b[i]:
            return False
    return True

# print(arearrayssame([1,2,4], [1,2,3]))
# complexity : O(n^2 space and O(i) time...)
def pivotpos():
    arr = [1,7,3,6,5,6]
    for i in range(len(arr)):
        leftsum = sum(arr[:i])
        rightsum = sum(arr[i+1:])
        if leftsum == rightsum:
            return i   
    return -1

# O(1) space.., O(n) time
def pivotpos():
    arr = [1,2,3,4,5,6,7,8,9,9,8,7,6,5,2,5,2,33,43,434,2,10,11,12,13,14,15,16,17,18,6,5,2,5,2,33,43,434,2,10,11,12,13,14,15,16,17,18]
    total = sum(arr)
    leftsum = 0
    for i in range(len(arr)):
        rightsum = total - leftsum - arr[i]
        if leftsum == rightsum:
            return i
        leftsum += arr[i]
    return -1
# print(pivotpos())
def missingnum():
    arr = [3,0,1]
    n = len(arr)
    res = n*(n+1)//2
    print(res - sum(arr))

def runningSum(arr):
    res = [0]*len(arr)
    res[0] = arr[0]
    for i in range(1, len(arr)):
        res[i] = res[i-1] + arr[i]
    return res
# print(runningSum([1,2,3,4]))

def conceqones():
    arr = [1,0,1,1,1]
    currentones = 0
    maxones = 0
    for num in arr:
        if num == 1:
            currentones += 1
            if currentones > maxones:
                maxones = currentones
        else:
            currentones = 0
    return maxones
# print(conceqones())

def twoSum(arr, target):
    for i in range(len(arr)):
        for j in range(len(arr)):
            if arr[i] + arr[j] == target:
                return [i,j]
    return []
print(twoSum([2,7,11,15], 9))
# Read matrix size and matrix rows from input
def printcolrev():
    matrix = [list(map(int, input("matrix: ").split())) for _ in range(int(input("size: ")))]
    cols = list(zip(*matrix))
    print(cols)

def noDuplicateLetters(s):
    print("".join(dict.fromkeys(s)))
# noDuplicateLetters("programming")

from collections import Counter
def longestSubString(s):
    # freq = Counter(s)
    # for ch, count in freq.most_common():
    #    print(f"{ch} : {count}")
    freq = {}
    for i, char in enumerate(s):
        if char in freq:
            freq[char] +=1
        else:
            freq[char] = 1
    print(freq)
    
# longestSubString("ababab")


# linkedlist
class Node:
    def __init__(self, data):
        self.data= data
        self.next = None
class Linkedlist:
    def __init__(self):
        self.head = None

    def printll(self):
        temp = self.head
        while temp:
            print(temp.data, end="-->")
            temp = temp.next
        print("None")
    def insAtBegining(self, data):
        newnode = Node(data)
        newnode.next = self.head
        self.head = newnode
    def insAtEnd(self, data):
        newnode = Node(data)
        if not self.head:
            self.head = newnode
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = newnode
    def printLengthofLL(self):
        temp = self.head
        count = 0
        while temp:
            temp = temp.next
            count+=1
        print(count)
    def insertAtPos(self, data, reqpos):
        newnode = Node(data)
        temp = self.head
        pos = 1
        if pos == 1:
            self.insAtBegining(data)
        if(pos > 2):
            return -1
        while temp and pos < reqpos-1:
            temp = temp.next
            pos+=1
            if(pos == reqpos):
                newnode.next = temp.next
                temp.next = newnode
        

ll = Linkedlist()
ll.insAtBegining(10)
ll.insAtEnd(20)
ll.printll()
ll.printLengthofLL()
ll.insertAtPos(30,1)

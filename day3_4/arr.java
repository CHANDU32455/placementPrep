
import java.util.*;

public class arr {

    public static void something() {
        String str = "Hello, World!";
        boolean result;
        result = str instanceof String;
        System.out.println(result);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array length: " + arr.length);

        for (int value : arr) {
            System.out.println("Array value: " + value);
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 5; i > 0; i--) {
            System.out.println("value:" + arr[i - 1]);
        }
    }

    public static void arrbasics() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("You entered:");
        // way1
        System.out.println("WAY1...");
        for (int i = 0; i < size; i++) {
            System.out.println("ele at " + i + " is: " + arr[i]);
        }
        // way2
        System.out.println("WAY2...");
        for (int val : arr) {
            System.out.println("ele:" + val);
        }
        // way3
        System.out.println("WAY3...");
        System.out.println("arr:" + Arrays.toString(arr));
    }

    public static void oddsum_evensum() {
        int[] arr = {15, 84, 73, 90, 27, 34, 69, 74, 18, 8};
        int evensum = 0, oddsum = 0;
        for (int i = 0; i < arr.length; i++) {
            // change arr[i]  to  i    for index based solution..
            if (i % 2 == 0) { // check with val in arr (ele based..)
                evensum += arr[i];
            } else {
                oddsum += arr[i];
            }
        }
        System.out.println("evensum:" + evensum);
        System.out.println("oddsum:" + oddsum);
        int diff = oddsum - evensum;
        System.out.println("oddsum-evensum: " + diff);

        /**
         * PS C:\Users\Chandu\projects\Placement_Preperation\day3> javac
         * arr.java;java arr.java evensum:308 oddsum:184 oddsum-evensum: -124 PS
         * C:\Users\Chandu\projects\Placement_Preperation\day3> javac
         * arr.java;java arr.java evensum:202 oddsum:290 oddsum-evensum: 88
         */
    }

    public static boolean mirroredArr(int[] arr) {
        boolean ismirror = true;
        int n = arr.length;
        if (n % 2 == 1) {
            ismirror = false;
        }
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - i - 1]) {
                ismirror = false;
                break;
            }
        }
        return ismirror;
    }

    public static boolean AresameArrays(int[] a1, int[] a2) {
        boolean arrayssame = true;
        if (a1.length != a2.length) {
            arrayssame = false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                arrayssame = false;
            }
        }
        return arrayssame;
    }

    public static boolean AreSameFreqs(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        // rest is gpt code...
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for (int num : a) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }

        return freq1.equals(freq2);
    }

    public static void sortvalues() {
        Scanner s = new Scanner(System.in);
        System.out.println("enter size..");
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("enter elements..");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        //bubble sorting logic
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("sorted array..");
        System.out.println(Arrays.toString(arr));
    }

    public static void firstHalfDecSortedArr(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < mid - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // print first half rev and then normal
        for (int i = 0; i < mid; i++) {
            System.out.print(arr[mid - i - 1] + " ");
        }
        for (int i = mid; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void firstHalfAscNextHalfDesc(int[] arr) {
        int n = arr.length;
        int mid = n / 2;

        // sort the entire arr first
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // print first half in ascending order
        for (int i = 0; i < mid; i++) {
            System.out.print(arr[i] + " ");
        }
        // print second half in descending order
        for (int i = mid; i < n; i++) {
            System.out.print(arr[mid + n - i - 1] + " ");
        }
    }

    public static void evenoddBinary(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                res[i] = 0; 
            }else {
                res[i] = 1;
            }
        }
        System.out.println("Binary representation of arr: " + Arrays.toString(res));
    }

    public static void pushZeroesEnd(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count++;
            } else {
                arr[i - count] = arr[i];
            }
        }
        for (int i = n - count; i < n; i++) {
            arr[i] = 0;
        }
        System.out.println("Final array:" + Arrays.toString(arr));
    }

    public static void firstHalfLargestMinusNextHalfSmall(int[] arr) {
        int n = arr.length;
        int mid = n / 2;
        int small = arr[mid];

        int big = arr[0];
        for (int i = 0; i < mid; i++) {
            if (arr[i] > big) {
                big = arr[i];
            }
        }
        for (int i = mid; i < n; i++) {
            if (arr[i] < small) {
                small = arr[i];
            }
        }
        System.out.println("small: " + small + " big: " + big);
        System.out.println("Difference: " + (big - small));

    }

    public static void playWithMethods() {
        int[] arrry = {8, 5, 2, 7, 9, 0, 6, 3, 1, 4};
        int[] copyarr = Arrays.copyOf(arrry, arrry.length);
        // fill arr with 0s
        int[] someArr = new int[10];
        Arrays.fill(someArr, 5);
        System.out.println("Filled Array: " + Arrays.toString(someArr));
        // fill first 5 with 0, then 5 with 1
        Arrays.fill(someArr, 0, 5, 0);
        Arrays.fill(someArr, 5, 10, 1);
        System.out.println("Partially Filled Array: " + Arrays.toString(someArr));
        Arrays.fill(someArr, 0);
        System.out.println("Filled Array with 0s: " + Arrays.toString(someArr));
        System.out.println("Copy of Array: " + Arrays.toString(copyarr));
        System.out.println("Are arrays equal? " + Arrays.equals(arrry, copyarr));
        System.out.print("Originam Arr: " + Arrays.toString(arrry));
        Arrays.sort(arrry);  // sort in ascending order
        System.out.println("\nSorted Arr: " + Arrays.toString(arrry));
        // bin search
        System.out.println("Binary Search for 3:");
        int index = Arrays.binarySearch(arrry, 3);
        System.out.println("Index of 3: " + index);

        System.out.println("Array length: " + arrry.length);
        System.out.println("Array as List: " + Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        // deep equals
        int[][] multiArr1 = {{0, 9}, {8, 7}};
        int[][] multiArr2 = {{0, 9}, {8, 7}};
        System.out.println("Are multi-dimensional arrays equal? " + Arrays.deepEquals(multiArr1, multiArr2));

        int num = 10;
        if ((num & 1) == 1) {
            System.out.println(num + " is odd"); 
        }else {
            System.out.println(num + " is even");
        }

        // merge 2 arrays and sort
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {40, 50, 60};
        int[] mergedArr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArr, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArr, arr1.length, arr2.length);
        Arrays.sort(mergedArr);
        System.out.println("Merged and sorted array: " + Arrays.toString(mergedArr));
    }

    public static void pivotIndex() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 2, 5, 2, 33, 43, 434, 2, 10, 11, 12, 13, 14, 15, 16, 17, 18, 6, 5, 2, 5, 2, 33, 43, 434, 2, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        int n = arr.length;
        int leftSum = 0, rightSum = 0;
        for (int i = 0; i < n; i++) {
            rightSum += arr[i];
        }
        for (int i = 0; i < n; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                System.out.println("Pivot index found at: " + i);
                return;
            }
            leftSum += arr[i];
        }
        System.out.println("No pivot index found.");
    }

    public static int findMissingNum(int[] arr) {
        int n = arr.length;
        int totalSum = (n + 1) * (n + 2) / 2; // Sum of first n natural numbers
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        return totalSum - arrSum;
    }

    public static void runningSum() {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int[] runningSum = new int[n];
        runningSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            runningSum[i] = runningSum[i - 1] + arr[i];
        }
        System.out.println("Running Sum: " + Arrays.toString(runningSum));
    }

    public static void shuffleArray(int[] arr) {
        int n = arr.length;
        int mid = n / 2;
        int[] shuffled = new int[n];
        for (int i = 0; i < mid; i++) {
            shuffled[2 * i] = arr[i]; //even pos
            shuffled[2 * i + 1] = arr[mid + i]; // oddpos
        }
        System.out.println("Shuffled Array: " + Arrays.toString(shuffled));
    }

    public static int numbersWithEvenNoOfDigits() {
        System.out.println("enter size.. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter all ele in one line...");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("You entered: " + Arrays.toString(arr));
        int count = 0;
        for (int num : arr) {
            int digits = (int) Math.log10(num) + 1; // returns no.of digits
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int conseqOnesCount(int[] arr){
        int currentones = 0, maxones = 0;
        for(int num : arr){
            if(num == 1){
                currentones++;
                if(currentones > maxones) maxones = currentones;
            }else currentones = 0;
        }
        return maxones;
    }

    public static void noOfSmallerNumsThanCurrent(){
        int[] arr = {8,1,2,2,3};
        int n = arr.length;
        for(int j=0; j<n; j++){
            int count = 0;
            for(int i=0; i<n; i++){
                if(arr[i] < arr[j]) count++;
            }
            System.out.print(count + " ");
        }
    }

    public static int[] twoSumProblem(int[] arr, int target){
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i] + arr[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void sortByParity(int[] arr){
        int n = arr.length;
        int left = 0, right = n-1;
        while(left < right){
            if(arr[left] % 2 == 0){
                left++;
            }else{
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right --;
            }
        }
        System.out.println("SortedByParityArr: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a1 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] a2 = {15, 6, 94, 11, 31, 13, 34, 33, 26, 53};
        // something();
        // arrbasics();
        // oddsum_evensum();  // ele based and index based..
        // System.out.println("ismirror: "+ mirroredArr(arr));
        // System.out.println("AreArraysSame" +AresameArrays(a1, a2));
        // System.out.println("AreArraysSameFreqs: " +AreSameFreqs(a1, a2));
        // sortvalues();
        // firstHalfDecSortedArr(a2);
        // firstHalfAscNextHalfDesc(a1);
        // evenoddBinary(new int[]{3,3,3,3,3,3,3});
        // pushZeroesEnd(new int[]{1, 0, 2, 0, 3, 0, 4, 0, 5,0,0,0});
        // firstHalfLargestMinusNextHalfSmall(a2);
        // playWithMethods();
        // pivotIndex();
        // System.out.println("Missing number in array: " + findMissingNum(new int[]{1,2,3,4,5,6,8}));
        // runningSum();
        // shuffleArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        // System.out.println("Count of numbers with even digits: " + numbersWithEvenNoOfDigits());
        // System.out.println(conseqOnesCount(new int[]{1,0,1,1,1}));
        // noOfSmallerNumsThanCurrent();
        // System.out.println("" + Arrays.toString(twoSumProblem(new int[]{2,7,11,15}, 9)));
        sortByParity(new int[]{3,1,2,4});
    }
}

// sort, toString, equals, copyOf, copyOfRange, fill, BinarySearch, asList, deepEquls, deepHashCode, deepToString, parallelSort, spliterator, stream, parallelStream
// Arrays.sort(arr);  // sort in ascending order
// Arrays.toString(arr);  // print array
// Arrays.equals(arr1, arr2);  // check if two arrays are equal
// Arrays.copyOf(arr, newLength);  // copy array to new length
// Arrays.copyOfRange(arr, from, to);  // copy a range of the array
// Arrays.fill(arr, value);  // fill array with a specific value
// Arrays.binarySearch(arr, key);  // binary search for a key in the array
// Arrays.asList(arr);  // convert array to list
// Arrays.deepEquals(arr1, arr2);  // check if two multi-dimensional arrays are equal
// Arrays.deepHashCode(arr);  // get hash code for multi-dimensional array
// Arrays.deepToString(arr);  // print multi-dimensional array
// Arrays.parallelSort(arr);  // sort array in parallel
// Arrays.spliterator(arr);  // get spliterator for array
// Arrays.stream(arr);  // create a stream from the array
// Arrays.parallelStream(arr);  // create a parallel stream from the array
// Arrays.stream(arr).forEach(System.out::println);  // print each element in the array using stream
// Arrays.parallelStream(arr).forEach(System.out::println);  // print each element in the array using parallel stream
// Arrays.stream(arr).filter(x -> x > 5).forEach(System.out::println);  // print elements greater than 5 using stream
// Arrays.parallelStream(arr).filter(x -> x > 5).forEach(System.out::println);  // print elements greater than 5 using parallel stream      
// Arrays.stream(arr).map(x -> x * 2).forEach(System.out::println);  // double each element using stream
// Arrays.parallelStream(arr).map(x -> x * 2).forEach(System.out::println);  // double each element using parallel stream
// Arrays.stream(arr).sorted().forEach(System.out::println);

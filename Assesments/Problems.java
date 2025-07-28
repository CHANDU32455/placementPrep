import java.util.*;

public class Problems {

    // problem 8 : unique num of occ
    public static boolean hasUniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> frequencySet = new HashSet<>(freqMap.values());
        return freqMap.size() == frequencySet.size();
    }

    // problem 9 : dest city
    public static String findDestinationCity(List<List<String>> paths) {
        Set<String> departures = new HashSet<>();
        for (List<String> path : paths) {
            departures.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!departures.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }

    // problem 10 : missing num
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum - actualSum;
    }

    // Extra: Even/Odd Digit Transformer
    public static void evenOddStuff(String num) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (char c : num.toCharArray()) {
            int digit = Character.getNumericValue(c);
            even.append((digit + 2) % 10);
            odd.append((digit + 1) % 10);
        }

        int evenFinal = 0, oddFinal = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            if (digit % 2 == 0) {
                evenFinal = evenFinal * 10 + Character.getNumericValue(even.charAt(i));
            } else {
                oddFinal = oddFinal * 10 + Character.getNumericValue(odd.charAt(i));
            }
        }

        int result = Math.abs(evenFinal - oddFinal);
        System.out.println("Original:      " + num);
        System.out.println("Even digits →  " + evenFinal);
        System.out.println("Odd digits →   " + oddFinal);
        System.out.println("Abs diff →     " + result);
    }

    public static void main(String[] args) {

        int[] occArr1 = {1, 2, 2, 1, 1, 3};
        int[] occArr2 = {1, 2};
        System.out.println("Problem 8:");
        System.out.println(hasUniqueOccurrences(occArr1)); // true
        System.out.println(hasUniqueOccurrences(occArr2)); // false


        System.out.println("\nProblem 9:");
        List<List<String>> paths = Arrays.asList(
            Arrays.asList("London", "New York"),
            Arrays.asList("New York", "Lima"),
            Arrays.asList("Lima", "Sao Paulo")
        );
        System.out.println(findDestinationCity(paths)); // Sao Paulo


        System.out.println("\nProblem 10:");
        int[] nums1 = {3, 0, 1};
        int[] nums2 = {0, 1};
        System.out.println(findMissingNumber(nums1)); // 2
        System.out.println(findMissingNumber(nums2)); // 2


        System.out.println("\nEvenOddStuff Demo:");
        evenOddStuff("2486");
    }
}

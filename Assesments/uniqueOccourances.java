import java.util.*;

public class uniqueOccourances {
    public static boolean hasUniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Check if all frequencies are unique
        Set<Integer> frequencySet = new HashSet<>(freqMap.values());

        // If the size of the set equals the size of the map, all frequencies are unique
        return freqMap.size() == frequencySet.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        int[] arr2 = {1, 2};
        System.out.println(hasUniqueOccurrences(arr1)); // true
        System.out.println(hasUniqueOccurrences(arr2)); // false
    }
}

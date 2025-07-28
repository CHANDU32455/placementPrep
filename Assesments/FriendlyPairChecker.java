
public class FriendlyPairChecker {

    // Method to calculate the sum of proper divisors
    static int sumProperDivisors(int num) {
        int sum = 1; // 1 is a proper divisor of every number > 1
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                int div = num / i;
                if (div != i) sum += div;
            }
        }
        return sum;
    }

    // Method to check if two numbers are friendly pairs
    static boolean areFriendlyPairs(int a, int b) {
        return sumProperDivisors(a) == b && sumProperDivisors(b) == a;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int A = sc.nextInt(); // 220
        int B = sc.nextInt(); // 284
        System.out.println(areFriendlyPairs(A, B));
    }
}

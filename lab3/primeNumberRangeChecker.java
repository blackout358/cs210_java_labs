import java.util.Arrays;

public class primeNumberRangeChecker {
    public static void main(String[] args) {
        int start = 200; // Input start
        int end = 1; // Input end
        long timeStart = System.nanoTime();
        int count = countPrimesInRange(start, end);
        long timeEnd = System.nanoTime();
        System.out.println(count);
        System.out.println((timeEnd - timeStart) / 1000000);
    }

    public static int countPrimesInRange(int start, int end) {
        if (start > end) {
            int temp = end;
            end = start;
            start = temp;
        }
        if (start < 2) {
            start = 2; // Prime numbers start from 2
        }

        boolean[] isPrime = new boolean[end + 1]; // Create array from 0-end
        Arrays.fill(isPrime, true); // set all to true
        isPrime[0] = isPrime[1] = false; // change 0 and 1 to false as tey arent primes

        for (int p = 2; p * p <= end; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= end; i += p) {
                    isPrime[i] = false; // Elliminate all mulitples of p
                }
            }
        }

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}

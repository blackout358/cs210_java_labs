import java.util.Random;
// import java.util.Math;

public class Lab4 {
    public static void main(String[] args) {
        int totalPoints = 100000;

        long startTime = System.nanoTime();
        double pi = monteCarloPi(totalPoints);
        long endTime = System.nanoTime();

        System.out.println("PI estimate: " + pi);
        System.out.println("Pi Time: " + (endTime - startTime) / 1000000 + "ms");
        System.out.println("Absolute Error: " + Math.abs(Math.PI - pi));

        startTime = System.nanoTime();
        double eular = monteCarloEuler(totalPoints);
        endTime = System.nanoTime();

        System.out.println("\nEulers estimate: " + eular);
        System.out.println("Euler Time: " + (endTime - startTime) / 1000000 + "ms");

        System.out.println("Absolute Error: " + Math.abs(Math.E - eular));

    }

    /**
     * Select a random number between 0-1, square them and add them together to see
     * how far they are from the origin (0,0) If it falls less than or on one,
     * 
     * @insidecircle is incremented. Then the formula to calculate pi is used =
     *               number of points inside the circle / total points * 4
     * 
     * @param totalPoints
     * @return And estimate for pi
     */
    public static double monteCarloPi(int totalPoints) {
        int insideCircle = 0;
        Random random = new Random();

        for (int i = 0; i < totalPoints; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double rSquared = x * x + y * y;

            if (rSquared <= 1) {
                insideCircle++;
            }
        }

        return (double) insideCircle / totalPoints * 4;
    }

    /**
     * Declared the sum and the current factorial. The factorial is increased with
     * every iteration of the for loop as its being stored. This means we do not
     * need to make a factorial every iteration
     * 
     * 
     * @param totalPoints
     * @return Eulers number
     */
    public static double monteCarloEuler(int totalPoints) {
        double sum = 1;
        double factorial = 1;

        for (int i = 1; i <= totalPoints; i++) {
            factorial *= i;
            double number = 1.0 / factorial;
            sum += number;
        }

        return sum;
    }

}
import java.util.Random;

public class GlassBridge {

    public static void main(String[] args) {
        int n = 16; // n player
        int steps = 17; // steps
        double p = 0.5;

        // Initiation
        double[][] P1 = new double[n][steps + 1];
        double[][] P2 = new double[n][steps + 1];

        // P1[s][t] is the probability that player s+1 faces n-t steps
        // P2[s][t] is the probability that player s+1 survives if they face n-t steps

        P1[0][0] = 1;

        /*
         * Calculate P1 using dynamic programming
         * It calculates the players chance to successfully face steps
         * 
         * The steps don't physically disappear, but the probabilities reflect the
         * likelihood of each player successfully navigating the remaining steps based
         * on their choices and the choices of previous players.
         */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= steps; j++) {
                for (int k = 0; k < j; k++) {
                    P1[i][j] += P1[i - 1][k] * Math.pow(p, j - k - 1) * (1 - p);
                }
            }
        }

        /*
         * Calculate P2, representing the survival probability for each player at each
         * step
         * Everytime the player steps, the survival probability gets close to 1, showing
         * they have more of a chance of surving
         */
        for (int i = 0; i <= steps; i++) {
            for (int j = 0; j < n; j++) {
                P2[j][i] = Math.pow(p, steps - i);
            }
        }

        /*
         * Random slip factor, if they slip that is the end of it, write 0 showing they
         * died
         */
        Random random = new Random();
        for (int i = 0; i <= steps; i++) {
            for (int j = 0; j < n; j++) {
                double slip = random.nextDouble();
                if (slip <= 0.15) { // 1% chance of slipping
                    P2[j][i] = 0; // Probability of survival becomes 0 if slipped
                }
            }
        }

        /*
         * P3[t] is the probability of player t+1 being the first survivor, the survival
         * chance is componded as every previous player increases the next ones survival
         * 
         * The expore more paths, uncovering the right path quicker
         */
        double[] P3 = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= steps; j++) {
                P3[i] += P1[i][j] * P2[i][j];
            }
        }

        /*
         * P_survival[t] is player t+1's cumulative survival probability in the game
         * It adds the previouses chance of survival to this ones chance of survival and
         * the chance they are the first surviver
         */
        double[] P_survival = new double[n];
        P_survival[0] = P3[0];
        for (int i = 1; i < n; i++) {
            P_survival[i] = P_survival[i - 1] + P3[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Player " + (i + 1) + " survival chance: " + Math.round(P_survival[i] * 100) + "%");
        }
    }
}

/*
 * https://www.jhelvy.com/posts/2021-10-19-monte-carlo-bridge-game/
 * https://www.asterhu.com/post/2021-11-04-squid-game-probability/
 */
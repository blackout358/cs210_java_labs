// import java.util.Random;

// public class Main {
//     public static void main(String[] args) {
//         boolean[][] glassBridge = new boolean[17][2];
//         boolean[][] map = new boolean[17][2];

//         glassBridge = generateGlassBridge(glassBridge);
//         double numberOfConstestants = 1000;
//         double numOfWins = 0;
//         for (int i = 0; i < numberOfConstestants; i++) {
//             if (glassBride(glassBridge, map)) {
//                 numOfWins++;
//             }
//         }
//         System.out.println(5 / (numOfWins - 5) * 100);
//         System.out.println(numOfWins / numberOfConstestants);
//         double result = (numOfWins / numberOfConstestants) * 100;

//         System.out.println(result);
//     }

//     public static boolean glassBride(boolean[][] glassBridge, boolean[][] map) {
//         int playerPos = 0;
//         Random rand = new Random();
//         for (int i = 0; i < 17; i++) {
//             boolean goLeft = rand.nextBoolean();
//             if (jump(glassBridge, goLeft, playerPos, map)) {
//                 playerPos++;
//                 int path = goLeft ? 0 : 1;
//                 map[i][path] = true; // Update only the chosen path
//             } else {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static boolean jump(boolean[][] glassBridge, boolean goLeft, int playerPos, boolean[][] map) {
//         int path = goLeft ? 0 : 1;
//         boolean slipping = didSlip();
//         if (slipping) {
//             return false;
//         } else if ((map[playerPos][0] || map[playerPos][1])) {
//             return true;
//         }
//         if (glassBridge[playerPos][path]) {
//             return true;
//         } else {
//             // Update the other path in the map array
//             // map[playerPos][path] = false;
//             path = path == 0 ? 1 : 0;
//             map[playerPos][path] = true;
//             return false;
//         }
//     }

//     public static boolean didSlip() {
//         Random rand = new Random();
//         double chanceToSlip = rand.nextDouble();
//         chanceToSlip = Math.round(chanceToSlip * 100.0) / 100.0;
//         return (chanceToSlip == 0.01);
//     }

//     public static boolean[][] generateGlassBridge(boolean[][] bridge) {
//         Random rand = new Random();
//         bridge = new boolean[17][2];
//         for (int i = 0; i < bridge.length; i++) {
//             boolean path = rand.nextBoolean();
//             bridge[i][0] = path;
//             bridge[i][1] = !path;
//         }
//         return bridge;
//     }

// }
public class Main {

    public static void main(String[] args) {
        String s = "13, 19, 21, 24, 18, 17, 24, 19, 16, 22, 26, 19";
        String res = s.replace(',', '+');
        res = res.replace(" ", "");
        // string

        System.out.println(res);
        System.out.println(
                (double) (13 + 19 + 21 + 24 + 18 + 17 + 24 + 19 + 16 + 22 + 26 + 19) / 12);

        // for (int i = 0; i < )
    }
}
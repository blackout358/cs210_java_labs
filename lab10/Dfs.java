import java.util.Stack;

class Brain {

    Stack<String> stacks = new Stack<String>();
    boolean[][] map = new boolean[100][100];

    int x = 50;
    int y = 50;

    public String getMove(boolean north, boolean south, boolean east, boolean west) {

        /*
         * Check if it has been around itself
         * if it has, go back one, if it hasnt, go down the new route
         */

        if (north && !map[x - 1][y]) {
            x--;
            map[x][y] = true;
            stacks.push("south");
            return "north";
        } else if (south && !map[x + 1][y]) {
            x++;
            map[x][y] = true;
            stacks.push("north");
            return "south";
        } else if (east && !map[x][y + 1]) {
            y++;
            map[x][y] = true;
            stacks.push("west");
            return "east";
        } else if (west && !map[x][y - 1]) {
            y--;
            map[x][y] = true;
            stacks.push("east");
            return "west";
        }
        /*
         * If it has explored all options, go back one, and change the x y co-ordinite
         * to match
         */

        String backup = stacks.pop();
        if (backup.equals("north")) {
            x--;
        } else if (backup.equals("south")) {
            x++;
        } else if (backup.equals("east")) {
            y++;
        } else if (backup.equals("west")) {
            y--;
        }
        return backup;

    }
}
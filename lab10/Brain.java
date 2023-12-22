import java.util.Stack;

class Bra3in {

    public int facing = 0;
    String lastMove = "";

    Stack<String> moves = new Stack<>();
    Stack<String> divergences = new Stack<>();

    public String getMove(boolean north, boolean south, boolean east, boolean west) {
        if (lastMove == null) {
            return Start(north, south, east, west);
        } else {
            return findMove(north, south, east, west);
        }
    }

    public String Start(boolean north, boolean south, boolean east, boolean west) {
        if (west) {
            moves.push("west");
            return "west";
        } else if (south) {
            moves.push("south");
            return "south";
        } else if (north) {
            moves.push("north");
            return "north";
        } else if (east) {
            moves.push("east");
            return "east";
        }
        return "-1";

    }

    // public String findMove(boolean north, boolean south, boolean east, boolean
    // west) {
    // if (north)

    // }

    public int findNumberOfPaths(boolean north, boolean south, boolean east, boolean west) {
        int count = 1;
        if (north || south || east || west) {
            count++;
        }
        if (north && south || north && east || north && west || south && west || south && east || east && west
                || north && south && east || north && south && west || north && east && west || south && east && west
                || north && south && east && west) {
            count++;
        }
        if (north && south && east || north && south && west || north && east && west || south && east && west) {
            count++;
        }
        return count;
    }

    public String getFacing() {
        switch (facing) {
            case 0:
                return "north";
            case 1:
                return "east";
            case 2:
                return "south";
            case 3:
                return "west";

            default:
                return "-1";
        }

    }

    public void turnLeft() {
        facing = (facing - 1 + 4) % 4;
    }

    public void turnRight() {
        facing = (facing + 1 + 4) % 4;
    }

    void turnAround() {
        facing = (facing + 2 + 4) % 4;
    }
}
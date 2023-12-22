import java.util.Stack;

class Bra3in {
    public Stack<String> moves = new Stack<>();
    public String lastMove;
    String[][] map = new String[2000][2000];
    int localPosX = 1000;
    int localPosY = 1000;
    boolean goBack = false;

    public String getMove(boolean north, boolean south, boolean east, boolean west) {
        mapBrain(north, south, east, west);
        if (lastMove == null) {
            // Initial move is random
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    return moveNorth();
                case 1:
                    return moveSouth();
                case 2:
                    return moveEast();
                default:
                    return moveWest();
            }
        }
        if (south && map[localPosX][localPosY + 1] != "|") {
            return moveSouth();

        } else if (west && map[localPosX - 1][localPosY] != "|") {
            return moveWest();
        } else if (north && map[localPosX][localPosY - 1] != "|") {
            return moveNorth();
        } else if (east && map[localPosX + 1][localPosY] != "|") {
            return moveEast();
        } else {
            return moveBack();
        }
        // Explore as deeply as possible before backtracking

    }

    public void mapBrain(boolean north, boolean south, boolean east, boolean west) {
        if (!north) {
            map[localPosX][localPosY - 1] = "X";
        }
        if (!south) {
            map[localPosX][localPosY + 1] = "X";
        }
        if (!east) {
            map[localPosX + 1][localPosY] = "X";
        }
        if (!west) {
            map[localPosX - 1][localPosY] = "X";
        }
    }

    private String moveNorth() {
        moves.push("south");
        localPosY--;
        map[localPosX][localPosY] = "|";
        lastMove = "north";
        return "north";
    }

    private String moveSouth() {
        localPosY++;
        map[localPosX][localPosY] = "|";
        moves.push("north");
        lastMove = "south";
        return "south";
    }

    private String moveEast() {
        localPosX++;
        map[localPosX][localPosY] = "|";
        moves.push("west");
        lastMove = "east";
        return "east";
    }

    private String moveWest() {
        localPosX--;
        map[localPosX][localPosY] = "|";
        moves.push("east");
        lastMove = "west";
        return "west";
    }

    public String moveBack() {
        if (lastMove == "north") {
            return moveSouth();
        } else if (lastMove == "south") {
            return moveNorth();
        } else if (lastMove == "east") {
            return moveWest();
        } else if (lastMove == "west") {
            return moveEast();
        }
        return "ERROR";
    }

    // public void visualiseMap() {
    // for (int i = 0; i<)
    // }
}

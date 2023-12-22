import java.util.Stack;

class Br8ain {
    public Stack<String> moves = new Stack<>();
    public String lastMove;

    public String getMove(boolean north, boolean south, boolean east, boolean west) {
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
        } else {
            // Explore as deeply as possible before backtracking
            if (north && lastMove != "south") {
                return moveNorth();
            } else if (south && lastMove != "north") {
                return moveSouth();
            } else if (east && lastMove != "west") {
                return moveEast();
            } else if (west && lastMove != "east") {
                return moveWest();
            } else {
                // Backtrack if no unexplored direction is available
                if (!moves.isEmpty()) {
                    lastMove = moves.pop();
                    return lastMove;
                }
            }
        }
        return null; // Add appropriate handling for unexpected cases
    }

    private String moveNorth() {
        moves.push("north");
        lastMove = "north";
        return "north";
    }

    private String moveSouth() {
        moves.push("south");
        lastMove = "south";
        return "south";
    }

    private String moveEast() {
        moves.push("east");
        lastMove = "east";
        return "east";
    }

    private String moveWest() {
        moves.push("west");
        lastMove = "west";
        return "west";
    }
}

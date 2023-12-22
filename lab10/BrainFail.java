class Bra2in {
    public static String lastMove;

    // this is the dumbest possible strategy - random
    public String getMove(boolean north, boolean south, boolean east, boolean west) {
        if (lastMove == null) {
            // If no last move or with a small probability, make a random move
            int random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    return "north";
                case 1:
                    return "south";
                case 2:
                    return "east";
                default:
                    return "west";
            }
        } else if (north || lastMove != "south") {
            saveLastMove("north");
            return "north";
        } else if (south || lastMove != "north") {
            saveLastMove("south");
            return "south";
        } else if (east || lastMove != "west") {
            saveLastMove("east");
            return "east";
        } else {
            saveLastMove("west");
            return "west";
        }

    }

    public static void saveLastMove(String move) {
        lastMove = move;
    }

}

class Brai2n {
    public int facing = 0;

    public String getMove(boolean north, boolean south, boolean east, boolean west) {
        return moveForward(north, south, east, west);

    }

    public String moveForward(boolean north, boolean south, boolean east, boolean west) {
        if ((north && getFacing() == "north") || (south && getFacing() == "south") || (east && getFacing() == "east")
                || (west && getFacing() == "west")) {
            // moveForward();
            return getFacing();
        } else {
            changeDirection();
            return moveForward(north, south, east, west);
        }

    }

    public void changeDirection() {
        if (facing < 3) {
            facing++;
        } else {
            facing = 0;
        }
    }

    public String getFacing() {
        switch (facing) {
            case 0:
                return "west";
            case 1:
                return "south";
            case 2:
                return "east";
            case 3:
                return "north";
            default:
                return "ERROR";
        }
    }
}

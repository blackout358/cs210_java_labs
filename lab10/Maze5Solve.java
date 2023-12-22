class Brai3n
    public int facing = 0;
    String lastMove = "";
    boolean rightHand = false;

    public String getMove(boolean north, boolean south, boolean east,
            boolean west) {
        if (lastMove == "" && north && !south && !east && west) {
            rightHand = !rightHand;
            lastMove = "ad";
        }
        return RightHandLatch(north, south, east, west);
    }

    public String RightHandLatch(boolean north, boolean south, boolean east,
            boolean west) {

        if (rightHand) {
            hitWall(north, south, east, west);

        }

        String direction = getFacing();

        /* Check aviable options */

        if (direction == "north") {
            if (east) {
                turnRight();
                return getFacing();
            }
            if (north) {
                return getFacing();
            } else {
                turnLeft();
                return RightHandLatch(north, south, east, west);
            }
        }
        if (direction == "east") {
            if (south) {
                turnRight();
                return getFacing();
            }
            if (east) {
                return getFacing();
            } else {
                turnLeft();
                return RightHandLatch(north, south, east, west);
            }
        }
        if (direction == "south") {

            if (west) {
                turnRight();
                return getFacing();
            }
            if (south) {
                return getFacing();
            } else {
                turnLeft();
                return RightHandLatch(north, south, east, west);
            }
        }
        if (direction == "west") {
            if (north) {
                turnRight();
                return getFacing();
            }
            if (west) {
                return getFacing();
            } else {
                turnLeft();
                return RightHandLatch(north, south, east, west);
            }
        }
        return "-1";
    }

    public void hitWall(boolean north, boolean south, boolean east,
            boolean west) {
        String direction = getFacing();
        if (direction == "east" && !east && north && south) {
            turnLeft();

        } else if (direction == "west" && !west && north && south) {
            turnLeft();
        } else if (direction == "north" && !north && east && west) {
            turnLeft();
        } else if (direction == "south" && !south && east && west) {
            turnLeft();
        }
    }

    // public String leftHandRule(boolean north, boolean south, boolean east,
    // boolean west) {
    // String direction = getFacing();

    // /* Check aviable options */

    // if (direction == "north") {
    // if (east && north) {
    // turnAround();
    // return leftHandRule(north, south, east, west);
    // }
    // if (east) {
    // turnLeft();
    // return getFacing();
    // }
    // if (north) {
    // return getFacing();
    // } else {
    // turnLeft();
    // return leftHandRule(north, south, east, west);
    // }
    // }
    // if (direction == "east") {
    // if (south) {
    // turnRight();
    // return getFacing();
    // }
    // if (east) {
    // return getFacing();
    // } else {
    // turnLeft();
    // return leftHandRule(north, south, east, west);
    // }
    // }
    // if (direction == "south") {
    // if (west) {
    // turnRight();
    // return getFacing();
    // }
    // if (south) {
    // return getFacing();
    // } else {
    // turnLeft();
    // return leftHandRule(north, south, east, west);
    // }
    // }
    // if (direction == "west") {
    // if (north) {
    // turnLeft();
    // return getFacing();
    // }
    // if (west) {
    // return getFacing();
    // } else {
    // turnLeft();
    // return leftHandRule(north, south, east, west);
    // }
    // }
    // return "-1";
    // }

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
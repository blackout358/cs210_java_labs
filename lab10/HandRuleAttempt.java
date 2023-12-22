class Brai2n {
    public int facing = 0;
    String lastMove = "";

    public String getMove(boolean north, boolean south, boolean east, boolean west) {
        // return rightHandRule(north, south, east, west);
        // return leftHandRule(north, south, east, west); /* Closet */
        // return leftHandOnWall(north, south, east, west);
        return leftHandRuleOnWall(north, south, east, west);
        // return rightHandOnWall(north, south, east, west);
        // return rightHandOnWall(north, south, east, west);
    }

    public String leftHandRuleOnWall(boolean north, boolean south, boolean east,
            boolean west) {
        String direction = getFacing();

        /* Check aviable options */

        if (direction == "north") {
            if (west) {
                turnLeft();
                return getFacing();
            }
            if (north) {
                return getFacing();
            } else {
                turnRight();
                return leftHandRuleOnWall(north, south, east, west);
            }
        }
        if (direction == "east") {
            if (north) {
                turnLeft();
                return getFacing();
            }
            if (east) {
                return getFacing();
            } else {
                turnRight();
                return leftHandRuleOnWall(north, south, east, west);
            }
        }
        if (direction == "south") {
            if (east) {
                turnLeft();
                return getFacing();
            }
            if (south) {
                return getFacing();
            } else {
                turnRight();
                return leftHandRuleOnWall(north, south, east, west);
            }
        }
        if (direction == "west") {
            if (south) {
                turnLeft();
                return getFacing();
            }
            if (west) {
                return getFacing();
            } else {
                turnRight();
                return leftHandRuleOnWall(north, south, east, west);
            }
        }
        return "-1";
    }

    public String leftHandOnWall(boolean north, boolean south, boolean east,
            boolean west) {
        String direction = getFacing();

        if (direction == "north" && north && !west) {
            lastMove = direction;
            return direction;
        } else if (direction == "east" && east && !north) {
            lastMove = direction;
            return direction;
        } else if (direction == "south" && south && !east) {
            lastMove = direction;
            return direction;
        } else if (direction == "west" && west && !south) {
            lastMove = direction;
            return direction;
        }

        /* Wall was there but now is gone, so go that directiona */

        if (direction == "north" && north && west) {
            lastMove = direction;
            return direction;
        } else if (direction == "east" && east && north) {
            lastMove = direction;
            return direction;
        } else if (direction == "south" && south && east) {
            lastMove = direction;
            return direction;
        } else if (direction == "west" && west && south) {
            lastMove = direction;
            return direction;
        }
        // if (lastMove == "north" && west && north) {

        // return direction;
        // }

        if (lastMove == getFacing() && north) {
            turnLeft();
            direction = getFacing();
            return direction;
        }
        if (lastMove == getFacing() && east) {
            turnLeft();
            direction = getFacing();
            return direction;
        }
        if (lastMove == getFacing() && south) {
            turnLeft();
            direction = getFacing();
            return direction;
        }

        turnLeft();
        return leftHandOnWall(north, south, east, west);

    }

    /*
     * works for maze 5
     */

    public String rightHandOnWall(boolean north, boolean south, boolean east,
            boolean west) {
        String direction = getFacing();

        if (direction == "north" && north && !east) {
            lastMove = direction;
            return direction;
        } else if (direction == "east" && east && !south) {
            lastMove = direction;
            return direction;
        } else if (direction == "south" && south && !west) {
            lastMove = direction;
            return direction;
        } else if (direction == "west" && west && !north) {
            lastMove = direction;
            return direction;
        }

        /* wall infront lets attach */
        // if ()

        /* Wall was there but now is gone, so go that directiona */

        if (lastMove == getFacing() && east) {
            turnRight();
            // turnLeft();
            direction = getFacing();
            return direction;
        }

        if (lastMove == getFacing() && south) {
            turnRight();
            // turnLeft();
            direction = getFacing();
            return direction;
        }
        if (lastMove == getFacing() && west) {
            turnRight();
            // turnLeft();
            direction = getFacing();
            return direction;
        }
        if (lastMove == getFacing() && north) {
            turnRight();
            // turnLeft();
            direction = getFacing();
            return direction;
        }
        if (direction == "north" && north && east) {
            lastMove = "north";
            return lastMove;
        }
        // } else if (direction == "east" && east && south) {
        // lastMove = "south";
        // return lastMove;
        // } else if (direction == "south" && south && west) {
        // lastMove = "west";
        // return lastMove;
        // } else if (direction == "west" && west && north) {
        // lastMove = "north";
        // return lastMove;
        // }

        // turnRight();
        turnLeft();
        return rightHandOnWall(north, south, east, west);

    }

    public String leftHandRule(boolean north, boolean south, boolean east,
            boolean west) {
        String direction = getFacing();

        /* Check aviable options */

        if (direction == "north") {
            if (east && north) {
                turnAround();
                return leftHandRule(north, south, east, west);
            }
            if (east) {
                turnLeft();
                return getFacing();
            }
            if (north) {
                return getFacing();
            } else {
                turnLeft();
                return leftHandRule(north, south, east, west);
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
                return leftHandRule(north, south, east, west);
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
                return leftHandRule(north, south, east, west);
            }
        }
        if (direction == "west") {
            if (north) {
                turnLeft();
                return getFacing();
            }
            if (west) {
                return getFacing();
            } else {
                turnLeft();
                return leftHandRule(north, south, east, west);
            }
        }
        return "-1";
    }

    public String rightHandRule(boolean north, boolean south, boolean east,
            boolean west) {
        String direction = getFacing();

        /* Check aviable options */

        if (direction == "north") {
            if (west) {
                turnLeft();
                return getFacing();
            }
            if (north) {
                return getFacing();
            } else {
                turnRight();
                return rightHandRule(north, south, east, west);
            }
        }
        if (direction == "east") {
            if (north) {
                turnLeft();
                return getFacing();
            }
            if (east) {
                return getFacing();
            } else {
                turnRight();
                return rightHandRule(north, south, east, west);
            }
        }
        if (direction == "south") {
            if (east) {
                turnLeft();
                return getFacing();
            }
            if (south) {
                return getFacing();
            } else {
                turnLeft();
                return rightHandRule(north, south, east, west);
            }
        }
        if (direction == "west") {
            if (south) {
                turnLeft();
                return getFacing();
            }
            if (west) {
                return getFacing();
            } else {
                turnRight();
                return rightHandRule(north, south, east, west);
            }
        }
        return "-1";

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
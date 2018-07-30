package javalesson.stepic;

public class RobotGame {
    public static void main(String[] args) {
        Robot robot = new Robot();
        moveRobot(robot, 5, 5);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();
        Direction direction = robot.getDirection();

        switch (direction) {
            case UP: {
                if (x < toX) {
                    robot.turnRight();
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnLeft();
                    } else {
                        robot.turnRight();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                } else {
                    robot.turnLeft();
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnRight();
                    } else {
                        robot.turnLeft();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                }
                break;
            }
            case RIGHT: {
                if (x < toX) {
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnLeft();
                    } else {
                        robot.turnRight();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                } else {
                    robot.turnLeft();
                    robot.turnLeft();
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnRight();
                    } else {
                        robot.turnLeft();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                }
                break;
            }
            case DOWN: {
                if (x < toX) {
                    robot.turnLeft();
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnLeft();
                    } else {
                        robot.turnRight();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                } else {
                    robot.turnRight();
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnRight();
                    } else {
                        robot.turnLeft();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                }
                break;
            }
            case LEFT: {
                if (x < toX) {
                    robot.turnLeft();
                    robot.turnLeft();
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnLeft();
                    } else {
                        robot.turnRight();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                } else {
                    while (x != toX) {
                        x++;
                        robot.stepForward();
                    }
                    if (y < toY) {
                        robot.turnRight();
                    } else {
                        robot.turnLeft();
                    }
                    while (y != toY) {
                        y++;
                        robot.stepForward();
                    }
                }
                break;
            }
        }
    }
}


class Robot {
    int x = 0;
    int y = 0;
    Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        System.out.println("Поворот против часовой стрелки");
        if (direction == Direction.DOWN) {
            this.direction = Direction.RIGHT;
            return;
        }

        if (direction == Direction.UP) {
            this.direction = Direction.LEFT;
            return;
        }

        if (direction == Direction.LEFT) {
            this.direction = Direction.DOWN;
            return;
        }

        if (direction == Direction.RIGHT) {
            this.direction = Direction.UP;
            return;
        }
    }

    public void turnRight() {
        System.out.println("поворот по часовой стрелке");
        if (this.direction == Direction.DOWN) {
            System.out.println("Вниз -> влево");
            this.direction = Direction.LEFT;
            return;
        }

        if (this.direction == Direction.UP) {
            System.out.println("Вверх -> вправо");
            this.direction = Direction.RIGHT;
            return;
        }

        if (this.direction == Direction.LEFT) {
            System.out.println("Влево -> вверх");
            this.direction = Direction.UP;
            return;
        }

        if (this.direction == Direction.RIGHT) {
            System.out.println("Вправо -> вниз");
            this.direction = Direction.DOWN;
            return;
        }
    }

    public void stepForward() {
        System.out.println("движение");
        if (direction == Direction.DOWN) {
            System.out.println("вниз");
            this.y--;
        }

        if (direction == Direction.UP) {
            System.out.println("вверх");
            this.y++;
        }

        if (direction == Direction.LEFT) {
            System.out.println("налево");
            this.x--;
        }

        if (direction == Direction.RIGHT) {
            System.out.println("направо");
            this.x++;
        }
    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}
//    public static void moveRobot(Robot robot, int toX, int toY) {
//        int x = robot.getX();
//        int y = robot.getY();
//        Direction direction = robot.getDirection();
//        switch (direction) {
//            case RIGHT: {
//                robot.turnLeft();
//                break;
//            }
//            case DOWN: {
//                robot.turnLeft();
//                robot.turnLeft();
//                break;
//            }
//            case LEFT: {
//                robot.turnRight();
//                break;
//            }
//        }
//        if (x == toX && y < toY) {
//            while (y != toY) {
//                y++;
//                robot.stepForward();
//            }
//        }
//        if (x < toX && y < toY) {
//            while (y != toY) {
//                y++;
//                robot.stepForward();
//            }
//            robot.turnRight();
//            while (x != toX) {
//                x++;
//                robot.stepForward();
//            }
//        }
//        if (x < toX && y == toY) {
//            robot.turnRight();
//            while (x != toX) {
//                x++;
//                robot.stepForward();
//            }
//        }
//        if (x < toX && y > toY) {
//            robot.turnRight();
//            while (x != toX) {
//                x++;
//                robot.stepForward();
//            }
//            robot.turnRight();
//            while (y != toY) {
//                y--;
//                robot.stepForward();
//            }
//        }
//        if (x == toX && y > toY) {
//            robot.turnRight();
//            robot.turnRight();
//            while (y != toY) {
//                y--;
//                robot.stepForward();
//            }
//        }
//        if (x > toX && y > toY) {
//            robot.turnLeft();
//            while (x != toX) {
//                x--;
//                robot.stepForward();
//            }
//            robot.turnLeft();
//            while (y != toY) {
//                y--;
//                robot.stepForward();
//            }
//        }
//        if (x > toX && y == toY) {
//            robot.turnLeft();
//            while (x != toX) {
//                x--;
//                robot.stepForward();
//            }
//        }
//        if (x > toX && y < toY) {
//            while (y != toY) {
//                y++;
//                robot.stepForward();
//            }
//            robot.turnLeft();
//            while (x != toX) {
//                x--;
//                robot.stepForward();
//            }
//        }
//    }

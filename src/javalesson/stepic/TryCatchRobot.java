package javalesson.stepic;

import java.util.logging.Level;

public class TryCatchRobot {
    public static void main(String[] args) {

    }
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean connect = false;
        for (int i = 0; !connect  && (i < 3); i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                connect = true;
            } catch (RobotConnectionException e) {
                e.getMessage();
            }
        }
        if (!connect) {
            throw new RobotConnectionException("3 attempts failed");
        }
    }
}
interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
interface RobotConnectionManager {
    RobotConnection getConnection();
}
class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);
    }
    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}

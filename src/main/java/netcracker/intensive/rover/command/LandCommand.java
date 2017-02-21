package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class LandCommand implements RoverCommand {

    Rover rover;
    Point position;
    Direction direction;

    public LandCommand(Rover rover, Point position, Direction direction) {
        this.rover = rover;
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void execute() {
        rover.land(position, direction);
    }

    @Override
    public String toString() {
        return "Land at " + position.toString() + " heading " + direction.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LandCommand that = (LandCommand) o;

        if (rover != null ? !rover.equals(that.rover) : that.rover != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        return direction == that.direction;

    }

    @Override
    public int hashCode() {
        int result = rover != null ? rover.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}

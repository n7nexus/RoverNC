package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class TurnCommand implements RoverCommand {

    Rover rover;
    Direction direction;

    public TurnCommand(Rover rover, Direction direction) {
        this.rover = rover;
        this.direction = direction;
    }

    @Override
    public void execute() {
        rover.turnTo(direction);
    }

    @Override
    public String toString() {
        return "Heading " + direction.name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TurnCommand that = (TurnCommand) o;

        if (rover != null ? !rover.equals(that.rover) : that.rover != null) return false;
        return direction == that.direction;

    }

    @Override
    public int hashCode() {
        int result = rover != null ? rover.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}

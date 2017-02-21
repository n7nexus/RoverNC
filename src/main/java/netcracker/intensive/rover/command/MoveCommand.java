package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class MoveCommand implements RoverCommand {

    Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.move();
    }

    @Override
    public String toString() {
        return "Rover moved";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoveCommand that = (MoveCommand) o;

        return rover != null ? rover.equals(that.rover) : that.rover == null;

    }

    @Override
    public int hashCode() {
        return rover != null ? rover.hashCode() : 0;
    }
}

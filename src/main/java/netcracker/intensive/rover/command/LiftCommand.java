package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;

public class LiftCommand implements RoverCommand {
    Rover rover;
    public LiftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.lift();
    }

    @Override
    public String toString() {
        return "Rover lifted";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiftCommand that = (LiftCommand) o;

        return rover != null ? rover.equals(that.rover) : that.rover == null;

    }

    @Override
    public int hashCode() {
        return rover != null ? rover.hashCode() : 0;
    }
}

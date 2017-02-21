package netcracker.intensive.rover.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCommand implements RoverCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingCommand.class);

    private RoverCommand command;

    public LoggingCommand(RoverCommand command) {
        this.command = command;
    }


    @Override
    public void execute() {
        command.execute();
        LOGGER.debug(command.toString());
    }

    @Override
    public String toString() {
        return command.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoggingCommand that = (LoggingCommand) o;

        return command != null ? command.equals(that.command) : that.command == null;

    }

    @Override
    public int hashCode() {
        return command != null ? command.hashCode() : 0;
    }
}

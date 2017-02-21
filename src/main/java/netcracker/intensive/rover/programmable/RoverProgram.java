package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.util.*;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";
    private Map<String, Object> settings;
    private Collection<RoverCommand> commands;

    public RoverProgram() {
        this.settings = new HashMap<>();
        this.commands = new ArrayList<>();
    }

    public void setSettings(String option, boolean value){
        settings.put(option, value);
    }

    public void addCommand(RoverCommand command){
        commands.add(command);
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public Collection<RoverCommand> getCommands() {
        return commands;
    }
}

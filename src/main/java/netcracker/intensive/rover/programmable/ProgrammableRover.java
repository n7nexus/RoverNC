package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.stats.RoverStatsModule;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import javax.naming.directory.Attribute;
import java.util.Collections;
import java.util.Map;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover implements ProgramFileAware{

    private RoverCommandParser parser;
    private RoverStatsModule statsModule;
    //private Attribute settings;

    public ProgrammableRover(GroundVisor groundVisor, RoverStatsModule roverStatsModule) {
        super(groundVisor);
        this.statsModule = roverStatsModule;
    }

    @Override
    public void executeProgramFile(String path) {
        parser = new RoverCommandParser(this, path);
        for(RoverCommand c: parser.getProgram().getCommands()) {
            c.execute();
            if((boolean) parser.getProgram().getSettings().get(RoverProgram.STATS)) {
                statsModule.registerPosition(getCurrentPosition());
            }
        }
    }

    public Map<String, Object> getSettings() {
        Map<String, Object> settings = Collections.unmodifiableMap(parser.getProgram().getSettings());
        return settings;
        //return parser.getProgram().getSettings();
    }
}

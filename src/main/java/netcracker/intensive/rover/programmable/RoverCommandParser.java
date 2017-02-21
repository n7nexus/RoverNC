package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.*;
import netcracker.intensive.rover.constants.Direction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RoverCommandParser {

    private RoverProgram program;
    private Rover rover;
    //private String filename;

    private BufferedReader reader;

    private RoverCommand CmdLog(RoverCommand command, boolean log) {
        if(log) {
            return new LoggingCommand(command);
        }
        return command;
    }

    public RoverCommandParser(Rover rover, String file) {
        this.rover = rover;
        boolean log = false;
        //this.filename = file;
        this.program = new RoverProgram();
        try {
            if(this.getClass().getResource(file) == null) {
                throw new RoverCommandParserException();
            }

            String rscPath = this.getClass().getResource(file).getFile();
            reader = new BufferedReader(new FileReader(rscPath));
            String tmp;
            RoverCommand command;
            while( (tmp = reader.readLine()) != null) {
                String[] cmd = tmp.split(" ");
                switch (cmd[0]) {
                    case RoverProgram.LOG:
                        log = cmd[1].equals("on");
                        program.setSettings(RoverProgram.LOG, log);
                        break;
                    case RoverProgram.STATS:
                        program.setSettings(RoverProgram.STATS, cmd[1].equals("on"));
                        break;
                    case RoverProgram.SEPARATOR:
                        break;
                    case "turn":
                        command = new TurnCommand(rover, Direction.valueOf(cmd[1].toUpperCase()));
                        program.addCommand(CmdLog(command, log));
                        break;
                    case "move":
                        command = new MoveCommand(rover);
                        program.addCommand(CmdLog(command, log));
                        break;
                    case "lift":
                        command = new LiftCommand(rover);
                        program.addCommand(CmdLog(command, log));
                        break;
                    case "land":
                        command =  new LandCommand(rover, new Point(Integer.parseInt(cmd[1]),Integer.parseInt(cmd[2])), Direction.valueOf(cmd[3].toUpperCase()));
                        program.addCommand(CmdLog(command, log));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RoverCommandParserException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public RoverProgram getProgram() throws RoverCommandParserException{

        return program;
    }
}

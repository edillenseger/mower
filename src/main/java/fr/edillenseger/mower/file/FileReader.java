package fr.edillenseger.mower.file;

import fr.edillenseger.mower.instructions.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileReader {

    private static Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    public Instructions readFromResourcesFolder(String fileName) throws URISyntaxException, IOException {
        LOGGER.info("Reading file from resources folder : " + fileName);
        URI uri = getClass().getClassLoader().getResource(fileName).toURI();
        return readFromUri(uri);
    }

    public Instructions readFromUri(URI uri) throws IOException {
        LOGGER.info("Reading file from URI : " + uri.toString());
        List<String> instructionsLines = Files.readAllLines(Paths.get(uri), StandardCharsets.UTF_8);
        return read(instructionsLines);
    }

    private Instructions read(List<String> instructionsLines) {
        if(instructionsLines != null && !instructionsLines.isEmpty()){
            Instructions instructions = new Instructions();
            instructions.maxCoordinates = getCoordinates(instructionsLines.get(0));
            for(int i = 1; i < instructionsLines.size(); i = i+2){
                if(i < instructionsLines.size() - 1){
                    instructions.addMowerInstructions(getMowerInstructions(instructionsLines.get(i), instructionsLines.get(i+1)));
                } else {
                    LOGGER.warning("Missing line instruction for mower at line " + i);
                }
            }
            return instructions;
        } else {
            LOGGER.warning("No instructions to read");
            return null;
        }
    }

    private MowerInstructions getMowerInstructions(String startPosition, String movements){
        if(startPosition.matches("^\\d \\d [NEWS]$")
            && movements.matches("^[LRF][LRF]*$")){
            MowerInstructions mowerInstructions = new MowerInstructions();
            mowerInstructions.initialCoordinates = getCoordinates(startPosition);
            mowerInstructions.initialOrientation = getOrientation(startPosition);
            mowerInstructions.movements = getMovements(movements);
            return mowerInstructions;
        } else {
            LOGGER.warning("Invalid mower-instructions pattern [startPosition:" + startPosition + "/movements:" + movements + "]");
            return null;
        }
    }

    private List<Movement> getMovements(String line){
        List<Movement> movements = new ArrayList<>();
        if(line.matches("^[LRF][LRF]*$")){
            char[] split = line.toCharArray();
            for(char movement : split){
                movements.add(Movement.valueOf(String.valueOf(movement)));
            }
        } else {
            LOGGER.warning( "Invalid movements pattern [" + line + "]");
        }
        return movements;
    }

    private Orientation getOrientation(String line){
        if(line.matches("^\\d \\d( [NEWS])?$")){
            String[] split = line.split(" ");
            return Orientation.valueOf(split[2]);
        } else {
            LOGGER.warning( "Invalid orientation pattern [" + line + "]");
            return null;
        }
    }

    private Coordinates getCoordinates(String line) {
        if(line.matches("^\\d \\d [NEWS]?$")){
            String[] split = line.split(" ");
            return new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        } else {
            LOGGER.warning( "Invalid coordinates pattern [" + line + "]");
            return null;
        }
    }
}

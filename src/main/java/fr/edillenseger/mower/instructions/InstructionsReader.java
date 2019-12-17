package fr.edillenseger.mower.instructions;

import fr.edillenseger.mower.Mower;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InstructionsReader {

    private static Logger LOGGER = Logger.getLogger(InstructionsReader.class.getName());

    public Instructions readInstructions(String fileName){
        LOGGER.info("Reading file " + fileName);
        try {
            URI uri = getClass().getClassLoader().getResource(fileName).toURI();
            List<String> instructionsLines = Files.readAllLines(Paths.get(uri), StandardCharsets.UTF_8);
            Instructions instructions = new Instructions();
            instructions.maxCoordinates = getMaxCoordinates(instructionsLines.get(0));
            for(int i = 1; i < instructionsLines.size(); i = i+2){
                instructions.addMower(getMowerInstructions(instructionsLines.get(i), instructionsLines.get(i+1)));
                //todo vérifier si on a bien les deux lignes
            }
            return instructions;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Exception occurs while reading the file", e);
        } catch (URISyntaxException e) {
            LOGGER.log(Level.SEVERE, "Exception occurs while getting uri of the file", e);
        }
        return null;
    }

    private Mower getMowerInstructions(String lineStartingPosition, String lineInstructions){
        Mower mower = new Mower();
        if(lineStartingPosition.matches("^\\d \\d [NEWS]$")){
            String[] split = lineStartingPosition.split(" ");
            mower.coordinates = new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
            mower.orientation = Orientation.valueOf(split[2]);
        }//TODO gestion erreur
        mower.movements = new ArrayList<>();
        if(lineInstructions.matches("^[LRF]*$")){
            char[] split = lineInstructions.toCharArray();
            for(char movement : split){
                mower.movements.add(Movement.valueOf(String.valueOf(movement)));
            }
        }//TODO gestion erreur
        return mower;
    }

    private Coordinates getMaxCoordinates(String line){
        if(line.matches("^\\d \\d$")){
            String[] split = line.split(" ");
            return new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
        } else {
            LOGGER.log(Level.SEVERE, "Can not read coordinates from instructions file");
            //TODO exception
            return null;
        }
    }
}

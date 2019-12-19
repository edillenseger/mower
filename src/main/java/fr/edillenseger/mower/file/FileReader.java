package fr.edillenseger.mower.file;

import fr.edillenseger.mower.exceptions.*;
import fr.edillenseger.mower.instructions.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileReader {

    private static Logger LOGGER = Logger.getLogger(FileReader.class.getName());
    private static String MAX_COORDINATES_REGEX = "^\\d \\d$";
    private static String MOWER_COORDINATES_REGEX = "^\\d \\d [NEWS]$";
    private static String MOWER_MOVEMENTS_REGEX = "^[LRF]+$";

    public InstructionsFile readFromResourcesFolder(String fileName) throws URISyntaxException, IOException, MowerArgumentException {
        LOGGER.info("Reading file from resources folder : " + fileName);
        URL url = getClass().getClassLoader().getResource(fileName);
        if(url == null){
            throw new MissingFileException();
        }
        return readFile(Paths.get(url.toURI()));
    }

    public InstructionsFile readFromFilePath(String filePath) throws IOException, MowerArgumentException {
        LOGGER.info("Reading file from file path : " + filePath);
        return readFile(Path.of(filePath));
    }

    private InstructionsFile readFile(Path path) throws IOException, MowerArgumentException {
        List<String> instructionsLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return getInstructions(instructionsLines);
    }

    private InstructionsFile getInstructions(List<String> instructionsLines) throws MowerArgumentException {
        if(instructionsLines == null || instructionsLines.isEmpty()){
            throw new EmptyFileException();
        }
        String maxCoordinatesLine = instructionsLines.get(0);
        if (!maxCoordinatesLine.matches(MAX_COORDINATES_REGEX)) {
            throw new MalFormedLineException("Invalid max coordinates pattern [" + maxCoordinatesLine + "]");
        }
        InstructionsFile instructionsFile = new InstructionsFile();
        instructionsFile.setMaxCoordinates(getCoordinates(maxCoordinatesLine));
        instructionsFile.addAllMowerInstructions(getAllMowerInstructions(instructionsLines));
        return instructionsFile;
    }

    private List<MowerInstructions> getAllMowerInstructions(List<String> instructionsLines) throws MissingLineException, MalFormedLineException {
        List<MowerInstructions> mowerInstructionsList = new ArrayList<>();
        for(int i = 1; i < instructionsLines.size(); i = i+2){
            if(i >= instructionsLines.size() - 1){
                throw new MissingLineException("Missing line instruction for mower at line " + i);
            }
            MowerInstructions mowerInstructions = getMowerInstructions(instructionsLines.get(i), instructionsLines.get(i+1));
            mowerInstructionsList.add(mowerInstructions);
        }
        return mowerInstructionsList;
    }

    private MowerInstructions getMowerInstructions(String startPosition, String movements) throws MalFormedLineException {
        if (!startPosition.matches(MOWER_COORDINATES_REGEX) || !movements.matches(MOWER_MOVEMENTS_REGEX)) {
            throw new MalFormedLineException("Invalid movements instructions [" + startPosition + "/" + movements + "]");
        }
        MowerInstructions mowerInstructions = new MowerInstructions();
        mowerInstructions.initialCoordinates = getCoordinates(startPosition);
        mowerInstructions.initialOrientation = getOrientation(startPosition);
        mowerInstructions.movements = getMovements(movements);
        return mowerInstructions;
    }

    private List<Movement> getMovements(String line) {
        List<String> split = line.chars().mapToObj(value -> String.valueOf((char)value)).collect(Collectors.toList());
        return split.stream().map(Movement::valueOf).collect(Collectors.toList());
    }

    private Orientation getOrientation(String line) {
        String[] split = line.split(" ");
        return Orientation.valueOf(split[2]);
    }

    private Coordinates getCoordinates(String line) {
        String[] split = line.split(" ");
        return new Coordinates(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}

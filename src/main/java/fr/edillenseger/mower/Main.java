package fr.edillenseger.mower;

import fr.edillenseger.mower.exceptions.*;
import fr.edillenseger.mower.file.*;
import fr.edillenseger.mower.instructions.InstructionsFile;
import fr.edillenseger.mower.instructions.InstructionsRunner;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String args[]) throws IOException, URISyntaxException, MowerArgumentException {
        FileReader fileReader = new FileReader();
        InstructionsFile instructionsFile = fileReader.readFromResourcesFolder("instructions.txt");
        InstructionsRunner instructionsRunner = new InstructionsRunner();
        instructionsRunner.execute(instructionsFile);
    }
}

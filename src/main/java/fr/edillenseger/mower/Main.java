package fr.edillenseger.mower;

import fr.edillenseger.mower.instructions.Instructions;
import fr.edillenseger.mower.instructions.InstructionsReader;
import fr.edillenseger.mower.instructions.InstructionsRunner;

public class Main {

    public static void main(String args[]) {
        InstructionsReader instructionsReader = new InstructionsReader();
        Instructions instructions = instructionsReader.readInstructions("instructions.txt");
        InstructionsRunner instructionsRunner = new InstructionsRunner();
        instructionsRunner.execute(instructions);
    }
}

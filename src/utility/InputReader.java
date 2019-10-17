package utility;

import java.util.Scanner;

/**
 * utilities.InputReader reads typed text input from the standard text terminal.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */
public class InputReader {
    private Scanner reader;

    /**
     * Create a InputReader that reads text from the text terminal.
     */
    public InputReader() {
        reader = new Scanner(System.in);
    }


    /**
     * Reads user input from the terminal.
     */
    public String readInput() {
        // print prompt
        System.out.print(">> ");

        return reader.nextLine().trim();
    }

    /**
     * To allow user to see last message displayed.
     * Prints a message and waits for user to input an Enter command.
     */
    public void printReturnCommand() {
        System.out.println(">> Press Enter to return to previous menu.");
        readInput();
    }
}
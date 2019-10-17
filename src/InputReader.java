import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */
public class InputReader {
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader() {
        reader = new Scanner(System.in);
    }


    /**
     * Reads user input.
     */
    public String getUserInput() {
        // print prompt
        System.out.print(">> ");

        return reader.nextLine().trim();
    }
}
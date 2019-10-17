package menu;

/**
 * A class representing shared characteristics of Menus in the application.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */
public abstract class Menu {
    private InputReader inputReader;

    /**
     * Constructor of Menu class.
     * Creates a scanner.
     */
    public Menu() {
        inputReader = new InputReader();
    }

    /**
     * Print out the menu for the user.
     */
    abstract public void printMenu();

    /**
     * Given a input in the menu, process it.
     */
    abstract public boolean processMenu();

    /**
     * Display invalid command message.
     */
    protected void printInvalidCommand() {
        System.out.println("You typed an invalid command. Press Enter to continue.");
        System.out.println(">> ");
        getInput();
    }

    /**
     * To allow user to see last message displayed.
     * Prints a message and waits for user to input an Enter command.
     */
    protected void printReturnToMenu() {
        System.out.println(">> Press Enter to return to previous menu.");
        getInput();
    }

    /**
     * Reads user input.
     */
    protected String getInput() {
        return inputReader.getInput();
    }
}

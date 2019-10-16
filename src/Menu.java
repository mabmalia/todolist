import java.util.Scanner;

/**
 * A class representing shared characteristics of Menus.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */
public abstract class Menu {
    private Scanner reader;
    private ToDoList currentTasks;

    /**
     * Create a todo list and an input reader.
     */
    public Menu() {
        currentTasks = new ToDoList();
        reader = new Scanner(System.in);
    }

    /**
     * Print out the menu for the user.
     */
    abstract public void printMenu();

    /**
     * Given a input in the menu, process it.
     * @return true if the input ends the application, false otherwise.
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
     * Prints a message and waits for user to input an enter.
     */
    protected void printReturnToMenu() {
        System.out.println(">> Press enter to return to previous menu.");
        getInput();
    }

    /**
     * Reads user input.
     */
    protected String getInput() {
        // print prompt
        System.out.print(">> ");

        return reader.nextLine().trim();
    }

    /**
     * Saves current to do list in the File.
     */
    protected void saveToDoList() {
        currentTasks.insertTasksToFile();
    }

    /**
     * Count tasks by status.
     * @param status of the task.
     * @return number of tasks done or in progress.
     */
    protected long countsTasks(boolean status) {
        return currentTasks.countTasksByStatus(status);
    }
}

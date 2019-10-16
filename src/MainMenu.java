/**
 * A class representing the Main Menu of the application.
 * Extends Menu class.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */
public class MainMenu extends Menu {

    /**
     * Constructor of the class.
     */
    public MainMenu() {
        super();
    }

    /**
     * Print out the main menu for the user.
     */
    public void printMenu() {
        System.out.println(">> You have " + countsTasks(false) + " tasks todo and "
                                            + countsTasks(true) +" tasks done.");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">> ");
    }

    /**
     * Given a input in the main menu, process it.
     * @return true If the input ends the application, false otherwise.
     */
    public boolean processMenu() {
        boolean wantToQuit = false;

        switch (getInput()) {
            case "1":
                //showTaskInput();
                break;

            case "2":
                //addTaskInput();
                break;

            case "3":
                //editTaskInput();
                break;

            case "4":
                saveToDoList();
                wantToQuit = true;
                break;
            default:
                printInvalidCommand();
                break;
        }
        return wantToQuit;
    }
}

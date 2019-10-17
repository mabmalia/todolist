package menu;

/**
 * A class representing the Main Menu of the application.
 * Extends Menu class.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */
public class MainMenu extends Menu {
    private int numberTasksDone;
    private int numberTasksInProgress;

    /**
     * Constructor of the MainMenu class.
     * Creates a to do list
     */
    public MainMenu(int numberTasksDone, int numberTasksInProgress) {
        super();
        this.numberTasksDone = numberTasksDone;
        this.numberTasksInProgress = numberTasksInProgress;
    }

    /**
     * Print out the main menu for the user.
     */
    public void printMenu() {
        System.out.println(">> You have " + numberTasksInProgress + " tasks todo and "
                                            + numberTasksDone +" tasks done.");
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

        //print main menu
        printMenu();

        switch (getInput()) {
            case "1":
                Menu showMenu = new ShowMenu();
                showMenu.processMenu();
                break;

            case "2":
                //addTaskInput();
                break;

            case "3":
                //editTaskInput();
                break;

            case "4":
                wantToQuit = true;
                break;
            default:
                printInvalidCommand();
                break;
        }
        return wantToQuit;
    }
}

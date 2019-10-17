package menu;

/**
 * A class representing the Show Menu of the application.
 * Extends Menu class.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */

public class ShowMenu extends Menu{

    /**
     * Constructor of the ShowMenu class.
     */

    public ShowMenu() {
        super();
    }

    /**
     * Print out the show menu for the user.
     */

    public void printMenu() {
        System.out.println(">> Pick an option:");
        System.out.println(">> (0) Return to main menu");
        System.out.println(">> (1) Sort by project");
        System.out.println(">> (2) Sort by due date");
        System.out.println(">> ");
    }

    /**
     * Sequence of actions that allows the user to see the todo list,
     * sorted by date or project.
     */

    public boolean processMenu(){
        //exit method if the todo list is empty
        if(getListSize() == 0){
            System.out.println(">> The todo list is empty.");
            //For users to see the last message before returning to main menu
            printReturnToMenu();
            return false;
        }

        boolean wantToQuit = false;

        while(!wantToQuit) {

            //print menu with show list options
            printMenu();

            switch (getInput()) {
                case "0":
                    wantToQuit = true;
                    break;

                case "1":
                    currentTasks.sortTasksByProject();
                    printReturnToMenu();
                    wantToQuit = true;
                    break;

                case "2":
                    currentTasks.sortTasksByDate();
                    printReturnToMenu();
                    wantToQuit = true;
                    break;

                default:
                    printInvalidCommand();
                    break;
            }
        }
        return true;
    }
}


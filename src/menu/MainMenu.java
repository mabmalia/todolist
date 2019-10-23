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
     * Creates to fields to count the number of tasks done and in progress.
     */
    public MainMenu() {
        super();
        this.numberTasksDone = 0;
        this.numberTasksInProgress = 0;
    }

    /**
     * Constructor of the MainMenu class.
     * @param numberTasksDone number of tasks done.
     * @param numberTasksInProgress number of tasks in progress.
     */
    public void updateCounters(int numberTasksDone, int numberTasksInProgress) {
        this.numberTasksDone = numberTasksDone;
        this.numberTasksInProgress = numberTasksInProgress;
    }

    /**
     * Go to Show or Edit menu if the todo list has items.
     * @return code that translates user input in show menu.
     */
    public String showMenuIfNotEmpty(String menuOption) {
        if((numberTasksDone + numberTasksInProgress) == 0){
            System.out.println(">> The todo list is empty.");
            //For users to see the message before returning to main menu
            printReturnToMenu();
            return MenuOptionCode.RETURN;
        }

        String command = MenuOptionCode.RETURN;
        switch (menuOption){
            case "1":
                Menu showMenu = new ShowMenu();
                command = showMenu.processMenu();
                break;

            case "3":
                Menu editMenu = new EditMenu();
                command = editMenu.processMenu();
                break;
        }

        return command;
    }

    /**
     * Print out the main menu for the user.
     */
    public void printMenu() {
        System.out.println(">> You have " + numberTasksInProgress + " tasks todo and "
                                                + numberTasksDone + " tasks done.");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">> ");
    }

    /**
     * Given a input in the main menu, process it.
     * @return user input.
     */
    public String processMenu() {
        String userInput = MenuOptionCode.RETURN;

        boolean quitMenu = false;

        while(!quitMenu) {

            //print main menu
            printMenu();

            switch (getInput()) {
                case "1":
                    userInput = showMenuIfNotEmpty("1");
                    quitMenu = true;
                    break;

                case "2":
                    userInput = MenuOptionCode.ADD;
                    quitMenu = true;
                    break;

                case "3":
                    userInput = showMenuIfNotEmpty("3");
                    quitMenu = true;
                    break;

                case "4":
                    userInput = MenuOptionCode.QUIT;
                    quitMenu = true;
                    break;

                default:
                    printInvalidCommand();
                    break;
            }
        }
        return userInput;
    }
}

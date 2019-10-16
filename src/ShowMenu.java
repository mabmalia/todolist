/**
 * A class representing the Show Menu of the application.
 * Extends Menu class.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 *//*

public class ShowMenu extends Menu{

    */
/**
     * Constructor of the class.
     *//*

    public ShowMenu() {
        super();
    }

    */
/**
     * Print out the show menu for the user.
     *//*

    public void printMenu() {
        System.out.println(">> Pick an option:");
        System.out.println(">> (0) Return to main menu");
        System.out.println(">> (1) Sort by project");
        System.out.println(">> (2) Sort by due date");
        System.out.println(">> ");
    }

    */
/**
     * Sequence of actions that allows user to show the todo list.
     *//*

    public void processMenu(){

        //exit method if the todo list is empty
        if(currentTasks.getListSize() == 0){
            System.out.println(">> The todo list is empty.");
            //For users to see the last message before returning to main menu
            printReturnToMenu();
            return;
        }

        boolean wantToQuit = false;

        while(!wantToQuit) {

            //print show task list options
            printShowMenu();

            switch (reader.getInput()) {
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
    }
}
*/

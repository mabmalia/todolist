package menu;

/**
 * A class representing the Edit Menu of the application.
 * Extends Menu class.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 */

public class EditMenu extends Menu {

    /**
     * Constructor of the EditMenu class.
     */
    public EditMenu() {
        super();
    }

    /**
     * Print out the edit menu for the user.
     */
    public void printMenu(){
        System.out.println(">> Pick an option:");
        System.out.println(">> (0) Return to main menu");
        System.out.println(">> (1) Edit task details");
        System.out.println(">> (2) Mark task as done");
        System.out.println(">> (3) Remove task");
    }

    /**
     * Sequence of actions that allows user to edit a task.
     * @return user input.
     */
    public String processMenu(){
        String userInput = MenuOptionCode.RETURN;

        boolean quitMenu = false;

        while(!quitMenu) {

            //print edit menu
            printMenu();

            switch (getInput()) {
                case "0":
                    userInput = MenuOptionCode.RETURN;
                    quitMenu = true;
                    break;

                case "1":
                    userInput = MenuOptionCode.EDIT;
                    quitMenu = true;
                    break;

                case "2":
                    userInput = MenuOptionCode.DONE;
                    quitMenu = true;
                    break;

                case "3":
                    userInput = MenuOptionCode.REMOVE;
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

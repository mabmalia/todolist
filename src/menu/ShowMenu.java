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
     * @return user input.
     */
    public String processMenu(){
        String userInput = OptionCode.RETURN.toString();

        boolean quitMenu = false;

        while(!quitMenu) {

            //print show menu
            printMenu();

            switch (getInput()) {
                case "0":
                    userInput = OptionCode.RETURN.toString();
                    quitMenu = true;
                    break;

                case "1":
                    userInput = OptionCode.SHOW_BY_PROJECT.toString();
                    quitMenu = true;
                    break;

                case "2":
                    userInput = OptionCode.SHOW_BY_DATE.toString();
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


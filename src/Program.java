import menu.MainMenu;
import menu.Menu;
/**
 *  This class is the main class of the MyToDo application.
 *  MyToDo is a very simple, text based todo list application.
 *
 *  Users can create new tasks, assign them a title and due date,
 *  and choose a project for that task to belong to.
 *  Users can also edit, mark as done or remove tasks.
 *
 *  The application saves the current task list to file when the user quits,
 *  and then restarts with the former state restored.
 *
 * @author  Miguel Mália
 * @version 2019.10.06
 */

public class Program {
    private ToDoList currentTasks;

    /**
     * Constructor of Program class.
     * Creates a new Main Menu.
     */
    public Program() {
        currentTasks = new ToDoList();
    }

    /**
     *  Main routine. Loops until user quits the application.
     */
    public void routine() {
        //prints welcome message
        System.out.println(">> Welcome to MyToDo!");

        /*
         Start the main application loop. Repeatedly read commands and
         execute them until the user quits the application.
         */
        boolean finished = false;
        while (! finished) {

            //creates a menu view and inserts the list status in it to be displayed
            Menu mainMenu = new MainMenu(currentTasks.countTasksByStatus(false), currentTasks.countTasksByStatus(true));

            finished = mainMenu.processMenu();
        }

        //Saves current to do list in a file
        currentTasks.insertTasksToFile();

        System.out.println("Thank you for using MyToDo.\nNow go and do some tasks!");
    }

    /**
     *  Sequence of actions that processes user input.
     */
    public void processUserInput() {
    }

    /**
     * The point from where the program starts its execution.
     */
    public static void main (String[] args){
        Program program = new Program();
        program.routine();
    }
}
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
    private Menu mainMenu;
    private ToDoList currentTasks;

    /**
     * Create a todo list and an input reader.
     */
    public Program() {
        currentTasks = new ToDoList();
        mainMenu = new MainMenu();
    }

    /**
     *  Main routine. Loops until user quits the application.
     */
    public void routine() {
        System.out.println(">> Welcome to MyToDo!");

        /*
         Start the main application loop. Repeatedly read commands and
         execute them until the user quits the application.
         */
        boolean finished = false;
        while (! finished) {
            mainMenu.printMenu();

            finished = mainMenu.processMenu();
        }
        System.out.println("Thank you for using MyToDo.\nNow go and do some tasks!");
    }

    /**
     * The point from where the program starts its execution.
     */
    public static void main (String[] args){
        Program program = new Program();
        program.routine();
    }
}
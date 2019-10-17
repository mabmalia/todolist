import menu.*;
import utility.InputReader;

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
    private InputReader inputReader;

    /**
     * Constructor of Program class.
     * Creates a new Main Menu.
     */
    public Program() {
        currentTasks = new ToDoList();
        inputReader = new InputReader();
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

        //creates a main menu view with the list status in it to be displayed
        MainMenu mainMenu = new MainMenu();

        //boolean variable to exit the loop when user presses 4 in the main menu
        boolean quit = false;
        while (!quit) {
            mainMenu.updateCounters(currentTasks.countTasksByStatus(true), currentTasks.countTasksByStatus(false));
            quit = processInput(mainMenu.processMenu());
        }

        //Saves current to do list in a file
        currentTasks.insertTasksToFile();

        System.out.println("Thank you for using MyToDo.\nNow go and do some tasks!");
    }

    /**
     *  Sequence of actions that processes user input.
     */
    private boolean processInput(String userInput) {
        int index;

        switch (userInput) {
            case "11":
                //Sort list by project
                currentTasks.sortTasksByProject();
                inputReader.printReturnCommand();
                break;

            case "12":
                //Sort list by date
                currentTasks.sortTasksByDate();
                inputReader.printReturnCommand();
                break;

            case "21":
                //adds a new task
                break;

            case "31":
                //edits a task detail(s)
                //currentTasks.modifyTaskStatusToDone(index); //index of the task required
                break;

            case "32":
                //marks a task as done
                index = selectTask();
                if (index != -1) {
                    currentTasks.modifyTaskStatusToDone(index);
                    System.out.println("Task was marked as done.");
                }
                break;

            case "33":
                //remove a task
                index = selectTask();
                if (index != -1){
                    currentTasks.removeTaskOfList(index);
                    System.out.println("Task was successfully removed.");
                }
                break;

            case "41":
                return true;
        }
        return false;
    }

    /**
     *  Allows user to select a task to be edited or removed.
     * @return int representing the index of the task.
     */
    public int selectTask(){
        //Prints all tasks of the todo list with an index
        currentTasks.showTasksWithIndex();

        //Requests user to select a task
        boolean invalidIndex = false;
        int index = -1;
        while (!invalidIndex){
            System.out.println("Select a task by inserting its index. Or press (0) to return to main menu.");
            String userInput = inputReader.readInput();
            if(userInput.equals("0")){
                return index;
            }

            index = utility.Utility.convertIndexToInt(userInput) -1;
            if (index == -1 || index > currentTasks.getSize() && index < 1) {
                System.out.println("Invalid index. Please try again.");
            }
            else {
                System.out.println("The following task was selected:");
                System.out.println(currentTasks.getSpecificTask(index));
                invalidIndex = true;
            }
        }

        return index;
    }

    /**
     * The point from where the program starts its execution.
     */
    public static void main (String[] args){
        Program program = new Program();
        program.routine();
    }
}
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *  This class is the main class of the MyToDo application.
 *  MyToDo is a very simple, text based todo list application.
 *
 *  Users can create new tasks, assign them a title and due date,
 *  and choose a project for that task to belong to.
 *  Users can also edit, mark as done or remove tasks.
 *
 *  The application saves the current task list to file, when the user quits,
 *  and then restarts with the former state restored.
 *
 * @author  Miguel Mália
 * @version 2019.10.06
 */

public class Program {
    private Scanner reader;
    private ToDoList currentTasks;

    /**
     * Create a scanner to read user input.
     */
    public Program() {
        reader = new Scanner(System.in);
        currentTasks = new ToDoList();
    }

    /**
     *  Main routine. Loops until user quits the application.
     */
    public void routine()
    {
        System.out.println(">> Welcome to MyToDo!");

        /*
         Enter the main application loop. Here repeatedly read commands and
         */
        // execute them until the user quits the application.
        boolean finished = false;
        while (! finished) {
            printMainMenu();

            finished = processMainInput(getInput());
        }
        System.out.println("Thank you for using MyToDo.\nNow go and do some tasks!");
    }

    /**
     * Given a input, process it.
     * @param input The input to be processed.
     * @return true If the input ends the application, false otherwise.
     */
    private boolean processMainInput(String input)
    {
        boolean wantToQuit = false;

        switch (input) {
            case "1":
                //SHOW LIST IMPLEMENTATION
                break;

            case "2":
                processTaskInput(addTaskInput());
                break;

            case "3":
                //EDIT TASK IMPLEMENTATION
                break;

            case "4":
                //SAVE THE FILE IMPLEMENTATION
                wantToQuit = true;
                break;
            default:
                System.out.println("You typed an invalid command.");
                break;
        }
        return wantToQuit;
    }

    /**
     * Print out the opening message for the user.
     */
    private void printMainMenu()
    {
        System.out.println(">> You have X tasks todo and Y tasks done.");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit Task (update, mark as done, remove)");
        System.out.println(">> (4) Save and Quit");
        System.out.println(">> ");
    }

    /**
     * Reads user input.
     * @return The next input from the user.
     */
    public String getInput() {
        System.out.print(">> ");         // print prompt

        return reader.nextLine().trim();
    }

    /**
     * Sequence of actions that allows user to input task details
     * and the application to store that input
     */
    public String[] addTaskInput(){
        /*
        An array with a question for each field of a task
        and another populated with the user input for that question
         */
        String[] taskQuestions = new String[3];
        taskQuestions[0] = ">> Insert task title:";
        taskQuestions[1] = ">> Insert due date (format dd/MM/yyyy):";
        taskQuestions[2] = ">> Insert project title (optional):";

        String[] taskDetails = new String[3];

        //print a return statement as an user option
        System.out.println(">> [To return to main menu press (0)]");

        //print insert statements and collect user input
        for(int index = 0; index < taskQuestions.length;index++){
            System.out.println(taskQuestions[index]);

            String input = getInput();

            if(!input.equals("0")){
                taskDetails[index] = input;
            }
            else{
                return null; //takes the user back to main menu
            }
        }

        return taskDetails;
    }

    /**
     * Creates a new task
     * @param taskDetails The task details input by the user.
     * @return true If the creation operation was successful, false otherwise.
     */
    public void processTaskInput(String[] taskDetails){
        if (!Parser.isEmpty(taskDetails)) {
            //Check if a valid title or date were inserted
            if(taskDetails[0] == null || taskDetails[0].length() == 0){
                System.out.println(">> Task title cannot be empty. The task was not created.");
            }
            else if (!Parser.isValidDate(taskDetails[1])) {
                System.out.println(">> Date with incorrect format or outdated. The task was not created.");
            }
            else {
                //Create a task and insert it in the todo list
                Task newTask = new Task(taskDetails[0], Parser.convertDate(taskDetails[1]), taskDetails[2]);

                if (currentTasks.insertTask(newTask)) {
                    System.out.println(">> The task was successfully created.");
                }
                else {
                    System.out.println(">> Something went wrong. The task was not created.");
                }
            }

            //For users to see the last message before returning to main menu
            System.out.println(">> Press any key to return to main menu.");
            getInput();
        }
    }

    /**
     * The point from where the program starts its execution.
     */
    public static void main (String[] args){
        Program program = new Program();
        program.routine();
    }
}
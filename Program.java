import java.util.Scanner;

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
    private Scanner reader;
    private ToDoList currentTasks;
    private static final int NUMBER_OF_FIELDS = 4;      // How many fields are expected.
    private static final int TITLE = 0,                 // Index values for the fields in each task.
            PROJECT = 1,
            DUE_DATE = 2,
            STATUS = 3;

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
    public void routine() {
        System.out.println(">> Welcome to MyToDo!");

        //Updates the todo list.
        uploadTasksFromFile();

        /*
         Enter the main application loop. Repeatedly read commands and
         execute them until the user quits the application.
         */
        boolean finished = false;
        while (! finished) {
            printMainMenu();

            finished = processMainInput(getInput());
        }
        System.out.println("Thank you for using MyToDo.\nNow go and do some tasks!");
    }

    /**
     * Given a input in the main menu, process it.
     * @param input The input to be processed.
     * @return true If the input ends the application, false otherwise.
     */
    private boolean processMainInput(String input) {
        boolean wantToQuit = false;

        switch (input) {
            case "1":
                currentTasks.showTasks();
                //currentTasks.sortTasks("getProject");
                //currentTasks.filterTasks("x");
                break;

            case "2":
                processTaskInput(addTaskInput());
                break;

            case "3":
                //EDIT TASK IMPLEMENTATION
                break;

            case "4":
                saveToDoList();
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
    private void printMainMenu() {
        System.out.println(">> You have " + currentTasks.countTasksStatus(false) + " tasks todo and "
                + currentTasks.countTasksStatus(true) +" tasks done.");
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
        // print prompt
        System.out.print(">> ");

        return reader.nextLine().trim();
    }

    /**
     * Sequence of actions that allows user to see a task list.
     */
    public void showTaskList(){

        //display todo list as is


        //print a return statement as an user option
        System.out.println(">> [To return to main menu press (0)]");
        /*
        //print show task list options
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Sort by project");
        System.out.println(">> (2) Filter by project");
        System.out.println(">> (3) Sort by due date");
        System.out.println(">> (4) filter by due date");
        */
    }

    /**
     * Sequence of actions that allows user to input task details.
     * and the application to store that input.
     * @return a String array with the task details.
     */
    public String[] addTaskInput(){
        /*
        An array with a question for each field of a task
        and another populated with the user input for that question
         */
        String[] taskQuestions = new String[3];
        taskQuestions[0] = ">> Insert task title:";
        taskQuestions[1] = ">> Insert project title:";
        taskQuestions[2] = ">> Insert due date (format yyyy-MM-dd):";

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
     * Creates a new task and inserts it in the todo list.
     * @param taskDetails The task details input by the user.
     */
    public void processTaskInput(String[] taskDetails){

        //If the user pressed 0, taskDetails is null
        // so user is redirected to main menu without any other message being printed
        if (taskDetails != null && taskDetails.length != 0) {

            //Check if a valid title/project or date were inserted
            if((taskDetails[0] == null || taskDetails[0].length() == 0) || (taskDetails[1] == null || taskDetails[1].length() == 0)){
                System.out.println(">> Task title or project cannot be empty. The task was not created.");
            }
            else if (!Utility.isValidDate(taskDetails[2])) {
                System.out.println(">> Date with incorrect format or outdated. The task was not created.");
            }
            else {
                //Create a task and insert it in the todo list
                Task newTask = new Task(taskDetails[0], taskDetails[1], Utility.convertDate(taskDetails[2]));
                currentTasks.insertTask(newTask);
                System.out.println(">> The task was successfully created.");
            }

            //For users to see the last message before returning to main menu
            System.out.println(">> Press any key to return to main menu.");
            getInput();
        }
    }

    /**
     * Writes the tasks of the list to a csv file.
     */
    private void saveToDoList() {
        FileManager fileManager = new FileManager();
        fileManager.writeToCSV(currentTasks.getListOfTasks());
    }

    /**
     * Uploads the tasks of the file to the todo list.
     */
    private void uploadTasksFromFile() {
        FileManager fileManager = new FileManager();
        currentTasks.insertList(fileManager.ReadFromCSV());
    }

    /**
     * The point from where the program starts its execution.
     */
    public static void main (String[] args){
        Program program = new Program();
        program.routine();
    }
}
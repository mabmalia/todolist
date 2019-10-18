import menu.*;
import task.TaskFields;
import utility.*;

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
     * @param userInput the command input to be processed.
     * @return true if the user wants to quit the application, false otherwise.
     *
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
                //Add a new task
                addTask(enterTaskDetails(MenuOptionCode.ADD.toString()));
                inputReader.printReturnCommand();
                break;

            case "31":
                //Edit the details of a task
                index = selectTask();
                if (index != -1) {
                    editTask(enterTaskDetails(MenuOptionCode.EDIT.toString()), index);
                    inputReader.printReturnCommand();
                }
                break;

            case "32":
                //marks a task as done
                index = selectTask();
                if (index != -1) {
                    currentTasks.editTaskStatus(index, true);
                    System.out.println("Task was marked as done.");
                    inputReader.printReturnCommand();
                }
                break;

            case "33":
                //remove a task
                index = selectTask();
                if (index != -1){
                    currentTasks.removeTaskOfList(index);
                    System.out.println("Task was successfully removed.");
                    inputReader.printReturnCommand();
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
    private int selectTask(){
        //Prints all tasks of the todo list with an index
        currentTasks.showTasksWithIndex();

        //Requests user to select a task
        boolean invalidIndex = false;
        int index = -1;
        while (!invalidIndex){
            System.out.println("Select a task by inputting its index. Or press (0) to return to main menu.");
            String userInput = inputReader.readInput();
            if(userInput.equals("0")){
                return -1;
            }

            index = utility.Utility.convertIndexToInt(userInput) -1;
            if (index >= currentTasks.getSize() || index < 0) {
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
     * Sequence of actions that allows user to insert details of a a task.
     * @param userInput to know if the user wants to add or edit a task.
     * @return an array with the details of the task
     */
    private String[] enterTaskDetails(String userInput){
        /*
         An array with a question for each field of a task
         and other to store the user input for that question.
         An enum is used to know the index of each task field.
         */
        String[] taskQuestions = new String[TaskFields.NUMBER_OF_FIELDS.toInt()-1];
        String[] taskDetails = new String[TaskFields.NUMBER_OF_FIELDS.toInt()-1];

        taskQuestions[TaskFields.TITLE.toInt()] = ">> Insert task title:";
        taskQuestions[TaskFields.PROJECT.toInt()] = ">> Insert project title:";
        taskQuestions[TaskFields.DUE_DATE.toInt()] = ">> Insert due date (format yyyy-MM-dd):";

        //If a task is being edited, then the user can skip the fields that don't want to edit
        //by pressing Enter (empty field)
        if (userInput.equals(MenuOptionCode.EDIT.toString())){
            System.out.println("Press (Enter) to skip a field that doesn't need to be edited.");
        }

        //Print insert statements and collect user input
        for(int index = 0; index < taskQuestions.length; index++){
            boolean fieldIsValid = false;
            String quit = ""; //backup for user to be able to quit add or edit mode

            while(!fieldIsValid){
                System.out.println(taskQuestions[index]);

                String input = inputReader.readInput();

                //Check if field is empty or invalid
                //If editing a task, the field can be empty
                if(input.isEmpty() && userInput.equals(MenuOptionCode.EDIT.toString())){
                    taskDetails[index] = input;
                    fieldIsValid = true;
                }
                else if(input.isEmpty()){
                    System.out.println(">> Field cannot be empty.");
                    System.out.println(">> Press (Enter) to continue or (0) to return to main menu.");
                    quit = inputReader.readInput();
                }
                else if(TaskFields.DUE_DATE.toInt() == index && !Utility.isValidDate(input)){
                    System.out.println(">> Date with invalid format.");
                    System.out.println(">> Press (Enter) to continue or (0) to return to main menu.");
                    quit = inputReader.readInput();
                }
                else{ //For not empty fields with valid date (if array index matches date enum index)
                    taskDetails[index] = input;
                    fieldIsValid = true;
                }

                //backup for user to be able to quit add or edit mode menu
                if(quit.equals("0")){
                    return null;
                }
            }
        }
        return taskDetails;
    }

    /**
     * Adds a new task to the to do list.
     * @param details an array with the title, project and due date of the task.
     */
    private void addTask (String[] details){
        //Create a task and insert it in the todo list
        // if the details are not null
        if(details != null){
            currentTasks.insertTask(details[TaskFields.TITLE.toInt()],
                    details[TaskFields.PROJECT.toInt()],
                    Utility.convertDate(details[TaskFields.DUE_DATE.toInt()]));

            System.out.println("Task was successfully created.");
        }
        else{
            System.out.println("A new task was not created.");
        }
    }

    /**
     * Edits a task from the to do list.
     * @param details an array with the title, project and due date of the task.
     * @param index the index of the task to be edited.
     */
    private void editTask (String[] details, int index){
        //modify a task in the todo list
        // if the details are not null
        if(details != null){
            for(int iteration = 0; iteration < details.length; iteration++){
                if(iteration == TaskFields.TITLE.toInt() && !details[iteration].equals("")){
                    currentTasks.editTaskTitle(index, details[iteration]);
                }
                else if(iteration == TaskFields.PROJECT.toInt() && !details[iteration].equals("")){
                    currentTasks.editTaskProject(index, details[iteration]);
                }
                else if(iteration == TaskFields.DUE_DATE.toInt() && !details[iteration].equals("")){
                    currentTasks.editTaskDueDate(index, Utility.convertDate(details[iteration]));
                }
            }

            System.out.println("Task was successfully edited.");
        }
        else{
            System.out.println("Task was not edited.");
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
/**
 * A class representing the Add Menu of the application.
 * Extends Menu class.
 *
 * @author  Miguel Mália
 * @version 2019.10.16
 *//*

public class AddAndEditMenu extends Menu {

    */
/**
     * Constructor of the class.
     *//*

    public AddAndEditMenu() {
        super();
    }

    */
/**
     * Print out the edit menu for the user.
     *//*

    public void printMenu(){
        System.out.println(">> Pick an option:");
        System.out.println(">> (0) Return to main menu");
        System.out.println(">> (1) Edit task title");
        System.out.println(">> (2) Edit task project");
        System.out.println(">> (3) Edit task due date");
        System.out.println(">> (4) Mark task as done");
        System.out.println(">> (5) Remove task");
    }

    */
/**
     * Sequence of actions that allows user to edit a task.
     *//*

    public void processMenu() {

        //show todo list if it is not empty
        if(currentTasks.getListSize() == 0){
            System.out.println(">> The todo list is empty.");
            //For users to see the last message before returning to main menu
            printReturnToMenu();
            return;
        }
        currentTasks.showTasksWithIndex();

        //Requests user to choose a task to be edited or removed
        //Improve the loop to allow user to return to main menu - Need improvement!
        boolean invalidIndex = false;
        int index = -1;
        while (!invalidIndex){
            index = Utility.convertIndexToInt(reader.getInput());
            if (index == -1 || index > currentTasks.getListSize() && index < 1) {
                System.out.println("You typed an invalid index. Try again or press (0) to return to main menu.");
            }
            else {
                System.out.println("You selected the following task:");
                System.out.println(currentTasks.getSpecificTask(index));
                invalidIndex = true;
            }
        }

        //Display edit options
        boolean wantToQuit = false;

        while(!wantToQuit) {

            //print edit task options
            printEditMenu();

            switch (reader.getInput()) {
                case "0":
                    wantToQuit = true;
                    break;

                case "1":
                    //currentTasks.modifyTaskTitle(index,"Validar se o campo nao vem vazio."); //necessario validar campo nao vazio
                    wantToQuit = true;
                    break;

                case "2":
                    //currentTasks.modifyTaskProject(index,"Validar se o campo nao vem vazio."); //necessario validar campo nao vazio
                    wantToQuit = true;
                    break;

                case "3":
                    //currentTasks.modifyTaskDueDate(index,"Validar se o campo nao vem vazio."); //necessario validar campo nao vazio
                    wantToQuit = true;
                    break;

                case "4":
                    currentTasks.modifyTaskStatusToDone(index);
                    System.out.println("Task was marked as done.");
                    wantToQuit = true;
                    printReturnToMenu();
                    break;

                case "5":
                    currentTasks.removeTaskOfList(index);
                    System.out.println("Task was successfully removed.");
                    wantToQuit = true;
                    printReturnToMenu();
                    break;

                default:
                    printInvalidCommand();
                    break;
            }
        }
    }
}
*/

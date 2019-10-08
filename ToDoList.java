import java.util.ArrayList;
import java.util.Date;

/**
 * This class is part of the MyToDo application.
 * MyToDo is a very simple, text based todo list application.
 *
 * This class holds a list of tasks.
 * Users can add, remove or edit tasks in the list.
 * They can also view the tasks in the list, sorted and filtered by date or project
 *
 * @author  Miguel Mália
 * @version 2019.10.06
 */

public class ToDoList {
    private ArrayList<Task> tasks;
    private int completeTasks;
    private int incompleteTasks;

    /**
     * Create a todo list.
     */
    public ToDoList(){
        tasks = new ArrayList<>();
    }

    /**
     * Inserts a task in the list.
     * @param newTask The task to be added to the list.
     * @return true If the add operation was successful, false otherwise.
     */
    public boolean insertTask(Task newTask){
        return tasks.add(newTask);
    }
}

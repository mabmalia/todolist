import java.util.ArrayList;
import java.util.Comparator;

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

    /**
     * Create a todo list.
     */
    public ToDoList(){
        tasks = new ArrayList<>();
    }

    /**
     * Check if todo list is empty.
     * @return true if the list is empty and false otherwise.
     */
    public boolean isListEmpty(){
        return tasks.isEmpty();
    }

    /**
     * Inserts a task in the list.
     * @param newTask The task to be added to the list.
     */
    public void insertTask(Task newTask){
        tasks.add(newTask);
    }

    /**
     * Insert a list of tasks in the list.
     * @param newList The task to be added to the list.
     */
    public void insertList(ArrayList<Task> newList){
        tasks.addAll(newList);
    }

    /**
     * Returns the list of tasks.
     * @return an ArrayList with all the tasks in the todolist.
     */
    public ArrayList<Task> getListOfTasks(){
        return tasks;
    }

    /**
     * Shows all tasks in the list.
     */
    public void showTasks(){
        tasks.stream()
                .map(Task::toString)
                .forEach(System.out::println);
    }

    /**
     * Counts the number of tasks done or undone.
     * @param status specifies what tasks to be counted.
     * @return number of tasks done or undone according to parameter input.
     */
    public long countTasksStatus(boolean status){
        return tasks.stream()
                .filter(task -> task.getStatus() == status)
                .count();
    }

    /**
     * Sorts and shows all tasks by project.
     */
    public void sortTasksByProject(){

        tasks.stream()
                .sorted(Comparator.comparing(Task::getProject))
                .map(Task::toString)
                .forEach(System.out::println);
    }

    /**
     * Sorts and shows all tasks by date.
     */
    public void sortTasksByDate(){

        tasks.stream()
                .sorted(Comparator.comparing(Task::getDueDate))
                .map(Task::toString)
                .forEach(System.out::println);
    }
}
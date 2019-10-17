import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

import task.Task;

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
    private FileManager fileManager;

    /**
     * Create a todo list.
     */
    public ToDoList(){
        tasks = new ArrayList<>();
        fileManager = new FileManager();
        tasks.addAll(fileManager.ReadFromCSV());
    }

    /**
     * Creates and inserts a task in the list.
     * @param title The task title.
     * @param project The task project.
     * @param dueDate The task due date.
     */
    public void insertTask(String title, String project, String dueDate){
        Task task = new Task(title, project, Utility.convertDate(dueDate));
        tasks.add(task);
    }

    /**
     * Saves all the tasks in the list to the file.
     */
    public void insertTasksToFile(){
        fileManager.writeToCSV(tasks);
    }

    /**
     * Removes a task from the list.
     * @param index of the task to be removed.
     */
    public void removeTaskOfList(int index){
        tasks.remove(index);
    }

    /**
     * Returns the size of the list.
     * @return a int with the size.
     */
    public int getSize(){
        return tasks.size();
    }

    /**
     * Shows all tasks in the list with an index associated.
     */
    public void showTasksWithIndex(){
        tasks.stream()
                .map(task -> "index = " + (tasks.indexOf(task) + 1) + ", " + task.toString())
                .forEach(System.out::println);
    }

    /**
     * Get specific task in the list.
     * @param index of the task.
     * @return the details of the task as a String.
     */
    public String getSpecificTask(int index){
        return "index = " + (index + 1) + tasks.get(index).toString();
    }

    /**
     * Counts the number of tasks done or to do.
     * @param status specifies what tasks to be counted.
     * @return number of tasks done or to do according to parameter input.
     */
    public int countTasksByStatus(boolean status){
        return Math.toIntExact(tasks.stream()
                                .filter(task -> task.getStatus() == status)
                                .count());
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

    /**
     * Modify a specific task.
     * @param index of the task.
     * @param title of the task.
     */
    public void modifyTaskTitle(int index, String title){
        tasks.get(index).setTitle(title);
    }

    /**
     * Modify a specific task.
     * @param index of the task.
     * @param project of the task.
     */
    public void modifyTaskProject(int index, String project){
        tasks.get(index).setProject(project);
    }

    /**
     * Modify a specific task.
     * @param index of the task.
     * @param dueDate of the task.
     */
    public void modifyTaskDueDate(int index, LocalDate dueDate){
        tasks.get(index).setDueDate(dueDate);
    }

    /**
     * Modify a specific task.
     * @param index of the task.
     */
    public void modifyTaskStatusToDone(int index){
        tasks.get(index).setStatus(true);
    }
}
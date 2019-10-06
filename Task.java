import java.util.Date;

/**
 * Class Task - a task in a todo list.
 *
 * This class is part of the ToDoList application.
 * ToDoList is a very simple, text based todo list application.
 *
 * A task will have a title, due date, status and project
 * Task priority was added as a new feature
 *
 * @author  Miguel Mália
 * @version 2019.10.06
 */

public class Task {
    private String title;
    private Date dueDate;
    private String project;
    private boolean status;

    /**
     * Create a Task based on user input not yet done (status = false)
     *
     * @param title The task's title
     * @param dueDate The task's due date
     * @param project The task's project
     */
    public Task(String title, Date dueDate, String project){
        this.title = title;
        this.dueDate = dueDate;
        this.project = project;
        status = false;
    }

    /**
     * Return the title of the task
     * @return the title of the task
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Return the project of the task
     * @return the project of the task
     */
    public String getProject()
    {
        return project;
    }

    /**
     * Return the due date of the task
     * @return the due date of the task
     */
    public Date getDueDate()
    {
        return dueDate;
    }

    /**
     * Return the status of the task
     * @return the status of the task
     */
    public boolean getStatus()
    {
        return status;
    }

    /**
     * Return a description of the task in the form:
     *     title + project + due date
     * @return A detailed description of the task
     */
    public String getTaskDetails()
    {
        return title + " " + project + " " + dueDate;
    }
}

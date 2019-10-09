import java.time.LocalDate;

/**
 * This class is part of the MyToDo application.
 * MyToDo is a very simple, text based todo list application.
 *
 * This class holds the details of a task:
 *      title, due date, status and project.
 *
 * @author  Miguel Mália
 * @version 2019.10.06
 */
public class Task {
    private String title;
    private LocalDate dueDate; //LocalDate represents a date in ISO format (yyyy-MM-dd) without time
    private String project;
    private boolean status;

    /**
     * Create an undone Task based on user input.
     *
     * @param title The task's title.
     * @param dueDate The task's due date.
     * @param project The task's project.
     */
    public Task(String title, LocalDate dueDate, String project){
        this.title = title;
        this.dueDate = dueDate;
        this.project = project;
        status = false;
    }

    /**
     * Return the title of the task.
     * @return the title of the task as a String.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Return the project of the task.
     * @return the project of the task as a String..
     */
    public String getProject()
    {
        return project;
    }

    /**
     * Return the due date of the task.
     * @return the due date of the task as a LocalDate.
     */
    public LocalDate getDueDate()
    {
        return dueDate;
    }

    /**
     * Return the status of the task.
     * @return the status of the task.
     */
    public boolean getStatus()
    {
        return status;
    }

    /**
     * Return the status of the task as Done (true) or Undone (false).
     * @return the status of the task.
     */
    public String getStringStatus() {
        return status ? "Done" : "Undone";
    }

    /**
     * Return a description of the task in the form:
     *     title + project + due date
     * @return A detailed description of the task as a String.
     */
    @Override
    public String toString() {
        return "title = \'" + title
                + "\', project = \'" + project
                + "\', date = " + getDueDate()
                + ", status = " + getStringStatus();
    }
}

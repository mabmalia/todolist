package task;

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
    private String project;
    private LocalDate dueDate; //LocalDate represents a date in ISO format (yyyy-MM-dd) without time
    private boolean status;

    /**
     * Create a to do Task based on user input.
     *
     * @param title The task's title.
     * @param project The task's project.
     * @param dueDate The task's due date.
     */
    public Task(String title, String project, LocalDate dueDate){
        this.title = title;
        this.project = project;
        this.dueDate = dueDate;
        status = false;
    }

    /**
     * Create a Task with status true or false.
     *
     * @param title The task's title.
     * @param project The task's project.
     * @param dueDate The task's due date.
     * @param status true if the task is done, false otherwise.
     */
    public Task(String title, String project, LocalDate dueDate, boolean status){
        this.title = title;
        this.project = project;
        this.dueDate = dueDate;
        this.status = status;
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
     * Sets the title of the task.
     * @param title the title of the task.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return the project of the task.
     * @return the project of the task as a String.
     */
    public String getProject()
    {
        return project;
    }

    /**
     * Sets the project of the task.
     * @param project the project of the task.
     */
    public void setProject(String project) {
        this.project = project;
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
     * Sets the date of the task.
     * @param dueDate the due date of the task.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
     * Sets the date of the task.
     * @param status the due date of the task.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Return the status of the task as Done (true) or to do (false).
     * @return the status of the task.
     */
    public String statusToString() {
        return status ? "Done" : "To do";
    }

    /**
     * Return a description of the task in the form:
     *     "title = title, project = project, date = dueDate, status = status"
     * @return A detailed description of the task as a String.
     */
    @Override
    public String toString() {
        return "title = \'" + title
                + "\', project = \'" + project
                + "\', date = " + dueDate
                + ", status = \'" + statusToString() + "\'";
    }
}

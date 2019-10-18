import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

import task.Task;
import task.TaskFields;
import utility.Utility;

/**
 * A class to read and write CSV-style records of tasks.
 *
 * @author  Miguel Mália
 * @version 2019.10.06
 */
public class FileManager {
    private static final String CSV_FILE_NAME = "todolist.csv";     //File name.
    private String csvFilePath;   //File path.

    /**
     Creates a File Manager.
     */
    public FileManager(String csvFilePath){
        this.csvFilePath = csvFilePath;
    }

    /**
     * Writes the todo list to a CSV file.
     * @param tasks a list to be written in a CSV file.
     */
    public void writeToCSV(ArrayList<Task> tasks){
        //Check if directory exists
        //Otherwise create it
        File directory = new File(csvFilePath);
        if (! directory.exists()){
            directory.mkdir();
        }

        //Overwrites existing file with new tasks
        File csvFile = new File(csvFilePath + CSV_FILE_NAME);
        try (PrintWriter writeCSV = new PrintWriter(csvFile)) {
            tasks.stream()
                    .map(FileManager::convertToCSV)
                    .forEach(writeCSV::println);
        }
        catch(IOException e) {
            System.out.println("Something went wrong. Tasks may have been lost.");
        }
    }

    /**
     * Reads tasks from the CSV file and return them as a list.
     * @return an ArrayList with the tasks in the file.
     */
    public ArrayList<Task> ReadFromCSV(){

        // Create a Function that takes a line from the CSV file
        // and returns a Task.
        Function<String, Task> createTask =
                record -> {
                            //split on the comma only if that comma has zero or an even number of quotes ahead of it.
                            String[] parts = record.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                            if(parts.length == TaskFields.NUMBER_OF_FIELDS.toInt()) {
                                try {
                                    String title = parts[TaskFields.TITLE.toInt()].replaceAll("^\"|\"$", "").replaceAll("\"\"", "\"");
                                    String project = parts[TaskFields.PROJECT.toInt()].replaceAll("^\"|\"$", "").replaceAll("\"\"", "\"");
                                    LocalDate dueDate = Utility.convertDate(parts[TaskFields.DUE_DATE.toInt()]);
                                    boolean status = !parts[TaskFields.STATUS.toInt()].contains("To do");
                                    return new Task(title, project, dueDate, status);
                                }
                                catch(Exception e) {
                                    return null;
                                }
                            }
                            else {
                                return null;
                            }
                        };

        //Create an ArrayList of tasks
        ArrayList<Task> tasks;
        try {
            tasks = Files.lines(Paths.get(csvFilePath + CSV_FILE_NAME))
                    .map(createTask::apply)
                    .filter(task -> task != null)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Unable to open " + CSV_FILE_NAME);
            tasks = new ArrayList<>();
        }
        return tasks;
    }

    /**
     * Convert tasks to a CSV format line.
     * @param task a task to be converted.
     * @return a string with the CSV line
     */
    private static String convertToCSV(Task task) {

        return handleSpecialCharacters(task.getTitle()) + "," +
                handleSpecialCharacters(task.getProject()) + "," +
                task.getDueDate() + "," +
                task.statusToString();
    }

    /**
     * Handle special characters.
     * @param field to be handled.
     * @return a String.
     */
    private static String handleSpecialCharacters(String field) {
        //Values that contain commas must be enclosed within double quotes.
        //Double quotes within quoted values must be escaped by doubling them.
        String escapedField = field.replaceAll("\\R", " ");
        if (field.contains(",") || field.contains("\"") || field.contains("'")) {
            field = field.replace("\"", "\"\"");
            escapedField = "\"" + field + "\"";
        }
        return escapedField;
    }
}

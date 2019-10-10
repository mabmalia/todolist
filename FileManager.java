import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A class to read and write CSV-style records of tasks.
 *
 * @author  Miguel Mália
 * @version 2019.10.06
 */
public class FileManager {
    private static final String CSV_FILE_PATH = "src/resources/";   //File path.
    private static final String CSV_FILE_NAME = "todolist.csv";     //File name.
    private static final int NUMBER_OF_FIELDS = 4;                  // How many fields are expected.
    // Index values for the fields in each task.
    private static final int TITLE = 0,
            PROJECT = 1,
            DUE_DATE = 2,
            STATUS = 3;

    /**
     Creates a File Manager.
     */
    public FileManager(){ }

    /**
     * Get the File name and path.
     * @return the file path + the file name and extension.
     */
    @Override
    public String toString() {
        return CSV_FILE_PATH + CSV_FILE_NAME;
    }

    /**
     * Writes the todo list to a CSV file.
     */
    public void writeToCSV(ArrayList<Task> tasks){
        File csvFile = new File(CSV_FILE_PATH + CSV_FILE_NAME);
        try (PrintWriter writeCSV = new PrintWriter(csvFile)) {
            tasks.stream()
                    .map(Task::toString)
                    .map(FileManager::handleSpecialCharacters)
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
                            String[] parts = record.split(",");
                            if(parts.length == NUMBER_OF_FIELDS) {
                                try {
                                    String title = parts[TITLE].trim().replace("title = ", "");
                                    String project = parts[PROJECT].trim().replace("project = ", "");
                                    LocalDate dueDate = Utility.convertDate(parts[DUE_DATE].trim().replace("date = ",""));
                                    boolean status = parts[STATUS].contains("Undone") ? false : true;
                                    return new Task(title, project, dueDate, status);
                                }
                                catch(NumberFormatException e) {
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
            tasks = Files.lines(Paths.get(CSV_FILE_PATH + CSV_FILE_NAME))
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
     * Handle special characters.
     */
    public static String handleSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
}

import org.junit.jupiter.api.Test;
import task.Task;
import utility.Utility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileManagerTest {

    //create a date and tasks
    LocalDate date = Utility.convertDate("2020-10-20");
    String title1 = "bir,lz";
    String title2 = "sam\"p\"le";
    String project1 = "project\"X\"";
    String project2 = "shopping";
    Task task1 = new Task(title1, project1, date);
    Task task2 = new Task(title2, project2, date);

    @Test
    public void writeTasksToFileTrue(){

        //create an array list and add tasks
        ArrayList<Task> listSample = new ArrayList<>();
        listSample.add(task1);
        listSample.add(task2);

        //write tasks to file
        FileManager fileManager = new FileManager("test_resources/");
        fileManager.writeToCSV(listSample);

        //Check if file is empty
        int fileSize;
        try{
            fileSize = Files.readAllLines(Paths.get("resources/todolist.csv")).size();
        }
        catch(IOException e){
            fileSize = -1;
        }

        assertTrue(fileSize > 0);
    }

    @Test
    public void fileContentEqualToTasksWrote(){
        //Create a list with tasks read from file
        FileManager fileManager = new FileManager("test_resources/");
        ArrayList<Task> listSample = new ArrayList<>(fileManager.ReadFromCSV());

        assertEquals(2, listSample.size());
        assertEquals(title1, listSample.get(0).getTitle());
        assertEquals(title2, listSample.get(1).getTitle());
        assertEquals(project1, listSample.get(0).getProject());
        assertEquals(project2, listSample.get(1).getProject());
        assertEquals(date, listSample.get(0).getDueDate());
        assertEquals(false, listSample.get(1).getStatus());
    }

    @Test
    public void handleCommaCharacterTrue(){
        FileManager fileManager = new FileManager("test_resources/");
        String testHandleTitle = null;
        try{
            Method method = FileManager.class.getDeclaredMethod("handleSpecialCharacters", String.class);
            method.setAccessible(true);
            testHandleTitle = (String) method.invoke(fileManager, title1);

        }
        catch(Exception e){
            e.printStackTrace();
        }
        assertEquals("\"bir,lz\"", testHandleTitle);
    }
}
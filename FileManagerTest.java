import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileManagerTest {

    @Test
    public void folderExistsTrue(){

        FileManager fileManager = new FileManager();

        Path path = Paths.get(fileManager.toString().substring(0,fileManager.toString().lastIndexOf("/")));

        assertTrue(Files.exists(path));
    }

    @Test
    public void writeFileTrue(){

        //create a date and a list with some tasks
        LocalDate date = Utility.convertDate("2020-10-20");

        ArrayList<Task> listSample = new ArrayList<>();
        listSample.add(new Task("bir,lz","projectX", date));
        listSample.add(new Task("sam\"p\"le","shopping", date));

        //write tasks to file
        FileManager fileManager = new FileManager();
        fileManager.writeToCSV(listSample);

        //Check if file is empty
        int fileSize;
        try{
            fileSize = Files.readAllLines(Paths.get(fileManager.toString())).size();
        }
        catch(IOException e){
            e.printStackTrace();
            fileSize = -1;
        }

        assertTrue(Files.exists(Paths.get(fileManager.toString())));
        assertTrue(fileSize > 0);
    }

    @Test
    public void fileContentEqualsToWroteTasks(){}
}
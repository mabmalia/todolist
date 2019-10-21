import org.junit.jupiter.api.Test;
import task.Task;
import utility.Utility;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {
    //create a date
    LocalDate date1 = Utility.convertDate("2020-10-20");
    LocalDate date2 = Utility.convertDate("2023-12-25");

    String title1 = "birlz";
    String title2 = "new title";
    String project1 = "birlz";
    String project2 = "new project";

    @Test
    public void insertTaskTrue(){
        ToDoList list = new ToDoList("test_resources/");

        int initialSize = list.getSize();

        list.insertTask(title1, project1, date1);

        assertEquals(initialSize + 1, list.getSize());
    }

    @Test
    public void removeTaskThrowsIndexOutOfBounds(){
        ToDoList list = new ToDoList("test_resources/");

        assertThrows(IndexOutOfBoundsException.class, () -> list.removeTaskOfList(list.getSize()));
    }

    @Test
    public void getSpecificTaskTrue(){
        ToDoList list = new ToDoList("test_resources/");
        list.insertTask(title1, project1, date1);
        list.insertTask(title2, project2, date2);

        String specificTask = "index = " + (list.getSize()) + ", " + (new Task(title2, project2, date2)).toString();

        assertEquals(specificTask, list.getSpecificTask(list.getSize()-1));
    }

    @Test
    public void getSpecificTaskFalse(){
        ToDoList list = new ToDoList("test_resources/");
        list.insertTask(title1, project1, date1);
        list.insertTask(title2, project2, date2);

        String specificTask = "index = 1, " + (new Task(title2, project2, date2)).toString();

        assertNotEquals(specificTask, list.getSpecificTask(0));
    }

    @Test
    public void countTasksByStatus(){
        File file = new File("test_resources/todolist.csv");

        if(file.exists()){
            file.delete();
        }

        ToDoList list = new ToDoList("test_resources/");
        list.insertTask(title1, project1, date1);
        list.insertTask(title2, project2, date2);

        assertEquals(2, list.countTasksByStatus(false));
    }

    @Test
    public void removeTaskLowerLimit(){
        File file = new File("test_resources/todolist.csv");

        if(file.exists()){
            file.delete();
        }

        ToDoList list = new ToDoList("test_resources/");
        list.insertTask(title1, project1, date1);
        list.insertTask(title2, project2, date2);
    }

    @Test
    public void removeTaskUpperLimit(){
        File file = new File("test_resources/todolist.csv");

        if(file.exists()){
            file.delete();
        }

        ToDoList list = new ToDoList("test_resources/");
        list.insertTask(title1, project1, date1);
        list.insertTask(title2, project2, date2);

        int initialSize = list.getSize();

        list.removeTaskOfList(initialSize-1);

        assertEquals(initialSize - 1, list.getSize());
    }
}

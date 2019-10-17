import org.junit.jupiter.api.Test;
import task.Task;
import utility.Utility;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    //create a date
    LocalDate date1 = Utility.convertDate("2020-10-20");
    LocalDate date2 = Utility.convertDate("2023-12-25");
    String title1 = "birlz";
    String title2 = "new title";
    String project1 = "birlz";
    String project2 = "new project";

    @Test
    public void titleIsEqualTrue(){
        Task task = new Task(title1, project1, date1);

        String titleTest = task.getTitle();

        assertEquals(title1, titleTest);
    }

    @Test
    public void modifyTitleTrue(){
        Task task = new Task(title1, project1, date1);

        task.setTitle(title2);

        assertEquals(title2, task.getTitle());
    }

    @Test
    public void nullTitleThrowsAnException(){
        Task task = null;

        assertThrows(NullPointerException.class, () -> task.getTitle());
    }

    @Test
    public void projectIsEqualTrue(){
        Task task = new Task(title1, project1, date1);

        String projectTest = task.getProject();

        assertEquals(project1, projectTest);
    }

    @Test
    public void modifyProjectTrue(){
        Task task = new Task(title1, project1, date1);

        task.setProject(project2);

        assertEquals(project2, task.getProject());
    }

    @Test
    public void nullProjectThrowsAnException(){
        Task task = null;

        assertThrows(NullPointerException.class, () -> task.getProject());
    }

    @Test
    public void dateIsEqualTrue(){
        Task task = new Task(title1, project1, date1);

        LocalDate dateTest = task.getDueDate();

        assertEquals(date1, dateTest);
    }

    @Test
    public void modifyDateTrue(){
        Task task = new Task(title1, project1, date1);

        task.setDueDate(date2);

        assertEquals(date2, task.getDueDate());
    }

    @Test
    public void nullDateThrowsAnException(){
        Task task = null;

        assertThrows(NullPointerException.class, () -> task.getDueDate());
    }


    @Test
    public void statusIsFalse(){
        Task task = new Task(title1, project1, date1);

        boolean status = task.getStatus();

        assertEquals(false, status);
    }

    @Test
    public void modifyStatusTrue(){
        Task task = new Task(title1, project1, date1);

        task.setStatus(true);

        assertEquals(true, task.getStatus());
    }

    @Test
    public void statusStringIsDone(){
        Task task = new Task(title1, project1, date1, true);

        String status = task.statusToString();

        assertEquals("Done", status);
    }

    @Test
    public void statusStringIsToDo(){
        Task task = new Task(title1, project1, date1);

        String status = task.statusToString();

        assertEquals("To do", status);
    }
}
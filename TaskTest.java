import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    //create a date
    LocalDate date = Utility.convertDate("2020-10-20");

    @Test
    public void titleIsEqual(){
        Task task = new Task("birlz","projectX", date);

        String title = task.getTitle();

        assertEquals("birlz", title);
    }

    @Test
    public void nullTitleThrowsAnException(){
        Task task = null;

        assertThrows(NullPointerException.class, () -> task.getTitle());
    }

    @Test
    public void projectIsEqual(){
        Task task = new Task("birlz","projectX", date);

        String project = task.getProject();

        assertEquals("projectX", project);
    }

    @Test
    public void nullProjectThrowsAnException(){
        Task task = null;

        assertThrows(NullPointerException.class, () -> task.getProject());
    }

    @Test
    public void dateIsEqual(){
        Task task = new Task("birlz","projectX", date);

        LocalDate dateTest = task.getDueDate();

        assertEquals(date, dateTest);
    }

    @Test
    public void nullDateThrowsAnException(){
        Task task = null;

        assertThrows(NullPointerException.class, () -> task.getDueDate());
    }


    @Test
    public void statusIsFalse(){
        Task task = new Task("birlz","projectX", date);

        boolean status = task.getStatus();

        assertEquals(false, status);
    }

    @Test
    public void statusStringIsDone(){
        Task task = new Task("birlz","projectX", date, true);

        String status = task.statusToString();

        assertEquals("Done", status);
    }

    @Test
    public void statusStringIsUndone(){
        Task task = new Task("birlz","projectX", date);

        String status = task.statusToString();

        assertEquals("Undone", status);
    }

}

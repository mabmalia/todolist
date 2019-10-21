import org.junit.jupiter.api.Test;
import utility.Utility;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilityTest {

    @Test
    public void isValidDateTrue(){
        String date = "2020-12-25";

        assertTrue(Utility.isValidDate(date));
    }

    @Test
    public void isValidDateFalse(){
        String date = "2002/09/09";

        assertTrue(!Utility.isValidDate(date));
    }

    @Test
    public void convertDateAndCheckIsAfterNow(){
        String date = "2020-12-25";

        LocalDate currentDate = LocalDate.now();

        assertTrue(Utility.convertDate(date).isAfter(currentDate));
    }

    @Test
    public void convertDateAndCheckIsBeforeNow(){
        String date = "2000-12-25";

        LocalDate currentDate = LocalDate.now();

        assertTrue(Utility.convertDate(date).isBefore(currentDate));
    }
}

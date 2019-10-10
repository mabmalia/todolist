import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public final class Utility {
    /**
     * Converts a date from a String to a LocalDate type.
     * @param stringDate A date value as a String type.
     * @return a LocalDate type value. Returns null if date is not valid or outdated.
     */
    public static LocalDate convertDate(String stringDate){

        LocalDate date;

        try {
            date = LocalDate.parse(stringDate);
        }
        catch (DateTimeParseException e) {
            date = null;
        }

        return date;
    }

    /**
     * Verifies if a String type value is a LocalDate type value.
     * Also checks if the date is older than now.
     * @param stringDate A date value as a String type.
     * @return a true if the parameter can be parsed to a LocalDate type value.
     */
    public static boolean isValidDate(String stringDate){
        if(stringDate == null){
            return false;
        }

        LocalDate date;

        try {
            //check if it is valid
            date = LocalDate.parse(stringDate);

            //check if is outdated
            LocalDate currentDate = LocalDate.now();
            if(currentDate.isAfter(date) || currentDate.isEqual(date)) {
                return false;
            }
        }
        catch (DateTimeParseException e) {
            return false;
        }

        return true;
    }
}

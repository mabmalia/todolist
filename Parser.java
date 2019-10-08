import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    /**
     * Converts a date from a String to a Date type.
     * @param stringDate A date value as a String type.
     * @return a Date type value. Returns null if date is not valid or outdated.
     */
    public static Date convertDate(String stringDate){
        //The date format that should be input and validated
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date;

        try {
            date = dateFormat.parse(stringDate);
        }
        catch (ParseException e) {
            date = null;
        }

        return date;
    }

    /**
     * Converts a date from a String to a Date type.
     * @param stringDate A date value as a String type.
     * @return a Date type value. Returns null if date is not valid or outdated.
     */
    public static boolean isValidDate(String stringDate){
        if(stringDate == null){
            return false;
        }

        //The date format that should be validated
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date;

        try {
            date = dateFormat.parse(stringDate);

            //check if is outdated
            Date currentDate = new Date();
            if(currentDate.compareTo(date) > 0) {
                return false;
            }

        }
        catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * This method checks if an array is empty.
     * @param array to be verified.
     * @return turns true if the input array is null or their length is zero.
     */
    public static boolean isEmpty( Object[] array ){
        if( array == null || array.length == 0 ){
            return true;
        }
        return false;
    }
}

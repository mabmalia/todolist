/**
 * Representations for all the valid fields of a task
 * along with their index order.
 *
 * @author  Miguel Mälia
 * @version 2019.10.10
 */
public enum TaskFields {
    // An index for each field of a task with its
    TITLE(0), PROJECT(1), DUE_DATE(2), STATUS(3), NUMBER_OF_FIELDS(4);

    private int fieldIndex;

    /**
     * Initialise with the corresponding index int.
     * @param fieldIndex The field index.
     */
    TaskFields(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    /**
     * returns the field index as an int.
     */
    public int toInt()
    {
        return fieldIndex;
    }
}


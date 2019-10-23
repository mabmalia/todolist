package task;

/**
 * Number representations for all the fields of a task.
 *
 * @author  Miguel Mälia
 * @version 2019.10.10
 */
public enum TaskFields {
    // An index for each field of a task
    TITLE(0), PROJECT(1), DUE_DATE(2), STATUS(3), NUMBER_OF_FIELDS(4);

    private int fieldIndex;

    /**
     * Initialise with the corresponding index int.
     * @param fieldIndex The field's index.
     */
    TaskFields(int fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    /**
     * Returns the field's index as an int.
     * @return the field index.
     */
    public int toInt()
    {
        return fieldIndex;
    }
}



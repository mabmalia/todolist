package menu;

/**
 * Representations for all the options input in the application menus.
 *
 * @author  Miguel Mälia
 * @version 2019.10.10
 */
public enum OptionCode {
    // A code for each option input in the application menus
    RETURN("00"),
    SHOW_BY_PROJECT("11"),
    SHOW_BY_DATE("12"),
    ADD("21"),
    EDIT("31"),
    DONE("32"),
    REMOVE("33"),
    QUIT("41");

    private String menuCommand;

    /**
     * Initialise with the corresponding option code.
     * @param menuCommand The code of the user input.
     */
    OptionCode(String menuCommand) {
        this.menuCommand = menuCommand;
    }

    /**
     * Returns the code associated to a menu option.
     * @return the code of an option.
     */
    public String toString()
    {
        return menuCommand;
    }
}

package Broker;

/**
 * Created by André on 09/10/2015.
 */
public class FormatException extends Exception{
    private final String ERROR_MESSAGE = "Error De Formato :(";

    @Override
    public String getMessage() {
        return ERROR_MESSAGE;
    }
}

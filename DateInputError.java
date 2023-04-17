package FinalWorJava;

import java.text.ParseException;

public class DateInputError extends ParseException {
    public DateInputError(String mess, int errorOffset) {
        super(mess + ": неправильный формат даты", errorOffset);
    }
}

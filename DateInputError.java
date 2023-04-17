package FinalWorkJava;

import java.io.IOException;

public class DateInputError extends IOException {
    public DateInputError(String mess) {
        super(mess + ": неправильный формат даты");
    }
}

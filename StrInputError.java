package FinalWorJava;

import java.io.IOException;

public class StrInputError extends IOException {
    public StrInputError(String mess) {
        super(mess + ": содержит число или мало символов");
    }
}

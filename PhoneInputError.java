package FinalWorJava;

import java.io.IOException;

public class PhoneInputError extends IOException {
    public PhoneInputError(String mess) {
        super(mess + ": содержит буквы или мало символов");
    }
}
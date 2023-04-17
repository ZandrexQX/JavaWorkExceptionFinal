package FinalWorkJava;

import java.io.IOException;

public class SexInputError extends IOException {
    public SexInputError(String mess) {
        super(mess + ": неправильный формат. Только f или m.");
    }
}

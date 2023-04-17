package FinalWorJava;

import java.io.IOException;

public class ArrInputError extends IOException {
    public ArrInputError() {
        super("Количество данных некорректно");
    }
}

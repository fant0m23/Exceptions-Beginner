import java.io.IOException;
import java.util.NoSuchElementException;

public class ElementIsNullException extends IOException {
    String massage = "Элемент равен null";
    public ElementIsNullException() {
        super();
    }

    public String getMessage() {
        return massage;
    }

}

import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileNotFoundException extends Exception {
    String massage = "Файл не найден!";
    public MyFileNotFoundException() {
        super();
    }

    public String getMessage() {
        return massage;
    }
}

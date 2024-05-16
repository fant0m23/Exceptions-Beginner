import java.io.IOException;

public class IncorrectEntryFromUserException extends IOException {
    public IncorrectEntryFromUserException(String msg) {
        super(msg);
    }
}

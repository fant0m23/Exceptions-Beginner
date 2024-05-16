import java.io.IOException;

public class TelephoneNotCorrectException extends IOException {
    public TelephoneNotCorrectException(String msg) {
        super(msg);
    }
}

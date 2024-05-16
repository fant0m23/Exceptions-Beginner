import java.io.IOException;

public class BirthdateNotCorrectException extends IOException {
    public BirthdateNotCorrectException(String msg){
        super(msg);
    }
}

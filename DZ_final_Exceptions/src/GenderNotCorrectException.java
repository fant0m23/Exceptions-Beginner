import java.io.IOException;

public class GenderNotCorrectException extends IOException {
    public GenderNotCorrectException(String msg){
        super(msg);
    }
}

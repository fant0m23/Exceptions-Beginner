import java.io.IOException;

public class ZeroDivException extends ArithmeticException {
    String massage = "Делитель равен нулю!";
    public ZeroDivException() {
        super();
    }

    public String getMessage() {
        return massage;
    }
}

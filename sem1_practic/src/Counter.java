import java.io.Closeable;
import java.io.IOException;

public class Counter implements Closeable {
    private int c;
    private boolean isOpen = true;

    public int getC() {
        return c;
    }

    public void add() throws IOException {
        if (this.isOpen()) this.c++;
        else throw new IOException("Error: Ресурс закрыт!");
    }

    public boolean isOpen(){
        return isOpen;
    }

    @Override
    public void close() throws IOException {
        isOpen = false;
        c = 0;
    }
}

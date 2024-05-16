import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Man {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        String[] mass = {"volt", null, "duck", null, "fast"};
        try {
            doSomething(a, b);
            getElement(mass,b);
        } catch (ZeroDivException | ElementIsNullException e) {
            System.err.println(e.getMessage());
        }


    }

    public void rwLine(Path pathRead, Path pathWrite) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            out.write(in.readLine());
        }
    }

    public static void doSomething(int a, int b) throws ZeroDivException {
        if (b != 0) System.out.println((double) a / b);
        else throw new ZeroDivException();

    }

    public static void getElement(String[] arr, int i) throws ElementIsNullException {
        if (arr[i] != null) System.out.println(arr[i]);
        else throw new ElementIsNullException();
    }

    public static void printTXT(File file, File file2) throws MyFileNotFoundException {

    }

}
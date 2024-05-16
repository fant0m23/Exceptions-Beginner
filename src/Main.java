//        Напишите метод, который вернет содержимое текущей папки в виде массива строк.
//        Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
//
//        Обработайте ошибки с помощью try-catch конструкции. В случае исключения, оно должно записаться в
//        лог-файл.


import java.io.File;
import java.io.FileWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        //setLogger();
        String[] content = getContent("C:\\\\Users\\\\fant0m23\\\\УЧЁБА\\\\Exceptions-Beginner");
        // если указать ".", то произойдет обращение к корневой папке ПРОЕКТА

        // правильная работа в блоке try:
        recordToFile(content, "C:\\\\Users\\\\fant0m23\\\\УЧЁБА\\\\Exceptions-Beginner\\\\.gitignore");

        // для получения ошибки записи, и её логирования в logFile.txt через catch:
        //recordToFile(content, ".");
    }

    public static String[] getContent(String nameFolder) {
        File data = new File(nameFolder);
        return data.list();
    }

    public static void recordToFile(String[] dataList, String fileName) {
        // FileWriter не позволяет работать без блока try/catch
        try (FileWriter fw = new FileWriter(fileName)) {
            for (String line : dataList) {
                fw.write(line);
                fw.write(System.lineSeparator());
            }
        } catch (Exception ex) {
            // System.err.println("Ошибка записи в файл!");
            logger.warning("Ошибка записи в файл!");
        }
    }

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void setLogger(){
        try {
            FileHandler fH = new FileHandler("C:\\\\Users\\\\fant0m23\\\\УЧЁБА\\\\Exceptions-Beginner\\\\logFile.txt", true); // true для дозаписи лог-файла
            logger.addHandler(fH);
            SimpleFormatter textFormater = new SimpleFormatter();  // эти строки не обязательны в данном примере, т.к.
            fH.setFormatter(textFormater); // logger в этом формате (простого текста) возвращает по умолчанию
            // они для демонстрации, что есть различные классы-форматеры (например XMLFormatter)
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

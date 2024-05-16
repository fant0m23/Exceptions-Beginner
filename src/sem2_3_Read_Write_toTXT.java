//        Запишите в файл следующие строки:
//        Анна=4
//        Елена=5
//        Марина=6
//        Владимир=?
//        Константин=?
//        Иван=4
//        Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
//        (либо HashMap).
//        В отдельном методе нужно будет пройти по структуре данных.
//        Если сохранено значение ?, заменить его на соответствующее число.
//        Если на каком-то месте встречается символ, отличный от числа или ?, бросить
//        подходящее исключение.
//        Записать в тот же файл данные с замененными символами ?

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class sem2_3_Read_Write_toTXT {
    public static void main(String[] args) {
        String path = "C:\\\\STUDY\\\\Exceptions-Beginner\\\\src\\\\file.txt";
        try {
            Map<String, String> dict = readDataFromTXT(path);
            replaceSymbol(dict);
            recordToTXT(dict, path);
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public static Map<String, String> readDataFromTXT(String path) throws RuntimeException{
        Map<String, String> dict = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // на семинаре 2 чтение осуществлялось с помощью Scanner'а
            // вот так:
            // File file = new File(path);
            // Scanner scanner = new Scanner(file);
            // while (scanner.hasNextLine()){
            //    String line = scanner.nextLine();
            //    ...
            // }
            String line = br.readLine();
            while (line != null) {
                String[] rows = line.split("=");
                if (rows.length != 2) throw new RuntimeException("Неверные данные в строке!");
                else {
                    dict.put(rows[0], rows[1]);
                    line = br.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка чтения данных из файла.");
        }
        return dict;
    }

    public static void replaceSymbol(Map<String, String> dict) throws RuntimeException {
        Set<String> listKeys = dict.keySet();
        for (String key : listKeys) {
            String value = dict.get(key);
            if (value.equalsIgnoreCase("?")) {
                dict.put(key, String.valueOf(key.length()));
            }
        }
        String strKey = "", value = "";
        try {
            for (String keys : listKeys) {
                value = dict.get(keys);
                strKey = keys;
                int k = Integer.parseInt(value);
                if (k != keys.length()) dict.put(keys, String.valueOf(keys.length()));
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("Недопустимое значение: %s=%s%n", strKey, value));
        }
    }

    public static void recordToTXT(Map<String, String> dict, String path) {
        Set<String> listKeys = dict.keySet();
        try (FileWriter fw = new FileWriter(path, false)) {
            for (String key : listKeys) {
                fw.write(key + "=" + dict.get(key));
                fw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл!");
            ;
        }

    }

}




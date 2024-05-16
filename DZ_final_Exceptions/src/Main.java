/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные
пробелом:       Фамилия Имя Отчество датарождения номертелефона пол
    Форматы данных:
    фамилия, имя, отчество - строки
    дата_рождения - строка формата dd.mm.yyyy
    номер_телефона - целое беззнаковое число без форматирования
    пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
ошибки, обработать его и показать пользователю сообщение, что он ввел меньше или больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы
данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java
и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией,
что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
записаться полученные данные, вида:    <Фамилия><Имя><Отчество><датарождения><номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен
увидеть стектрейс ошибки.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String test = "Иванов Иван Иванович m 01.01.2001 79200030003";
        String inputStr = requestFromUser();

        try {
            InputConverter converter = new InputConverter(inputStr);
            String gender = converter.findRemoveGender();
            String birthdate = converter.findRemoveBirthdate();
            String telephone = converter.findRemoveTelephone();
            String fileName = converter.getFileName();
            String secondName = converter.getSecondName();
            String firstName = converter.getFirstName();
            String lastName = converter.getLastName();
            try (FileWriter fw = new FileWriter(fileName, true)) {
                fw.write(String.format("<%s><%s><%s><%s><%s><%s>", secondName, firstName, lastName,
                        birthdate, telephone, gender));
                fw.write(System.lineSeparator());
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл!");
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        } catch (IncorrectEntryFromUserException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String requestFromUser() {
        System.out.print("Введите данные в формате \"Фамилия Имя Отчество датарождения номертелефона пол\"" +
                " через пробел.\n\tФорматы данных:\n    фамилия, имя, отчество - строки\n" +
                "    дата_рождения - строка формата dd.mm.yyyy\n" +
                "    номер_телефона - целое беззнаковое число без форматирования\n" +
                "    пол - символ латиницей f или m\n>>> ");
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        scanner.close();
        return result;
    }
}
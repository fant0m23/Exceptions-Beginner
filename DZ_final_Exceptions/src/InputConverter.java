import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConverter {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public InputConverter(String inputStr) throws IncorrectEntryFromUserException {
        String[] arr = inputStr.split(" ");
        for (String part : arr) {
            if (part.isEmpty())
                throw new IncorrectEntryFromUserException("Вводить данные необходимо через ОДИН пробел");
        }
        if (arr.length == 6) list = new ArrayList<>(Arrays.asList(arr));
        else if (arr.length < 6) throw new IncorrectEntryFromUserException("Введенных данных недостаточно");
        else throw new IncorrectEntryFromUserException("Введено больше чем требуется");
    }

    public String findRemoveGender() throws IncorrectEntryFromUserException {
        String gender = " ";
        for (String part : this.list) {
            if (part.length() == 1) {
                gender = part;
            }
        }
        if (gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f")) {
            list.remove(gender);
            return gender;
        } else if (gender.equals(" "))
            throw new IncorrectEntryFromUserException("В качестве пола вводите не более 1 символа (f или m латиницей)");
        else
            throw new IncorrectEntryFromUserException("Вводите символ латиницей f или m (вы ввели в качестве пола символ \"" +
                    gender + "\")");
    }

    public String findRemoveBirthdate() throws IncorrectEntryFromUserException {
        LocalDate birthDate = LocalDate.MAX;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 10 && isLocalDate(list.get(i))) {
                birthDate = LocalDate.parse(list.get(i).replace('.', '/'), dtf);
                index = i;
            }
        }
        if (birthDate == LocalDate.MAX) throw new IncorrectEntryFromUserException("Некорректный ввод даты рождения. " +
                "Вводите в формате dd.MM.yyyy");
        else return list.remove(index);
    }

    private boolean isLocalDate(String str) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(str.replace('.', '/'), dtf);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public String findRemoveTelephone() throws IncorrectEntryFromUserException {
        long result = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isLongNumber(list.get(i))) {
                result = Long.parseLong(list.get(i));
                index = i;
            }
        }
        if (result == 0) throw new IncorrectEntryFromUserException("Телефонный номер во введенной строке не найден");
        else return list.remove(index);


    }

    private boolean isLongNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getFileName() {
        return list.get(0) + ".txt";
    }

    public String getSecondName() throws IncorrectEntryFromUserException {
        for (int i = 0; i < list.get(0).length(); i++) {
            if (!Character.isLetter(list.get(0).charAt(i)))
                throw new IncorrectEntryFromUserException("Фамилия не может содержать цифры или спецсимволы!");
        }
        return list.get(0);
    }

    public String getFirstName() throws IncorrectEntryFromUserException {
        for (int i = 0; i < list.get(1).length(); i++) {
            if (!Character.isLetter(list.get(1).charAt(i)))
                throw new IncorrectEntryFromUserException("Имя не может содержать цифры или спецсимволы!");
        }
        return list.get(1);
    }

    public String getLastName() throws IncorrectEntryFromUserException {
        for (int i = 0; i < list.get(2).length(); i++) {
            if (!Character.isLetter(list.get(2).charAt(i)))
                throw new IncorrectEntryFromUserException("Отчество не может содержать цифры или спецсимволы!");
        }
        return list.get(2);
    }
}

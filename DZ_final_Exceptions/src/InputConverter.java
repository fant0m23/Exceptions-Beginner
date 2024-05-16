import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConverter {
    private List<String> list;

    public InputConverter(String inputStr) throws QuantityInputException {
        String[] arr = inputStr.split(" ");
        if (arr.length == 6) list = new ArrayList<>(Arrays.asList(arr));
        else if (arr.length < 6) throw new QuantityInputException("Введенных данных не достаточно.");
        else throw new QuantityInputException("Введено больше чем требуется");
    }

    public Character findRemoveGender() throws GenderNotCorrectException {
        char gender = ' ';
        for (String part : this.list) {
            if (part.length() == 1) {
                gender = part.charAt(0);
            }
        }
        if (gender == 'm' || gender == 'f') {
            list.remove(String.valueOf(gender));
            return gender;
        } else if (gender == ' ')
            throw new GenderNotCorrectException("В качестве пола вводите не более 1 символа (f или m латиницей)");
        else
            throw new GenderNotCorrectException("Вводите символ латиницей f или m (вы ввели в качестве пола символ \"" +
                    gender + "\")");
    }

    public String findRemoveBirthdate() throws BirthdateNotCorrectException {
        LocalDate birthDate = LocalDate.MAX;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 10 && isLocalDate(list.get(i))) {
                birthDate = LocalDate.parse(list.get(i).replace('.', '/'), dtf);
                index = i;
            }
        }
        if (birthDate == LocalDate.MAX) throw new BirthdateNotCorrectException("Некорректный ввод даты рождения. " +
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

    public String findRemoveTelephone() throws TelephoneNotCorrectException {
        long result = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (isLongNumber(list.get(i))) {
                result = Long.parseLong(list.get(i));
                index = i;
            }
        }
        if (result == 0) throw new TelephoneNotCorrectException("Телефонный номер во введенной строке не найден");
        else return list.remove(index);


    }

    private boolean isLongNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public String getFileName(){
        return list.get(0) + ".txt";
    }

    public String getPersonFullName(){
        return list.get(0) + " " + list.get(1) + " " + list.get(2);
    }
}

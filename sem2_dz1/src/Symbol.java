/*
Символ `а`.
Напишите программу, которая принимает символ a в качестве аргумента и выполняет следующую проверку:
если символ a равен пробелу '', программа должна выбрасывать исключение с сообщением
"Empty string has been input.".
В противном случае программа должна возвращать сообщение
"Your input was - [символ]", где [символ] заменяется на введенный символ a.

На входе:

'0'

На выходе:

Result: Your input was - 0

 */


class Expr3 {
    public static String expr(char a) throws Exception {
        if (a == ' ') throw new Exception("Empty string has been input.");
        else return String.format("Your input was - %c",a);
    }
}
// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки

public class Symbol {
    public static void main(String[] args) {
        char a;

        if (args.length == 0) {
            a = ' '; // Значение по умолчанию, если аргументы не были предоставлены
        } else {
            a = args[0].charAt(0); // Преобразуйте первый аргумент командной строки в символ
        }

        try {
            String result = Expr3.expr(a);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
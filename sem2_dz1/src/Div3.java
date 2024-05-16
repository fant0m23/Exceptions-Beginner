/*
Деление
Напишите программу для выполнения арифметической операции деления двух целых чисел a и b.
При этом программа должна проверить, что делитель b не равен нулю, и выполнить деление только в этом случае.
Если b равен нулю, программа должна вернуть результат равный нулю.
После выполнения операции деления, программа также должна вывести сумму чисел a и b с помощью метода printSum.
Если аргументы не переданы через командную строку, используйте значения по умолчанию.

На входе:
'12'
'5'

На выходе:
17
2.4
 */

class Expr2 {

    public static double expr(int a, int b) {
        if (b == 0){
            printSum(a, b);
            return 0;
        }
        else {
            printSum(a, b);
            return (double) a / b;
        }
    }

    public static void printSum(int a, int b) {
        System.out.println(a + b);
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки

public class Div3 {
    public static void main(String[] args) {
        int a;
        int b;

        if (args.length == 0) {
            a = 12;
            b = 0; // Default values if no arguments are provided
        } else {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }

        double result = Expr2.expr(a, b);
        System.out.println(result);
    }
}
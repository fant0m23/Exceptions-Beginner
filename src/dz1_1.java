
//        Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
//
//        Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
//
//        Метод divisionByZero - Деление на 0
//
//        Метод numberFormatException - Ошибка преобразования строки в число
//
//        Важно: они не должны принимать никаких аргументов

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] mass = {3, 5};
        System.out.println(mass[4]);
    }

    public static void divisionByZero() {
        int a = 5, b = 0;
        System.out.println(a / b);
    }

    public static void numberFormatException() {
        String str = "1o";
        System.out.println(Integer.parseInt(str));
    }
}

public class dz1_1 {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}

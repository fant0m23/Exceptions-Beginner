//      Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое
//        значение. Метод ищет в массиве заданное значение и возвращает его индекс. При этом,
//        например:
//        1. если длина массива меньше некоторого заданного минимума, метод возвращает -1 в
//        качестве кода ошибки.
//        2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
//        3. если вместо массива пришел null, метод вернет -3
//        4. придумайте свои варианты исключительных ситуаций и верните соответствующие
//        коды ошибок.
//        Напишите метод, в котором реализуете взаимодействие с пользователем. То есть, этот
//        метод запросит искомое число у пользователя, вызовет первый метод, обработает
//        возвращенное значение и покажет читаемый результат пользователю. Например, если
//        вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.


import java.util.Scanner;

public class sem1_1 {
    public static void main(String[] args) {
        int[] mass = {2, 6, 9, 3, 7, 5, 9, 8, 5, 3};
        int minLength = 7;

        getFind(mass, minLength);
    }

    private static int getIndex(int[] mass, int minLength, int find) {
        if (mass == null) return -3;
        if (mass.length < minLength) return -1;
        for (int i = 0; i < mass.length ; i++) {
            if (mass[i] == find) return i;
        }
        return -2;

    }

    private static void getFind(int[] mass, int minLength) {
        System.out.print("Введите искомое число >>> ");
        Scanner scanner = new Scanner(System.in);
        int find = scanner.nextInt();
        int result = getIndex(mass, minLength, find);
        if (result == -1) System.out.println("Исходный массив слишком короткий");
        else if (result == -2) System.out.println("Данный элемент не найден");
        else if (result == -3) System.out.println("Массив равен null");
        else System.out.println("Данный элемент находится на позиции " + result);
    }
}
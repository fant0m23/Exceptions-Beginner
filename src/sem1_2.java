//        Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
//        Необходимо посчитать и вернуть сумму элементов этого массива.
//        При этом накладываем на метод 2 ограничения: метод может работать только с
//        квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
//        только значение 0 или 1.
//        Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
//        ошибке.

public class sem1_2 {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};

        System.out.println(sumArray(arr));
    }

    public static int sumArray(int[][] mass) {
        int sum = 0;
        int rows = mass.length;
        for (int[] arr : mass) {
            if (arr.length != rows) throw new RuntimeException("Массив не квадратный");
        }
        for (int[] arr : mass) {
            for (int i : arr) {
                if (i != 0 && i != 1) throw new RuntimeException("Массив должен состоять только из 0 и 1");
                sum += i;
            }
        }
        return sum;
    }


}
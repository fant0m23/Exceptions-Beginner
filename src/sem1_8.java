/*
Реализуйте метод, принимающий в качестве аргументов двумерный массив.
Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
детализировать какие строки со столбцами не требуется.
Как бы вы реализовали подобный метод?
 */


public class sem1_8 {
    public static void main(String[] args) {
        int[][] mass = {{3, 7, 1},
                {6},
                {7, 7, 2}};
        try {
            checkLength(mass);
        } catch (IndexOutOfBoundsException re) {
            System.err.println("длина строк и столбцов с одинаковым индексом не одинакова!");
        }
    }

    public static void checkLength(int[][] arr) throws IndexOutOfBoundsException {
        int index = 0;
        for (int[] row : arr) {
            int size = row.length;
            int temp = arr[size - 1][index];
            index++;
        }
        System.out.println("Всё норм!");
    }

}

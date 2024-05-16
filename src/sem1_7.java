//        Реализуйте метод, принимающий в качестве аргументов два целочисленных массива и
//        возвращающий новый массив, каждый элемент которого равен сумме элементов двух
//        входящих массивов в той же ячейке.
//        Если длины массивов не равны, необходимо как-то оповестить пользователя.

import java.util.Arrays;

public class sem1_7 {
    public static void main(String[] args) {
        int[] arr1 = {4, 7, 1, 8};
        int[] arr2 = {2,  6, 5};

        try {
            System.out.println(Arrays.toString(sumElements(arr1, arr2)));
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public static int[] sumElements(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) throw new IllegalArgumentException("Массивы разной длины!");
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }


}
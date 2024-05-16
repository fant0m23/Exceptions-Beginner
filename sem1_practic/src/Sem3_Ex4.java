public class Sem3_Ex4 {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] mass = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        try {
            System.out.println(sumStrArray(mass));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int sumStrArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int summa = 0;
        if (arr.length != 3) throw new MyArraySizeException();
        for (String[] subArr : arr) {
            if (subArr.length != 3) throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    summa += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В строке %d столбце %d не число!", i + 1, j + 1));
                }
            }
        }
        return summa;
    }


}

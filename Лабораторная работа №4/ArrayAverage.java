public class ArrayAverage {
    public static void main(String[] args) {
        Object[] arr = {1, 2, 3, 4, 5, "null"};
        int sum = 0;
        int count = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                String str = String.valueOf(arr[i]);
                try{
                    int number = Integer.parseInt(str);
                    sum += number;
                    count++; 
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Элемент массива не является целым числом: " + arr[i]);
                }
            }
            double average = (double) sum / count;
            System.out.println("Среднее арифметическое: " + average);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: неверные данные в массиве.");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла неожиданная ошибка.");
        }
    }
}
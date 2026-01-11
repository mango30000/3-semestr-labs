class SumMassive implements Runnable{
    private int[] array;
    private int start;
    private int end;
    public int sum = 0;

    public SumMassive(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for (int i = start; i < end; i++){
            sum += array[i];
        }
    }
}

public class SumHalfMassive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        int mid = n / 2;

        SumMassive task1 = new SumMassive(arr, 0, mid);
        SumMassive task2 = new SumMassive(arr, mid, n);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван.");
        }

        int totalSum = task1.sum + task2.sum;

        System.out.println("Сумма первой половины: " + task1.sum);
        System.out.println("Сумма второй половины: " + task2.sum);
        System.out.println("Общая сумма: " + totalSum);
    }
}

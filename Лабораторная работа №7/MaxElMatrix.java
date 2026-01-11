class MaxInRow implements Runnable {
    private int[] row;
    public int maxEl = Integer.MIN_VALUE;
    public MaxInRow(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        for (int element : row) {
            if (element > maxEl) {
                maxEl = element;
            }
        }
    }
}

public class MaxElMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 3},
            {8, 2, 9},
            {4, 7, 46}
        };

        int rows = matrix.length;

        MaxInRow[] tasks = new MaxInRow[rows];
        Thread[] threads = new Thread[rows];

        for (int i = 0; i < rows; i++) {
            tasks[i] = new MaxInRow(matrix[i]);
            threads[i] = new Thread(tasks[i]);
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван.");
            }
        }

        int maxElement = Integer.MIN_VALUE;
        for (MaxInRow task : tasks) {
            if (task.maxEl > maxElement) {
                maxElement = task.maxEl;
            }
        }
        for (int i = 0; i < rows; i++) {
            System.out.println("Максимальный элемент в строке: " + tasks[i].maxEl);
        }
        System.out.println("Максимальный элемент в матрице: " + maxElement);
    }
}

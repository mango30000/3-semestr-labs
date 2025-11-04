import java.util.*;

public class UniqueMassiv {
    public static int[] mergeUniqueSorted(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        input = input.substring(1, input.length() - 1);
        String[] parts = input.split("\\], \\[", 2);

        String[] A = parts[0].isEmpty() ? new String[0] : parts[0].split(",");
        int[] a = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            a[i] = Integer.parseInt(A[i].trim());
        }

        String[] B = parts[1].isEmpty() ? new String[0] : parts[1].split(",");
        int[] b = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            b[i] = Integer.parseInt(B[i].trim());
        }

        int[] result = mergeUniqueSorted(a, b);

        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(",");
            System.out.print(result[i]);
        }
        System.out.println("]");
        sc.close();
    }
}

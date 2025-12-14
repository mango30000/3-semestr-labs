import java.util.*;

public class GenerateKomb {
    
    private static void generate(String current, boolean[] used, int n, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generate(current + i, used, n, result);
                used[i] = false;
            }
        }
    }
    
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        
        if (n > k) {
            return result;
        }
        
        boolean[] used = new boolean[k];
        generate("", used, n, result);
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        String input = scanner.nextLine();
        String[] parts = input.split("[, ]+");
        
        int n = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        
        List<String> result = bruteForce(n, k);
        
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("\"" + result.get(i) + "\"");
            if (i < result.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        
        scanner.close();
    }
} 

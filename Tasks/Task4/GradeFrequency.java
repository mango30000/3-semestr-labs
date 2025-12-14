import java.util.Scanner;
public class GradeFrequency {
    public static int[] evaluateGrades(int[] grades) {
        int[] result = new int[5]; 
        
        for (int grade : grades) {
            if (grade >= 90 && grade <= 100) {
                result[0]++; 
            } else if (grade >= 80 && grade <= 89) {
                result[1]++; 
            } else if (grade >= 70 && grade <= 79) {
                result[2]++; 
            } else if (grade >= 60 && grade <= 69) {
                result[3]++; 
            } else if (grade >= 0 && grade <= 59) {
                result[4]++; 
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String gradesStr = input.substring(1, input.length() - 1);
        scanner.close();
        String[] gradeStrings = gradesStr.split(",");
        int[] grades = new int[gradeStrings.length];
        
        for (int i = 0; i < gradeStrings.length; i++) {
            grades[i] = Integer.parseInt(gradeStrings[i].trim());
        }
        
        int[] counts = evaluateGrades(grades);
        String[] letters = {"A", "B", "C", "D", "F"};
        
        StringBuilder output = new StringBuilder("{");
        boolean hasContent = false;
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                if (hasContent) output.append(", ");
                output.append(letters[i]).append(": ").append(counts[i]);
                hasContent = true;
            }
        }
        
        output.append("}");
        System.out.println(output);
        
        scanner.close();
    }
}

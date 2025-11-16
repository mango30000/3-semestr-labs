import java.util.HashMap;

public class StudentTable {
    private HashMap<Integer, Student> studentMap;

    public StudentTable() {
        studentMap = new HashMap<>();
    }

    public void addStudent(int gradebooknumber, Student student) {
        if (gradebooknumber < 0) {
            System.out.println("Номер зачетной книжки должен быть больше 0.");
        }else {studentMap.put(gradebooknumber, student);}
    }

    public Student findStudent(int gradebooknumber) {
        return studentMap.get(gradebooknumber);
    }

    public boolean removeStudent(int gradebooknumber) {
        if (studentMap.containsKey(gradebooknumber)) {
            studentMap.remove(gradebooknumber);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StudentTable stable = new StudentTable();

        Student s1 = new Student("Огурчиков", "Семён", 17, 3.9);
        Student s2 = new Student("Кузнецова", "Надежда", 24, 4.6);
        Student s3 = new Student("Иванова", "Лена", 20, 3.5);
        Student s4 = new Student("","Николай", 18, 5.0);


        stable.addStudent(2201, s1);
        stable.addStudent(2304, s2);
        stable.addStudent(2510, s3);
        stable.addStudent(-2222, s4);

        System.out.println("Есть студент 2510: " + stable.findStudent(2510));
        System.out.println("Есть студент 3333: " + stable.findStudent(3333));
        System.out.println("Есть студент 2222: " + stable.findStudent(2222));

        System.out.println("Удален студент 2201: " + stable.removeStudent(2201));
        System.out.println("Есть студент 2201: " + stable.findStudent(2201));
    }
}

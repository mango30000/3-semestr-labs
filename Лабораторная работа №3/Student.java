public class Student {
    String lastname;
    String name;
    int age;
    double gpa;

    public Student(String lastname, String name, int age, double gpa) {
        setLastname(lastname);
        setName(name);
        setAge(age);
        setGpa(gpa);
    }

    public String getLastname() {return lastname;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public double getGpa() {return gpa;}

    public void setLastname(String lastname) {
        if (lastname == null || lastname.trim().isEmpty()) {
            System.out.println("Фамилия не может быть null или пустой.");
        } else {this.lastname = lastname;}
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Имя не может быть null или пустым.");
        } else {this.name = name;} 
    }

    public void setAge(int age) {
        if (age < 0 || age > 150) { 
            System.out.println("Возраст должен быть от 0 до 150.");
        } else {this.age = age;}
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 5.0) {
            System.out.println("Средний балл должен быть от 0.0 до 5.0.");
        } else {this.gpa = gpa;}
    }

    @Override
    public String toString() {
        return "Student{" +
                "Имя:'" + name + '\'' +
                ", Фамилия:'" + lastname + '\'' +
                ", Возраст:" + age +
                ", Средний балл:" + gpa +
                '}';
    } 
}

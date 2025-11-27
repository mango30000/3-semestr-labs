import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomEmptyStackException extends RuntimeException{
    public CustomEmptyStackException() {}
    public CustomEmptyStackException (String message) {
        super (message);
    }
}

class Card {
    private String name;
    public Card(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class ExceptionLogger {
    public static void logException(Exception e) {
        String logfile = "logErrors.txt";
        try (FileWriter writer = new FileWriter(logfile, true);
            PrintWriter pw = new PrintWriter(writer)) {
            pw.println("Тип исключения: " + e.getClass());
            e.printStackTrace(pw);
        } catch (IOException ex) {
            System.err.println("Не удалось записать лог исключения:");
            ex.printStackTrace();
        }
    }
}

class CustomStack {
    private String[] data;
    private int top;
    private int capacity;

    public CustomStack(int size) {
        capacity = size;
        data = new String[capacity];
        top = -1;
    }
    public void push(String value) {
        data[++top] = value;
    }
    public String pop() {
        if (top == -1) {
            throw new CustomEmptyStackException("Невозможно извлечь из пустого стека.");
        }
            return data[top--];
    }
    public String peek() {
        if (top == -1) {
            throw new CustomEmptyStackException("Невозможно посмотреть вершину пустого стека.");
        }
        return data[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(2);
        stack.push("A");
        System.out.println(stack.pop());
        try {
            stack.pop();
        } catch (CustomEmptyStackException e) {
            ExceptionLogger.logException(e);
            System.out.println("Ошибка:" + e.getMessage());
        }
    }
}
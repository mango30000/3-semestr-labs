public class Stack<T> {
    private T[] data;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер стека должен быть положительным");
        }
        data = (T[]) new Object[capacity];
        top = -1;
    }
    public void push(T element) {
        data[++top] = element;
    }
    public T pop() {
        if (top == -1) {
            throw new IllegalStateException("Невозможно извлечь из пустого стека.");
        }
        return data[top--];
    }
    public T peek() {
        if (top == -1) {
            throw new IllegalStateException("Невозможно посмотреть вершину пустого стека.");
        }
        return data[top];
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<> (10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
    }
}

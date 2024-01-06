import java.util.EmptyStackException;

public class ArrayStack {
    private Employee [] stack;
    private int top;
    // FOr the stack capacity
    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push (Employee employee){
        // Check if the stack is full
        if (top == stack.length) {
            // Resize array by doubling the size and then copy old elements to new array
            Employee [] newArray = new Employee[2*stack.length];
            System.arraycopy(stack, 0 , newArray, 0, stack.length);
            stack = newArray;
        }
        top = top + 1; //Increment top
        stack[top] = employee; //Insert element on the Incremented position.
        //stack[top++] = employee; //One line vs two
    }

    public Employee pop(){
        // Check if the stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top = top - 1; //Decrementing top’s position to remove last element from stack
        Employee employee = stack[top]; // Store the top employee stack element
        stack[top] = null; // Null out the stack for the next pop function call
        return employee;
        //Employee employee = stack[top]; One line of code
    }

    public Employee peek() {
        // Check if the stack is empty
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top = top - 1;
        return stack[top];
    }

    public int size() {
        return top;
    }
    public boolean isEmpty() {
        // Return true if the stack is empty
        return top == 0;
    }

    public void printStack() {
        for (int i = top -1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}



import java.util.Stack;

public class StackTraversal {


    private static void pushBottom(Stack<Integer> stack, int element) {

        if (stack.isEmpty())
            stack.push(element);

        else {
            int top = stack.pop();            // if stack has elements, pop all and push current to bottom of stack
            pushBottom(stack, element);
            stack.push(top);
        }
    }

    private static void revUtil(Stack<Integer> stack) {

        if (stack.isEmpty())
            return;

        int top = stack.pop();
        revUtil(stack);                 // recurse till bottom of the stack is reached
        pushBottom(stack, top);         // push every element at the bottom of the stack

    }

    private static void print(Stack<Integer> stack) {
        stack.forEach(item -> System.out.print(item + " "));
        System.out.println("--> Top");
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(9);

        print(stack);
        System.out.println();
        revUtil(stack);
        print(stack);
    }

}

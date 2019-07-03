package task2_stack_transaction;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int top;

    List<Integer> stack;
    public Solution() {
        // write your code in Java SE 8
        stack = new ArrayList<>();
    }

    public void push(int value) {
        top = value;
        stack.add(top);
    }

    public int top() {
        return top;
    }

    public void pop() {
        if (stack.isEmpty()){
            return;
        }
        stack.remove(stack.size()-1);
        top = stack.get(stack.size()-1);
    }

    public void begin() {

    }

    public boolean rollback() {
        return false;
    }

    public boolean commit() {
        return false;
    }

    public static void test() {
        // Define your tests here
        Solution sol = new Solution();
        sol.push(5);
        sol.push(2);
        assert sol.top() == 2 : "top() should be 2";
        sol.pop();
        assert sol.top() == 5 : "top() should be 5";

        Solution sol2 = new Solution();
        assert sol2.top() == 0;
        sol2.pop();
    }
};

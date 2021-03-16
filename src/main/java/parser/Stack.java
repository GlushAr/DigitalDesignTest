package parser;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Character> data;

    public void push(Character symbol) {
        data.add(symbol);
    }

    public Character pop() {
        return data.remove(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public Stack() {
        this.data = new ArrayList<>();
    }
}

package leet;

import java.util.*;

/**
 * @author alireza_bayat
 * created on 4/3/22
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> validObjects = new HashMap<>();
        validObjects.put(')', '(');
        validObjects.put('}', '{');
        validObjects.put(']', '[');
        Stack<Character> charStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (validObjects.containsValue(c))
                charStack.push(c);
            else if (validObjects.containsKey(c)) {
                if (charStack.empty())
                    return false;
                Character character = validObjects.get(c);
                if (charStack.peek() == character)
                    charStack.pop();
                else
                    return false;
            } else
                return false;
        }
        return charStack.empty();
    }
}

package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 */
public class GenerateParentheses {
    ValidParentheses validParentheses = new ValidParentheses();

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        List<Character> c = Arrays.asList('(', ')');
        generatedString(c, new StringBuilder(), result, n * 2);
        return result;
    }

    private void generatedString(List<Character> c, StringBuilder path, List<String> result, int n) {
        if (validParentheses.isValid(path.toString()) && path.length() == n) {
            result.add(path.toString());
            return;
        }
        if (path.length() >= n) {
            return;
        }

        for (int i = 0; i < c.size(); i++) {
            path.append(c.get(i));
            generatedString(c, path, result, n);
            path.setLength(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> strings = generateParentheses.generateParenthesis(3);
        System.out.println(strings);
    }
}

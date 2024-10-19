package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        combinations(digits, 0, result, new StringBuilder());
        return result;
    }

    private static void combinations(String digit, int index, List<String> result, StringBuilder stringBuilder) {
        if (index == digit.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        char c = digit.charAt(index);
        String s = map.get(c);

        for (Character character : s.toCharArray()) {
            stringBuilder.append(character);
            combinations(digit, index + 1, result, stringBuilder);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }
}

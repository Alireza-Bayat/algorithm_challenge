package leet;

import java.util.Arrays;
import java.util.List;

/**
 * Given a square grid of characters in the range ascii[a-z],
 * rearrange elements of each row alphabetically, ascending.
 * Determine if the columns are also in ascending alphabetical order,
 * top to bottom. Return YES if they are or NO if they are not.
 */
public class GridChallenge {

    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] chars = grid.get(i).toCharArray();
            Arrays.sort(chars);
            grid.set(i, String.valueOf(chars));
        }

        for (int i = 0; i < grid.size(); i++) {

            for (int j = 1; j < grid.size(); j++) {
                if (grid.get(j).charAt(i) < grid.get(j - 1).charAt(i)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        gridChallenge(List.of("asd", "asd", "qwe"));
    }
}

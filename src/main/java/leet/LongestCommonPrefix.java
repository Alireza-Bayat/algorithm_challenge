package leet;

/**
 * @author alireza_bayat
 * created on 4/2/22
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        else if (strs.length == 1)
            return strs[0];
        char[] firstIndex = strs[0].toCharArray();
        String prefix = "";
        for (int j = 0; j < firstIndex.length; j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() - 1 >= j) {
                    if (firstIndex[j] == strs[i].charAt(j)) {
                        if (i == strs.length - 1)
                            prefix = prefix.concat(String.valueOf(firstIndex[j]));
                    } else
                        return prefix;
                } else
                    return prefix;
            }
        }
        return prefix;
    }

}

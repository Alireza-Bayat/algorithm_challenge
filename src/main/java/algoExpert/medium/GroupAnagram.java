package algoExpert.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alireza_bayat
 * created on 24/5/23
 */
public class GroupAnagram {

    public List<List<String>> groupAnagrams(List<String> stringLists) {
        Map<String, List<String>> anagramGroupMap = new HashMap<>();
        for (String stringList : stringLists) {
            char[] chars = stringList.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            if (anagramGroupMap.containsKey(sortedString)) {
                anagramGroupMap.get(sortedString).add(stringList);
                continue;
            }
            List<String> anagramWords = new ArrayList<>();
            anagramWords.add(stringList);
            anagramGroupMap.put(sortedString, anagramWords);
        }

        // to generate output only
        List<List<String>> anagrams = new ArrayList<>();
        for (String s : anagramGroupMap.keySet()) {
            anagrams.add(anagramGroupMap.get(s));
        }
        return anagrams;
    }
}

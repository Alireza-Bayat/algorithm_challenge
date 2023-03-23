package leet;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        int counter = 0;
        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            if (!characterSet.contains(s.charAt(rightPointer))) {
                characterSet.add(s.charAt(rightPointer));
                counter = Math.max(counter, rightPointer - leftPointer + 1);
            } else {
                while (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                    characterSet.remove(s.charAt(leftPointer));
                    leftPointer++;
                }
                characterSet.remove(s.charAt(leftPointer));
                leftPointer++;
                characterSet.add(s.charAt(rightPointer));
            }
        }

        return counter;
    }
}


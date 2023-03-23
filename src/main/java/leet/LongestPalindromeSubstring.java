package leet;

public class LongestPalindromeSubstring {

    int startingPosition;
    int lengthOfString;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i); //odd number
            checkPalindrome(s, i, i + 1); // even number
        }
        return s.substring(startingPosition, startingPosition + lengthOfString);
    }


    //considering that we are moving from middle to both ends so end++ and start--
    private void checkPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        // -1 is cause of array index start 0
        // start + 1 cause in the while we decreased the value in last loop which turn out it was not needed
        if (lengthOfString < end - start - 1) {
            lengthOfString = end - start - 1;
            startingPosition = start + 1;
        }
    }
}

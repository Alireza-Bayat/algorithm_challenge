package leet.twoPointer;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }

        int index = 0;
        int leftPointer = 0;
        while(leftPointer < t.length()){
            char sChar = s.charAt(index);
            char tChar = t.charAt(leftPointer);
            if (sChar == tChar){
                index++;
            }
            leftPointer++;
            if(index >= s.length()){
                return true;
            }
        }
        return false;
    }
}

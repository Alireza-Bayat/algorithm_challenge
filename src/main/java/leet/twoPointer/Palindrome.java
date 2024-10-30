package leet.twoPointer;

/**
 * @author alireza_bayat
 * created on 4/1/22
 */
public class Palindrome {

    public boolean isPalindrome(int x) {
        return reverseInteger(x) == x;
    }

    private int reverseInteger(int x) {
        int reverseInt = 0;
        while (x > 0) {
            int lastInt = x % 10;
            reverseInt = lastInt + (10 * reverseInt);
            x = x / 10;
        }
        return reverseInt;
    }

    public boolean isPalindrome(String s) {
        // s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        // System.out.println(s);
        // for (int i = 0;i < s.length(); i++){
        //     if(s.charAt(i) != s.charAt(s.length() - i -1)){
        //         return false;
        //     }
        // }
        // return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!((leftChar >= 'a' && leftChar <= 'z') || (leftChar >= 'A' && leftChar <= 'Z') || (leftChar >= '0' && leftChar <= '9'))) {
                left++;
            } else if (!((rightChar >= 'a' && rightChar <= 'z') || (rightChar >= 'A' && rightChar <= 'Z') || (rightChar >= '0' && rightChar <= '9'))) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}

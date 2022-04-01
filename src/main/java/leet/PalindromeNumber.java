package leet;

/**
 * @author alireza_bayat
 * created on 4/1/22
 */
public class PalindromeNumber {

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
}

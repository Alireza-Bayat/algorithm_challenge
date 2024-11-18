package leet.twopointer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alireza_bayat
 * created on 4/1/22
 */
public class PalindromeNumberTest {

    private Palindrome palindrome;

    @Before
    public void setup() {
        palindrome = new Palindrome();
    }

    @Test
    public void isPalindrome() {
        Assert.assertTrue(palindrome.isPalindrome(121));
    }

    @Test
    public void isPalindrome_negativeNumber() {
        Assert.assertFalse(palindrome.isPalindrome(-121));
    }

    @Test
    public void isPalindrome_2() {
        Assert.assertFalse(palindrome.isPalindrome(10));
    }

    @Test
    public void isPalindrome_3() {
        Assert.assertTrue(palindrome.isPalindrome(1));
    }

    @Test
    public void isPalindrome_4() {
        Assert.assertFalse(palindrome.isPalindrome(123));
    }

    @Test
    public void isPalindrome_String_with_signs_in_it() {
        Assert.assertTrue(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
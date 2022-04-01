package leet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author alireza_bayat
 * created on 4/1/22
 */
public class PalindromeNumberTest {

    private PalindromeNumber palindromeNumber;

    @Before
    public void setup() {
        palindromeNumber = new PalindromeNumber();
    }

    @Test
    public void isPalindrome() {
        Assert.assertTrue(palindromeNumber.isPalindrome(121));
    }

    @Test
    public void isPalindrome_negativeNumber() {
        Assert.assertFalse(palindromeNumber.isPalindrome(-121));
    }

    @Test
    public void isPalindrome_2() {
        Assert.assertFalse(palindromeNumber.isPalindrome(10));
    }

    @Test
    public void isPalindrome_3() {
        Assert.assertTrue(palindromeNumber.isPalindrome(1));
    }

    @Test
    public void isPalindrome_4() {
        Assert.assertFalse(palindromeNumber.isPalindrome(123));
    }
}
package leet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestPalindromeSubstringTest {

    private LongestPalindromeSubstring longestPalindromeSubstring;

    @Before
    public void setUp() {
        longestPalindromeSubstring = new LongestPalindromeSubstring();
    }

    @Test
    public void longestPalindrome() {
        Assert.assertEquals("aba", longestPalindromeSubstring.longestPalindrome("abaddd"));
    }

    @Test
    public void longestPalindrome_empty() {
        Assert.assertEquals("", longestPalindromeSubstring.longestPalindrome(""));
    }

    @Test
    public void longestPalindrome_odd() {
        Assert.assertEquals("abcba", longestPalindromeSubstring.longestPalindrome("zzsdabcbasss"));
    }

    @Test
    public void longestPalindrome_even() {
        Assert.assertEquals("abccba", longestPalindromeSubstring.longestPalindrome("zzsdabccbasss"));
    }
}
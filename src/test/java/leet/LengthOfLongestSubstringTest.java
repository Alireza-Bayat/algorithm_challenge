package leet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LengthOfLongestSubstringTest {

    private LengthOfLongestSubstring longestSubstring;

    @Before
    public void setup() {
        longestSubstring = new LengthOfLongestSubstring();
    }

    @Test
    public void lengthOfLongestSubstring() {
        Assert.assertEquals(6, longestSubstring.lengthOfLongestSubstring("abcdeffff"));
    }


    @Test
    public void lengthOfLongestSubstring_middle() {
        Assert.assertEquals(3, longestSubstring.lengthOfLongestSubstring("abssdde"));
    }

    @Test
    public void lengthOfLongestSubstring_empty() {
        Assert.assertEquals(0, longestSubstring.lengthOfLongestSubstring(""));
    }

    @Test
    public void lengthOfLongestSubstring_repeat() {
        Assert.assertEquals(1, longestSubstring.lengthOfLongestSubstring("aaaaaaaa"));
    }
}
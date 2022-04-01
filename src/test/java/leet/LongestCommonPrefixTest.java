package leet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author alireza_bayat
 * created on 4/2/22
 */
public class LongestCommonPrefixTest {


    private LongestCommonPrefix longestCommonPrefix;

    @Before
    public void setup() {
        longestCommonPrefix = new LongestCommonPrefix();
    }

    @Test
    public void longestCommonPrefix() {
        String[] strArr = {"flower", "flow", "floight"};
        Assert.assertEquals("flo", longestCommonPrefix.longestCommonPrefix(strArr));
    }

    @Test
    public void longestCommonPrefix_1() {
        String[] strArr = {"dog", "racecar", "car"};
        Assert.assertEquals("", longestCommonPrefix.longestCommonPrefix(strArr));
    }

    @Test
    public void longestCommonPrefix_2() {
        String[] strArr = {"ab", "a"};
        Assert.assertEquals("a", longestCommonPrefix.longestCommonPrefix(strArr));
    }

    @Test
    public void longestCommonPrefix_3() {
        String[] strArr = {"cir", "car"};
        Assert.assertEquals("c", longestCommonPrefix.longestCommonPrefix(strArr));
    }

    @Test
    public void longestCommonPrefix_4() {
        String[] strArr = {"flower", "flower", "flower", "flower"};
        Assert.assertEquals("flower", longestCommonPrefix.longestCommonPrefix(strArr));
    }
}
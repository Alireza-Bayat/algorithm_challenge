package leet.twoPointer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsSubsequenceTest {


    private IsSubsequence isSubsequence;

    @Before
    public void setup() {
        isSubsequence = new IsSubsequence();
    }

    @Test
    public void isSubsequence() {
        Assert.assertTrue(isSubsequence.isSubsequence("abc", "annnkbljpilcwe"));
    }

    @Test
    public void isSubsequence_false() {
        Assert.assertFalse(isSubsequence.isSubsequence("abcz", "annnkbljpilcwe"));
    }
}
package leet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestConsecutiveSeqTest {

    private LongestConsecutiveSeq longestConsecutiveSeq;

    @Before
    public void prepare() {
        longestConsecutiveSeq
                = new LongestConsecutiveSeq();
    }

    @Test
    public void longestConsecutive() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, longestConsecutiveSeq.longestConsecutive(nums));
    }

    public void longestConsecutiveV1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, longestConsecutiveSeq.longestConsecutiveV1(nums));
    }
}
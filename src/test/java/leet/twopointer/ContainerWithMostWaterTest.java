package leet.twopointer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ContainerWithMostWaterTest {

    ContainerWithMostWater containerWithMostWater;

    @Before
    public void prepare() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    @Test
    public void maxArea() {
        int[] height = {1, 2, 1, 1, 1, 1, 1, 9, 1, 9, 1, 1, 1, 2, 3, 1, 2};
        Assert.assertEquals(containerWithMostWater.maxArea(height), 30);

        int[] height2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(containerWithMostWater.maxArea(height2), 49);
    }
}
package leet.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class NumberOfIslandsTest {

    private NumberOfIslands numberOfIslands;

    @Before
    public void prepare() {
        numberOfIslands = new NumberOfIslands();
    }

    @Test
    public void numIslands() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '0'}};
        Assert.assertEquals(2, numberOfIslands.numIslands(grid));
        Assert.assertEquals(2, NumberOfIslands.VersionOne.numIslands(grid));
    }

    @Test
    public void numIslands_3() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        Assert.assertEquals(3, numberOfIslands.numIslands(grid));
        Assert.assertEquals(3, NumberOfIslands.VersionOne.numIslands(grid));
    }

}
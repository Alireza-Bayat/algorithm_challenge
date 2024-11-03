package leet.graph;

import org.junit.Before;
import org.junit.Test;

public class SurroundedRegionsTest {
    private SurroundedRegions surroundedRegions;

    @Before
    public void prepare() {
        surroundedRegions = new SurroundedRegions();
    }

    @Test
    public void solve() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        surroundedRegions.solve(board);
        System.out.println("DONE");
    }

    @Test
    public void solve_O() {
        char[][] board = {
                {'O', 'O'},
                {'O', 'O'}};
        surroundedRegions.solve(board);
        System.out.println("DONE");
    }
}
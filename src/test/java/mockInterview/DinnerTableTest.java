package mockInterview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DinnerTableTest {

    private DinnerTable dinnerTable;

    @Before
    public void startUp() {
        dinnerTable = new DinnerTable();
    }

    @Test
    public void solution() {
        int solution = dinnerTable.solution(new int[]{1, 2, 3, 4}, new int[]{1, 6, 7, 8});
        Assert.assertEquals(1, solution);
    }

    @Test
    public void table_notSatisfied() {
        int solution = dinnerTable.solution(new int[]{1, 1, 1, 1}, new int[]{1, 6, 7, 8});
        Assert.assertEquals(-1, solution);
    }
}
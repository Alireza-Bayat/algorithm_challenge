package leet.bitmanipulation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddBinaryTest {

    private AddBinary addBinary;

    @Before
    public void prepare() {
        addBinary = new AddBinary();
    }

    @Test
    public void addBinary() {
        Assert.assertEquals("100", addBinary.addBinary("11", "1"));
    }

}
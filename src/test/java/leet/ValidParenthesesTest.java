package leet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author alireza_bayat
 * created on 4/3/22
 */
public class ValidParenthesesTest {

    private ValidParentheses validParentheses;

    @Before
    public void setup() {
        validParentheses = new ValidParentheses();
    }

    @Test
    public void isValid() {
        Assert.assertTrue(validParentheses.isValid("((({}[])))"));
    }

    @Test
    public void isValid_2() {
        Assert.assertFalse(validParentheses.isValid("((({}[]))){"));
    }

    @Test
    public void isValid_3() {
        Assert.assertFalse(validParentheses.isValid("((({][]))){"));
    }

    @Test
    public void isValid_4() {
        Assert.assertFalse(validParentheses.isValid("("));
    }

    @Test
    public void isValid_5() {
        Assert.assertFalse(validParentheses.isValid("]"));
    }
}
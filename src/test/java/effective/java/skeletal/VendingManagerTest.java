package effective.java.skeletal;

import org.junit.Before;
import org.junit.Test;

import effective.java.codeSample.skeletal.CandyVending;
import effective.java.codeSample.skeletal.DrinkingVending;
import effective.java.codeSample.skeletal.Vending;

public class VendingManagerTest {

    private Vending candy;
    private Vending drink;

    @Before
    public void setup() {
        candy = new CandyVending();
        drink = new DrinkingVending();
    }

    @Test
    public void skeletalFlowOutput() {
        candy.process();
        System.out.println("---------------------------");
        drink.process();
    }
}

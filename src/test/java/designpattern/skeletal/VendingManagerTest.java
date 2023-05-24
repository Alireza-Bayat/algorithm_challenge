package designpattern.skeletal;

import org.junit.Before;
import org.junit.Test;

import designPattern.skeletal.CandyVending;
import designPattern.skeletal.DrinkingVending;
import designPattern.skeletal.Vending;

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

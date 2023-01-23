package designpattern.bridge;

import org.junit.Before;
import org.junit.Test;

import designPattern.bridge.device.Radio;
import designPattern.bridge.device.TV;
import designPattern.bridge.remote.AdvanceRemote;

public class DemoBridgePatternTest {

    private TV tv;
    private Radio radio;

    @Before
    public void setup() {
        tv = new TV();
        radio = new Radio();
    }

    @Test
    public void demoBridge(){
        AdvanceRemote advanceRemote = new AdvanceRemote(tv);
        advanceRemote.power();
        advanceRemote.channelUp();
        tv.printStatus();
    }
}

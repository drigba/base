package hu.bme.mit.train.tachnograph;

import hu.bme.mit.train.tachno.TachnographImpl;

import org.junit.Assert;
import org.junit.Test;


import java.util.Date;

public class TestTachnoGraph {

    @Test
    public void Test1(){
        TachnographImpl t = new TachnographImpl();
        t.add(new Date(), 12, 21);
        Assert.assertFalse(t.getTable().isEmpty());
    }
}

package com.xjj.sessionClient.core;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DeliverySessionCreationTypeTest extends TestCase {
    DeliverySessionCreationType deliverySessionCreationType = new DeliverySessionCreationType();

    @Test
    public void testSetDeliverySessionId() {
        long value = 11l;
        deliverySessionCreationType.setDeliverySessionId(value);
        assertEquals(value, deliverySessionCreationType.getDeliverySessionId());
    }
    @Test
    public void testSetAction() {
        ActionType action = ActionType.START;
        deliverySessionCreationType.setAction(action);
        assertEquals(action, deliverySessionCreationType.getAction());
    }
    @Test
    public void testSetTMGIPool() {
        deliverySessionCreationType.setTMGIPool("TMGPool");
        assertEquals("TMGPool", deliverySessionCreationType.getTMGIPool());
    }
    @Test
    public void testSetTMGI() {
        deliverySessionCreationType.setTMGI("TMG");
        assertEquals("TMG", deliverySessionCreationType.getTMGI());
    }
    @Test
    public void testSetStartTime() {
        Long time = 1122111l;
        deliverySessionCreationType.setStartTime(time);
        assertEquals(time, deliverySessionCreationType.getStartTime());
    }
    @Test
    public void testSetStopTime() {
        Long time = 333344444l;
        deliverySessionCreationType.setStopTime(time);
        assertEquals(time, deliverySessionCreationType.getStopTime());
    }
}
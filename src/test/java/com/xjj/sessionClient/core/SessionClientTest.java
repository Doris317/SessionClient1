package com.xjj.sessionClient.core;

import junit.framework.TestCase;
import org.junit.Test;

public class SessionClientTest extends TestCase {

    @Test
    public void testStart() {
        for (int i = 0; i < 10; i++) {
            SessionClient sessionClient = new SessionClient(i, 5);
        }


    }
}
package com.xjj.sessionClient;

import com.xjj.sessionClient.core.DeliverySessionCreationTypeTest;
import com.xjj.sessionClient.core.SessionClientTest;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DeliverySessionCreationTypeTest.class, SessionClientTest.class, })
public class AppTest extends TestCase {
    public AppTest(String testName) {
        super(testName);
    }

    public void testApp()
    {
        assertTrue( true );
    }

}

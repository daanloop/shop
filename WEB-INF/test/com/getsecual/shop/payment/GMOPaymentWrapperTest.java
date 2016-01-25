
package com.getsecual.shop.payment;

import static org.junit.Assert.*;
import com.getsecual.shop.payment.GMOPaymentWrapper;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;


@RunWith(JMock.class)
public class GMOPaymentWrapperTest {

    private GMOPaymentWrapper wrapper;
    private Mockery mockery;
    
    @Before
    public void setUp() {
        wrapper = new GMOPaymentWrapper();
        mockery = new JUnit4Mockery() {{
            setImposteriser(ClassImposteriser.INSTANCE);
        }};
    }
    
    @After
    public void checkExpectations() {
        mockery.assertIsSatisfied();
    }
}

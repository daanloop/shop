
package com.getsecual.shop.payment;

import static org.junit.Assert.*;
import com.getsecual.shop.payment.BankingPaymentGatewayConfiguration;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;


@RunWith(JMock.class)
public class BankingPaymentGatewayConfigurationTest {

    private BankingPaymentGatewayConfiguration configuration;
    private Mockery mockery;
    
    @Before
    public void setUp() {
        configuration = new BankingPaymentGatewayConfiguration();
        mockery = new JUnit4Mockery() {{
            setImposteriser(ClassImposteriser.INSTANCE);
        }};
    }
    
    @After
    public void checkExpectations() {
        mockery.assertIsSatisfied();
    }
}

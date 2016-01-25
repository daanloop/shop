
package net.malta.web.app;

import static org.junit.Assert.*;
import net.malta.web.app.ShowDeliveryAddressChoiseAction;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

/**
 * @author Denis Zhdanov
 * @since 01/19/2016
 */
@RunWith(JMock.class)
public class ShowDeliveryAddressChoiseActionTest {

    private ShowDeliveryAddressChoiseAction action;
    private Mockery mockery;
    
    @Before
    public void setUp() {
        action = new ShowDeliveryAddressChoiseAction();
        mockery = new JUnit4Mockery() {{
            setImposteriser(ClassImposteriser.INSTANCE);
        }};
    }
    
    @After
    public void checkExpectations() {
        mockery.assertIsSatisfied();
    }
}

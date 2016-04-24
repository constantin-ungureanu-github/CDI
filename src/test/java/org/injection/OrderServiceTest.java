package org.injection;

import static org.junit.Assert.assertEquals;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.injection.objects.Order;
import org.injection.services.OrderService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest {
    private WeldContainer weldContainer;
    private OrderService orderService;

    @Before
    public void initBeanManager() {
        weldContainer = new Weld().initialize();

        final BeanManager beanManager = weldContainer.getBeanManager();
        final Bean<?> orderServiceBean = beanManager.resolve(beanManager.getBeans(OrderService.class));

        orderService = (OrderService) beanManager.getReference(orderServiceBean, OrderService.class, beanManager.createCreationalContext(orderServiceBean));
    }

    @After
    public void closeBeanManager() {
        weldContainer.shutdown();
    }

    @Test
    public void testPurchaseOrder() throws Exception {
        Order order = orderService.purchase(100.0);
        assertEquals(70.0, order.getTotal(), 0.000001);
    }
}

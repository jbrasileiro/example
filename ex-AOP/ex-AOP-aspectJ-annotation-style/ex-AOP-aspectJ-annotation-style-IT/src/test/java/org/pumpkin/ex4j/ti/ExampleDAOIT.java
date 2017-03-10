package org.pumpkin.ex4j.ti;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Test;
import org.pumpkin.ex4j.ejb.service.ExampleServiceLocal;
import org.pumpkin.ex4j.ti.core.BaseIT;

public class ExampleDAOIT
    extends
    BaseIT {

    @Deployment(
        name = "deploymentEar")
    public static Archive<?> deploymentEar() {
        final String[] packageWEB = new String[] {
            "" };
        return BaseIT.createEAR(ExampleDAOIT.class, null, packageWEB);
    }

    @Before
    public void setUp() {
    }

    @EJB
    private ExampleServiceLocal service;

    @Test
    public void test() {
        final String result = service.getResult(1);
        System.out.println(result);
    }

}

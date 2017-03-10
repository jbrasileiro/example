package org.pumpkin.ex4j.ti;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.Test;
import org.pumpkin.ex4j.ejb.service.ExampleServiceLocal;
import org.pumpkin.ex4j.ti.core.BaseIT;

public class ExampleDAOIT
    extends
    BaseIT {

    private static final String[] DEPENDENCIES = {
        "org.aspectj:aspectjrt:1.8.7"
    };

    @Deployment(
        name = "deploymentEar")
    public static Archive<?> deploymentEar() {
        JavaArchive lib = ShrinkWrap.create(JavaArchive.class, "libs.jar");
        for (String dependency : DEPENDENCIES) {
            lib.merge(Maven.resolver().resolve(dependency).withTransitivity().asSingle(JavaArchive.class));
        }
        JavaArchive jar = getJAR().merge(lib);
        WebArchive war = getWAR();
        war.addPackages(true, "");
        EnterpriseArchive ear = getEAR(jar, war);
        ear.toString(true);
        return ear;
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

package org.pumpkin.ex4j.ti.core;

import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public interface TestIntegration {

    JavaArchive getJAR();

    WebArchive getWAR();

    EnterpriseArchive getEAR(JavaArchive jar,
        WebArchive war);

}

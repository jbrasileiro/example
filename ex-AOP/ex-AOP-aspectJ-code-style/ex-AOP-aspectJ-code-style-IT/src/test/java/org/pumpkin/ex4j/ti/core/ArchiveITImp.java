package org.pumpkin.ex4j.ti.core;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class ArchiveITImp
    implements
    ArchiveIT {

    public static final String WAR_NAME = "test-intregation-war.war";
    public static final String JAR_NAME = "test-intregation-jar.jar";
    public static final String EAR_NAME = "test-integration-ear.ear";

    @Override
    public JavaArchive getJAR() {
        final JavaArchive jar = ShrinkWrap.create(JavaArchive.class, JAR_NAME);
        jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return jar;
    }

    @Override
    public WebArchive getWAR() {
        final WebArchive war = ShrinkWrap.create(WebArchive.class, WAR_NAME);
        war.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        return war;
    }

    @Override
    public EnterpriseArchive getEAR(final JavaArchive jar,
        final WebArchive war) {
        final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, EAR_NAME);
        ear.addAsModule(jar);
        ear.addAsModule(war);
        return ear;
    }
}

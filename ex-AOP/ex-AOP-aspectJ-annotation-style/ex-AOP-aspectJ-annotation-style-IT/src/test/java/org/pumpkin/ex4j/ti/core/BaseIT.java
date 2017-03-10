package org.pumpkin.ex4j.ti.core;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public abstract class BaseIT
    implements
    IntegrationTest {

    public static EnterpriseArchive createEAR(final Class<?> clazz,
        final String[] packageJAR,
        final String[] packageWEB) {
        final ArchiveIT archiveIT = getArchiveIT();
        final JavaArchive jar = archiveIT.getJAR();
        if (packageJAR != null) {
            for (final String vPackage : packageJAR) {
                jar.addPackages(true, vPackage);
            }
        }
        final WebArchive war = archiveIT.getWAR();
        if (packageWEB != null) {
            for (final String vPackage : packageWEB) {
                jar.addPackages(true, vPackage);
            }
        }
        war.addClass(clazz);
        final EnterpriseArchive ear = archiveIT.getEAR(jar, war);
        System.out.println(ear.toString(true));
        return ear;
    }

    private static ArchiveIT getArchiveIT() {
        return new ArchiveITImp();
    }
}

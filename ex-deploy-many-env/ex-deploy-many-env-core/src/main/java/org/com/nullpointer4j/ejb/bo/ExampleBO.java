package org.com.nullpointer4j.ejb.bo;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ExampleBOLocal.class)
public class ExampleBO
    implements
    ExampleBOLocal {

    @Override
    public Boolean execute() {
        return true;
    }
}

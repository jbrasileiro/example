package org.com.nullpointer4j.ejb.bo;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

public interface ExampleBOLocal {

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    Boolean execute();
}

package org.com.nullpointer4j.web.ws;

import javax.ejb.EJB;
import javax.jws.WebService;

import org.com.nullpointer4j.ejb.bo.ExampleBOLocal;

@WebService(
    serviceName = "ExampleWebService",
    endpointInterface = "org.com.nullpointer4j.web.ws.ExampleWebService")
public class ExampleWebServiceImp
    implements
    ExampleWebService {
    
    @EJB
    private ExampleBOLocal exampleBO;

    public Boolean execute(
        final String request) {
        return exampleBO.execute();
    }
}

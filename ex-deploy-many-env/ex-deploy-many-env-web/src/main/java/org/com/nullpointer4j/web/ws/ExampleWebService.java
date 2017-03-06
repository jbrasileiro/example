package org.com.nullpointer4j.web.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(
    targetNamespace = "http://interfaces.ws.extratoservice.riachuelo.com.br/")
@SOAPBinding(
    style = Style.RPC)
public interface ExampleWebService {

    @WebMethod
    Boolean execute(
        @WebParam(
            name = "request") String request);

}

package org.pumpkin.ex4j;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(
    targetNamespace = "http://interfaces.ws.clienteservice.riachuelo.com.br/")
@SOAPBinding(
    style = Style.RPC)
public interface IExampleWebService {

    @WebMethod
    ExampleResponse obterCliente(
        @WebParam(
            name = "request") ExampleRequest request);
}

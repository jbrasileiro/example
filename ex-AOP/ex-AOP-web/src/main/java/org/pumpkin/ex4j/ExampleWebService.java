package org.pumpkin.ex4j;

import javax.ejb.EJB;
import javax.jws.WebService;

import org.pumpkin.ex4j.ejb.service.ExampleServiceLocal;

@WebService(
    serviceName = "ClienteWService",
    targetNamespace = "http://interfaces.ws.clienteservice.riachuelo.com.br/",
    endpointInterface = "br.com.riachuelo.fincliente.web.webservices.IClienteWService")
public class ExampleWebService
    implements
    IExampleWebService {

    @EJB
    private ExampleServiceLocal exampleService;

    @Override
    public ExampleResponse obterCliente(
        final ExampleRequest request) {
        try {
            final ExampleResponse response = new ExampleResponse();
            response.setResult(exampleService.getResult(request.getId()));
            return response;
        } catch (final Exception e) {
            e.printStackTrace();
            final ExampleResponse response = new ExampleResponse();
            response.setResult(e.getMessage());
            return response;
        }
    }
}

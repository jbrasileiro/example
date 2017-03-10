package org.pumpkin.ex4j;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExampleRequest
    implements
    WebServiceRequest {

    private static final long serialVersionUID = -4350583978814254103L;
    @XmlElement(
        name = "id",
        required = true,
        nillable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }
}

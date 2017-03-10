package org.pumpkin.ex4j.ejb.service;

import java.util.Random;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ExampleServiceLocal.class)
public class ExampleService
    implements
    ExampleServiceLocal {

    @Override
    public String getResult(
        final Integer id) {
        return "Random number: ".concat(Long.toString(new Random(1500).nextLong()));
    }
}

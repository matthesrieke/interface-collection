/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.spring.injection.interfacecollection.handlers;

import org.springframework.stereotype.Component;

/**
 *
 * @author matthes
 */
@Component
public class MohammedGreetingsHandler implements GreetingsHandler {

    @Override
    public boolean canHandleName(String name) {
        return "mohammed".equalsIgnoreCase(name);
    }

    @Override
    public String greetPerson(String name) {
        return String.format("Good day, %s!", name);
    }
    
}

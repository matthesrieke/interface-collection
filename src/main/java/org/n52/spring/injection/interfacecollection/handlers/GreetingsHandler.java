/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.n52.spring.injection.interfacecollection.handlers;

/**
 *
 * @author matthes
 */
public interface GreetingsHandler {
    
    boolean canHandleName(String name);
    
    String greetPerson(String name);
    
}

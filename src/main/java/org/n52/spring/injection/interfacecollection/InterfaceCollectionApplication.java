package org.n52.spring.injection.interfacecollection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.n52.spring.injection.interfacecollection.handlers.GreetingsHandler;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterfaceCollectionApplication implements InitializingBean {

    @Autowired
    List<GreetingsHandler> handlers;

    public static void main(String[] args) {
        SpringApplication.run(InterfaceCollectionApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Hi, who is there?");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine().trim();
        
        Optional<GreetingsHandler> candidate = this.handlers.stream()
                .filter(h -> h.canHandleName(name))
                .findFirst();
        
        if (candidate.isPresent()) {
            System.out.println(candidate.get().greetPerson(name));
        } else {
            System.out.println("Sorry, I do not know you...");
        }
    }

}

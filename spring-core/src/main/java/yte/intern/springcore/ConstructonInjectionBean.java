package yte.intern.springcore;

import org.springframework.stereotype.Component;

@Component
public class ConstructonInjectionBean {

    public void print(){
        System.out.println("Ben bir constructor injection bean'iyim");
    }
}

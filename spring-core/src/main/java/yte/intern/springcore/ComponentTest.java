package yte.intern.springcore;

import org.springframework.stereotype.Component;

@Component
public class ComponentTest { // bu class SpringCoreApp classı ile aynı yerde olmak zorundador
    public void print(){
        //System.out.println("welcome to spring");
        System.out.println("Ben @Component kullanıyorum");
    }
}

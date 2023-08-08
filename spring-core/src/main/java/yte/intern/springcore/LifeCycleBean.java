package yte.intern.springcore;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleBean {

    public LifeCycleBean(){
        System.out.println("constructor içerisindeyim");
    }

    @PostConstruct
    public void init(){
        System.out.println("init içerisindeyim");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy içerisindeyim");
    }

    public void print(){
        System.out.println("print içerisindeyim");
    }
}

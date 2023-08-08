package yte.intern.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InjectionTest {

    public ComponentTest componentTest;
    public BeanTest beanTest;

    @Autowired
    public InjectionTest(ComponentTest componentTest, BeanTest beanTest) {
        this.componentTest = componentTest;
        this.beanTest = beanTest;
    }

    public void print(){
        beanTest.print();
        componentTest.print();
    }

}

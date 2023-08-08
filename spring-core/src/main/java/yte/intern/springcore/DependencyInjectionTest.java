package yte.intern.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  //bunun da bir bean olması gerekiyor
public class DependencyInjectionTest {

    @Autowired
    private FieldInjectionBean fieldInjectionBean;
    private SetterInjectionBean setterInjectionBean;

    private ConstructonInjectionBean constructonInjectionBean;

    @Autowired  // bu sayede new lemeden kendiliğinden objeleri oluşturacak
    public DependencyInjectionTest(ConstructonInjectionBean constructonInjectionBean){
        this.constructonInjectionBean = constructonInjectionBean;
    }

    public void print(){
        fieldInjectionBean.print();
        setterInjectionBean.print();
        constructonInjectionBean.print();
    }

    @Autowired
    public void setSetterInjectionBean(SetterInjectionBean setterInjectionBean) {
        this.setterInjectionBean = setterInjectionBean;
    }
}

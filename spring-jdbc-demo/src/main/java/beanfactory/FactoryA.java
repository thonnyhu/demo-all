package beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * Created by Mirana on 2017/8/25.
 */
public class FactoryA implements FactoryBean<A> {

    private A a = new A();

    public A getObject() throws Exception {
        return a;
    }

    public Class<?> getObjectType() {
        return A.class;
    }

    public boolean isSingleton() {
        return true;
    }
}

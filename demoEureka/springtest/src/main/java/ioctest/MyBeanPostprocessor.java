package ioctest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;


@Component
public class MyBeanPostprocessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessorBeforeInitialization.." + beanName + "=>" + bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postprocessotAfterInitialization.." + beanName + "=>" + bean);
        return bean;
    }

    public void dosomthing() {
        IntStream.range(0, 10).mapToObj(i -> new Thread(() -> System.out.println("mmm"), String.valueOf(i)));

    }


}

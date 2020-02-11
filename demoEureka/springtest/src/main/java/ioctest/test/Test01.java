package ioctest.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.view.document.AbstractPdfView;

public class Test01 {
    public static void main(String[] args) {
        String s3 = new String("123") + new String("123");
        s3.intern();
        String s4 = "123123";
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

    }
}

import enums.GetClass;
import org.junit.Test;
import poji.BaseEntity;
import poji.Student;
import poji.TemplatexClass;
import service.StealMethod;
import serviceImpl.HitAndStoneMethod;

import java.lang.reflect.Method;

public class TestReflect {

    @Test
    public void test01() throws Exception {
//        StealMethod s = new HitAndStoneMethod();
        TemplatexClass item = new Student("jrbing");
        String s1 = printClassInfo(item.getClass());
        String methodName = "set" + s1;
        BaseEntity b = new BaseEntity();
        //2.一参
        Method method2 = b.getClass().getMethod(methodName, item.getClass());
        method2.invoke(b, item);
        System.out.println("getStudent:     " + b.getStudent());
    }

    String printClassInfo(Class c) {
//        System.out.println("Class Name :" + c.getName()
//                + "is interface? :" + c.isInterface()
//                + "simple Name " + c.getSimpleName()
//        );
        String name1 = c.getName();
        String[] name = (name1).split("\\.");
        int len = name.length - 1;
        String s = name[len];
        return s;
    }

}
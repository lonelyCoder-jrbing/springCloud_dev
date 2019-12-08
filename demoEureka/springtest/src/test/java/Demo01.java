import ioctest.MyBeanPostprocessor;
import org.springframework.beans.factory.annotation.Autowired;

public class Demo01 {
    @Autowired
    private MyBeanPostprocessor myBeanPostprocessor;

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        demo01.test01();

    }


    public void test01() {

        myBeanPostprocessor.dosomthing();

    }

}

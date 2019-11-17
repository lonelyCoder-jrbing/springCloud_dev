package service;

import poji.Student;
import poji.Teacher;

public interface StealMethod {

     Student student=null;
     Teacher teacher=null;





    String pickTarget();

    void confuseThetarget(String target);

    void stealTheItem(String target);

    default void steal() {
        String target = pickTarget();
        confuseThetarget(target);
        stealTheItem(target);
    }
}

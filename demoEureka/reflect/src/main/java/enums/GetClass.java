package enums;

import poji.Student;
import poji.Teacher;

public enum GetClass {


    TEACHER("Teacher", Teacher.class),
    STUDENT("Student", Student.class);


    private String name;
    private Class clzz;

    GetClass(String name, Class clzz) {
        this.name = name;
        this.clzz = clzz;
    }

    public static Class getClass(String s) throws Exception {
        for (GetClass e : GetClass.values()) {
            if (s.equals(e.name)) {
                return e.clzz;
            }
        }
        throw new Exception("");
    }


}

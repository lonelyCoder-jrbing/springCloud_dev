package com.yh.TestTemplateMethod;

public class APP {
    public static void main(String[] args) {
        //模板方法给算法定义了一个框架,框架的实现类提供算法的具体实现
        HitAndRunMethod method = new HitAndRunMethod();
        Theif theif = new Theif(method);
        theif.steal();

        SubtleMethod method1 = new SubtleMethod();
        theif.changMethod(method1);
        theif.steal();

    }


}

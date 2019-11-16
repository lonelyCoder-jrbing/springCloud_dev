package com.yh.TestTemplateMethod;

public class Theif {
    private StealingMethod method;

    public Theif(StealingMethod method) {
        this.method = method;
    }


    public void steal() {
        method.steal();
    }

    public void changMethod(StealingMethod method) {
        this.method = method;
    }
}

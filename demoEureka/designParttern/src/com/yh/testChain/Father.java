package com.yh.testChain;

public abstract class Father {

    private Father nextSon;

    public Father(Father nextSon) {
        this.nextSon = nextSon;
    }

    public void dosomething() {
    }


}

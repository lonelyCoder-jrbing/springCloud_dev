package com.yh.visitor;

public class ConfiguretionForUnix implements ZoomVisitor {

    @Override
    public void visit(Zoom zoom) {
        System.out.println("zoom is coming to visit unix");
    }
}

package com.yh.visitor;

public class ConfiguretionForDos implements AllmodelVisitor {

    @Override
    public void visit(Heys heys) {
        System.out.println("heys is come to visit dos...");
    }

    @Override
    public void visit(Zoom zoom) {
        System.out.println("zoom is coming to visit dos....");
    }
}

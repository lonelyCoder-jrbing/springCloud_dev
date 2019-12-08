package com.yh.visitor;

public class Heys extends Model {

    @Override
    public void accept(ModellVisitor modellVisitor) {
        if (modellVisitor instanceof HeysVisitor) {
            ((HeysVisitor) modellVisitor).visit(this);
            System.out.println("heys is coming to visit me...");
        } else {
            System.out.println("no one but heys can visit me ....");
        }
    }

    @Override
    public String toString() {
        return "Heys{}";
    }
}

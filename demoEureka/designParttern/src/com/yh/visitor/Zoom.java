package com.yh.visitor;

public class Zoom extends Model {

    @Override
    public void accept(ModellVisitor modellVisitor) {
        if (modellVisitor instanceof ZoomVisitor) {
            ((ZoomVisitor) modellVisitor).visit(this);
            System.out.println("zoom comes to visit me ..");
        } else {
            System.out.println("no one but zoom can come here...");
        }
    }

    @Override
    public String toString() {
        return "Zoom{}";
    }
}

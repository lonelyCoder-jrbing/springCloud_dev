package com.yh.nullObject;

public class NullNode implements Node {

    private NullNode() {
    }

    private static NullNode Instance = new NullNode();

    public static Node getInstance() {
        return Instance;
    }


    @Override
    public Node getRight() {
        return null;
    }

    @Override
    public Node getLeft() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void walk() {
        //do nothing
    }

    @Override
    public int getTreeSize() {
        return 0;
    }
}

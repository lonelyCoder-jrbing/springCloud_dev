package com.yh.nullObject;

public class NodeImpl implements Node {

    private String name;
    private Node left;
    private Node right;

    public NodeImpl(String name, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public Node getRight() {
        return this.right;
    }

    @Override
    public Node getLeft() {
        return this.left;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void walk() {
        System.out.println("name:  " + name);
        if (left.getTreeSize() > 0) {
            left.walk();
        }
        if (right.getTreeSize() > 0) {
            right.walk();
        }
    }

    @Override
    public int getTreeSize() {
        return 1 + left.getTreeSize() + right.getTreeSize();
    }
}

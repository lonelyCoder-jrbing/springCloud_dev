package com.yh.nullObject;

public class AppTest {
    public static void main(String[] args) {
        Node node =  new NodeImpl("root",
                new NodeImpl("111",
                        new NodeImpl("2222",NullNode.getInstance(), NullNode.getInstance()),NullNode.getInstance())
                , NullNode.getInstance());
        node.walk();
    }
}

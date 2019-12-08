package com.yh.facade;

public class App {
    /*充分利用了构造器的优势，在创建一个对象的时候，将子系统顺带进行初始化，
    在调用方法的时候，将子系统以参数形式穿进去。并且将子系统的行为特征使用枚举的类型进行表示，
    当子系统进行多个动作时，可以传入多个类型枚举参数。
    */
    public static void main(String[] args) {
        DwarvenGoldmineFacade facade = new DwarvenGoldmineFacade();
        facade.startNewday();
        facade.digOutGold();
        facade.endUpaDay();
    }
}

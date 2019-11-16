package com.yh.delegation;

public class PrintController {

  private Printer printer;
  //代理模式将，共同实现了一个接口的几个类用一个代理对他们进行统一管理。
  //创建代理对象的时候需要将接口的应用放进代理类的构造器中，在使用代理类进行创建的时候直接在代理类中传入需要使用的对象。
  public PrintController(Printer printer) {
    this.printer = printer;
  }
  public  void print(){
    printer.print();
  }

}

package com.yh.delegation.printers;

import com.yh.delegation.MESG;
import com.yh.delegation.Printer;

public class HpPrinter implements Printer {

  @Override
  public void print() {
    System.out.println(MESG.HP.getMesg());
  }
}

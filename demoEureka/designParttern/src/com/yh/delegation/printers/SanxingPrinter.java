package com.yh.delegation.printers;

import com.yh.delegation.MESG;
import com.yh.delegation.Printer;

public class SanxingPrinter implements Printer {

    @Override
    public void print() {
        System.out.println(MESG.SANXING.getMesg());
    }
}

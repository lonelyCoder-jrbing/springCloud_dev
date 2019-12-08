package com.yh.delegation.printers;

import com.yh.delegation.MESG;
import com.yh.delegation.Printer;

public class HuaweiPrinter implements Printer {

    @Override
    public void print() {
        System.out.println(MESG.HUAWEI.getMesg());
    }
}

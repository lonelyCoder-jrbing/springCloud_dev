package com.yh.delegation;

import com.yh.delegation.printers.HpPrinter;
import com.yh.delegation.printers.HuaweiPrinter;
import com.yh.delegation.printers.SanxingPrinter;

public class APP {

    public static void main(String[] args) {
        HpPrinter hp = new HpPrinter();
        HuaweiPrinter huawei = new HuaweiPrinter();
        SanxingPrinter sanxingPrinter = new SanxingPrinter();
        PrintController pc = new PrintController(hp);
        PrintController huaweiprint = new PrintController(huawei);
        PrintController sanxingprinter = new PrintController(sanxingPrinter);
        pc.print();
        huaweiprint.print();
        sanxingPrinter.print();


    }


}

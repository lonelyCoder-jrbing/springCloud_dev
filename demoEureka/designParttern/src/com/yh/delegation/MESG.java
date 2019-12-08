package com.yh.delegation;

public enum MESG {
    HP("hp printer is printing..."), HUAWEI("huawei printer is printing"), SANXING("sanxing printer is printing");
    private String mesg;

    MESG(String mesg) {
        this.mesg = mesg;
    }

    public String getMesg() {
        return mesg;
    }
}

package com.yh.ConverterTest;

public class Changeface implements Converter<UglyGirl, BeautyGirl> {

    @Override
    public BeautyGirl convert(UglyGirl source) {
        BeautyGirl beautyGirl = new BeautyGirl();
        beautyGirl.setEyes(source.getEyes());
        return beautyGirl;
    }
}

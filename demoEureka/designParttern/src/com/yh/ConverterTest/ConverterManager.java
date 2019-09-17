package com.yh.ConverterTest;


import org.springframework.beans.BeanUtils;

public final class ConverterManager {

  private Converter converter;

//  private ConverterManager(Converter converter) {
//    this.converter = converter;
//  }
//  public static ConverterManager builder(Class<? extends Converter> target){
//    Converter converter = (Converter)BeanUtils.instantiateClass(target);
//    return new ConverterManager(converter);
//  }
  public <T,R> R convert(T source){
    return (R) this.converter.convert(source);
  }
}

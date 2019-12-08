package com.yh.ConverterTest;

@FunctionalInterface
public interface Converter<T, R> {

    R convert(T source);
}

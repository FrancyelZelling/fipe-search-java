package com.zelling.fipe.utils;

public interface ConverterInterface {
    <T> T getData(String Json, Class <T> newClass);
}

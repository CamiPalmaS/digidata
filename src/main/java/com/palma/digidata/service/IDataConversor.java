package com.palma.digidata.service;

public interface IDataConversor {
    <T> T obtainData(String json, Class<T> tClass);
}

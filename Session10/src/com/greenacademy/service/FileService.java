package com.greenacademy.service;

import java.util.List;

public interface FileService <T> {
    void save(String path, List<T> data);
    List<T> load(String path);
}

package com.greenacademy.service.impl;

import com.greenacademy.service.FileService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl<T> implements FileService<T> {
    @Override
    public void save(String path, List<T> data) {
        // D:\\New folder\\data.txt
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<T> load(String path) {
        try (FileInputStream fos = new FileInputStream(path)) {
            ObjectInputStream oos = new ObjectInputStream(fos);
            return (List<T>) oos.readObject();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }
}

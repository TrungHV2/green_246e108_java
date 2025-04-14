package com.greenacademy.model;

public interface NetEntity {
    void update(NetEntity other);
    Object getKey();
}

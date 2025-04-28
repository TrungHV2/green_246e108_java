package com.greenacademy.util;

import java.sql.SQLException;

@FunctionalInterface
public interface ThrowFunc<T, R> {
    R apply(T t) throws Exception;
}

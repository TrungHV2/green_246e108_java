package com.greenacademy.util;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface MyFunc<T> {
    T apply(ResultSet rs) throws SQLException;
}

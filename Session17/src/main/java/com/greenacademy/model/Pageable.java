package com.greenacademy.model;

import java.util.List;

public class Pageable<T> {
    private List<T> data;
    private int page;
    private int pageSize;
    private int total;

    public Pageable() {
    }

    public Pageable(List<T> data, int page, int pageSize, int total) {
        this.data = data;
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

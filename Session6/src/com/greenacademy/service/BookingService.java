package com.greenacademy.service;

import com.greenacademy.model.Booking;

public interface BookingService {
    Booking[] findAll();
    Booking findById(String id);
    boolean add(Booking booking);
    boolean delete(String id);
}

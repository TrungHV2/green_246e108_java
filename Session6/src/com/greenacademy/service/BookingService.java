package com.greenacademy.service;

import com.greenacademy.model.Booking;

import java.util.Date;

public interface BookingService {
    Booking[] findAll();
    Booking findById(String id);
    boolean bookIdExists(String id);
    boolean validateDate(int roomId, Date from, Date to);
    boolean add(Booking booking);
    boolean delete(String id);
}

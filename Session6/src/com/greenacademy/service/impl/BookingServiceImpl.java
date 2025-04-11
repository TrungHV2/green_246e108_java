package com.greenacademy.service.impl;

import com.greenacademy.model.Booking;
import com.greenacademy.service.BookingService;

import java.util.Arrays;
import java.util.Date;

public class BookingServiceImpl implements BookingService {
    private static BookingServiceImpl instance;
    private Booking[] bookings;
    private int index = 0;

    private BookingServiceImpl() {
        bookings = new Booking[10];
    }

    public static BookingServiceImpl getInstance() {
        if (instance == null)
            instance = new BookingServiceImpl();
        return instance;
    }

    @Override
    public Booking[] findAll() {
        return Arrays.copyOf(bookings, index);
    }

    @Override
    public Booking findById(String id) {
        for (int i = 0; i < index; i++)
            if (bookings[i].getBookId().equals(id))
                return bookings[i];
        return null;
    }

    @Override
    public boolean bookIdExists(String id) {
        for (int i = 0; i < index; i++)
            if (bookings[i].getBookId().equals(id))
                return true;
        return false;
    }

    @Override
    public boolean validateDate(int roomId, Date from, Date to) {
        for (int i = 0; i < index; i++)
            if (bookings[i].getRoomId() == roomId && (
                (bookings[i].getStartDate().after(from) && bookings[i].getStartDate().before(to)) ||
                (bookings[i].getEndDate().after(from) && bookings[i].getEndDate().before(to))
            ))
                return true;
        return false;
    }

    @Override
    public boolean add(Booking booking) {
        if (index == bookings.length)
            bookings = Arrays.copyOf(bookings, bookings.length + 10);
        bookings[index++] = booking;
        return true;
    }

    @Override
    public boolean delete(String id) {
        int deleted = -1;
        for (int i = 0; i < index; i++) {
            if (bookings[i].getBookId().equals(id)) {
                deleted = i;
                break;
            }
        }
        if (deleted != -1) {
            index--;
            System.arraycopy(bookings, deleted + 1, bookings, deleted, index - deleted);
            bookings[index] = null;
            return true;
        }
        return false;
    }
}

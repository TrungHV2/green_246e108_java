package com.greenacademy.service;

import com.greenacademy.model.Room;

public interface RoomService {
    Room[] findAll();
    Room[] findByPrice(double fromPrice, double toPrice);
    Room findById(int id);
    boolean roomNumberExists(String roomNumber);
    void save(Room room);
    void edit(Room room);
    void delete(int id);
}

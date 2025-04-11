package com.greenacademy.service.impl;

import com.greenacademy.model.Room;
import com.greenacademy.service.RoomService;

import java.util.Arrays;

public class RoomServiceImpl implements RoomService {
    private static RoomServiceImpl instance;
    private Room[] rooms;
    private int index = 0;

    private RoomServiceImpl() {
        rooms = new Room[10];
    }

    public static RoomServiceImpl getInstance() {
        if (instance == null)
            instance = new RoomServiceImpl();
        return instance;
    }

    @Override
    public Room[] findAll() {
        return Arrays.copyOf(rooms, index);
    }

    @Override
    public Room[] findByPrice(double fromPrice, double toPrice) {
        int count = 0;
        for (int i = 0; i < index; i++)
            if (rooms[i].getPrice() >= fromPrice && rooms[i].getPrice() <= toPrice)
                count++;
        Room[] result = new Room[count];
        int _index = 0;
        for (int i = 0; i < index; i++)
            if (rooms[i].getPrice() >= fromPrice && rooms[i].getPrice() <= toPrice)
                result[_index++] = rooms[i];
        return result;
    }

    @Override
    public Room findById(int id) {
        for (int i = 0; i < index; i++)
            if (rooms[i].getRoomId() == id)
                return rooms[i];
        return null;
    }

    @Override
    public boolean roomNumberExists(String roomNumber) {
        for (int i = 0; i < index; i++)
            if (rooms[i].getRoomNumber().equals(roomNumber))
                return true;
        return false;
    }

    @Override
    public void save(Room room) {
        if (index == rooms.length)
            rooms = Arrays.copyOf(rooms, rooms.length + 10);
        rooms[index++] = room;
    }

    @Override
    public void edit(Room room) {
        Room old = findById(room.getRoomId());
        if (old != null) {
            old.setRoomNumber(room.getRoomNumber());
            old.setRoomType(room.getRoomType());
            old.setPrice(room.getPrice());
        }
    }

    @Override
    public void delete(int id) {
        int delIndex = -1;
        for (int i = 0; i < index; i++) {
            if (rooms[i].getRoomId() == id) {
                delIndex = i;
                break;
            }
        }
        if (delIndex != -1) {
            index--;
            System.arraycopy(rooms, delIndex + 1, rooms, index, index - delIndex);
            rooms[index] = null;
        }
    }
}

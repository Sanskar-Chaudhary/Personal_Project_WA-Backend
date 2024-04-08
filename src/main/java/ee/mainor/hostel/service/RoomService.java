package ee.mainor.hostel.service;

import ee.mainor.hostel.model.Room;
import ee.mainor.hostel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(String id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room updatedRoom) {
        if (roomRepository.existsById(updatedRoom.getId())) {
            return roomRepository.save(updatedRoom);
        }
        throw new RuntimeException("Room does not exist.");
    }

    public void deleteRoom(String id) {
        roomRepository.deleteById(id);
    }

}

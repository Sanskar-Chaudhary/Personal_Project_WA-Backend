package ee.mainor.hostel.service;

import ee.mainor.hostel.model.Booking;
import ee.mainor.hostel.model.Room;
import ee.mainor.hostel.repository.BookingRepository;
import ee.mainor.hostel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking addBooking(Booking booking) {
        Optional<Room> room = roomRepository.findById(booking.getRoomId());
        if (room.isEmpty()) {
            throw new RuntimeException("Room does not exist.");
        }
        if (!isRoomAvailable(booking.getRoomId(), booking.getCheckInDate(), booking.getCheckOutDate())) {
            throw new RuntimeException("Room not available for the given dates");
        }
        if (!isAtLeastOneDay(booking.getCheckInDate(), booking.getCheckOutDate())) {
            throw new RuntimeException("Booking must be for at least one day");
        }
        return bookingRepository.save(booking);
    }


    private boolean isRoomAvailable(String roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Booking> overlappingBookings = bookingRepository.findBookingsByRoomAndDateRange(roomId, checkInDate, checkOutDate);
        return overlappingBookings.isEmpty();
    }

    private boolean isAtLeastOneDay(LocalDate checkInDate, LocalDate checkOutDate) {
        return !checkInDate.isEqual(checkOutDate);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        return bookingRepository.findById(id).map(existingBooking -> {
            updatedBooking.setId(existingBooking.getId()); // Ensure the ID is correct
            return bookingRepository.save(updatedBooking);
        }).orElseThrow(() -> new RuntimeException("Booking does not exist."));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}

package ee.mainor.hostel.repository;

import ee.mainor.hostel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.roomId = :roomId AND NOT (b.checkOutDate <= :checkInDate OR b.checkInDate >= :checkOutDate)")
    List<Booking> findBookingsByRoomAndDateRange(String roomId, LocalDate checkInDate, LocalDate checkOutDate);
}

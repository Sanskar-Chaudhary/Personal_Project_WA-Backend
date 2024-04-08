// model/Booking.java
package ee.mainor.hostel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roomId;
    private String userId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;


    // Constructor
    public Booking(String roomId, String userId, LocalDate checkInDate, LocalDate checkOutDate) {
        this.roomId = roomId;
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

}

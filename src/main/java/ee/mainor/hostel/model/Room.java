// model/Room.java
package ee.mainor.hostel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Room {
    @Id
    private String id;
    private String type;
    private double monthlyPrice;
    private double nightlyPrice;


    // Constructor
    public Room(String id, String type, double monthlyPrice, double nightlyPrice) {
        this.id = id;
        this.type = type;
        this.monthlyPrice = monthlyPrice;
        this.nightlyPrice = nightlyPrice;

    }

}

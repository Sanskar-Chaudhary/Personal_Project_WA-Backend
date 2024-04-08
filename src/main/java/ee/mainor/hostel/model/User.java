package ee.mainor.hostel.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_users")
@Getter
@Setter
@NoArgsConstructor

public class User {
    @Id
    private String username; // Simple identifier for demo purposes
    private String password; // In a real app, passwords should never be stored in plain text

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

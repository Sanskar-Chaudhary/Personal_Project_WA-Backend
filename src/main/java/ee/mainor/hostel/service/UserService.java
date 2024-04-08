package ee.mainor.hostel.service;

import ee.mainor.hostel.model.User;
import ee.mainor.hostel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        // In a real app, check if user exists and encrypt password
        return userRepository.save(user);
    }

    public boolean loginUser(String username, String password) {
        return userRepository.findById(username)
                .map(user -> user.getPassword().equals(password)) // NEVER do this in real applications!
                .orElse(false);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

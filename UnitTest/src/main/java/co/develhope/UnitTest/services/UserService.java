package co.develhope.UnitTest.services;

import co.develhope.UnitTest.entities.User;
import co.develhope.UnitTest.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id) {
       return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User not found"));
    }

    public User createUser(User user) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public User updateUser(User newUser, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        return userRepository.saveAndFlush(user);

    }

    public void deleteUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User  not found");
        }
    }
}

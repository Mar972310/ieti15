package ieti.lab15.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ieti.lab15.demo.dto.UserDto;
import ieti.lab15.demo.model.User;
import ieti.lab15.demo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDto user) {
        User u = new User(user);
        userRepository.save(u);
        return u;
    }

    public List<User> getAllser() {
        return userRepository.findAll();
    }

    public User getNameUser(String name) {
        return userRepository.findByName(name);
    }

    public User updateUser(String id, UserDto user) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
    }

    public void deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con id: " + id);
        }
    }
}

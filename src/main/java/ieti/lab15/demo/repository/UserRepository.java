
package ieti.lab15.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ieti.lab15.demo.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
    Optional<User> findByEmail(String email);
}

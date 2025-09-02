
package ieti.lab15.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ieti.lab15.demo.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);
}

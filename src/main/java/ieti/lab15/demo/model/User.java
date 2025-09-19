package ieti.lab15.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ieti.lab15.demo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;

    private String email;
    
    private String password;


    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }

}

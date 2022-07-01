package by.tms.calculator.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private String username;
    private String password;


    public User(String name, String log, String password) {
        this.name = name;
        this.username = log;
        this.password = password;

    }


}

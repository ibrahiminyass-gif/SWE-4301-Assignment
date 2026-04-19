package com.jah.dip.original;

public class UserService {

    private MySQLUserRepository userRepository = new MySQLUserRepository();

    public void createUser(String user) {
        userRepository.save(user);
    }

    public String getUser(int id) {
        return userRepository.findById(id);
    }
}

package com.jah.dip.refactored;

public interface UserRepository {
    void save(String user);
    String findById(int id);
}

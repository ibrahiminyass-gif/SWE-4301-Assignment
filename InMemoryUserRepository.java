package com.jah.dip.refactored;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private final Map<Integer, String> store = new HashMap<>();
    private int nextId = 1;

    @Override
    public void save(String user) {
        store.put(nextId++, user);
        System.out.println("Saving user [" + user + "] to in-memory store...");
    }

    @Override
    public String findById(int id) {
        return store.getOrDefault(id, "User not found");
    }
}

package com.jah.dip.refactored;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DipRefactoredTest {

    @Test
    void createUser_withInMemoryRepo_shouldPersistUser() {
        InMemoryUserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);

        service.createUser("Alice");

        String found = service.getUser(1);
        assertEquals("Alice", found);
    }

    @Test
    void getUser_whenNotFound_shouldReturnNotFoundMessage() {
        InMemoryUserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);

        String result = service.getUser(999);

        assertEquals("User not found", result);
    }

    @Test
    void multipleUsers_shouldBeStoredAndRetrievedInOrder() {
        InMemoryUserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);

        service.createUser("Alice");
        service.createUser("Bob");
        service.createUser("Charlie");

        assertEquals("Alice",   service.getUser(1));
        assertEquals("Bob",     service.getUser(2));
        assertEquals("Charlie", service.getUser(3));
    }

    @Test
    void userService_shouldDelegateToProvidedRepository() {
        
        final boolean[] saveCalled = { false };

        UserRepository stub = new UserRepository() {
            @Override
            public void save(String user) { saveCalled[0] = true; }

            @Override
            public String findById(int id) { return "StubUser"; }
        };

        UserService service = new UserService(stub);
        service.createUser("Test");

        assertTrue(saveCalled[0], "UserService must delegate save() to repository");
        assertEquals("StubUser", service.getUser(1));
    }

    @Test
    void mySQLRepository_saveAndFindById_shouldNotThrow() {
        MySQLUserRepository repo = new MySQLUserRepository();
        UserService service = new UserService(repo);

        assertDoesNotThrow(() -> service.createUser("Dave"));
        assertDoesNotThrow(() -> service.getUser(1));
    }
}

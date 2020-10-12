package ru.linkov.ss.user.serialization.model;

import java.io.Serializable;
import java.util.Collection;

public class UserCollection implements Serializable {
    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserCollection{" +
                "users=" + users +
                '}';
    }
}

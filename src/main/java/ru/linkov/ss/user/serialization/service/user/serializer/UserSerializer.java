package ru.linkov.ss.user.serialization.service.user.serializer;

import ru.linkov.ss.user.serialization.model.User;

import java.util.Collection;

public interface UserSerializer {
    void serialize(Collection<User> userCollection, String outputFile);
}

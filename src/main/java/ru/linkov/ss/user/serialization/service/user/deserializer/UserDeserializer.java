package ru.linkov.ss.user.serialization.service.user.deserializer;

import ru.linkov.ss.user.serialization.model.User;
import ru.linkov.ss.user.serialization.model.UserCollection;

import java.io.IOException;
import java.util.Collection;

public interface UserDeserializer {
    public Collection<User> deserialize(String inputFile) throws IOException;
}

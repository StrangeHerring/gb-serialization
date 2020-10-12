package ru.linkov.ss.user.serialization.service.user.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.linkov.ss.user.serialization.model.User;
import ru.linkov.ss.user.serialization.model.UserCollection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class JsonUserDeserializer implements UserDeserializer {
    public Collection<User> deserialize(String inputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(inputFile);

        Object o = objectMapper.readerFor(UserCollection.class)
                .readValue(file);
        UserCollection userCollection = (UserCollection) o;
        System.out.println(userCollection);

        return new ArrayList<>();
    }
}

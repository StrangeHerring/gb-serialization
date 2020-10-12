package ru.linkov.ss.user.serialization.service.user.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.linkov.ss.user.serialization.model.User;
import ru.linkov.ss.user.serialization.model.UserCollection;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class XmlUserSerializer implements UserSerializer {
    public void serialize(Collection<User> userCollection, String outputFile) {
        ObjectMapper objectMapper = new XmlMapper();
        File output = new File(outputFile);
        try {
            objectMapper.writerFor(UserCollection.class).writeValue(output, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

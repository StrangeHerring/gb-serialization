package ru.linkov.ss.user.serialization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.linkov.ss.user.serialization.model.User;
import ru.linkov.ss.user.serialization.model.UserCollection;
import ru.linkov.ss.user.serialization.service.user.deserializer.CsvUserDeserializer;
import ru.linkov.ss.user.serialization.service.user.deserializer.JsonUserDeserializer;
import ru.linkov.ss.user.serialization.service.user.deserializer.UserDeserializer;
import ru.linkov.ss.user.serialization.service.user.deserializer.XmlUserDeserializer;
import ru.linkov.ss.user.serialization.service.user.serializer.CsvUserSerializer;
import ru.linkov.ss.user.serialization.service.user.serializer.JsonUserSerializer;
import ru.linkov.ss.user.serialization.service.user.serializer.UserSerializer;
import ru.linkov.ss.user.serialization.service.user.serializer.XmlUserSerializer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SerializerDeserializerTest {
    private List<User> testUsers(){
        ArrayList<User> userCollection = new ArrayList<User>();
        userCollection.add(new User(1, "Ivan", "ivan@mail.ru"));
        userCollection.add(new User(2, "Fedor", "fedor@mail.ru"));
        userCollection.add(new User(3, "Max", "max@mail.ru"));
        userCollection.add(new User(4, "Oleg", "oleg@mail.ru"));
        userCollection.add(new User(5, "Konstantin", "kosnt@mail.ru"));
        userCollection.add(new User(6, "Max", "maxim@mail.ru"));
        userCollection.add(new User(7, "Ivan", "vano@mail.ru"));
        userCollection.add(new User(8, "John", "john@mail.ru"));
        userCollection.add(new User(9, "Anton", "anton@mail.ru"));
        userCollection.add(new User(10, "Sergey", "sergey@mail.ru"));
        return userCollection;
    }

    @Test
    public void XmlTest() throws IOException {
        Collection<User> userCollection = testUsers();
        File xmlFile = new File("src\\test\\resources\\test-users.xml");
        UserSerializer serializer = new XmlUserSerializer();

        serializer.serialize(userCollection, xmlFile.getName());

        Assertions.assertTrue((xmlFile).exists());
        Assertions.assertTrue((xmlFile).length() > 0);

        UserDeserializer deserializer = new XmlUserDeserializer();
        Collection<User> deserializeUsers =  deserializer.deserialize(xmlFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

    @Test
    public void JsonTest() throws IOException {
        Collection<User> userCollection = testUsers();
        File jsonFile = new File("src\\test\\resources\\test-users.json");
        UserSerializer serializer = new JsonUserSerializer();

        serializer.serialize(userCollection, jsonFile.getName());

        Assertions.assertTrue((jsonFile).exists());
        Assertions.assertTrue((jsonFile).length() > 0);

        UserDeserializer deserializer = new JsonUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(jsonFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

    @Test
    public void CsvTest() throws IOException {
        Collection<User> userCollection = testUsers();
        File csvFile = new File("src\\test\\resources\\test-users.csv");
        UserSerializer serializer = new CsvUserSerializer();

        serializer.serialize(userCollection, csvFile.getName());

        Assertions.assertTrue((csvFile).exists());
        Assertions.assertTrue((csvFile).length() > 0);

        UserDeserializer deserializer = new CsvUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(csvFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }
}

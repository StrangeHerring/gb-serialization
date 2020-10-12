package ru.linkov.ss.user.serialization.service.user.deserializer;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import ru.linkov.ss.user.serialization.model.User;
import ru.linkov.ss.user.serialization.model.UserCollection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsvUserDeserializer implements UserDeserializer {
    public Collection<User> deserialize(String inputFile) throws IOException {
        CsvMapper objectMapper = new CsvMapper();
        File file = new File(inputFile);
        CsvSchema csvSchema = objectMapper
                .schemaFor(User.class)
                .withHeader();

        Object o = objectMapper.reader(csvSchema)
                .readValue(file);
        UserCollection userCollection = (UserCollection) o;
        System.out.println(userCollection);

        return new ArrayList<>();
    }
}

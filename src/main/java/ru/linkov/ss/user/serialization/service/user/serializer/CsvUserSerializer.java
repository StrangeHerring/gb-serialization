package ru.linkov.ss.user.serialization.service.user.serializer;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import ru.linkov.ss.user.serialization.model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CsvUserSerializer implements UserSerializer {
    public void serialize(Collection<User> userCollection, String outputFile) {
        CsvMapper objectMapper = new CsvMapper();
        File output = new File(outputFile);
        CsvSchema csvSchema = objectMapper
                .schemaFor(User.class)
                .withHeader();
        try {
            objectMapper.writer(csvSchema).writeValue(output, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

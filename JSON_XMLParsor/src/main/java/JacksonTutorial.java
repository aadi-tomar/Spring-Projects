import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Address;
import entity.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JacksonTutorial {
    ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        JacksonTutorial jacksonTutorial = new JacksonTutorial();
        User user = new User(1, "Aadi", "Tomar",
                new Address("A-54", " gali no. 2", "gzb", 201053));
        jacksonTutorial.getJsonFromJavaObject(user);
        jacksonTutorial.readJsonFromFile();
        jacksonTutorial.writeJsonToFile(user);

    }

    private void getJsonFromJavaObject(User user) throws JsonProcessingException {

        String jsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println(jsonObject);
        getJavaObjectFromJson(jsonObject);
    }

    private void readJsonFromFile() throws IOException {
        FileReader fileReader = new FileReader("new_file.txt");
        User user = objectMapper.readValue(fileReader, User.class);
        fileReader.close();
        System.out.println(user);

    }

    private void writeJsonToFile(User user) throws IOException {
        FileWriter fileWriter = new FileWriter("new_file1.txt");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileWriter, user);
        fileWriter.close();
    }

    private void getJavaObjectFromJson(String jsonObject) throws JsonProcessingException {
        User user = objectMapper.readValue(jsonObject, User.class);
        System.out.println(user);
    }
}

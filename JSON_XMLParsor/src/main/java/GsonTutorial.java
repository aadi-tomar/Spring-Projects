import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Address;
import entity.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GsonTutorial {

    private Gson gson = new Gson();


    private Gson gson1 = new GsonBuilder().setPrettyPrinting().create();

    public GsonTutorial() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        GsonTutorial gsonTutorial = new GsonTutorial();
        User user = new User(1, "Ram", "Tomar",
                new Address("F-54", " gali no. 2", "gzb", 2010343));

        //gsonTutorial.readJsonFromFile();
        //gsonTutorial.getJsonFromJavaObject(user);
        System.out.println("Reading Json List from file ");
        gsonTutorial.readListFromFile();

        //gsonTutorial.writeJsonToFile(user);
    }

    private void getJsonFromJavaObject(User user) throws IOException {
        String jsonObject= gson1.toJson(user);
        System.out.println(jsonObject);
        getJavaObjectFromJson(jsonObject);
    }

    private void writeJsonToFile(User user) throws IOException {
        FileWriter fileWriter = new FileWriter("new_file.txt");
        gson1.toJson(user, fileWriter);
        fileWriter.close();
    }

    private void readJsonFromFile() throws IOException {
        FileReader fileReader = new FileReader("new_file.txt");
        User user = gson.fromJson(fileReader, User.class);
        fileReader.close();
        System.out.println(user);

    }

    private void readListFromFile() throws IOException {
        FileReader fileReader = new FileReader("new_file.txt");
        User[] usersList = gson1.fromJson(fileReader, User[].class);
        fileReader.close();
        for(User user : usersList)
        System.out.println(user);


    }

    private void getJavaObjectFromJson(String jsonObject){
        User user = gson1.fromJson(jsonObject, User.class);
        System.out.println(user);
    }

}

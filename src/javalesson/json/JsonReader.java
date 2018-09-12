package javalesson.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonReader{
    public static void main(String[] args) {

    }
}

class JsonReaderUser {

    public List<User> getUsersJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<User>>(){}.getType());
    }
}

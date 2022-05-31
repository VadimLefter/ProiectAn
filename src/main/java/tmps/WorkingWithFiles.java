package tmps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class WorkingWithFiles {
  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private Path fileName = Path.of("C:\\Users\\ionio\\Desktop\\ProiectAnTMPS\\src\\main\\java\\tmps\\menu.txt");

  public Object ReloadMenu(ArrayList<Compartiment> compartimentList) {
    try {
      return compartimentList = gson.fromJson(Files.readString(fileName), new TypeToken<ArrayList<Compartiment>>(){}.getType());
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public void SaveMenu(ArrayList<Compartiment> compartimentList)
  {
    try {
      Files.writeString(fileName, gson.toJson(compartimentList), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    ReloadMenu(compartimentList);
  }
}

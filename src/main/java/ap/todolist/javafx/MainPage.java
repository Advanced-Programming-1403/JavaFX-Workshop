package ap.todolist.javafx;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPage implements Initializable{
    ArrayList<Task> tasks;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tasks = new ArrayList<>();
    }
}

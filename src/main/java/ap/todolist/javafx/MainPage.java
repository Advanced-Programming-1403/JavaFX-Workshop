package ap.todolist.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPage implements Initializable{
    ArrayList<Task> tasks;

    @FXML
    VBox vbox;

    @FXML
    TextField taskText;

    @FXML
    DatePicker taskDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vbox.getChildren().clear();
        tasks = new ArrayList<>();
    }

    @FXML
    public void addTask(){
        if (taskText.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a task title");
            alert.showAndWait();
            return;
        } else if (taskDate.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a task due date");
            alert.showAndWait();
            return;
        } else {
            tasks.add(new Task(taskText.getText(), taskDate.getValue()));
            taskText.clear();
            taskDate.setValue(null);
            addComponents();
        }

    }
    public void addComponents(){
        vbox.getChildren().clear();

        for (Task task : tasks) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Task.fxml"));
                HBox taskBox = fxmlLoader.load();

                TaskController controller = fxmlLoader.getController();
                controller.setTask(task);

                vbox.getChildren().add(taskBox);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}

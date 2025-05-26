package ap.todolist.javafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController implements Initializable{
    private ArrayList<Task> tasks;
    private LocalDate date;

    @FXML
    VBox vbox;

    @FXML
    TextField taskText;

    @FXML
    DatePicker taskDate;

    @FXML
    Circle profile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vbox.getChildren().clear();
        date = LocalDate.now();
        tasks = new ArrayList<>();
        Image image = new Image(getClass().getResource("Images/thom.png").toExternalForm());
        profile.setFill(new ImagePattern(image));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
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
        }else if(taskDate.getValue().isBefore(LocalDate.now())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid task due date");
            alert.showAndWait();
        }else {
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

    public void myDay(){
        vbox.getChildren().clear();
        for (Task task : tasks) {
            if(task.getTaskDate().equals(date)){
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


}

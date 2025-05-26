package ap.todolist.javafx;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Intro implements Initializable {

    @FXML
    Button Btn;
    @FXML
    AnchorPane icon;
    @FXML
    public void ChangeScene1(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ChangeScene2(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CSS.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void iconMove(){
        Timeline ty = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(icon.layoutYProperty(), icon.getLayoutY())),
                new KeyFrame(Duration.seconds(1.3), new KeyValue(icon.layoutYProperty(), icon.getLayoutY() + 20))
        );
        ty.play();
        Timeline to = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(icon.opacityProperty(), 0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(icon.opacityProperty(), 1))
        );
        to.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        iconMove();
    }
}

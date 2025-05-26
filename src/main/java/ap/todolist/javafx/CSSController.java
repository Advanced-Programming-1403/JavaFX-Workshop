package ap.todolist.javafx;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CSSController implements Initializable {
    @FXML
    AnchorPane anchorPane;
    @FXML
    VBox vbox;
    @FXML
    ImageView imageView;
    public void ChangeStyle(){
        if(anchorPane.getStylesheets().toString().contains("CSS_Light.css")){
            anchorPane.getStylesheets().remove(getClass().getResource("CSS_Light.css").toExternalForm());
            anchorPane.getStylesheets().add(getClass().getResource("CSS_Dark.css").toExternalForm());
            Image image = new Image(getClass().getResource("kanye.png").toExternalForm());
            imageView.setImage(image);
        }else{
            anchorPane.getStylesheets().remove(getClass().getResource("CSS_Dark.css").toExternalForm());
            anchorPane.getStylesheets().add(getClass().getResource("CSS_Light.css").toExternalForm());
            Image image = new Image(getClass().getResource("thom.png").toExternalForm());
            imageView.setImage(image);
        }
    }
    public void hoverImage(){
        Timeline tx = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(vbox.scaleXProperty(), vbox.getScaleX())),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(vbox.scaleXProperty(), 1.1))
        );
        tx.play();
        Timeline ty = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(vbox.scaleYProperty(), vbox.getScaleY())),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(vbox.scaleYProperty(), 1.1))
        );
        ty.play();

    }
    public void unhoverImage(){
        Timeline tx = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(vbox.scaleXProperty(), vbox.getScaleX())),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(vbox.scaleXProperty(), 1))
        );
        tx.play();
        Timeline ty = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(vbox.scaleYProperty(), vbox.getScaleY())),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(vbox.scaleYProperty(), 1))
        );
        ty.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(getClass().getResource("kanye.png").toExternalForm());
        imageView.setImage(image);
    }
}

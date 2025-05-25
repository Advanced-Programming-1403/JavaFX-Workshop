package ap.todolist.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.TextFlow;

public class TaskController {
    @FXML
    private TextFlow textFlow;

    @FXML
    public void disableTask(ActionEvent event) {
        textFlow.setDisable(!textFlow.isDisabled());
    }

}

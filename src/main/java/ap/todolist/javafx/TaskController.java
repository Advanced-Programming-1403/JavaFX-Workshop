package ap.todolist.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

public class TaskController {
    @FXML
    private Text text;

    @FXML
    private RadioButton radioButton;

    @FXML
    public void disableTask(ActionEvent event) {
        boolean shouldDisable = !text.isDisabled();
        text.setDisable(shouldDisable);
        text.setStrikethrough(shouldDisable);
    }

    public void setTask(Task task) {
        text.setText(task.getTaskText() + " - " + task.getTaskDate());
    }

}

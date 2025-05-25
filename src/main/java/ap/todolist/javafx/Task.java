package ap.todolist.javafx;

import java.time.LocalDate;

public class Task {
    private String taskText;
    private LocalDate taskDate;

    public Task(String taskText, LocalDate taskDate) {
        this.taskText = taskText;
        this.taskDate = taskDate;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }
}

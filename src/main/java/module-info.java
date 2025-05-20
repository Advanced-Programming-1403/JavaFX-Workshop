module ap.todolist.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ap.todolist.javafx to javafx.fxml;
    exports ap.todolist.javafx;
}
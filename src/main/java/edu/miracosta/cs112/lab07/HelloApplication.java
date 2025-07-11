package edu.miracosta.cs112.lab07;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {

    /*** GUI COMPONENTS ***/
    private Button button;
    private Label message;
    private TextField nameInput;
    private int clickCount = 0;

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args); // needed for JavaFX apps to start
    }

    /*** OVERRIDDEN Application METHODS ***/
    @Override
    public void start(Stage primaryStage) throws Exception {
        // SETUP COMPONENTS
        message = new Label("Hi, User!");
        nameInput = new TextField();
        nameInput.setPromptText("Enter your name here...");
        button = new Button("Click me");
        button.setOnAction(this); // register this class as the event handler

        // ADD COMPONENTS
        VBox layout = new VBox();
        layout.setSpacing(10); // some spacing between elements
        layout.getChildren().addAll(message, nameInput, button);

        // SETUP SCENE AND SHOW
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ramysannta Hy"); // set window title to your name
        primaryStage.show();
    }

    /*** OVERRIDDEN EventHandler METHODS ***/
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button) {
            clickCount++;
            String userName = nameInput.getText().trim();
            if (userName.isEmpty()) {
                userName = "User";
            }
            message.setText("Hi #" + clickCount + ", " + userName + "!");
            System.out.println("Hello CS112"); // print to console
        }
    }
}

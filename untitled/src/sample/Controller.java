package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.text.Position;
import java.util.Timer;
import java.util.TimerTask;

public class Controller extends Application {
    Button button;
    Timer timer = new Timer();
    Stage pm;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        pm = primaryStage;
        primaryStage.setTitle("Get rest timer!");
        button = new Button();
        button.setText("Start counting time to short and long breaks");
        Label label1 = new Label("Short break timeout:");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField);
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        Label label2 = new Label("Long break timeout:");
        TextField textField2 = new TextField ();
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, textField2);
        hb2.setSpacing(20);
        hb2.setAlignment(Pos.TOP_CENTER);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                button.setDisable(true);
                nameOfMethod(textField, textField2);
            }
        });
        VBox layout = new VBox();
        button.setAlignment(Pos.TOP_CENTER);
//        layout.getChildren().add(hb);
        layout.getChildren().add(hb2);
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
//        button.getOnAction().handle();
    }

    private void nameOfMethod(TextField textField, TextField textField2){
        new Timeline(new KeyFrame(
                Duration.millis(Double.valueOf(textField2.getText())*60000),
                ae -> {doLongBreak();
                    nameOfMethod(textField, textField2);}))
                .play();

    }

    private  void doSomething(){
        final Stage dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(pm);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("TIME FOR SHORT BREAK!"));

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.setAlwaysOnTop(true);
        dialog.show();
    }

    private void doLongBreak(){
        final Stage dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(pm);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("TIME FOR LONG BREAK!"));

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.setAlwaysOnTop(true);
        dialog.show();

    }

    TimerTask task = new TimerTask()
    {


        public void run()
        {
            //Stage pm = new Stage();
            //pm.initModality(Modality.APPLICATION_MODAL);
            //dialog.initOwner(pm);
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("This is a Dialog"));
            Scene dialogScene = new Scene(dialogVbox, 300, 200);
            pm.setScene(dialogScene);
            pm.show();
        }

    };


}

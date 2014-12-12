/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author nathan
 */
public class MainView extends Application {
    private Button loadFileLocation;
    private Label pathLabel;
    private final DirectoryChooser  directoryChooser = new DirectoryChooser();
    private File locationFolder;
    
    @Override
    public void start(Stage primaryStage) {
        loadFileLocation = new Button();
        loadFileLocation.setText("Select path");
        loadFileLocation.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                locationFolder = directoryChooser.showDialog(primaryStage);
                if(locationFolder != null){
                    updateLabel();
                }
            }
        });
        
        pathLabel = new Label();
        
        StackPane root = new StackPane();
        root.getChildren().add(loadFileLocation);
        root.getChildren().add(pathLabel);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("RMU");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void updateLabel(){
        pathLabel.setText(locationFolder.getAbsolutePath());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

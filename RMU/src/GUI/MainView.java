/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Domain.DomainController;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author nathan
 */
public class MainView extends Application {
    private Button loadFileLocation;
    private DomainController domCntrl;
    
    @Override
    public void start(Stage primaryStage) {
        domCntrl = new DomainController();
        loadFileLocation = new Button();
        loadFileLocation.setText("Select path");
        loadFileLocation.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                String selectedPath = FolderSelectorHelper.getInstance().SelectPath();
                domCntrl.pathSelected(selectedPath);
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Overview.fxml"));
                
                Stage stage = new Stage(StageStyle.DECORATED);
                try{
                    stage.setScene(new Scene((Pane) loader.load()));
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
                OverviewController controller = loader.<OverviewController>getController();
                controller.initData(domCntrl);
                primaryStage.hide();
                stage.show();
            }
        });
        
        
        StackPane root = new StackPane();
        root.getChildren().add(loadFileLocation);
        
        Scene scene = new Scene(root, 500, 500);
        
        primaryStage.setTitle("RMU");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}

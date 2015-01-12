/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.DomainController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javax.swing.JOptionPane;
public class OverviewController implements Initializable {
    private DomainController domCntrl;
    @FXML private ListView fileListView;
    @FXML private Label folderLocationLabel;
    @FXML private Button randomizeButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void initData(DomainController domCntrl) {
        this.domCntrl = domCntrl;
        folderLocationLabel.setText(domCntrl.getSelectedPath());
        
        ObservableList<String> data = FXCollections.observableArrayList(domCntrl.getSelectedFiles());
        fileListView.setItems(data);
        
        randomizeButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ae){
                //JOptionPane.showMessageDialog(null, "i got clicked");
                ObservableList<String> data = FXCollections.observableArrayList(domCntrl.shuffleSelectedFiles());
                fileListView.setItems(data);
            }
        });
    }
    
}

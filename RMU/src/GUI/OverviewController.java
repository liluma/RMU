/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.DomainController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class OverviewController implements Initializable {
    private DomainController domCntrl;
    @FXML private ListView fileListView;
    @FXML private Label folderLocationLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void initData(DomainController domCntrl) {
        folderLocationLabel.setText("test");
    }
    
}
